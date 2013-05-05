package servlet;

import impl.MailImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailValidateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		String uId=(String) request.getAttribute("uId");
		
		System.out.println("成功"+uId);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		doGet(request, response);
	}
	
	
}
