<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CliveH
  Date: 2019/8/22
  Time: 10:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<!-- Head tag -->
<head>
    <meta name="generator" content="Hexo 3.8.0">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="google-site-verification" content="xBT4GhYoi5qRD5tr338pgPM5OWHHIDR6mNg1a3euekI">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keyword" content="">
    <link rel="shortcut icon" href="img/icon.jpg">
    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="js/buttons.js"></script>

    <!-- jQuery -->
    <script src="js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <title>

        ${article.articleTitle} - 何智强 | Blog

    </title>

    <link rel="canonical" href="http://cliveh.cn/article?articleId=${article.id}">

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/beantech.min.css">

    <link rel="stylesheet" href="css/donate.css">

    <!-- Pygments Highlight CSS -->
    <link href="http://cdn.bootcss.com/highlight.js/8.0/styles/monokai_sublime.min.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/highlight.js/8.0/highlight.min.js"></script>
    <script >hljs.initHighlightingOnLoad();</script>

<%--<link rel="stylesheet" href="//cdn.bootcss.com/highlight.js/9.2.0/styles/github.min.css">
    <script src="//cdn.bootcss.com/highlight.js/9.2.0/highlight.min.js">
        // highlight
        hljs.initHighlightingOnLoad();
    </script>--%>

    <link rel="stylesheet" href="css/highlight.css">
    <link rel="stylesheet" href="editormd/css/editormd.min.css"/>

    <link rel="stylesheet" href="css/widget.css">

    <link rel="stylesheet" href="css/rocket.css">

    <link rel="stylesheet" href="css/signature.css">

    <link rel="stylesheet" href="css/toc.css">

    <link href="https://cdn.staticfile.org/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">


    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

    <!-- ga & ba script hoook -->
    <script></script>

    <!--不蒜子-->
    <script async src="//busuanzi.ibruce.info/busuanzi/2.3/busuanzi.pure.mini.js"></script>

    <!--valine-->
    <script src="https://cdn1.lncld.net/static/js/3.0.4/av-min.js"></script>
    <script src="js/Valine.min.js"></script>
    <style>

        ::-webkit-input-placeholder { /* WebKit browsers */
            font-size: 14px;
        }

        ::-moz-placeholder { /* Mozilla Firefox 19+ */
            font-size: 14px;
        }

        :-ms-input-placeholder { /* Internet Explorer 10+ */
            font-size: 14px;
        }
    </style>


</head>


<!-- hack iOS CSS :active style -->
<body ontouchstart="">
<!-- Modified by Yu-Hsuan Yen -->
<!-- Post Header -->
<style type="text/css">
    header.intro-header {
        background-image: url('${article.articleImageUrl}')
        /*post*/
        <%--${pageContext.request.contextPath}/img/article_header/article_bg.jpg--%>

    }


</style>

<header class="intro-header">
    <!-- Signature -->
    <div id="signature">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

                    <div class="post-heading">
                        <div class="tags">

                            <c:forEach items="${article.tags}" var="tags">
                                <a class="tag" href="${pageContext.request.contextPath}/tags#${tags.tagName}"
                                   title="${tags.tagName}">
                                        ${tags.tagName}</a>
                            </c:forEach>

                        </div>
                        <h1>
                            ${article.articleTitle}
                        </h1>
                        <!-- <h2 class="subheading"></h2> -->
                        <!--文章访问量统计-->

                        <span id="busuanzi_container_page_pv">本文已被阅读过<span>${views}</span>次</span>

                        <!--文章访问量统计--> <span class="meta">
                            Posted by
                            ${article.articleAuthor} on
                            ${article.publishDate}
                        </span>
                    </div>


                </div>
            </div>
        </div>
    </div>
