package mdmUtil.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.siperian.sif.message.Password;
import com.siperian.sif.message.mrm.AuthenticateRequest;
import com.siperian.sif.message.mrm.AuthenticateResponse;

import mdmUtil.model.User;

@Service
public class MDMService implements AuthenticationProvider{

	@Autowired
	ConnectionService connectionService;

	User user = new User();

	public boolean authenticateUser() {
		System.out.println("In the authenticate method");
		AuthenticateRequest authReq = new AuthenticateRequest();
		authReq.setUsername(user.getUserName());
		authReq.setPassword(new Password(user.getPassword()));
		AuthenticateResponse authResp;
		try {
			authResp = (AuthenticateResponse) connectionService.getEBJSipClient().process(authReq);
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		System.out.println(authResp.getUsername());
		return true;

	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println(authentication.getName());
		user.setUserName(authentication.getName());
		user.setPassword(authentication.getCredentials().toString());
		UsernamePasswordAuthenticationToken authenticationToken = null;
		System.out.println("User details in the customer auth provider mehtod (MDMService):"+user);
		if(authenticateUser()) {
			Collection<GrantedAuthority> grantedAuth = Collections.singleton(new SimpleGrantedAuthority("USER"));
			System.out.println("Granted Auth initialized");
			authenticationToken = new UsernamePasswordAuthenticationToken(
					new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuth),
					user.getPassword(), grantedAuth);
			System.out.println("authentication token is initialized!");
		}
		else {
			throw new UsernameNotFoundException("404 User not found");
		}
		return authenticationToken;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
		
	}

}
