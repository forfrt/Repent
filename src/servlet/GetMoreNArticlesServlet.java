package servlet;

import impl.ArticlesImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Articles;

public class GetMoreNArticlesServlet extends HttpServlet{
	 	@Override  
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
	    throws ServletException, IOException {  
	 		System.out.println("------------servlet.getMoreNArticles.doGet method start------------");
	        
	 		try {
	 			getMoreNArticles(request, response);
	 		}
	 		catch (NumberFormatException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
			} 
	 		catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
			}  
	    }   
	  
	    private void getMoreNArticles(HttpServletRequest request,
				HttpServletResponse response) throws IOException, NumberFormatException, SQLException {
	    	// TODO Auto-generated method stub
	    	System.out.println("------------servlet.getMoreNArticles.getMoreNArticles method start------------");
	    	ArticlesImpl articlesImpl=new ArticlesImpl();
	    	
	    	response.setContentType("text/xml; charset=UTF-8");
	    	response.setHeader("Cache-Control","no-cache");
	    	
	    	PrintWriter out=response.getWriter();			
	    	System.out.println(request.getParameter("nId"));
	    	
	    	List<Articles> articleList=
	    			articlesImpl.getMoreNArticles(10, new Integer(request.getParameter("nId")));
	    	
	    	out.println("<response>");
	    	for(Articles article:articleList){
	    		out.println("<section>");
	    		out.println("<nId>"+article.getnId()+"</nId>");
	    		out.println("<nTitle>" +article.getnTitle()+ "</nTitle>");
	    		out.println("<nContent>"+article.getnContent()+"</nContent>");
	    		out.println("<uId>"+article.getuId()+"</uId>");
	    		out.println("<nTime>"+article.getnTime()+"</nTime>");
	    		//out.println("<aBrCount>"+article.getaBrCount()+"</aBrCount>");
	    		//out.println("<aReCount>"+article.getaReCount()+"</aReCount>");
	    		out.println("</section>");
	    	}
	    	out.println("</response>");
	    	
	    	out.close();
		}

		@Override  
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
	    throws ServletException, IOException {
		
			System.out.println("------------servlet.getMoreNArticles.doPost method start------------");
	        
			try {
			
				getMoreNArticles(request, response);
			} 
			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
			
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
			}  
	    }  
	  
	    @Override  
	    public String getServletInfo() {  
	        
	    	return "Short description";  
	    
	    }  

}
