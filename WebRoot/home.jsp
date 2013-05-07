<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	System.out.println("---------- home.jsp start! ----------");
 %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <title>忏悔网 - 首页</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/home.css" rel="stylesheet">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/home.js"></script>
</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="brand" href="home.jsp">忏悔网</a>
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li class="active"><a href="#">首页</a></li>
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
                    <div id="personal" class="pull-right">
                        <!--小头像图片大小为40*40-->
                        <img src="${param.currentUser.uPhoto}" alt="username"></img>
                        <a href="personal.html"><c:out value="${requestScope.uName}"></c:out></a>
                        <a href="Quit">Quit</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="container">
        <div class="row">
        <!-- slide展示部分 -->
            <br>
            <div id="myCarousel" class="carousel slide span9">
              <div class="carousel-inner">
                <div class="active item"><img src="img/temp2.jpg" alt=""></div>
                <div class="item"><img src="img/temp1.jpg" alt=""></div>
                <div class="item"><img src="img/temp2.jpg" alt=""></div>
                <div class="item"><img src="img/temp1.jpg" alt=""></div>
              </div>
              <a class="carousel-control left" href="#myCarousel" data-slide="prev">‹</a>
              <a class="carousel-control right" href="#myCarousel" data-slide="next">›</a>
            </div>
            
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
                    <p>19<c:out value="${requestScope.uId}"></c:out>04</p><%--just for test --%>
                    <p>19<c:out value="${sessionScope.uId}"></c:out>93</p><%--just for test --%>
                    <p>45<c:out value="${requestScope.uName}"></c:out>12</p><%--just for test --%>
                    <p>45<c:out value="${sessionScope.uName}"></c:out>12</p><%--just for test --%>
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
            <div id="alert"></div>
            <div id="content" class="span9">
                <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
                    <div class="btn-group">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" title="字体"><i class="icon-font"></i><b
                        class="caret"></b></a>
                        <ul class="dropdown-menu">
                        </ul>
                    </div>
                    <div class="btn-group">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" title="字体大小">
                            <i class="icon-text-height"></i>&nbsp;<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
                            <li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
                            <li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
                        </ul>
                    </div>
                    <div class="btn-group">
                        <a class="btn" data-edit="bold" title="加粗(Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
                        <a class="btn" data-edit="italic" title="斜体 (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
                        <a class="btn" data-edit="strikethrough" title="删除线"><i
                        class="icon-strikethrough"></i></a>
                        <a class="btn" data-edit="underline" title="下划线 (Ctrl/Cmd+U)"><i
                        class="icon-underline"></i></a>
                    </div>
                    <div class="btn-group">
                        <a class="btn" data-edit="insertunorderedlist" title="无序列表"><i class="icon-list-ul"></i></a>
                        <a class="btn" data-edit="insertorderedlist" title="有序列表"><i class="icon-list-ol"></i></a>
                    </div>
                    <div class="btn-group">
                        <a class="btn" data-edit="justifyleft" title="左对齐 (Ctrl/Cmd+L)"><i
                        class="icon-align-left"></i></a>
                        <a class="btn" data-edit="justifycenter" title="居中对齐 (Ctrl/Cmd+E)"><i
                        class="icon-align-center"></i></a>
                    </div>
                    <div class="btn-group">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" title="加入超链接"><i
                        class="icon-link"></i></a>
                        <div class="dropdown-menu input-append">
                            <input class="span2" placeholder="URL" type="text" data-edit="createLink"/>
                            <button class="btn" type="button">Add</button>
                        </div>
                        <a class="btn" data-edit="unlink" title="删除超链接"><i class="icon-cut"></i></a>
                    </div>

                    <div class="btn-group">
                        <a class="btn" title="插入图片(支持直接拖拽)" id="pictureBtn"><i
                        class="icon-picture"></i></a>
                        <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage"/>
                    </div>
                    <div class="btn-group">
                        <a class="btn" data-edit="undo" title="撤销 (Ctrl/Cmd+Z)"><i class="icon-undo"></i></a>
                        <a class="btn" data-edit="redo" title="恢复 (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
                    </div>
                </div>
                <form  id="myform" action="Compose" method="post">
                    <input id="title" type="text" class="span7" placeholder="标题" name="composedArticle.nTitle"/>
                    <input type="text" class="hiden" name="composedArticle.nContent">
                    <div id="editor" class="span7">内容&hellip;</div>
                    <input type="submit"  id="output" class="btn btn-large btn-primary pull-right" value="发表"/>
                </form>
                <!--页面的主要内容放在这里, 一下为示例-->
                <c:forEach items="${articleList}" var="article">
                <div id="${article.nId}" class="well">
                    <h4><c:out value="${article.nTitle}"></c:out></h4>
                    <h6><c:out value="${article.nContent }"></c:out></h6>
                    
                    <p class="btn btn-inverse offset6"><a href="#">详细内容>></a></p>
                </div>
                </hr>
                </c:forEach>
                <p class="text-center text-info" onclick=sendRequest()>正在加载,请稍候</p>                
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