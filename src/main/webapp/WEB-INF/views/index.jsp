<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
            <title>Home</title>
            <jsp:include page="Head.jsp"/>
	</head>
	<body>
           
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
             <jsp:include page="nav.jsp"/>
	
	<div class="container-wrap">
		<aside id="fh5co-hero">
			<div class="flexslider">
				<ul class="slides">
                                    <li style="background-image: url(<c:url value="/resources/images/img_bg_1.jpg"/>);">
			   		<div class="overlay-gradient"></div>
			   		<div class="container-fluid">
			   			<div class="row">
				   			<div class="col-md-6 col-md-offset-3 col-md-pull-3 slider-text">
				   				<div class="slider-text-inner">
				   					<h1>Not Every Project Needs To Be Perfect</h1>
										<h2>Free html5 templates Made by <a href="http://freehtml5.co/" target="_blank">freehtml5.co</a></h2>
										<p><a class="btn btn-primary btn-demo" href="#"></i> View Demo</a> <a class="btn btn-primary btn-learn">Learn More</a></p>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>
                                <li style="background-image: url(<c:url value="/resources/images/img_bg_2.jpg"/>);">
			   		<div class="overlay-gradient"></div>
			   		<div class="container-fluid">
			   			<div class="row">
				   			<div class="col-md-6 col-md-offset-3 col-md-push-3 slider-text">
				   				<div class="slider-text-inner">
				   					<h1>WordPress Theme For People Who Tell Stories</h1>
										<h2>Free html5 templates Made by <a href="http://freehtml5.co/" target="_blank">freehtml5.co</a></h2>
										<p><a class="btn btn-primary btn-demo" href="#"></i> View Demo</a> <a class="btn btn-primary btn-learn">Learn More</a></p>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>
                                <li style="background-image: url(<c:url value="/resources/images/img_bg_3.jpg"/>);">
			   		<div class="overlay-gradient"></div>
			   		<div class="container-fluids">
			   			<div class="row">
				   			<div class="col-md-6 col-md-offset-3 slider-text">
				   				<div class="slider-text-inner text-center">
				   					<h1>What Would You Like To Learn?</h1>
										<h2>Free html5 templates Made by <a href="http://freehtml5.co/" target="_blank">freehtml5.co</a></h2>
										<p><a class="btn btn-primary btn-demo" href="#"></i> View Demo</a> <a class="btn btn-primary btn-learn">Learn More</a></p>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>
                                <li style="background-image: url(<c:url value="/resources/images/img_bg_4.jpg"/>);">
			   		<div class="overlay-gradient"></div>
			   		<div class="container-fluid">
			   			<div class="row">
				   			<div class="col-md-6 col-md-offset-3 col-md-push-3 slider-text">
				   				<div class="slider-text-inner">
				   					<h1>I Love to Tell My Story</h1>
										<h2>Free html5 templates Made by <a href="http://freehtml5.co/" target="_blank">freehtml5.co</a></h2>
										<p><a class="btn btn-primary btn-demo" href="#"></i> View Demo</a> <a class="btn btn-primary btn-learn">Learn More</a></p>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>	   	
			  	</ul>
		  	</div>
		</aside>
		
	</div><!-- END container-wrap -->

		 <jsp:include page="footer.jsp"/>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up2"></i></a>
	</div>
	


	</body>
</html>

