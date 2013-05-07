<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="pojo.*,java.util.Date" %>
<%@ page import="java.sql.Timestamp" %>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <title>忏悔网 - 修改个人信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-responsive.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/changeinfo.js"></script>
</head>
<%
	Users user = (Users)session.getAttribute("user");
	String uname = user.getuName();
	String uMail = user.getuEmail();
	String uPwd = user.getuPassword();
	String URI = user.getuPhotoUri();
	
	Users_attachment users_attachment = (Users_attachment)session.getAttribute("userAttachment");
	Date birthday = users_attachment.getuDate();
	int grade = users_attachment.getuGrade();
	String sex = users_attachment.getuSex();
	int bsex = new Byte(sex).intValue();
	Timestamp rDate = users_attachment.getuRDate();
	
	String sex0 = "",sex1 = "";
	if(bsex == 0)
	{
		sex0 = "checked";
	}
	else{
		sex1 = "checked";
	}
 %>
<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-inner">
						<div class="container">
								<a class="brand" href="home.jsp">忏悔网</a>
								<div class="nav-collapse collapse">
										<ul class="nav">
												<li class=""><a href="home.jsp">首页</a></li>
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
																		<li><a href="#myModal" role="button" class="" data-toggle="modal">微信</a></li>
																</ul>
														</a>
												</li>
										</ul>
										<form action="#" class="navbar-search pull-left">
												<input type="text" class="input-medium search-query" placeholder="查询关键字"/>
												<button class="btn btn-info" style="margin-top: -1px;margin-left: 5px">查找</button>
										</form>
										<div id="personal" class="pull-right">
												<!--小头像图片大小为40*40-->
												<img src="img/head/username.jpg" alt="username">
												<a href="personal.html">username</a>
												<a href="#" class="text-info">注销</a><!--注销 -- 记得到时候加上-->
										</div>
								</div>
						</div>
				</div>
		</div>
		<div class="container">
				<div class="row">
						<br>
						<div id="ourdata" class="span3 offset9 affix">
								<hr>
								<div id="datatype">
										<a href="#" class="btn"><i class="icon-music"></i></a>
										<a href="#" class="btn"><i class="icon-film"></i></a>
										<a href="#" class="btn"><i class="icon-picture"></i></a>
										<a href="#" class="btn"><i class="icon-book"></i></a>
								</div>
								<div id="datascan" class="nav-list well">
										<a href="#">如何忏悔1</a><br />
										<a href="#">如何忏悔2</a><br />
										<a href="#">如何忏悔3</a><br />
								</div>
						</div>
				</div>
		</div>
    <!-- 微信关注我的窗口放在这里 -->
    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" data-aria-labelledby="myModalLabel" data-aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" data-aria-hidden="true">×</button>
            <h3 id="myModalLabel2">忏悔网的微信（coder_muyu）</h3>
        </div>
        <div class="modal-body">
            <img src="img/wx.jpg" alt="coder_muyu">
        </div>
    </div>
<div id="mainpart" class="container">
    <div class="row">
        <div id="content" class="span9">
            <!--在此添加个人信息的表格以供修改-->
            <hr>
            <div class="row">
                <div class="span3">
                    <img src="img/head/head2.jpg" alt="head">
                    <div class="btn-group pull-right">
                        <button id="changehead" class="btn btn-info ">修改头像</button>
                        <button id="ensurehead" class="hide btn btn-info">确定</button>
                    </div>
                </div>
                <div class="span5">
                    <form action="Update" method="post">
                        <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th style="min-width: 150px">修改我的个人资料</th>
                                    </tr>
                                </thead>
                                <tbody><!--从后台动态获取个人信息并填上，此处仅仅是例子-->
                                <tr>
                                    <td>帐号：</td>
                                    <td><%=uMail %></td>
                                </tr>
                                <tr>
                                    <td rowspan="2">昵称：</td>
                                    <td><input type="text" placeholder=<%=uname %>></td>
                                </tr>
                                <tr>
                                    <td><span id="nickname" class="alert-info">2~6个字符，不能包含空格、*号</span></td>
                                </tr>
                                <tr>
                                    <td rowspan="2">密码：</td>
                                    <td><input id="password_input" type="password" name="user.uPassword"></td>
                                </tr>
                                <tr>
                                    <td><span id="password" class="alert-info">请输入密码，6 - 20 位数字与字母的组合，区分大小写。(不修改密码则留空)</span></td>
                                </tr>
                                <tr>
                                    <td rowspan="2">请再次确认您的密码：</td>
                                    <td><input id="password_reaffirm" type="password"></td>
                                </tr>
                                <tr>
                                    <td><span id="reaffirm" class="alert-info">请再次确认您的密码是否一致</span></td>
                                </tr>
                                <tr>
                                    <td>生日：</td>
                                    <td><input type="date" name="currentUser.uDate" value="<%=birthday %>"></td>
                                </tr>
                                <tr>
                                    <td>性别：</td>
                                    <td>
                                        <input type="radio" <%=sex0 %>  name="currentUser.uSex">&nbsp;男&nbsp;
                                        <input type="radio" <%=sex1 %>  name="currentUser.uSex">&nbsp;女&nbsp;
                                    </td>
                                </tr>
                                <tr>
                                    <td>注册时间：</td>
                                    <td><%=rDate %></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><button type="submit" class="btn btn-info">确认修改</button></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
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