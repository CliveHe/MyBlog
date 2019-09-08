<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CliveH
  Date: 2019/8/22
  Time: 15:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>写文章 - Clive's 的博客管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="images/icon/icon.png">
    <link rel="shortcut icon" href="images/icon/favicon.ico">
    <!--[if gte IE 9]>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/html5shiv.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/respond.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script>window.location.href='upgrade-browser.html';</script>
    <![endif]-->
</head>

<body class="user-select">
<section class="container-fluid">
    <header>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Clive's Blog</a> </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="">消息 <span class="badge">1</span></a></li>
                        <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">admin <span class="caret"></span></a>
                            <ul class="dropdown-menu dropdown-menu-left">
                                <li><a title="查看或修改个人信息" data-toggle="modal" data-target="#seeUserInfo">个人信息</a></li>
                                <li><a title="查看您的登录记录" data-toggle="modal" data-target="#seeUserLoginlog">登录记录</a></li>
                            </ul>
                        </li>
                        <li><a href="/Index/outLogin" onClick="if(!confirm('是否确认退出？'))return false;">退出登录</a></li>
                        <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>
                    </ul>
                    <form action="" method="post" class="navbar-form navbar-right" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" autocomplete="off" placeholder="键入关键字搜索" maxlength="15">
                            <span class="input-group-btn">
              <button class="btn btn-default" type="submit">搜索</button>
              </span> </div>
                    </form>
                </div>
            </div>
        </nav>
    </header>
    <div class="row">
        <aside class="col-sm-2 col-md-1 col-lg-1 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/main">报告</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="${pageContext.request.contextPath}/manageArticle">文章</a></li>
                <li><a href="${pageContext.request.contextPath}/notice.jsp">公告</a></li>
                <li><a href="${pageContext.request.contextPath}/comment.jsp">评论</a></li>
                <li><a data-toggle="tooltip" data-placement="top" title="网站暂无留言功能">留言</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/category.jsp">栏目</a></li>
                <li><a class="dropdown-toggle" id="otherMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">其他</a>
                    <ul class="dropdown-menu" aria-labelledby="otherMenu">
                        <li><a href="${pageContext.request.contextPath}/user-group.jsp">友情链接</a></li>
                        <li><a href="${pageContext.request.contextPath}/loginlog.jsp">访问记录</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a class="dropdown-toggle" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">用户</a>
                    <ul class="dropdown-menu" aria-labelledby="userMenu">
                        <li><a href="${pageContext.request.contextPath}/user-group.jsp">管理用户组</a></li>
                        <li><a href="${pageContext.request.contextPath}/manage-user.jsp">管理用户</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/loginlog.jsp">管理登录日志</a></li>
                    </ul>
                </li>
                <li><a class="dropdown-toggle" id="settingMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">设置</a>
                    <ul class="dropdown-menu" aria-labelledby="settingMenu">
                        <li><a href="${pageContext.request.contextPath}/setting.jsp">基本设置</a></li>
                        <li><a href="${pageContext.request.contextPath}/readset.jsp">用户设置</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/safety.jsp">安全配置</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="disabled"><a>扩展菜单</a></li>
                    </ul>
                </li>
            </ul>
        </aside>
        <div class="col-sm-10 col-sm-offset-2 col-md-11 col-lg-11 col-md-offset-1 main" id="main">
            <div class="row">

                <form action="${pageContext.request.contextPath}/addArticle" method="post" class="add-article-form" accept-charset="UTF-8">
                    <div class="col-md-9">
                        <h1 class="page-header">撰写新文章</h1>
                        <div class="col-md-9">
                            <div class="form-group">
                                <label for="article-title" class="sr-only">标题</label>
                                <input type="text" id="article-title" name="articleTitle" class="form-control" placeholder="在此处输入标题" required autofocus autocomplete="off">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="article-author" class="sr-only">作者</label>
                                <input type="text" id="article-author" name="articleAuthor" class="form-control" placeholder="在此处输入作者" required autofocus autocomplete="off">
                            </div>
                        </div>

                        <!--Editor.md文本编辑器-->
                        <div class="form-group">
                            <label for="article-content" class="sr-only">内容</label>
                            <%--<script id="article-content" name="content" type="text/plain"></script>--%>
                            <link rel="stylesheet" href="${pageContext.request.contextPath}/editormd/css/editormd.min.css" />
                            <!--MarkDown的id标志 -->
                            <div class="editormd" id="my-editormd">
                                <!-- 书写与实时显示的textarea -->
                                <textarea  class="editormd-markdown-textarea" id="my-editormd-markdown-doc" name="my-editormd-markdown-doc" style="display:none;"></textarea>
                                <!-- 用于后端获取md文档内容，Java中：request.getParameter("my-editormd-html-code")。-->
                                <textarea  class="editormd-html-textarea" id="my-editormd-html-code" name="my-editormd-html-code" style="display:none;"></textarea>
                            </div>
                            <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
                            <script src="${pageContext.request.contextPath}/editormd/editormd.min.js"></script>
                            <script id="article-content" type="text/javascript">
                                $(function() {
                                    var editor = editormd("my-editormd", {
                                        // width  : "100%",
                                        // height : "100%",
                                        //theme : "dark",
                                        syncScrolling : "single",
                                        emoji : true,
                                        path   : "editormd/lib/",
                                        saveHTMLToTextarea : true,
                                        previewTheme : "dark"
                                    });

                                    //editor.getHTML();
                                });
                            </script>
                        </div>


                       <%-- <div class="add-article-box">
                            <h2 class="add-article-box-title"><span>作者</span></h2>
                            <div class="add-article-box-content">
                                <input type="text" class="form-control" placeholder="请输入名字" name="articleAuthor" autocomplete="off">
                                <span class="prompt-text">多个作者请用英文逗号，隔开</span>
                            </div>
                        </div>--%>
                        <div class="add-article-box">
                            <h2 class="add-article-box-title"><span>文章摘要</span></h2>
                            <div class="add-article-box-content">
                                <textarea class="form-control" name="articleAbstract" autocomplete="off"></textarea>
                                <span class="prompt-text">摘要是内容总结，并可以在网页描述中使用</span>
                            </div>
                        </div>
                        <%--<div class="add-article-box">
                            <h2 class="add-article-box-title"><span>文章头图url</span></h2>
                            <div class="add-article-box-content">
                                <input type="text" class="form-control" placeholder="请输入标签" name="articleImageUrl" autocomplete="off">
                                <span class="prompt-text">多个标签请用英文逗号，隔开</span>
                            </div>
                        </div>--%>
                    </div>
                    <div class="col-md-3">
                        <h1 class="page-header">操作</h1>

                        <div class="add-article-box">
                            <h2 class="add-article-box-title"><span>标签</span></h2>

                            <div class="add-article-box-content">
                                <ul class="category-list">

                                    <%--<li>
                                        <label>
                                            <input name="tags" type="radio" value="1" checked>
                                            ${tags.tagName}
                                            <sup>${tags.tagSize}</sup> <em class="hidden-md">( 标签ID: <span>1</span> )</em></label>
                                    </li>--%>
                                    <%--js显示标签内容--%>
                                </ul>
                            </div>
                            <div class="add-article-box-footer">
                                <button class="btn btn-default" type="button" ID="uncheck">取消选中</button>
                            </div>
                            <script>
                                $(function () {
                                    $.get("tags?isJson=true",function (data) {
                                        var arr = JSON.parse(data);
                                        var item = "";
                                        $(".category-list").empty(); //清空
                                        $.each(arr,function (index,tag) {
                                            item += "<li>\n" +
                                                "<label>\n" +
                                                "<input class='checkbox' name=\"tags\" type=\"checkbox\" value=\'"+tag.tagId+"\'>\n" +
                                                tag.tagName +
                                                " <sup>"+tag.tagSize+"</sup> <em class=\"hidden-md\"> ( 标签ID: <span>"+tag.tagId+"</span> )</em></label>\n" +
                                                "</li>"

                                        });
                                        $(".category-list").append(item);   // 显示到里面
                                    })
                                });

                                //取消选中
                                $(function () {
                                    $("#uncheck").click(function () {
                                        $(".checkbox").attr("checked", false);
                                    })
                                })
                            </script>
                        </div>

                        <div class="add-article-box">
                            <h2 class="add-article-box-title"><span>添加新标签</span></h2>
                            <div class="add-article-box-content">
                                <input type="text" class="form-control" placeholder="输入新标签" name="newTags" autocomplete="off">
                                <span class="prompt-text">首字母大写，多个标签请用英文逗号,隔开</span> </div>
                        </div>

                        <div class="add-article-box">
                            <h2 class="add-article-box-title"><span>文章头图</span></h2>
                            <div class="add-article-box-content">
                                <input type="text" class="form-control" placeholder="/img/article_header/article_bg.jpg" id="pictureUpload" name="articleImageUrl" autocomplete="off">
                            </div>
                            <div class="add-article-box-footer">
                                <button class="btn btn-default" type="button" ID="upImage">选择</button>
                            </div>
                        </div>

                        <div class="add-article-box">
                            <h2 class="add-article-box-title"><span>发布</span></h2>
                            <div class="add-article-box-content">
                                <p><label>状态：</label><span class="article-status-display">未发布</span></p>
                                <p><label>公开度：</label><input type="radio" name="visibility" value="0" checked/>公开 <input type="radio" name="visibility" value="1" />加密</p>
                                <p><label>发布于：</label><span class="article-time-display"><input style="border: none;" type="datetime" name="publishDate" value="" autocomplete="off" /></span></p>
                            </div>
                            <div class="add-article-box-footer">
                                <button class="btn btn-primary" type="submit" name="submit">发布文章</button>
                            </div>
                        </div>

                    </div>
                </form>

            </div>
        </div>
    </div>
