<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Live Game</title>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <jsp:include page="side.jsp"/>
            <!-- Page Content -->
            <div id="page-content-wrapper">
                <div class="container">
                    <br>
                    <div>
                        <label>Board no:${rg.id}</label>
                    </div>
                    <form role="form" action="<c:url value="/Admin/Live/${rg.id}?${_csrf.parameterName}=${_csrf.token}"/>"
                          method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-3 col-md-3">
                                <div class="form-group">

                                    <input type="text" class="form-control" name="player1" value="${rg.name1}" readonly>

                                </div>
                                <div class="form-group">
                                    <input type="number" class="form-control" name="break1" value="0">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="score1" value="${rg.points1}" readonly>
                                </div>


                            </div>
                            <div class="col-md-1 col-md-1">
                                <div class="form-group">
                                    <label>Players</label><br>
                                </div>
                                <div class="form-group">
                                    <label>Break</label><br>
                                </div>
                                <div class="form-group">
                                    <label>Scores</label>
                                </div>
                            </div> 
                            <div class="col-md-3 col-md-3">

                                <div class="form-group">
                                    <input type="text" class="form-control" name="player2" value="${rg.name2}" readonly>
                                </div>
                                <div class="form-group">
                                    <input type="number" class="form-control" name="break2" value="0">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="score2" value="${rg.points2}" readonly>
                                </div>

                            </div>
                            <div>
                                <button type="sumbit"></button>
                            </div>

                        </div>
                    </form>
                    <div class="row">
                        <div class="col-md-3 col-md-3">
                            <form action="<c:url value="/Admin/Live/Button/${rg.id}?${_csrf.parameterName}=${_csrf.token}"/>" method="post">
                                <div class="row">
                                    <label>Points</label>
                                    <button class="ball b1" type="submit" name="red1"></button>
                                    <button class="ball b2" type="submit" name="yellow1" ></button>
                                    <button class="ball b3" type="submit" name="green1"></button>
                                    <button class="ball b4" type="submit" name="orange1"></button>
                                    <button class="ball b5" type="submit" name="blue1" ></button>
                                    <button class="ball b6" type="submit" name="pink1" ></button>
                                    <button class="ball b7" type="submit" name="black1"></button>
                                </div>
                                <div class="row">
                                    <label>Fouls</label>
                                    <button class="ball b4" type="submit" name="forange1"></button>
                                    <button class="ball b5" type="submit" name="fblue1"></button>
                                    <button class="ball b6" type="submit" name="fpink1"></button>
                                    <button class="ball b7" type="submit" name="fblack1"></button>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-1 col-md-1">

                        </div>

                        <br>

                        <div class="col-md-3 col-md-3">
                            <form action="<c:url value="/Admin/Live/Button/${rg.id}?${_csrf.parameterName}=${_csrf.token}"/>" method="post">
                                <div class="row">
                                    <label>Points</label>
                                    <button class="ball b1" type="submit" name="red2"></button>
                                    <button class="ball b2" type="submit" name="yellow2" ></button>
                                    <button class="ball b3" type="submit" name="green2"></button>
                                    <button class="ball b4" type="submit" name="orange2"></button>
                                    <button class="ball b5" type="submit" name="blue2" ></button>
                                    <button class="ball b6" type="submit" name="pink2" ></button>
                                    <button class="ball b7" type="submit" name="black2"></button>
                                </div>
                                <div class="row">
                                    <label>Fouls</label>
                                    <button class="ball b4" type="submit" name="forange2"></button>
                                    <button class="ball b5" type="submit" name="fblue2"></button>
                                    <button class="ball b6" type="submit" name="fpink2"></button>
                                    <button class="ball b7" type="submit" name="fblack2"></button>
                                </div>
                            </form>
                        </div>

                    </div>
                                <br>
                    <div class="row">
                        <form action="<c:url value="/Admin/Live/End/${rg.id}?${_csrf.parameterName}=${_csrf.token}"/>" method="post">
                            <div class="row">

                                <input class="ball1 b8" type="submit" name="end" value="End Game"/>
                            </div>
                        </form>
                    </div>
                </div>

            </div>

        </div>
    </body>

</html>