</header>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Clive&#39;s Blog</a>
        </div>

        <div id="huxblog_navbar">
            <div class="navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>


                    <li>
                        <a href="${pageContext.request.contextPath}/about">About</a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/archive">Archives</a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/tags">Tags</a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
                    </li>


                </ul>
            </div>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<script>
    // Drop Bootstarp low-performance Navbar
    // Use customize navbar with high-quality material design animation
    // in high-perf jank-free CSS3 implementation
    var $body = document.body;
    var $toggle = document.querySelector('.navbar-toggle');
    var $navbar = document.querySelector('#huxblog_navbar');
    var $collapse = document.querySelector('.navbar-collapse');

    $toggle.addEventListener('click', handleMagic)

    function handleMagic(e) {
        if ($navbar.className.indexOf('in') > 0) {
            // CLOSE
            $navbar.className = " ";
            // wait until animation end.
            setTimeout(function () {
                // prevent frequently toggle
                if ($navbar.className.indexOf('in') < 0) {
                    $collapse.style.height = "0px"
                }
            }, 400)
        } else {
            // OPEN
            $collapse.style.height = "auto";
            $navbar.className += " in";
        }
    }
</script>


<!-- Main Content -->
<!-- Modify by Yu-Hsuan Yen -->

<!-- Post Content -->
<article>
    <div class="container">
        <div class="row">

            <!-- Post Container -->
            <div class="
                col-lg-8 col-lg-offset-2
                col-md-10 col-md-offset-1
                post-container">

                ${article.articleContent}

                <!--解析文章内容-->
                <%--<link rel="stylesheet" href="editormd/css/editormd.min.css" />
                <div class="content editormd-preview-theme-dark" id="my-markdown-view">
                    <!-- Server-side output Markdown text -->

                    <textarea style="display:none;">${article.articleContent}</textarea>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="editormd/editormd.js"></script>
                <script src="editormd/lib/marked.min.js"></script>
                <script src="editormd/lib/prettify.min.js"></script>
                <script type="text/javascript">
                    $(function() {
                        var testView = editormd.markdownToHTML("my-markdown-view", {
                            // markdown : "[TOC]\n### Hello world!\n## Heading 2", // Also, you can dynamic set Markdown text
                            // htmlDecode : true,  // Enable / disable HTML tag encode.
                            // htmlDecode : "style,script,iframe",  // Note: If enabled, you should filter some dangerous HTML tags for website security.
                        });
                    });
                </script>--%>

                <hr>
                <!-- Pager -->
                <%--<script>
                    //异步加载上一篇和下一篇文章title
                    $(function () {
                        $.get("findTitle",{articleId: ${article.lastArticleId}},function (data) {
                            $("#last > span").html(data);
                        });

                        $.get("findTitle",{articleId: ${article.nextArticleId}},function (data) {
                            $("#next").html(data);
                        })
                    })
                </script>--%>
                <ul class="pager">

                    <c:if test="${article.nextArticleId != -1}">
                        <li class="previous">
                            <a id="last"
                               href="${pageContext.request.contextPath}/article?articleId=${article.nextArticleId}"
                               data-toggle="tooltip" data-placement="top" title="${nextArticleTitle}">&larr; Previous
                                Post</a>
                        </li>
                    </c:if>
                    <c:if test="${article.nextArticleId == -1}">
                        <li class="previous">
                            <a data-toggle="tooltip" data-placement="top"
                               title="${nextArticleTitle}">${nextArticleTitle}</a>
                        </li>
                    </c:if>


                    <c:if test="${article.lastArticleId != -1}">
                        <li class="next">
                            <a id="next"
                               href="${pageContext.request.contextPath}/article?articleId=${article.lastArticleId}"
                               data-toggle="tooltip" data-placement="top" title="${lastArticleTitle}">Next Post
                                &rarr;</a>
                        </li>
                    </c:if>
                    <c:if test="${article.lastArticleId == -1}">
                        <li class="next">
                            <a data-toggle="tooltip" data-placement="top"
                               title="${lastArticleTitle}">${lastArticleTitle}</a>
                        </li>
                    </c:if>

                </ul>

                <br>

                <!--打赏-->

                <!--打赏-->

                <br>
                <!--分享-->
                <div class="social-share" data-wechat-qrcode-helper="" align="center"></div>
                <!--  css & js -->
                <link rel="stylesheet"
                      href="https://cdnjs.cloudflare.com/ajax/libs/social-share.js/1.0.16/css/share.min.css">
                <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/social-share.js/1.0.16/js/social-share.min.js"></script>--%>

                <!--valine-->
                <br>
                <hr/>

                <div class="comment v">
                    <div class="vwrap">

                        <form id="form1" action="" method="post">
                            <div class="vheader item3">
                                <input name="username" placeholder="昵称" class="vnick vinput" type="text"><input
                                    name="email" placeholder="邮箱" class="vmail vinput" type="email"><input name="link"
                                                                                                          placeholder="网址(http://)"
                                                                                                          class="vlink vinput"
                                                                                                          type="text">
                            </div>
                            <div class="vedit">
                                <textarea name="commentContent" id="veditor" class="veditor vinput" placeholder="ヾﾉ≧∀≦)o来啊，快活啊!"></textarea>
                                <textarea name="articleId" style="display:none;">${article.id}</textarea>
                                <div class="vinput vpreview" style="display:none;"></div>
                            </div>
                        </form>

                        <div class="vcontrol">
                            <div class="col col-20" title="Markdown is supported">
                                <a href="https://segmentfault.com/markdown" target="_blank">
                                    <svg class="markdown" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true">
                                        <path fill-rule="evenodd" d="M14.85 3H1.15C.52 3 0 3.52 0 4.15v7.69C0 12.48.52 13 1.15 13h13.69c.64 0 1.15-.52 1.15-1.15v-7.7C16 3.52 15.48 3 14.85 3zM9 11H7V8L5.5 9.92 4 8v3H2V5h2l1.5 2L7 5h2v6zm2.99.5L9.5 8H11V5h2v3h1.5l-2.51 3.5z"></path>
                                    </svg>
                                </a>
                            </div>
                            <div class="col col-80 text-right">
                                <button type="button" title="Cmd|Ctrl+Enter" class="vsubmit vbtn">回复</button>
                            </div>
                        </div>

                        <div style="display:none;" class="vmark"></div>
                    </div>

                    <div class="vinfo" style="display:none;">
                        <div class="vcount col"></div>
                    </div>
                    <div class="vinfo" style="display:block;">
                        <div class="vcount col" style="font-size: 12px"><span class="vnum">${commentCount}</span> 评论</div>
                    </div>

                    <%--评论列表--%>
                    <div class="vlist">

                        <c:forEach items="${comments}" var="comment">
                            <div class="vcard" id="5d6ff4f3c8959c0068e6ab1b">
                                <img class="vimg" style="width: 50px;height: 50px" src="https://cn-cliveh-bucket-1256393662.cos.ap-guangzhou.myqcloud.com/img/20150811135126_hscVy.thumb.224_0.gif">
                                <div class="vh" rootid="5d6ff4f3c8959c0068e6ab1b">
                                    <div class="vhead">
                                        <a href="http://${comment.user.websiteUrl}" target="_blank"><span class="vnick" style="font-size: 16px">${comment.user.username}</span></a>
                                        <span class="vsys"
                                              style="display: inline-block;padding: .2rem .5rem;background: #ededed;color: #b3b1b1;font-size: .75rem;border-radius: .2rem;margin-right: .3rem;font-size: 10px">${comment.user.address}</span>
                                    </div>
                                </div>
                                <div class="vmeta">
                                    <span class="vtime" style="font-size: 12px">${comment.commentDate}</span>
                                    <%--<span class="vat" style="font-size: 16px">回复</span>--%>
                                </div>
                                <div class="vcontent" style="font-size: 14px">
                                    <p>${comment.commentContent}</p>
                                </div>
                            </div>
                        </c:forEach>

                    </div>

                    <div class="vempty" style="display:block;">快来做第一个评论的人吧~</div>

                    <%--<div class="vpage txt-center"></div>--%>
                    <%--<div class="info">
                        <div class="power txt-right">Powered By <a href="https://valine.js.org"
                                                                   target="_blank">Valine</a><br>v1.3.6
                        </div>
                    </div>--%>
                </div>


                <br>


                <!-- require APlayer -->


                <!-- duoshuo Share start -->

                <!-- 多说 Share end-->

                <!-- 多说评论框 start -->

                <!-- 多说评论框 end -->

                <!-- disqus comment start -->

                <!-- disqus comment end -->


                <!-- disqus 评论框 start -->
                <%--<div class="comment">
                    <div id="lv-container" data-id="city" data-uid="MTAyMC80NDE0MC8yMDY3NA=="></div>
                </div>--%>
                <!-- disqus 评论框 end -->


            </div>

            <!-- Tabe of Content -->
            <!-- Table of Contents -->


            <aside id="sidebar">
                <div id="toc" class="toc-article">
                    <strong class="toc-title">Contents</strong>

                    <ol class="toc-nav">

                        <%--jquery动态生成目录--%>
                            <li class="toc-nav-item toc-nav-level-2"><a class="toc-nav-link" href="#"><span
                                    class="toc-nav-number">1.</span> <span class="toc-nav-text">格式不对，请使用H2为目录标题</span></a>
                            </li>

                    </ol>

                </div>
            </aside>


            <!-- Sidebar Container -->
            <div class="
                col-lg-8 col-lg-offset-2
                col-md-10 col-md-offset-1
                sidebar-container">

                <!-- Featured Tags -->

                <section>
                    <!-- no hr -->
                    <h5><a href="${pageContext.request.contextPath}/tags">FEATURED TAGS</a></h5>
                    <div class="tags">

                        <c:forEach items="${article.tags}" var="tags">
                            <a class="tag" href="${pageContext.request.contextPath}/tags#${tags.tagName}"
                               title="${tags.tagName}">
                                    ${tags.tagName}</a>
                        </c:forEach>

                    </div>
                </section>


                <!-- Friends Blog -->

            </div>
        </div>
    </div>
