<%-- 
    Document   : dashboard
    Created on : Jul 27, 2019, 9:52:41 AM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Edit Upcoming</title>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <jsp:include page="side.jsp"/>
            <div id="page-content-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">Edit Upcoming</div>
                                <div class="panel-body">
                                    <div class="col-md-6">
                                        <form role="form" action="<c:url value="/Admin/Upcoming/Update"/>" method="post">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                            <div class="form-group">
                                                <label>ID</label>
                                                <input class="form-control" type="text" name="id" value="${uc.id}" readonly>
                                                <p class="help-block">${error_title}</p>
                                            </div>
                                            <div class="form-group">
                                                <label>Player 1</label>
                                                <input class="form-control" type="text"  name="name1" value="${uc.name1}">
                                                <p class="help-block">${error_title}</p>
                                            </div>
                                            <div class="form-group">
                                                <label>Player 2</label>
                                                <input class="form-control" type="text" name="name2" value="${uc.name2}">
                                                <p class="help-block">${error_title}</p>
                                            </div>
                                            <div class="form-group">
                                                <label>Date and Time</label>
                                                <input type="datetime-local" class="form-control" name="start"  value="${uc.start}">
                                                <p class="help-block"></p>
                                            </div>
                                            <button type="submit" class="btn btn-default">Submit Button</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
