<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@page import="com.bean.classmate.DatabasetoExcel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="GB18030">
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



<!--Loader-->
<div class="loader">
  <div class="span">
    <div class="location_indicator"></div>
  </div>
</div>
 <!--Loader-->               
                

<!--Slider-->
<div class="rev_slider_wrapper">
  <div id="rev_overlaped" class="rev_slider"  data-version="5.0">
    <ul>
      <!-- SLIDE -->
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
          <h1><span class="t_white"><br>福大同学录</span></h1>
        </div>
        <div class="tp-caption tp-static-layer" 
          id="slide-37-layer-2" 
          data-x="['left','left','left','left']" data-hoffset="['50','50','50','50']" 
          data-y="['bottom','bottom','bottom','bottom']" data-voffset="['150','100','120','120']" 
          data-whitespace="nowrap"
          data-visibility="['on','on','on','on']"
          data-start="500" 
          data-basealign="slide" 
          data-startslide="0" 
          data-endslide="5" 
          style="z-index: 5;">
          <p class="t_white">We'll take a cup of kindness yet.For days of auld lang syne.<br> we are classmate.
          </p>
        </div>
        <div class="tp-caption tp-static-layer" 
          id="slide-37-layer-2" 
          data-x="['left','left','left','left']" data-hoffset="['50','50','50','50']" 
          data-y="['bottom','bottom','bottom','bottom']" data-voffset="['60','60','60','60']" 
          data-whitespace="nowrap"
          data-visibility="['on','on','on','on']"
          data-start="500" 
          data-basealign="slide" 
          data-startslide="0" 
          data-endslide="5" 
          style="z-index: 5;"><a href="a.jsp" class="btn-white border_radius uppercase">导出为表格</a>
        </div>
        <div class="tp-caption tp-static-layer" 
          id="slide-37-layer-2" 
          data-x="['left','left','left','left']" data-hoffset="['300','300','300','300']" 
          data-y="['bottom','bottom','bottom','bottom']" data-voffset="['60','60','60','60']" 
          data-whitespace="nowrap"
          data-visibility="['on','on','on','on']"
          data-start="500" 
          data-basealign="slide" 
          data-startslide="0" 
          data-endslide="5" 
          style="z-index: 5;"><a href="student.jsp" class="btn-white border_radius uppercase">查看同学录</a>
        </div>
      </div>
    </ul>
  </div>
</div>
<!--Slider ends-->






<button type="button" class="form_opener"><i class="fa fa-bars"></i></button>
<div class="tp_overlay">
  <div class="topbar clearfix text-center">
    <ul class="breadcrumb_top">
    <li><a href="javascript:void(0)"><i class="icon-icons43"></i>FZU</a></li>
   
    </ul>
  </div>
  
  <form class="callus top30 clearfix centered" method="post" action="NewFile.jsp" onsubmit="return check(this);">
  <h2 class="text-uppercase t_white bottom20 text-center">添加信息</h2>
    <div class="row">
      <div class="col-sm-6">
        <div class="single-query bottom15">
          <input type="text" class="v_name" name="v_name" placeholder="名字">
        </div>
      </div>
      <div class="col-sm-6">
        <div class="single-query bottom15">
          <div class="intro">
          <input type="text" class="v_address" name="v_address" placeholder="地址">
          </div>
        </div>
      </div>
      <div class="col-sm-6">
        <div class="single-query bottom15">
          <div class="intro">
             <input type="text" class="v_wechat" name="v_wechat" placeholder="微信">
          </div>
        </div>
      </div>
      
      <div class="col-sm-6">
        <div class="single-query bottom15">
          <div class="intro">
             <input type="text" class="v_qq" name="v_qq" placeholder="QQ">
          </div>
        </div>
      </div>
      <div class="col-sm-6">
        <div class="single-query bottom15">
          <div class="intro">
             <input type="text" class="v_phone" name="v_phone" placeholder="电话">
          </div>
        </div>
      </div>
      <div class="col-sm-6">
        <div class="single-query bottom15">
          <div class="intro">
            <input type="text" class="v_class" name="i_class" placeholder="班级">
          </div>
        </div>
      </div>
      <div class="col-sm-6">
        <div class="single-query bottom15">
          <div class="intro">
             <input type="text" class="v_log" name="v_log" placeholder="个性签名">
          </div>
        </div>
      </div>
    </div>
     
      <div class="row">
      <div class="col-md-11 col-sm-5 col-xs-4 text-right form-group top30">
         <button type="submit" class="border_radius btn-yellow text-uppercase">添加</button>
      </div>
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


