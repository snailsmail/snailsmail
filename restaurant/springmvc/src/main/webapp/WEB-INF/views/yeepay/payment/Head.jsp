<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/head_foot_css.css">
	<script type="text/javascript" src="jquery-1.6.js"></script>

  </head>
  
  <body>        
         <div id="head">
              <div id="head_1">
                    <div id="head_1_inner">
                           <div id="hello_div"><span id="span_hello">您好，欢迎来永乐票务！请 [<a href="#" class="login">登录</a>] [<a href="#" class="login">注册</a>]</span></div>
                           <div id="top_title">
                                <div id="help_div"><a href="#" id="help">帮助中心</a> </div>
                                <div id="websit_div" >
                                     <div id="1" style="position: absolute;z-index: 2;float:left; background-color: white;">
                                     <div onmouseover="list1.style.display='block'"  onmouseout="list1.style.display='none'" ><a href="#" id="menu2" class="login">网站导航</a></div>
									 <div style="display:none;" id="list1" onmouseover="list1.style.display='block'"  onmouseout="list1.style.display='none'" >
											<a href="#" class="login">演唱会</a><br>
											<a href="#" class="login">音乐会</a><br>
											<a href="#" class="login">话剧舞台剧</a><br>
											<a href="#" class="login">舞蹈芭蕾</a><br>
											<a href="#" class="login">戏取综艺</a><br>
											<a href="#" class="login">儿童亲子</a><br>
											<a href="#" class="login">休闲娱乐</a><br>
											<a href="#" class="login">体育赛事</a>
									 </div> 
									 </div>  
                                </div>
                                <div id="index_div">
										<div onmouseover="list.style.display='block'"  onmouseout="list.style.display='none'" ><a href="#" id="menu1" class="login">永乐首页</a></div>
										<div style="display:none;" id="list" onmouseover="list.style.display='block'"  onmouseout="list.style.display='none'" >
											<a href="#" class="login">专题会</a><br>
											<a href="#" class="login">场馆库</a><br>
											<a href="#" class="login">最新资料</a>
										</div>   
                                </div>
                           </div>
                     </div>
              </div>
              <div id="head_2">
                   <div id="logo"><img src="image/logo.png"></div>
                   <div id="logo_right">
                     <div id="space_div"></div>
                     <div id="search_out">
                       
                        <div id="search">
                        
                            <div id="search_input">
                                <div id="input_div"><input type="text" id="input_id" value="请输入演出艺人,场馆名称" /></div>
                                <div id="search_image"><a href="#" id="search_id" ><img src="image/serch.jpg"/ style="border-width: 0px;"></a></div></div>
                            <div id="search_start">
                              <table id="tab_star">
                                 <tr>
                                      <%
                                       String[] star={"汪峰","刘德华","周杰伦","王菲","后玄","张学友","萧敬腾","中国好声音","后来"};
                                        for(int i=0;i<9;i++)
                                        {
                                        %>
                                          <td><a href="#" id="star_id"><%=star[i] %></a></td> 
                                        <%
                                        }
                                      %>
                                 </tr>
                              </table>
                            </div>
                        </div>
                       
                       </div>
                       <div id="adv_search"><div id="font_adv"><a href="#" class="adv_href">高级搜索</a></div></div>
                       <div id="phone_div"><img src="image/phone.png"></div>
                   </div>
              </div>  
              <div id="head_3">
                    <div id="head_3_1">
                           <%
                              String[] str={"首页","演唱会","音乐会","话剧舞台剧","舞蹈芭蕾","戏曲综艺","儿童亲子","休闲娱乐","体育赛事"};
                              for(int i=8;i>=0;i--){
                              %>
                              <div id="classic"><%=str[i] %></div>
                              <%
                              }
                            %>  
                    </div>
                    <div id="head_3_2">
                        <div id="hot">热点:</div>
                        <div id="hot_title"><span id="hot1"></span>   <span id="hot1"></span>   <span id="hot1"></span></div>
                        <div id="right_title">
                             <table id="tab">
                                   <tr>
                                      <td><a href="#" class="tab_title">专题汇</a></td>
                                      <td><a href="#" class="tab_title">场馆库</a></td>
                                      <td><a href="#" class="tab_title">最新资讯</a></td>
                                   </tr>
                             </table>
                        </div>
                    </div>
              </div>
         </div>
  </body>
  <script type="text/javascript">
//鼠标焦点移进，文字消失 
$("#input_id").click(function(){ 
var check1 = $(this).val(); 
if (check1 == this.defaultValue){ 
$(this).val(""); 
}
});

$("#input_id").blur(function () { 
$(this).val(this.defaultValue); 
}); 

</script>
</html>













