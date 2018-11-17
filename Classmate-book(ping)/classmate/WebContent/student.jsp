<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.bean.classmate.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/reality-icon.css">
<link rel="stylesheet" type="text/css" href="css/bootsnav.css">
<link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css">
<link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="css/owl.transitions.css">
<link rel="stylesheet" type="text/css" href="css/cubeportfolio.min.css">
<link rel="stylesheet" type="text/css" href="css/settings.css">
<link rel="stylesheet" type="text/css" href="css/range-Slider.min.css">
<link rel="stylesheet" type="text/css" href="css/search.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="icon" href="images/icon.png">
</head>
<body>
<%
	Connection con1=connector.getconn();
	Statement stmt=con1.createStatement();
	ResultSet rs=stmt.executeQuery("select * from bean");
	List<bean> list=new ArrayList<bean>();
	while(rs.next())
	{
		bean bean1=new bean();
	    bean1.setI_class(rs.getInt("i_class"));
		bean1.setV_address(rs.getString("v_address"));
		bean1.setV_name(rs.getString("v_name"));
		bean1.setV_phone(rs.getString("v_phone"));
		bean1.setV_qq(rs.getString("v_qq"));
		bean1.setV_wechat(rs.getString("v_wechat"));
		bean1.setV_log(rs.getString("v_log"));
		list.add(bean1);
	}
	request.setAttribute("list", list);
%>
<%
out.print(list.get(1).getI_class());
%>


<!-- Gallery -->
<section id="property" class="padding bg_gallery">
  <div class="container">
    <div class="row">
      <div class="col-sm-12 text-center">
        <h2 class="uppercase">福大同学录</h2>
        <p class="heading_space">We'll take a cup of kindness yet.For days of auld lang syne.</p>
      </div>
    </div>
    <div class="clearfix">
      
    </div>
    
    <div id="property-gallery" class="cbp listing1">
    <c:forEach items="${requestScope.list}" var="list">
      <div class="cbp-item sale">
        <div class="property_item">
          <div class="image">
            <a href="#."><img src="images/listing3.jpg" alt="latest property" class="img-responsive"></a>
            <div class="price clearfix"> 
              <span class="tag pull-right">${list.v_name}</span>
            </div>
            
          </div>
          <div class="proerty_content">
            <div class="proerty_text">
              <h3 class="captlize">${list.v_name}</h3>
              <p>班级:${list.i_class}</p>
            </div>
            <div class="property_meta transparent"> 
              <span>QQ:${list.v_qq}</span> 
              <span>微信:${list.v_wechat}</span> 
              <span>电话:${list.v_phone}</span>   
            </div>
            <div class="property_meta transparent bottom30">
              <span>地址:${list.v_address}</span>
              <span>个性签名:${list.v_log}</span>
              <span></span>
            </div>
            
          </div>
        </div>
      </div>
      </c:forEach>
        </div>
       
      </div>
</section>


<!-- Gallery End -->
<script src="js/jquery-2.1.4.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.appear.js"></script>
<script src="js/jquery-countTo.js"></script>
<script src="js/bootsnav.js"></script>
<script src="js/masonry.pkgd.min.js"></script>
<script src="js/jquery.parallax-1.1.3.js"></script>
<script src="js/jquery.cubeportfolio.min.js"></script>
<script src="js/range-Slider.min.js"></script>
<script src="js/owl.carousel.min.js"></script> 
<script src="js/selectbox-0.2.min.js"></script>
<script src="js/zelect.js"></script>
<script src="js/jquery.fancybox.js"></script>
<script src="js/jquery.themepunch.tools.min.js"></script>
<script src="js/jquery.themepunch.revolution.min.js"></script>
<script src="js/revolution.extension.actions.min.js"></script>
<script src="js/revolution.extension.layeranimation.min.js"></script>
<script src="js/revolution.extension.navigation.min.js"></script>
<script src="js/revolution.extension.parallax.min.js"></script>
<script src="js/revolution.extension.slideanims.min.js"></script>
<script src="js/revolution.extension.video.min.js"></script>
<script src="js/custom.js"></script>
<script src="js/functions.js"></script>
</body>
</html>