package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Courses {

	@JsonProperty
	private List<pojo.webAutomation> webAutomation;
	@JsonProperty
	private List<pojo.api> api;
	@JsonProperty
	private List<pojo.mobile> mobile;
	
	public List<webAutomation> getWebautomation() {
		return webAutomation;
	}
	public void setWebautomation(List<pojo.webAutomation> webautomation) {
		this.webAutomation = webautomation;
	}
	
	public List<api> getApiautomtion() {
		return api;
	}
	public void setApiautomtion(List<pojo.api> apiautomtion) {
		this.api = apiautomtion;
	}
	
	public List<mobile> getMobileautomation() {
		return mobile;
	}
	public void setMobileautomation(List<pojo.mobile> mobileautomation) {
		this.mobile = mobileautomation;
	}
	
	
	
}
