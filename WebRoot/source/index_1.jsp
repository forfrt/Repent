<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html xmlns:wb="http://open.weibo.com/wb">
  <head>
    <base href="<%=basePath%>">
    
    <title>repent - 放心的忏悔网站</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js?appkey=YOUR APPKEY" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	WB2.anyWhere(
		function(W){
			W.parseCMD("/users/show.json", function(sResult, bStatus){
				try{
	            //to do something...
	        	}catch(e){}
	   		 },{
	   		 uid: '123456789'
	   		 }{
	   		 method: 'get'
	   		 });
	});
	</script>
  </head>
  
  <form action="Login">
  	<fieldset>
  	<legend>请登录</legend>
  	<div class="input_email">
  		<input type="email" name="currentUser.uEmail" placeholder="输入登录邮箱" autocomplete="off" />
  	</div>
  	
  	<div class="input_password">
  		<input type="password" name="currentUser.uPassword" placeholder="请输入密码" />
  	</div>
  	
  	<input id="remember_me" name="currentUser.remember_me" checked="false" type="checkbox" />
  	<span>两周内自动登录</span>
  	
  	<a id ="forget_password" href="javascript:void(0);">忘记密码?</a>
  	
  	<div class="input_submit">
  		<input type="submit" value="登录"/>
  	</div>
  	
  	</fieldset>
  	
  	<div>
  		<a href="/Repent/register.jsp">还没有帐号？立即注册 </a>
  	</div>
  	
  	<div class="authentification_login">使用其他帐号登录:<br/>
  		<wb:login-button type="3,2" ></wb:login-button>
  		<%-- <a class="weibo_login" href="javascript:void(0);">使用微博登录</a> --%>
  		<a class="qq_login" href="javascript:void(0);">使用qq登录</a>
  	</div>
  	
  </form>

  
 <jsp:include page="footer.jsp"></jsp:include>
</html>

