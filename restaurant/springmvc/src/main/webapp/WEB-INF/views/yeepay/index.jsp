<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/buy.css"></link>
</head>
<body>
<jsp:include page="WEB-INF/views/yeepay/payment/Head.jsp"></jsp:include>
<div id="totalBuy">
   <div id="buyHead">
   <span>首页</span><span>›</span><span>我的永乐</span><span>›</span><span>购物车</span>
   </div>
   <div id="buyBody">
      <div class="buySide">
   </div>
   <div id="buy">
      <div id="buy_1">
      </div>
      <div style="width: 920px; height: 40px; background-color: gray;">
      </div>
      <div class="confirm_per">
       <span class="blackFont">确认收货人信息[</span><span class="redFont">添加</span><span class="blackFont">]</span>
      </div>
      <div id="per_info">
        <table cellpadding="0px" cellspacing="0px">
           <tr>
             <td class="first_td">收货人姓名：</td>
             <td class="second_td">瓦尔大厦的</td>
           </tr>
              <tr>
             <td class="first_td">省市区域：</td>
             <td class="second_td">重庆市重庆市渝中区</td>
           </tr>
              <tr>
             <td class="first_td">详细地址：</td>
             <td class="second_td">阿斯顿飞洒</td>
           </tr>
              <tr>
             <td class="first_td">手机号码：</td>
             <td class="second_td">18862396669</td>
           </tr>
              <tr>
             <td class="first_td">邮箱地址：</td>
             <td class="second_td"></td>
           </tr>
              <tr>
             <td class="first_td">邮政编码： </td>
             <td class="second_td"></td>
           </tr>
        </table>
      </div>
       <div class="confirm_per">
       <span class="blackFont">确认购买信息</span>
      </div>
      <div id="buy_info">
          <table id="info_table" cellpadding="0px" cellspacing="0px">
              <tr id="first_tr">
                 <td>商品名称</td>
                 <td>商品状态</td>
                 <td>日期/场次</td>
                 <td>票价</td>
                 <td>商品折扣</td>
                 <td>数量</td>
                 <td>小计</td>
                 <td>退票保险</td>
              </tr>
                 <tr id="sec_tr">
                 <td class="sectd">太阳·芒刺—2013唐朝乐队北京音乐会
                 </td>
                 <td class="sectd">售票中</td>
                 <td class="sectd">2013-11-08  19:30</td>
                 <td class="sectd">180</td>
                 <td class="sectd">--</td>
                 <td class="sectd">1</td>
                 <td class="sectd">180</td>
                 <td>8*1</td>
              </tr>
          </table>
      </div>
      <div id="sub_btn">
           <a href="buy.jsp"><img src="image/sub_btn.png"/></a>
      </div>
   </div>
   <div class="buySide">

   </div>
   </div>
</div>
<jsp:include page="WEB-INF/views/yeepay/payment/foot.jsp"></jsp:include>
</body>
</html>