</section>

<!--个人信息模态框-->
<div class="modal fade" id="seeUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <form action="${pageContext.request.contextPath}/updateUser" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" >个人信息</h4>
                </div>
                <div class="modal-body">
                    <table class="table" style="margin-bottom:0px;">
                        <thead>
                        <tr> </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td wdith="30%">用户名:</td>
                            <td width="70%"><input type="text" value="${adminUser.username}" class="form-control" name="username" maxlength="10" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td wdith="30%">邮箱:</td>
                            <td width="70%"><input type="email" value="${adminUser.email}" class="form-control" name="email" maxlength="13" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td wdith="30%">旧密码:</td>
                            <td width="70%"><input type="password" class="form-control" name="oldPassword" maxlength="18" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td wdith="30%">新密码:</td>
                            <td width="70%"><input id="password" type="password" class="form-control" name="password" placeholder="请输入6-12位数字或字母" maxlength="18" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td wdith="30%">确认密码:</td>
                            <td width="70%"><input id="newPassword" type="password" class="form-control" name="newPassword" placeholder="请输入6-12位数字或字母" maxlength="18" autocomplete="off" /></td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr></tr>
                        </tfoot>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" onclick="return checkPassword()" class="btn btn-primary">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function checkPassword() {
        var pwd = $("#password").val();
        var newPwd = $("#newPassword").val();
        //定义正则表达式
        var reg_password = /^[0-9a-zA-Z.*-_]{6,12}$/;

        if (!reg_password.test(pwd)){
            alert("密码格式不正确");
            return false
        }

        if (pwd === newPwd){
            return true
        }

        if (pwd !== newPwd){
            alert("确认密码不一致");
            return false
        }

        return false
    }
