<%--
  Created by IntelliJ IDEA.
  User: hoanganhvu
  Date: 20/10/2023
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CRUD Student</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<%--navbar--%>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="https://th.bing.com/th/id/OIP.nFn_mpOrmv-KNugzesNztwHaHa?w=176&h=180&c=7&r=0&o=5&dpr=2&pid=1.7" alt="Bootstrap" width="30" height="24">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/student/index">List Student</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/index">List User</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Customer 2
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled">Customer 3</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<%--End Nav--%>
<h1>Student Manager</h1>
<div class="alert">
    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

</div>

<div class="container">
    <div class="row">
        <div class="col-12 d-flex justify-content-center align-items-center">
<%--            <form class="col-6" action="/student/index" method="post">--%>

<%--                <div class="input-group mb-3 input-group-sm">--%>
<%--                    <span class="input-group-text" id="input-group-sizing-default">ID</span>--%>
<%--                    <input name="id" value="${student.id}" type="text" class="form-control" >--%>
<%--                </div>--%>


<%--                <div class="input-group mb-3 input-group-sm">--%>
<%--                    <span class="input-group-text" >Name</span>--%>
<%--                    <input name="name" value="${student.name}" type="text" class="form-control">--%>
<%--                </div>--%>


<%--                <div class="input-group mb-3 input-group-sm">--%>
<%--                    <span class="input-group-text">Birth</span>--%>
<%--                    <input name="birth" value="${student.birth}" type="text" class="form-control">--%>
<%--                </div>--%>


<%--                <div class="input-group mb-3 input-group-sm">--%>
<%--                    <span class="input-group-text">Phone</span>--%>
<%--                    <input name="phone" value="${student.phone}" type="text" class="form-control">--%>
<%--                </div>--%>
<%--                <div >--%>
<%--                    <button formaction="/student/create"  class="btn btn-success">Create</button>--%>
<%--                    <button formaction="/student/update"  class="btn btn-warning">Update</button>--%>
<%--                    <button formaction="/student/delete"  class="btn btn-danger">Delete</button>--%>
<%--                    <button formaction="/student/reset"  class="btn btn-primary">Reset</button>--%>
<%--                </div>

            </form>--%>


            <form class="col-6" action="/student/index" method="post" enctype="multipart/form-data">

                <div class="input-group mb-3 input-group-sm">
                    <span class="input-group-text" id="input-gr-default">Image</span>
                    <input name="id" value="${student.linkImage}" type="file" class="form-control" >
                </div>


                <div class="input-group mb-3 input-group-sm">
                    <span class="input-group-text" >Name</span>
                    <input name="name" value="${student.name}" type="text" class="form-control">
                </div>


                <div class="input-group mb-3 input-group-sm">
                    <span class="input-group-text">Birth</span>
                    <input name="birth" value="${student.birth}" type="date" class="form-control">
                </div>


                <div class="input-group mb-3 input-group-sm">
                    <span class="input-group-text">Phone</span>
                    <input name="phone" value="${student.phone}" type="text" class="form-control">
                </div>
                <div >
                    <button formaction="/student/create"  class="btn btn-success">Create</button>
                    <button formaction="/student/update"  class="btn btn-warning">Update</button>
                    <button formaction="/student/delete"  class="btn btn-danger">Delete</button>
                    <button formaction="/student/reset"  class="btn btn-primary">Reset</button>
                </div>
            </form>
        </div>
        <br>
        <div class="container mt-3">
            <h2>Table Students</h2>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Birth</th>
                    <th>Phone</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.id}</td>
                        <td>
                            <img src="${student.linkImage}"  width="100" height="100">
                        </td>
                        <td>${student.name}</td>
                        <td>${student.birth}</td>
                        <td>${student.phone}</td>
                        <td>
                            <a href="/student/edit/?id=${student.id}">Edit</a>
                            <a class="delete" href="/student/delete/?id=${student.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <ul class="pagination">
                <c:set var="currentPage" value="${param.pageNumber == null ? 1 : param.pageNumber}" />
                <c:set var="totalPages" value="${students.size() / 5 + 1}" />
                <c:choose>
                    <c:when test="${currentPage > 1}">
                        <li class="page-item">
                            <a class="page-link" href="?pageNumber=${currentPage - 1}">Previous</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item disabled">
                            <a class="page-link" href="#">Previous</a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <c:forEach var="page" begin="1" end="${totalPages}">
                    <c:choose>
                        <c:when test="${currentPage == page}">
                            <li class="page-item active">
                                <span class="page-link">${page}</span>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="?pageNumber=${page}">${page}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:choose>
                    <c:when test="${currentPage < totalPages}">
                        <li class="page-item">
                            <a class="page-link" href="?pageNumber=${currentPage + 1}">Next</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item disabled">
                            <a class="page-link" href="#">Next</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
