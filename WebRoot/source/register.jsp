<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎您加入 - repent - 放心的忏悔网站</title>
</head>
<body>

<form action="Signup">
	<span class="input_title">邮箱:</span>
	<div class="input_email">
		<input id="email_input" type="email" name="currentUser.uEmail" />
		<span id="tip_email_input" class="tips"></span>
	</div>
	<span class="input_title">密码:</span>
	<div class="input_password">
		<input id="password_input" type="password" name="currentUser.uPassword"/>
	</div>
	
	<span class="input_title">确认密码:</span>
	<div class="input_password">
		<input id="password_reaffirm" type="password" />
		<span id="tip_password_reaffirm" class="tips"></span>
	</div>
	
	<span class="input_title">用户名:</span>
	<div class="input_name">
		<input id="name_input" type="text" name="currentUser.uName"/>
		<span id="tip_name_input" class="tips"></span>
	</div>
	
	<span class="input_title">验证码:</span>
	<div class="input_identity">
		<input id="identity_input" type="text"/>
		<img class="left" src=""/>
		<a class="identity_refresh" title="看不清，换一个" href="javascript:void(0);">刷新</a>
		<span id="tip_identity_input" class="tips"></span>
	</div>
	
	<span class="input_title"></span><!-- 为对齐而设置 -->
	<div class="affirm_authorization">
		<input id="authorization_affirm" type="checkbox" />
		<span> 我已认真阅读并同意Repent的</span>
		<a href="/s/privacy_policy" target="_blank">《服务条款》</a>
	</div>
	
	<span class="input_title"></span><!-- 为对齐而设置 -->
	<div>
		<input type="submit"/>
		<a id="register_btn" href="javascript:void(0);"  class="register_btn">注册</a>
	</div>
	
	<div class="return_login">
		<div style="text-align:right;">
			<a href="/index">&lt;&lt; 返回登录页</a>
		</div>
	</div>
	
</form>
 
 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>