</script>
<!--个人登录记录模态框-->
<div class="modal fade" id="seeUserLoginlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >登录记录</h4>
            </div>
            <div class="modal-body">
                <table class="table" style="margin-bottom:0px;">
                    <thead>
                    <tr>
                        <th>登录IP</th>
                        <th>登录时间</th>
                        <th>状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>::1:55570</td>
                        <td>2016-01-08 15:50:28</td>
                        <td>成功</td>
                    </tr>
                    <tr>
                        <td>::1:64377</td>
                        <td>2016-01-08 10:27:44</td>
                        <td>成功</td>
                    </tr>
                    <tr>
                        <td>::1:64027</td>
                        <td>2016-01-08 10:19:25</td>
                        <td>成功</td>
                    </tr>
                    <tr>
                        <td>::1:57081</td>
                        <td>2016-01-06 10:35:12</td>
                        <td>成功</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">朕已阅</button>
            </div>
        </div>
    </div>
</div>
<!--微信二维码模态框-->
<div class="modal fade user-select" id="WeChat" tabindex="-1" role="dialog" aria-labelledby="WeChatModalLabel">
    <div class="modal-dialog" role="document" style="margin-top:120px;max-width:280px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
            </div>
            <div class="modal-body" style="text-align:center"> <img src="images/weixin.jpg" alt="" style="cursor:pointer"/> </div>
        </div>
    </div>
