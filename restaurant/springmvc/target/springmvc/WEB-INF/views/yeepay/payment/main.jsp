<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style type="text/css">
#paySubmit
{
	width: 1000px;
	border: 1px solid #CCC;
}
#hr
{
	width: 929px;
	height: 1px;
	overflow: hidden;
	border-top: 1px dashed #ccc;
	margin-top: 20px;
}
#goods
{
	width: 929px;
	height: 94px;
	margin-top: 50px;
	border: 1px solid #CCC;
	margin-bottom: 20px;
}
#goods_title
{
	width: 929px;
	height: 40px;
}
#goods_title1
{
	width: 100px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	float: left;
}
#goods_title2
{
	width: 400px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	float: left;
}
#goods_title3
{
	width: 111px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	float: left;
}
#goods_title4
{
	width: 215px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	float: left;
}
#goods_title5
{
	width: 100px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	float: left;
}
#goods_message
{
	width: 929px;
	height: 54px;
	border-top: 1px solid #ccc;
}
#goods_message1
{
	width: 99px;
	height: 54px;
	line-height: 54px;
	text-align: center;
	border-right: 1px dashed #ccc;
	float: left;
}
#goods_message2
{
	width: 399px;
	height: 54px;
	line-height: 54px;
	border-right: 1px dashed #ccc;
	text-align: center;
	float: left;
}
#goods_message3
{
	width: 110px;
	height: 54px;
	line-height: 54px;
	text-align: center;
	border-right: 1px dashed #ccc;
	float: left;
}
#goods_message4
{
	width: 214px;
	height: 54px;
	line-height: 54px;
	text-align: center;
	border-right: 1px dashed #ccc;
	float: left;
}
#goods_message5
{
	width: 100px;
	height: 54px;
	line-height: 54px;
	text-align: center;
	float: left;
}
#goods_message5 a
{
	text-decoration: none;
}
</style>
</head>
	<body>
	<jsp:include page="Head.jsp"></jsp:include>
		  <div style="width: 1000px; text-align: left; height: 60px; vertical-align: middle; line-height: 60px;"><span style="color: #666666;">首页 &gt; 我的永乐  &gt; 购物车</span></div><br />
		  <div id="paySubmit">
		  		<div style="margin-top: 40px;">
		  			<img src="image/flow.png">
		  		</div>
		  		<div id="hr"></div>
				<div id="goods">
					<div id="goods_title">
						<div id="goods_title1">订单号</div>
						<div id="goods_title2">商品名称</div>
						<div id="goods_title3">配送方式</div>
						<div id="goods_title4">订单合计金额(含运费、保险)</div>
						<div id="goods_title5">操作</div>
					</div>
					<div id="goods_message">
						<div id="goods_message1">订单号</div>
						<div id="goods_message2">商品名称</div>
						<div id="goods_message3">配送方式</div>
						<div id="goods_message4">订单合计金额(含运费、保险)</div>
						<div id="goods_message5"><a href="pay.html">支付</a></div>						
					</div>
				</div>		  		
		  </div>

		  
		  
		  
	<a href="reqQuery.jsp">订单查询接口演示</a><br />
		<a href="refund.html">退款接口演示</a><br /> 
	<jsp:include page="foot.jsp"></jsp:include>		
	</body>
</html>