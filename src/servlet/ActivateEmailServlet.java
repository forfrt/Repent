package servlet;

import impl.UsersImpl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Users;

/*
 * 创建于13-05-04 FENGRT
 */
public class ActivateEmailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		
		/*
		 * 没有处理Session与Cookie,急需优化 13-05-04 FENGRT
		 */
		int uId=new Integer((String)request.getParameter("uId"));
		System.out.println("servlet.ActivateEmail.doGet.uId: "+uId);
		Users user=new Users();
		user.setuId(uId);
		try {
			String[] activateResult=new UsersImpl().setActivated(user);
			if(activateResult[activateResult.length-1].equalsIgnoreCase("success")){
				request.setAttribute("activated", "true");
				request.getRequestDispatcher("/.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		this.doGet(request, response);
		
	}

}