</article>

<%--删除vempty--%>
<script>
    $(function () {
        //如果有评论数据
        var isComment = $(".vlist").html().trim().replace(/\s/g,"");
        if (isComment !== ''){
            //删除vempty
            $(".vempty").remove();
        }
    })
</script>

<%--异步回复--%>
<script>

    $(function () {
        $(".vsubmit").click(function () {

            $.ajax({
                url:'${pageContext.request.contextPath}/saveComment'+'?t='+Math.random(),
                data:$('#form1').serialize(),                 //将表单数据序列化，格式为name=value
                type:'POST',
                dataType:'json',
                cache: false,
                success:function(data){
                    //删除vempty
                    $(".vempty").remove();
                    //success
                    var commentContent = data.commentContent;
                    var commentDate = data.commentDate;
                    var user = data.user;
                    var url =  user.websiteUrl;

                    var item = "";
                    //$(".vlist").empty();

                    //判断网址是否有http://，https://开头
                    var str = new RegExp("//");
                    if (str.test(url)){
                        item += '<div class="vcard" id="5d6ff4f3c8959c0068e6ab1b"><img class="vimg" style="width: 50px;height: 50px" src="https://cn-cliveh-bucket-1256393662.cos.ap-guangzhou.myqcloud.com/img/20150811135126_hscVy.thumb.224_0.gif">\n' +
                            '            <div class="vh" rootid="5d6ff4f3c8959c0068e6ab1b">\n' +
                            '                <div class="vhead"><a href="'+user.websiteUrl+'" target="_blank"><span class="vnick" style="font-size: 16px">'+user.username+'</span></a> <span class="vsys" style="display: inline-block;padding: .2rem .5rem;background: #ededed;color: #b3b1b1;font-size: .75rem;border-radius: .2rem;margin-right: .3rem;font-size: 10px">'+user.address+'</span></div>\n' +
                            '                <div class="vmeta">\n' +
                            '                    <span class="vtime" style="font-size: 12px">'+commentDate+'</span>\n' +
                            '                    <span class="vat" style="font-size: 16px">回复</span>\n' +
                            '                </div>\n' +
                            '                <div class="vcontent" style="font-size: 14px">\n' +
                            '                    <p>'+commentContent+'</p>\n' +
                            '                </div>\n' +
                            '            </div></div>';
                    }else {
                        item += '<div class="vcard" id="5d6ff4f3c8959c0068e6ab1b"><img class="vimg" style="width: 50px;height: 50px" src="https://cn-cliveh-bucket-1256393662.cos.ap-guangzhou.myqcloud.com/img/20150811135126_hscVy.thumb.224_0.gif">\n' +
                            '            <div class="vh" rootid="5d6ff4f3c8959c0068e6ab1b">\n' +
                            '                <div class="vhead"><a href="http://'+user.websiteUrl+'" target="_blank"><span class="vnick" style="font-size: 16px">'+user.username+'</span></a> <span class="vsys" style="display: inline-block;padding: .2rem .5rem;background: #ededed;color: #b3b1b1;font-size: .75rem;border-radius: .2rem;margin-right: .3rem;font-size: 10px">'+user.address+'</span></div>\n' +
                            '                <div class="vmeta">\n' +
                            '                    <span class="vtime" style="font-size: 12px">'+commentDate+'</span>\n' +
                            '                    <span class="vat" style="font-size: 16px">回复</span>\n' +
                            '                </div>\n' +
                            '                <div class="vcontent" style="font-size: 14px">\n' +
                            '                    <p>'+commentContent+'</p>\n' +
                            '                </div>\n' +
                            '            </div></div>';
                    }

                    $(".vlist").prepend(item);   // 显示到前面
                },
                error:function(){
                    console.log("提交ajax函数异常");
                }

            });

        })
    })
