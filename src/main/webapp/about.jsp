<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CliveH
  Date: 2019/8/20
  Time: 10:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<!-- Head tag -->
<head>
    <meta name="keywords" content="何智强,关于何智强,何智强的个人博客,cliveh.cn,Clive' Blog,cliveh">
    <meta name="description" content="何智强,关于何智强,何智强的个人博客,cliveh.cn,Clive' Blog,cliveh">
    <meta name="author" content="何智强,cliveh.cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="google-site-verification" content="xBT4GhYoi5qRD5tr338pgPM5OWHHIDR6mNg1a3euekI">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/icon.jpg">
    <!-- Place this tag in your head or just before your close body tag. -->
    <!--<script async defer src="https://buttons.github.io/buttons.js"></script>-->
    <script async defer src="js/buttons.js"></script>
    <title>

        About - 何智强 | Blog

    </title>

    <link rel="canonical" href="http://cliveh.cn/about/">

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/beantech.min.css">

    <link rel="stylesheet" href="css/donate.css">

    <!-- Pygments Highlight CSS -->

    <!--<link rel="stylesheet" href="//cdn.bootcss.com/highlight.js/9.2.0/styles/github.min.css">-->
    <link rel="stylesheet" href="css/github.min.css">
    <!--<script src="//cdn.bootcss.com/highlight.js/9.2.0/highlight.min.js">-->
    <script src="js/highlight.min.js">
        // highlight
        hljs.initHighlightingOnLoad();
    </script>

    <link rel="stylesheet" href="css/highlight.css">

    <link rel="stylesheet" href="css/widget.css">

    <link rel="stylesheet" href="css/rocket.css">

    <link rel="stylesheet" href="css/signature.css">

    <link rel="stylesheet" href="css/toc.css">

    <!-- Custom Fonts -->
    <!-- <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"> -->
    <!-- Hux change font-awesome CDN to qiniu -->
    <link href="https://cdn.staticfile.org/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- ga & ba script hoook -->
    <script></script>

    <!--不蒜子-->
    <script async src="//busuanzi.ibruce.info/busuanzi/2.3/busuanzi.pure.mini.js"></script>


</head>


<!-- hack iOS CSS :active style -->
<body ontouchstart="">
<!-- Modified by Yu-Hsuan Yen -->
<!-- Post Header -->
<style type="text/css">
    header.intro-header {
        background-image: url('https://cn-cliveh-bucket-1256393662.cos.ap-guangzhou.myqcloud.com/article_header/about1.png')
        /*page*/
    <%--${pageContext.request.contextPath}/img/header_img/about.jpg--%>

    }


</style>

<header class="intro-header">
    <!-- Signature -->
    <div id="signature">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

                    <div class="site-heading">
                        <h1>
                            About
                        </h1>
                        <!--<hr class="small">

                        <span id="jrsc">正在加载今日诗词....</span>
                        <script src="https://sdk.jinrishici.com/v2/browser/jinrishici.js" charset="utf-8"></script>
                        <script type="text/javascript">
                            jinrishici.load(function (result) {
                                // 自己的处理逻辑
                                console.log(result.data.content, result.data.origin.author, result.data.origin.dynasty);
                                var string = result.data.content + "  ——" + result.data.origin.dynasty + "·" + result.data.origin.author;
                                document.getElementById("jrsc").innerHTML = string;
                            });
                        </script>-->
                        <span class="subheading">走在成为极客的路上</span>
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
                    <li>
                        <a href="${pageContext.request.contextPath}/fc/">怀旧游戏机</a>
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
    var $body   = document.body;
    var $toggle = document.querySelector('.navbar-toggle');
    var $navbar = document.querySelector('#huxblog_navbar');
    var $collapse = document.querySelector('.navbar-collapse');

    $toggle.addEventListener('click', handleMagic);
    function handleMagic(e){
        if ($navbar.className.indexOf('in') > 0) {
            // CLOSE
            $navbar.className = " ";
            // wait until animation end.
            setTimeout(function(){
                // prevent frequently toggle
                if($navbar.className.indexOf('in') < 0) {
                    $collapse.style.height = "0px"
                }
            },400)
        }else{
            // OPEN
            $collapse.style.height = "auto";
            $navbar.className += " in";
        }
    }
