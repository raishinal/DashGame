<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="/resources/css/simple-sidebar.css"/>">
        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/css/simple-sidebar.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap-table.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/styles1.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap1.min.css"/>" rel="stylesheet">
        <script src="<c:url value="/resources/js/lumino.glyphs.js"/>"></script>
    </head>
    <body>
        <!-- Sidebar -->
        <div class="bg-light border-right" id="sidebar-wrapper">
            <div class="sidebar-heading">Admin Pannel </div>
            <div class="list-group list-group-flush">
                <a href="<c:url value="/Admin/Home"/>" class="list-group-item list-group-item-action bg-light">Start Game</a>
                <a href="<c:url value="/Admin/Statistics"/>" class="list-group-item list-group-item-action bg-light">See All Results</a>
                <a href="<c:url value="/Admin/Upcoming/Add"/>" class="list-group-item list-group-item-action bg-light">Add Upcoming</a>
                <a href="<c:url value="/Admin/Upcoming/Manage"/>" class="list-group-item list-group-item-action bg-light">Manage Upcoming</a>
            </div>
        </div>
        <!-- /#sidebar-wrapper -->
        <script>
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#wrapper").toggleClass("toggled");
            });
        </script>
        <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>

        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap-table.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

    </body>
</html>
