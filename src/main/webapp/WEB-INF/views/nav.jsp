<%-- 
    Document   : nav
    Created on : Jul 29, 2019, 12:51:18 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
       <nav class="fh5co-nav" role="navigation">
		<div class="container-wrap">
			<div class="top-menu">
				<div class="row">
					<div class="col-xs-2">
						<div id="fh5co-logo"><a href="<c:url value="/"/>">Neat</a></div>
					</div>
					<div class="col-xs-10 text-right menu-1">
						<ul>
                                                    <li ><a href="<c:url value="/"/>">Home</a></li>
							<li><a href="<c:url value="/Lives"/>">Live</a></li>
							<li><a href="<c:url value="/Results"/>">Results</a></li>
							<li><a href="<c:url value="/Upcoming"/>">Upcoming</a></li>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</nav>
    </body>
</html>
