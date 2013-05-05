package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import impl.UsersImpl;

import javax.security.sasl.SaslClientFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import com.sun.xml.internal.ws.client.RequestContext;

import params.Properties;
import pojo.Users;
import util.Md5;

import filter.SCFilter;

public class RememberMeServlet extends HttpServlet{
	private String ssidKey=new Properties().getSsidKey();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		/*
		 * 判断是否存在cookie与session,并验证
		 * 若验证通过则转到Home
		 */
		System.out.println("------------servlet.RememberMeServlet.doGet method start------------");
		String[] keys={"uId","uName"};
		HashMap<String, String>params=new SCFilter().SCInsert(request, keys);
		Users user=new Users();
		
		if(params.get("uId")==null||params.get("uName")==null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			System.out.println("++++++++++++servlet.RememberMeServlet.doGet method end1++++++++++++");
			return ;
		}else{
			user.setuId(new Integer(params.get("uId")));
			user.setuName(params.get("uName"));
			System.out.println("uId: "+user.getuId()+"uName: "+user.getuName());
		}
		
		if(Md5.calcMD5(params.get("uId")+ssidKey).equalsIgnoreCase(params.get("ssid"))){
			System.out.println("servlet.RememberMeServlet.doGet.params.ssid: "+params.get("ssid"));			
			request.getRequestDispatcher("Home.action").forward(request, response);
			
			System.out.println("success!");
			return ;
			
		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
			System.out.println("failed!");
			System.out.println("++++++++++++servlet.RememberMeServlet.doGet method end2++++++++++++");
			return ;
		}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		System.out.println("------------servlet.RememberMeServlet.doPost method start------------");
		doGet(request, response);
	}
}
