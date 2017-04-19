<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'foot.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/MyStyle.css">
	

  </head>
  
  <body>
         <div id="foot">
               <div id="foot_1">关于永乐 | 永乐大事记 | 品牌识别 | 合作招商 | 服务条款 | 隐私声明 | 招聘信息 | 联系我们 | 友情链接 | 网站地图 | 官方微博</div>       
               <div id="foot_2">版权所有 永乐票务 Copyright &copy 2003-2013 All Rights Reserved 京ICP证030942号 京公网安备11010102000758号<br>
 中国最大的演出门票预订综合性票务网站之一，为您提供各类演出票务网上订票服务。——"快乐生活 源自多彩永乐"<br>
北京春秋永乐文化传播有限公司
               </div>
               <div id=""></div>
         </div>
  </body>
</html>