</div>
<!--提示模态框-->
<div class="modal fade user-select" id="areDeveloping" tabindex="-1" role="dialog" aria-labelledby="areDevelopingModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="areDevelopingModalLabel" style="cursor:default;">该功能正在日以继夜的开发中…</h4>
            </div>
            <div class="modal-body"> <img src="images/baoman/baoman_01.gif" alt="深思熟虑" />
                <p style="padding:15px 15px 15px 100px; position:absolute; top:15px; cursor:default;">很抱歉，程序猿正在日以继夜的开发此功能，本程序将会在以后的版本中持续完善！</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">朕已阅</button>
            </div>
        </div>
    </div>
</div>
<!--右键菜单列表-->
<div id="rightClickMenu">
    <ul class="list-group rightClickMenuList">
        <li class="list-group-item disabled">欢迎访问异清轩博客</li>
        <li class="list-group-item"><span>IP：</span>172.16.10.129</li>
        <li class="list-group-item"><span>地址：</span>河南省郑州市</li>
        <li class="list-group-item"><span>系统：</span>Windows10 </li>
        <li class="list-group-item"><span>浏览器：</span>Chrome47</li>
    </ul>
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/admin-scripts.js"></script>
<script src="${pageContext.request.contextPath}/lib/ueditor/ueditor.config.js"></script>
<script src="${pageContext.request.contextPath}/lib/ueditor/ueditor.all.min.js"> </script>
<script src="${pageContext.request.contextPath}/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
<script id="uploadEditor" type="text/plain" style="display:none;"></script>
<script type="text/javascript">
    var editor = UE.getEditor('article-content');
    window.onresize=function(){
        window.location.reload();
    }
    var _uploadEditor;
    $(function () {
        //重新实例化一个编辑器，防止在上面的editor编辑器中显示上传的图片或者文件
        _uploadEditor = UE.getEditor('uploadEditor');
        _uploadEditor.ready(function () {
            //设置编辑器不可用
            //_uploadEditor.setDisabled();
            //隐藏编辑器，因为不会用到这个编辑器实例，所以要隐藏
            _uploadEditor.hide();
            //侦听图片上传
            _uploadEditor.addListener('beforeInsertImage', function (t, arg) {
                //将地址赋值给相应的input,只去第一张图片的路径
                $("#pictureUpload").attr("value", arg[0].src);
                //图片预览
                //$("#imgPreview").attr("src", arg[0].src);
            })
            //侦听文件上传，取上传文件列表中第一个上传的文件的路径
            _uploadEditor.addListener('afterUpfile', function (t, arg) {
                $("#fileUpload").attr("value", _uploadEditor.options.filePath + arg[0].url);
            })
        });
    });
    //弹出图片上传的对话框
    $('#upImage').click(function () {
        var myImage = _uploadEditor.getDialog("insertimage");
        myImage.open();
    });
    //弹出文件上传的对话框
    function upFiles() {
        var myFiles = _uploadEditor.getDialog("attachment");
        myFiles.open();
    }
</script>
</body>
</html>