</script>


<!-- Main Content -->
<!-- Main Content -->
<div class="container">
    <div class="row">


        <!-- USE SIDEBAR -->
        <!-- Post Container -->
        <div class="
                col-lg-8 col-lg-offset-1
                col-md-8 col-md-offset-1
                col-sm-12
                col-xs-12
                post-container
            ">

            <h3 id="关于我">关于我</h3>
            <blockquote>
                <p>天蝎座，喜欢哆啦A梦、张国荣。常听粤语歌。</p>
                <p>对知识有强烈的求知欲，不断学习新技术。</p>
                <p>对技术、开发有浓厚的兴趣，坚持每天coding，喜欢记录和分享问题，技术博客文章持续更新中。</p>
            </blockquote>
            <h3 id="兴趣方向">兴趣方向</h3>
            <blockquote>
                <p>WEB，大数据，Python，Linux</p>
            </blockquote>
            <h3 id="联系我">联系我</h3>
            <blockquote>
                <p>Email: <a href="mailto:clivehe08@gmail.com" target="_blank" rel="noopener">clivehe08@gmail.com</a>
                    <!-- <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="mailto:157412086@qq.com" target="_blank" rel="noopener">157412086@qq.com</a> -->
                </p>
            </blockquote>


            <br>

            <!-- require APlayer 音乐播放器-->

            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/aplayer@1.10/dist/APlayer.min.css">
            <script src="https://cdn.jsdelivr.net/npm/aplayer@1.10/dist/APlayer.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/meting@1.2/dist/Meting.min.js"></script>

            <div class="aplayer" data-id="38917139" data-server="netease" data-type="playlist" data-fixed="false">
            </div>


            <!-- 如果开启评论功能 -->

            <hr>

            <!-- disqus 评论框 start -->
            <div class="comment">
                <div id="lv-container" data-id="city" data-uid="MTAyMC80NDE0MC8yMDY3NA=="></div>
            </div>
            <!-- disqus 评论框 end -->


            <!-- 来必力City版公共JS代码 start (一个网页只需插入一次) -->
            <script type="text/javascript">
                (function(d, s) {
                    var j, e = d.getElementsByTagName(s)[0];

                    if (typeof LivereTower === 'function') { return; }

                    j = d.createElement(s);
                    j.src = 'https://cdn-city.livere.com/js/embed.dist.js';
                    j.async = true;

                    e.parentNode.insertBefore(j, e);
                })(document, 'script');
            </script>
            <noscript>为正常使用来必力评论功能请激活JavaScript</noscript>
            <!-- 来必力City版 公共JS代码 end -->


        </div>

        <!-- Sidebar Container -->
        <div class="
    col-lg-3 col-lg-offset-0
    col-md-3 col-md-offset-0
    col-sm-12
    col-xs-12
    sidebar-container
">

            <!-- Featured Tags -->

            <section>
                <!-- no hr -->
                <h5><a href="${pageContext.request.contextPath}/tags">FEATURED TAGS</a></h5>
                <div class="tags" id="tagscloud" style="width:219px;height:180px;">

                    <%--词云--%>

                </div>
            </section>

            <hr>

            <!-- Short About -->
            <section class="visible-md visible-lg">
                <h5><a href="${pageContext.request.contextPath}/about.jsp">ABOUT ME</a></h5>
                <div class="short-about">

                    <img id="avatar_pic" src="${pageContext.request.contextPath}/img/avatar/ironman.png">

                    <%--<p>Stay hungry,Stay foolish</p>--%>
                    <p>保持学习、善良，与努力。</p>


                    <!-- SNS Link -->
                    <ul class="list-inline">

                        <li>
                            <a target="_blank" href="https://github.com/CliveHe">
                        <span class="fa-stack fa-lg">
                            <i class="fa fa-circle fa-stack-2x"></i>
                            <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                        </span>
                            </a>
                        </li>

                    </ul>
                </div>
            </section>

            <hr>

            <h5>RECENT POSTS
                <div class="widget">
                    <ul>
                        <br/>

                        <c:forEach items="${recentArticle}" var="article">

                            <li>
                                <a href="${pageContext.request.contextPath}/article?articleId=${article.id}">${article.articleTitle}</a>
                            </li>

                        </c:forEach>

                    </ul>
                </div>
            </h5>

            <hr>

            <!-- Friends Blog -->

            <%--<h5>ARCHIVES</h5>
            <div class="widget">
                <ul class="archive-list"><li class="archive-list-item"><a class="archive-list-link" href="/archives/2019/07/">July 2019</a><span class="archive-list-count">1</span></li><li class="archive-list-item"><a class="archive-list-link" href="/archives/2019/06/">June 2019</a><span class="archive-list-count">1</span></li><li class="archive-list-item"><a class="archive-list-link" href="/archives/2019/05/">May 2019</a><span class="archive-list-count">2</span></li></ul>
            </div>

            <hr>--%>

        </div>


    </div>
