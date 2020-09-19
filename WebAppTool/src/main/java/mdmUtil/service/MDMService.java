package mdmUtil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siperian.sif.message.Password;
import com.siperian.sif.message.mrm.AuthenticateRequest;
import com.siperian.sif.message.mrm.AuthenticateResponse;

import mdmUtil.model.User;

@Service
public class MDMService {

	@Autowired
	ConnectionService connectionService;

	User user;

	public boolean authenticateUser(User user) {
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

}
