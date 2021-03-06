package filter;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;

import params.Properties;

import util.Md5;

public class SCFilter implements Filter {
	private String ssidKey=new Properties().getSsidKey();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//TODO:应该将S与C分开,S中可以存放uPhotoUri,C中不放,同时两者采用不同的加密
		
		//将session与cookie值取出放入request
		System.out.println("------------filter.SCFilter.doFilter method start------------");
		HttpServletRequest request=(HttpServletRequest)req;
		String[] keys={"uId","uName"};
		SCInsert(request,keys);
		
		chain.doFilter(request, res);
	}
	
	public HashMap SCInsert(HttpServletRequest request, String[] keys){
		//TODO: 将SCInsert分为SCParamsGet与SCParamsInsert--13.04.30 FENGRT
		HashMap<String, String> result=new HashMap<String, String>(4);
		HttpSession session=request.getSession();
		for(String key:keys){
			
			//获取session中的key值
			String uArg=(String) session.getAttribute(key);
			if(uArg!=null&&uArg.equalsIgnoreCase("")==false){
				//若uArg不为空,则将session中的key值赋到request的attribute中
				System.out.println("SCFilter.doFilter.request.getSession()."+key+"!=null");
				System.out.println("SCFilter.doFilter.request.getSession()."+key+"： "+uArg);
				
			}else{
				uArg=null;
				//若key为空,则查找cookie中是否含有key
				System.out.println("SCFilter.doFilter.request.getSession()."+key+"==null");
				Cookie[] cookies=request.getCookies();//取得所有cookies键值对
				for(int i=0;cookies!=null&&i<cookies.length;i++){
					Cookie cookie=cookies[i];
					if(cookie.getName().equals(key)){
						System.out.println("SCFilter.doFilter.request.getCookies["+i+"]."+key+"： "+cookie.getValue());
						uArg=cookie.getValue();
						session.setAttribute(key, uArg);//将session中也加入uName
						break;
					}
				}
			}
			//设置ssid
			if(key.equalsIgnoreCase("uId")&&uArg!=null){
				System.out.println("SCFilter.doFilter.ssidKey: "+ssidKey);
				System.out.println("SCFilter.doFilter.ssid: "+Md5.calcMD5(uArg+ssidKey));
				request.setAttribute("ssid", Md5.calcMD5(uArg+ssidKey));
				result.put("ssid", Md5.calcMD5(uArg+ssidKey));
			}
			
			request.setAttribute(key, uArg);
			result.put(key, uArg);
		}
		System.out.println("++++++++++++filter.SCFilter.doFilter method end++++++++++++");
		return result;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

