package mdmUtil.service;

import java.util.Properties;


import javax.naming.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siperian.sif.client.EjbSiperianClient;
import com.siperian.sif.client.SiperianClient;

import mdmUtil.model.MDMConnection;

@Service
public class ConnectionService {

	@Autowired
	MDMConnection mdmConnection;

	public EjbSiperianClient getEBJSipClient() {
		EjbSiperianClient ejbSipClient = null;
		System.out.println("In the EBJSipClient service method");
		Properties properties = new Properties();
		properties.put(SiperianClient.SIPERIANCLIENT_PROTOCOL, mdmConnection.getSiperianClientProtocol());
		properties.put(Context.INITIAL_CONTEXT_FACTORY, mdmConnection.getInitcontextFactory());
		properties.put("java.naming.factory.url.pkgs", mdmConnection.getNamingFactory());
		properties.put(Context.PROVIDER_URL, mdmConnection.getProviderURL());
		properties.put("jboss.naming.client.ejb.context", mdmConnection.isEjbContext());
		properties.put("siperian-client.orsId", mdmConnection.getOrsId());
		try {
			ejbSipClient = (EjbSiperianClient) SiperianClient.newSiperianClient(properties);
			System.out.println("EjbSiperianClientDemo.main() client created successfuly");
		} catch (Exception e) {
			System.out.println("error in creating client");
		}

		return ejbSipClient;

	}

}