</div>


<style type="text/css">
    #tagscloud {
        width: 250px;
        height: 260px;
        position: relative;
        font-size: 12px;
        color: #333;
        margin: 20px auto 0;
        text-align: center;
    }

    #tagscloud a {
        position: absolute;
        top: 0px;
        left: 0px;
        color: #333;
        font-family: Arial;
        text-decoration: none;
        margin: 0 10px 15px 0;
        line-height: 18px;
        text-align: center;
        font-size: 12px;
        padding: 1px 5px;
        display: inline-block;
        border-radius: 3px;
    }
</style>


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

<!-- jQuery -->
<script src="js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="js/hux-blog.min.js"></script>


<!-- async load function -->
<script>
    function async(u, c) {
        var d = document, t = 'script',
            o = d.createElement(t),
            s = d.getElementsByTagName(t)[0];
        o.src = u;
        if (c) { o.addEventListener('load', function (e) { c(null, e); }, false); }
        s.parentNode.insertBefore(o, s);
    }
</script>

<!-- jquery.tagcloud.js -->
<script>
    // only load tagcloud.js in tag.html
    if($('#tag_cloud').length !== 0){
        async("http://cliveh.cn/js/jquery.tagcloud.js",function(){
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
    async("https://cdn.bootcss.com/fastclick/1.0.6/fastclick.min.js", function(){
        var $nav = document.querySelector("nav");
        if($nav) FastClick.attach($nav);
    })
</script>


<!-- Google Analytics -->


<script>
    // dynamic User by Hux
    var _gaId = 'UA-142144900-1';
    var _gaDomain = 'cliveh.cn';

    // Originial
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

    ga('create', _gaId, _gaDomain);
    ga('send', 'pageview');
</script>

<!-- Baidu Tongji -->

<script>
    // dynamic User by Hux
    var _baId = 'ff7cc1a6dca9e548d001a8b34a18ec0b';

    // Originial
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?" + _baId;
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>

<%--词云--%>
<script>
    $.get("tags?isJson=true",function (data) {
        var arr = JSON.parse(data);
        var item = "";
        $("#tagscloud").empty(); //清空
        $.each(arr,function (index,tag) {
            item += "<a href=\"${pageContext.request.contextPath}/tags#" + tag.tagName + "\" title=\"" + tag.tagName + "\" rel=\"" + tag.tagSize + "\">" + tag.tagName + "</a>"

        });
        $("#tagscloud").append(item);   // 显示到里面
    })
</script>
<script type="text/javascript" src="js/tagsCloud.js"></script>

<a id="rocket" href="#top" class=""></a>
<script type="text/javascript" src="js/totop.js?v=1.0.0" async=""></script>
<script type="text/javascript" src="js/toc.js?v=1.0.0" async=""></script>
<!--单击显示文字-->
<%--<script type="text/javascript" src="js/click_show_text.js"></script>--%>
<!-- Image to hack wechat -->
<!-- <img src="http://cliveh.cn/img/icon_wechat.png" width="0" height="0" /> -->
<!-- Migrate from head to bottom, no longer block render and still work -->

</body>
</html>
