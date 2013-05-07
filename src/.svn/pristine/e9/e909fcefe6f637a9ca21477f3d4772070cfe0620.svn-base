package util;

import javax.servlet.http.HttpServletRequest;


public class RequestTool {
	private boolean validate(HttpServletRequest request){
		//TODO:ssid的验证
		return true;
	}
	
	public String getValue(HttpServletRequest request,String key){
		if(validate(request)){
			return (String) request.getAttribute(key);
		}
		return "error";
	}
}
