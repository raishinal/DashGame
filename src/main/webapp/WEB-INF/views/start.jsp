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

        <title>Start Page</title>

        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/css/simple-sidebar.css"/>" rel="stylesheet">

    </head>

    <body>

        <div class="d-flex" id="wrapper">

            <jsp:include page="side.jsp"/>

            <!-- Page Content -->
            <div id="page-content-wrapper">
                <div class="container">
                    <div class="row">
                         <form role="form" action="<c:url value="/Admin/Start?${_csrf.parameterName}=${_csrf.token}"/>"
                                         method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label>Player1</label>
                                            <input type="text" class="form-control" name="player1" placeholder="Enter player1 name">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Player2</label>
                                            <input type="text" class="form-control" name="player2" placeholder="Enter player2 name">
                                            <p class="help-block"></p>
                                        </div>
                             <div class="form-group">
                                            <label>Board no:</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="board"  value="1" checked>Board 1
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="board"  value="2" >Board 2
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="board"  value="3" >Board 3
                                            </label>
                                        </div>
                             <button type="submit" class="btn btn-default">Start</button>
                         </form>
                    </div>

                </div>
            </div>
            <!-- /#page-content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Bootstrap core JavaScript -->
        

        <!-- Menu Toggle Script -->
   

    </body>

</html>
