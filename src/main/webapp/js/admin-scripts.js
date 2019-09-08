//当浏览器窗口大小改变时重载网页
/*window.onresize=function(){
    window.location.reload();
}*/

//页面加载时给img和a标签添加draggable属性
(function () {
    $('img').attr('draggable', 'false');
    $('a').attr('draggable', 'false');
})();
 
//设置Cookie
function setCookie(name, value, time) {
    var strsec = getsec(time);
    var exp = new Date();
    exp.setTime(exp.getTime() + strsec * 1);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}
function getsec(str) {
    var str1 = str.substring(1, str.length) * 1;
    var str2 = str.substring(0, 1);
    if (str2 == "s") {
        return str1 * 1000;
    } else if (str2 == "h") {
        return str1 * 60 * 60 * 1000;
    } else if (str2 == "d") {
        return str1 * 24 * 60 * 60 * 1000;
    }
}
 
//获取Cookie
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg)) {
        return unescape(arr[2]);
    } else {
        return null;
    }
}

var checkall=document.getElementsByName("checkbox[]");  
//全选
function select(){
	for(var $i=0;$i<checkall.length;$i++){  
		checkall[$i].checked=true;  
	}  
};
//反选
function reverse(){
	for(var $i=0;$i<checkall.length;$i++){  
		if(checkall[$i].checked){  
			checkall[$i].checked=false;  
		}else{  
			checkall[$i].checked=true;  
		}  
	}  
}     
//全不选     
function noselect(){ 
	for(var $i=0;$i<checkall.length;$i++){  
		checkall[$i].checked=false;  
	}  
} 

 
//启用工具提示
$('[data-toggle="tooltip"]').tooltip();
 


//Console
try {
    if (window.console && window.console.log) {
        console.log("\n欢迎访问 Clive's Blog！\n\n在本站可以看到前端技术，后端程序，网站内容管理系统等文章；\n\n还有我的程序人生！！！\n");
        console.log("\n请记住我们的网址：%c www.cliveh.cn", "color:red");
        console.log("\nCopyright © 何智强 2019");
    }
} catch (e) {};