</script>

<%--获取h2--%>
<script>

    var H2 = document.getElementsByTagName("h2");
    var item = "";
    $.each(H2,function (i, data) {
        $(".toc-nav").empty();

        var id = data.id;

        var index = i+1;

        var content = data.innerHTML;
        var split = content.split(">");

        item += '<li class="toc-nav-item toc-nav-level-2"><a class="toc-nav-link" href="#'+ id +'"><span\n' +
            '                                class="toc-nav-number">'+ index +'.</span> <span class="toc-nav-text">'+ split[split.length-1] +'</span></a>\n' +
            '                        </li>';
    });

    // 显示到里面
    $(".toc-nav").append(item);

</script>

<!--动态背景-->
<%--<script color="0,0,255" opacity='0.6' count="200" src="https://cdn.bootcss.com/canvas-nest.js/2.0.4/canvas-nest.js"></script>--%>

<!-- 音乐播放器 -->
<link href="https://cdn.bootcss.com/aplayer/1.10.1/APlayer.min.css" rel="stylesheet">
<style>
    li {margin: 0em 0;}
    button {min-height: 0px;}
    .aplayer {margin: 0 0 1.75em 0 !important;}
    .aplayer.aplayer-fixed .aplayer-list {
        margin-bottom: 40px;
        border: 1px solid #eee;
        border-bottom: none;
    }
