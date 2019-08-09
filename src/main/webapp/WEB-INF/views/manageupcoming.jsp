<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Manage Upcoming</title>


    </head>

    <body>

        <div class="d-flex" id="wrapper">
            <jsp:include page="side.jsp"/>
            <div id="page-content-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">All Upcomings</div>
                                <div class="panel-body">
                                    <table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                                        <thead>
                                            <tr>
                                                <th data-field="player1" data-sortable="true">Player 1</th>
                                                <th data-field="Player2"  data-sortable="true">Player2</th>
                                                <th data-field="time"  data-sortable="true">Start Time</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${uc}" var="item">
                                                <tr>
                                                    <td>${item.name1}</td>
                                                    <td>${item.name2}</td>
                                                    <td>${item.start}</td>

                                                    <td><a href="<c:url value="/Admin/Upcoming/Edit/${item.id}"/>">Edit</a></td>
                                                    <td><a href="<c:url value="/Admin/Upcoming/Delete/${item.id}"/>"  onclick="return confirm('Are you sure?')">Delete</a></td>
                                                </tr>  
                                            </c:forEach>
                                        </tbody>

                                    </table>
                                </div>
                            </div>
                        </div>
                    </div><!--/.row-->	

                </div>
            </div>

        </div>
        <!-- /#wrapper -->

        <!-- Bootstrap core JavaScript -->


        <!-- Menu Toggle Script -->


    </body>

</html>
