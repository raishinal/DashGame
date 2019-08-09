<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Results</title>
        <jsp:include page="Head.jsp"/>
    </head>
    <body>


        <div class="fh5co-loader"></div>

        <div id="page">
            <jsp:include page="nav.jsp"/>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">All Games Statistics</div>
                            <div class="panel-body">
                                <table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                                    <thead>
                                        <tr>
                                            <th data-field="player1" data-sortable="true">Player 1</th>
                                            <th data-field="Player2"  data-sortable="true">Player2</th>
                                            <th data-field="score"  data-sortable="true">Score</th>
                                            <th data-field="winner" data-sortable="true">Winner</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${gs}" var="item">
                                            <tr>
                                                <td>${item.name1}</td>
                                                <td>${item.name2}</td>
                                                <td>${item.score1}-${item.score2}</td>
                                                <c:if test="${item.score1<item.score2}">
                                                    <td>${item.name2}</td>
                                                </c:if>
                                                <c:if test="${item.score1>item.score2}">
                                                    <td>${item.name1}</td>
                                                </c:if>


                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </div>
                </div><!--/.row-->	

            </div>
            <jsp:include page="footer.jsp"/>
        </div>

        <div class="gototop js-top">
            <a href="#" class="js-gotop"><i class="icon-arrow-up2"></i></a>
        </div>



    </body>
</html>