</style>
<div id="aplayer" class="aplayer" data-id="38917139" data-server="netease" data-type="playlist" data-fixed="true" ></div>
<script src="https://cdn.bootcss.com/aplayer/1.10.1/APlayer.min.js"></script>
<script src="https://unpkg.com/meting@1.2/dist/Meting.min.js"></script>
<!-- 音乐播放器end -->

<!-- 来必力City版公共JS代码 start (一个网页只需插入一次) -->
<script type="text/javascript">
    (function (d, s) {
        var j, e = d.getElementsByTagName(s)[0];

        if (typeof LivereTower === 'function') {
            return;
        }

        j = d.createElement(s);
        j.src = 'https://cdn-city.livere.com/js/embed.dist.js';
        j.async = true;

        e.parentNode.insertBefore(j, e);
    })(document, 'script');
</script>
<noscript>为正常使用来必力评论功能请激活JavaScript</noscript>
<!-- 来必力City版 公共JS代码 end -->


<!-- async load function -->
<script>
    function async(u, c) {
        var d = document, t = 'script',
            o = d.createElement(t),
            s = d.getElementsByTagName(t)[0];
        o.src = u;
        if (c) {
            o.addEventListener('load', function (e) {
                c(null, e);
            }, false);
        }
        s.parentNode.insertBefore(o, s);
    }
