<%-- 
    Document   : sellerDashboard
    Created on : Jul 13, 2022, 8:26:05 PM
    Author     : vobao
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="user" value="${sessionScope.userSession}"/>
<c:set var="role" value="${user.role}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>LaptopsGo</title>
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico" />
        <!-- CSS only -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
            crossorigin="anonymous"
            />
        <!-- font awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
            integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <!-- slick slider -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.css"
            integrity="sha512-6lLUdeQ5uheMFbWm3CP271l14RsX1xtx+J5x2yeIDkkiBpeVTNhTqijME7GgRKKi6hCqovwCoBTlRBEC20M8Mg=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
            integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <!--  -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
        <%@include file="../components/navBar.jsp" %>
        <div>
            <div
                style="--bs-breadcrumb-divider: '>'"
                class="breadcrumb__container"
                aria-label="breadcrumb"
                >
                <div class="container">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">
                            Dashboard
                        </li>
                    </ol>
                </div>
            </div>
            <div class="container">
                <h2 class="checkout__heading">Dashboard</h2>
                <c:set var="errors" value="${requestScope.errors}"/>
                <c:set var="success" value="${requestScope.success}"/>
                <c:if test="${errors != ''}">
                    <p class = "text-danger">${errors}</p>
                </c:if>
                <c:if test="${success != ''}">
                    <p class = "text-success">${success}</p>
                </c:if>
                <a class="btn btn__solid-red" href="${pageContext.request.contextPath}/Seller/add?action=create">Add new Product</a>

                <div class="table-responsive">
                    <table class="table table-hover" width="100%">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Name</th>
                                <th scope="col">Image</th>
                                <th scope="col">Brand</th>
                                <th scope="col">Category</th>
                                <th scope="col">Status</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Sold</th>
                                <th scope="col">Action</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="products" value="${requestScope.products}"/>
                            <c:set var="categories" value="${requestScope.categories}"/>
                            <c:set var="brands" value="${requestScope.brands}"/>

                            <c:forEach var="o" items="${products}"> 

                                <tr>
                                    <td>${o.getId()}</td>
                                    <td width="200px"><a href="${pageContext.request.contextPath}/Product/detail?id=${o.getId()}">${o.getName()}</a> </td>

                                    <td>
                                        <img 
                                            src="${o.getImageURL()}" alt="" style="width: 90px; height: 50px">
                                    </td>
                                    <td>${brands[o.getBrandID()]}</td>
                                    <td>${categories[o.getCategoryID()]}</td>
                                    <td>
                                        ${o.getIsNew() == 1 ? "New" : "Used"}
                                    </td>
                                    <td>${o.getQuantity()}</td>
                                    <td>${o.getSoldQuantity()}</td>
                                    <td>
                                        <a class="btn btn__solid-primary" href="${pageContext.request.contextPath}/Seller/add?action=edit&productID=${o.getId()}">Edit</a>
                                        <a class="btn btn__solid-red"  href="${pageContext.request.contextPath}/Seller/delete?productID=${o.getId()}">Delete</a>
                                    </td>
                                </tr> 

                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
        <%@include file="../components/footer.jsp" %>

        <!-- Bootstrap -->
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"
        ></script>
        <!-- jquery -->
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
            integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
        ></script>
        <!-- Slick -->
        <script
            type="text/javascript"
            src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"
        ></script>
        <!--  -->
        <script src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>
