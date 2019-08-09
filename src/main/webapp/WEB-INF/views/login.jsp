<%-- 
    Document   : login
    Created on : Jun 28, 2019, 9:08:38 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>

   <jsp:include page="Head.jsp"/>

    </head>
    <body>

        <div class="row">
            <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading"><a href="<c:url value="/Index"/>" >Go to homepage</a></div>
                    <div class="panel-heading">Log in</div>
                    <div class="panel-body">
                        <form role="form" action="<c:url value="/Login?${_csrf.parameterName}=${_csrf.token}"/>" method="post" id="contactForm" novalidate="novalidate">

                            <div class="form-group">
                                <input class="form-control" placeholder="Username" id="name" name="username" type="text" >
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" id="name" name="password" type="password" >
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <div class="col-md-12 form-group">
                                <button type="submit" value="submit" class="primary-btn">Login</button>
                                <a href="#">Forgot Password?</a>
                            </div>

                        </form>
                        <div class="panel-heading"><a href="<c:url value="/Register"/>" ><h5>Register</h5></a></div>
                    </div>
                </div>
            </div><!-- /.col-->
        </div><!-- /.row -->	

    </body>
</html>