</script>
<!-- anchor-js, Doc:http://bryanbraun.github.io/anchorjs/ -->
<script>
    async("https://cdn.bootcss.com/anchor-js/1.1.1/anchor.min.js", function () {
        anchors.options = {
            visible: 'hover',
            placement: 'left',
            icon: 'ℬ'
        };
        anchors.add().remove('.intro-header h1').remove('.subheading').remove('.sidebar-container h5');
    })
</script>
<style>
    /* place left on bigger screen */
    @media all and (min-width: 800px) {
        .anchorjs-link {
            position: absolute;
            left: -0.75em;
            font-size: 1.1em;
            margin-top: -0.1em;
        }
    }
</style>

<!-- Custom Theme JavaScript -->
<script src="js/hux-blog.min.js"></script>

<!-- 复制添加版权申明-->
<%--<script>
    /**/
    function setClipboardText(event) {
        event.preventDefault();//阻止元素发生默认的行为（例如，当点击提交按钮时阻止对表单的提交）。
        var node = document.createElement('div');
        //对documentfragment不熟，不知道怎么获取里面的内容，用了一个比较笨的方式
        node.appendChild(window.getSelection().getRangeAt(0).cloneContents());
        //getRangeAt(0)返回对基于零的数字索引与传递参数匹配的选择对象中的范围的引用。对于连续选择，参数应为零。
        var htmlData = '<div>'
            + node.innerHTML
            + '<br /><br /><hr />著作权归作者所有。<br />'
            + '商业转载请联系作者获得授权，非商业转载请注明出处。<br />'
            + '作者：CliveH <br />链接：'
            + location.href
            + '<br />来源：cliveh.cn<br /><br />'
            + '</div>';
        var textData = window.getSelection().getRangeAt(0)
            + '\n\n著作权归作者所有。\n'
            + '商业转载请联系作者获得授权，非商业转载请注明出处。\n'
            + '作者：CliveH\n'
            + '链接：'
            + location.href
            + '来源：cliveh.cn\n\n';
        if (event.clipboardData) {
            event.clipboardData.setData("text/html", htmlData);
            //setData(剪贴板格式, 数据) 给剪贴板赋予指定格式的数据。返回 true 表示操作成功。
            event.clipboardData.setData("text/plain", textData);
        } else if (window.clipboardData) { //window.clipboardData的作用是在页面上将需要的东西复制到剪贴板上，提供了对于预定义的剪贴板格式的访问，以便在编辑操作中使用。
            return window.clipboardData.setData("text", textData);
        }
    };

    document.addEventListener('copy', function (e) {
        setClipboardText(e);
    });
</script>--%>

<!-- chrome Firefox 中文锚点定位失效-->
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<!-- smooth scroll behavior polyfill  -->
<script type="text/javascript" src="js/smoothscroll.js"></script>
<script>
    $('#toc').on('click', 'a', function (a) {
        // var isChrome = window.navigator.userAgent.indexOf("Chrome") !== -1;
        // console.log(window.navigator.userAgent,isChrome)
        // if(isChrome) {
        // console.log(a.currentTarget.outerHTML);
        // console.log($(a.currentTarget).attr("href"));
        //跳转到指定锚点
        // document.getElementById(a.target.innerText.toLowerCase()).scrollIntoView(true);
        document.getElementById($(a.currentTarget).attr("href").replace("#", "")).scrollIntoView({behavior: 'smooth'});
        // }
    })
