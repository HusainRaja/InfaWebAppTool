package mdmUtil.model;

public class MDMConnection {

	private String siperianClientProtocol;
	private String initcontextFactory;
	private String namingFactory;
	private boolean ejbContext;
	private String orsId;
	private String providerURL;

	public String getSiperianClientProtocol() {
		return siperianClientProtocol;
	}

	public void setSiperianClientProtocol(String siperianClientProtocol) {
		this.siperianClientProtocol = siperianClientProtocol;
	}

	public String getInitcontextFactory() {
		return initcontextFactory;
	}

	public void setInitcontextFactory(String initcontextFactory) {
		this.initcontextFactory = initcontextFactory;
	}

	public String getNamingFactory() {
		return namingFactory;
	}

	@Override
	public String toString() {
		return "MDMConnection [siperianClientProtocol=" + siperianClientProtocol + ", initcontextFactory="
				+ initcontextFactory + ", namingFactory=" + namingFactory + ", ejbContext=" + ejbContext + ", orsId="
				+ orsId + ", providerURL=" + providerURL + "]";
	}

	public void setNamingFactory(String namingFactory) {
		this.namingFactory = namingFactory;
	}

	public boolean isEjbContext() {
		return ejbContext;
	}

	public void setEjbContext(boolean ejbContext) {
		this.ejbContext = ejbContext;
	}

	public String getOrsId() {
		return orsId;
	}

	public void setOrsId(String orsId) {
		this.orsId = orsId;
	}

	public String getProviderURL() {
		return providerURL;
	}

	public void setProviderURL(String providerURL) {
		this.providerURL = providerURL;
	}

}
