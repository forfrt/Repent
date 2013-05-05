<%@page import="servlet.RememberMeServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("---------- index.jsp start! ----------");
	//RequestDispatcher dispatcher=request.getRequestDispatcher("/rememberMe.do");
	//dispatcher.forward(request, response);
 %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <title>忏悔网 - 登录</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-responsive.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<!-- <script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js?appkey=YOUR APPKEY" type="text/javascript" charset="utf-8"></script> -->
    <style type="text/css">
        body{
            background: url("img/bg1.jpg") no-repeat;
        }
        footer{
            position: absolute;
            bottom: 0;
            width: 97.8%;
        }
        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin input[type="email"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
    </style>
	<script type="text/javascript">
	WB2.anyWhere(
		function(W){
			W.parseCMD("/users/show.json", function(sResult, bStatus){
				try{
	            //to do something...
	        	}catch(e){}
	   		 },{
	   		 uid: '123456789'
	   		 },{
	   		 method: 'get'
	   		 });
	});
	</script>    
</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="brand" href="home.html">忏悔网</a>
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li><a href="home.html">首页</a></li>
                        <li><a href="data.html">资料</a></li>
                        <li><a href="aboutus.html">关于我们</a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" role="button" data-target="#" href="#">
                                关注我们
                                <b class="caret"></b>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="http://weibo.com/fxw490769750">新浪微博</a></li>
                                    <li><a href="http://t.qq.com/fxw945">腾讯微博</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">微信</a></li>
                                </ul>
                            </a>
                        </li>
                    </ul>
                    <form action="#" class="navbar-search pull-left">
                        <input type="text" class="input-medium search-query" placeholder="查询关键字"/>
                        <button class="btn btn-info" style="margin-top: -1px;margin-left: 5px">查找</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div id="mainpart" class="container" style="padding: 150px">
        <div class="row">
            <div id="content" class="span5 offset3">
                <form class="form-signin" action="Login" method="post">
                    <fieldset>
                        <input class="input-block-level" type="email" name="currentUser.uEmail" placeholder="输入登录邮箱" autocomplete="off" />
                        <input class="input-block-level" type="password" name="currentUser.uPassword" placeholder="请输入密码" />
                        <input class="btn btn-large btn-primary" type="submit" value="登录"/>
                        <input id="remember_me" name="currentUser.remember_me" type="checkbox" />
                        <span>记住我</span>
                        <a id ="forget_password" href="javascript:void(0);">忘记密码?</a>
                    </fieldset>
                    <div class="text-right">
                        <a href="register.html">还没有帐号？立即注册 </a>
                    </div>
                    <hr>
                    <div class="authentification_login">使用其他帐号登录:<br/>
                        <wb:login-button type="3,2" ></wb:login-button>
                        <a class="qq_login" href="javascript:void(0);">使用qq登录</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <footer class="modal-footer">
        <div class="container">
			<p class="text-center text-info">忏悔网 ©2013</p>
		</div>
    </footer>
</body>
</html>