</script>


<!-- Footer -->
<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <ul class="list-inline text-center">


                    <li>
                        <a target="_blank" href="mailto:157412086@qq.com">
                            <span class="fa-stack fa-lg">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
                            </span>
                        </a>
                    </li>


                    <li>
                        <a target="_blank" href="https://github.com/CliveHe">
                            <span class="fa-stack fa-lg">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                            </span>
                        </a>
                    </li>


                </ul>
                <p class="copyright text-muted">
                    Copyright &copy; <a href="https://github.com/CliveHe/">何智强</a> 2019 All Rights Reserved&nbsp;&nbsp;|&nbsp;
                    <iframe src="https://ghbtns.com/github-btn.html?user=CliveHe&repo=MyBlog&type=star&count=true" style="margin-left: 2px; margin-bottom:-5px;" frameborder="0" scrolling="0" width="91px" height="20px">
                    </iframe>
                    <br>
                    <a href="http://beian.miit.gov.cn" target="_blank">湘ICP备19011167号</a>

                    <br>
                    <!--总访问量统计-->
                    <span id="busuanzi_container_site_pv" style="margin-left: 3px;">
                            本站总访问量 <span style="font-weight: bold" id="busuanzi_value_site_pv"></span> 次
                    </span>&nbsp;|&nbsp;
                    <span id="busuanzi_container_site_uv" style="margin-left: 3px;">
                        本站访客数 <span style="font-weight: bold" id="busuanzi_value_site_uv"></span> 人次
                    </span>
                </p>
            </div>
        </div>
    </div>
</footer>


<!-- async load function -->
<script>
    function async(u, c) {
        var d = document, t = 'script',
            o = d.createElement(t),
            s = d.getElementsByTagName(t)[0];
        o.src = u;
        if (c) {
            o.addEventListener('load', function (e) {
                c(null, e);
            }, false);
        }
        s.parentNode.insertBefore(o, s);
    }
</script>


<!-- jquery.tagcloud.js -->
<script>
    // only load tagcloud.js in tag.html
    if ($('#tag_cloud').length !== 0) {
        async("http://cliveh.cn/js/jquery.tagcloud.js", function () {
            $.fn.tagcloud.defaults = {
                //size: {start: 1, end: 1, unit: 'em'},
                color: {start: '#bbbbee', end: '#0085a1'},
            };
            $('#tag_cloud a').tagcloud();
        })
    }
</script>

<!--fastClick.js -->
<script>
    async("https://cdn.bootcss.com/fastclick/1.0.6/fastclick.min.js", function () {
        var $nav = document.querySelector("nav");
        if ($nav) FastClick.attach($nav);
    })
</script>


<!-- Google Analytics -->


<script>
    // dynamic User by Hux
    var _gaId = 'UA-142144900-1';
    var _gaDomain = 'cliveh.cn';

    // Originial
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o),
            m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

    ga('create', _gaId, _gaDomain);
    ga('send', 'pageview');
</script>


<!-- Baidu Tongji -->

<script>
    // dynamic User by Hux
    var _baId = 'ff7cc1a6dca9e548d001a8b34a18ec0b';

    // Originial
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?" + _baId;
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>


<a id="rocket" href="#top" class=""></a>
<script type="text/javascript" src="js/totop.js?v=1.0.0" async=""></script>
<script type="text/javascript" src="js/toc.js?v=1.0.0" async=""></script>
<!--单击显示文字-->
<script type="text/javascript" src="js/click_show_text.js"></script>
<!-- Image to hack wechat -->
<!-- <img src="http://cliveh.cn/img/icon_wechat.png" width="0" height="0" /> -->
<!-- Migrate from head to bottom, no longer block render and still work -->

</body>
</html>
