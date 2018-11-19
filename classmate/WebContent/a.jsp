<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.bean.classmate.*"%>
<html>
<head>
<meta charset="GB18030">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导出</title>
</head>
<body>
<%
	DatabasetoExcel.work();
%>


	<!--Loader-->
<div class="loader">
  <div class="span">
    <div class="location_indicator"></div>
  </div>
</div>
 <!--Loader-->  
 <div class="rev_slider_wrapper">
  <div id="rev_overlaped" class="rev_slider"  data-version="5.0">
    <ul>
 <li data-transition="fade">
        <img src="images/1.jpg" alt="" data-bgposition="center center" data-bgfit="cover" class="rev-slidebg">							
      </li>
      <li data-transition="fade">
        <img src="images/2.jpg" alt="" data-bgposition="center center" data-bgfit="cover" class="rev-slidebg">							
      </li>
      <div class="tp-static-layers">
        <div class="tp-caption tp-static-layer" 
          id="slide-37-layer-2" 
          data-x="['left','left','left','left']" data-hoffset="['50','50','50','50']" 
          data-y="['bottom','bottom','bottom','bottom']" data-voffset="['230','180','150','100']"  
          data-whitespace="nowrap"
          data-visibility="['on','on','on','on']"
          data-fontsize="['48','48','28','28']"
          data-start="500" 
          data-responsive_offset="on"
          data-basealign="slide" 
          data-startslide="0" 
          data-endslide="5" 
          style="z-index: 5;">
          <h1><span class="t_white"><br>导出成功</span></h1>
	</div>
	<form action="index.jsp">
	<div class="row">
		 <div class="col-md-4 col-sm-4 col-xs-4 text-right form-group top30">
	     
         <button type="submit" class="border_radius btn-blue text-uppercase">返回</button>
        
    	</div>
        </div>
     </form>
     </div>
    </ul>
  </div>
</div>
        
        
       

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