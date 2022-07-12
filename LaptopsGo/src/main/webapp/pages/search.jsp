<%-- 
    Document   : search
    Created on : Jul 11, 2022, 4:10:57 PM
    Author     : vobao
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="user" value="${sessionScope.userSession}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>LaptopsGo - Search</title>
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
        <!--Content-->
        <div>
            <!-- Breadcrumb -->
            <div
                style="--bs-breadcrumb-divider: '>'"
                class="breadcrumb__container"
                aria-label="breadcrumb"
                >
                <div class="container">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">
                            Search
                        </li>
                    </ol>
                </div>
            </div>
            <!--  end Breadcrumb-->
            <div class="filter-product">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 filter">
                            <h3 class="filter__heading">Filter</h3>
                            <div class="filter__brand">
                                <h4 class="filter__title">Brand</h4>
                                <div class="filter__list">
                                    <c:set var="brandList" value="${requestScope.brandList}"/>
                                    <c:set var="currentBrand" value="${requestScope.currentBrand}"/>

                                    <!--                                    <form action="" method="GET">
                                    <c:forEach var="o" items="${brandList}"> 
                                        <button type="submit" name="brand" value="${o.getName()}" class="filter__item">
                                            <div class="filter__item-inner">
                                                <img
                                                    src="${o.getImageURL()}"
                                                    alt=""
                                                    class="filter__img"
                                                    />
                                            </div>
                                        </button>
                                        <input type="text" value ="filterBrand" hidden/>
                                    </c:forEach>
                                </form>-->

                                    <c:forEach var="o" items="${brandList}"> 
                                        <c:choose>
                                            <c:when test="${o.getName() == currentBrand}">
                                                <a href="./search?brand=${o.getName()}" class="filter__item active">
                                                    <div class="filter__item-inner">
                                                        <img
                                                            src="${o.getImageURL()}"
                                                            alt=""
                                                            class="filter__img"
                                                            />
                                                    </div>
                                                </a>
                                            </c:when>
                                            <c:otherwise >
                                                <a href="./search?brand=${o.getName()}" class="filter__item">
                                                    <div class="filter__item-inner">
                                                        <img
                                                            src="${o.getImageURL()}"
                                                            alt=""
                                                            class="filter__img"
                                                            />
                                                    </div>
                                                </a>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>
                                </div>
                            </div>
                            <div class="filter__category">
                                <h4 class="filter__title">Category</h4>
                                <div class="filter__list">
                                    <c:set var="categoryList" value="${requestScope.categoryList}"/>
                                    <c:set var="currentCategory" value="${requestScope.currentCategory}"/>

                                    <c:forEach var="o" items="${categoryList}"> 
                                        <c:choose>
                                            <c:when test="${o.getName() == currentCategory}">
                                                <a href="./search?category=${o.getName()}" class="filter__item active">
                                                    <div class="filter__item-inner">
                                                        <span class="filter__category-name"
                                                              >${o.getName()}</span
                                                        >
                                                    </div>
                                                </a>
                                            </c:when>
                                            <c:otherwise >
                                                <a href="./search?category=${o.getName()}" class="filter__item">
                                                    <div class="filter__item-inner">
                                                        <span class="filter__category-name"
                                                              >${o.getName()}</span
                                                        >
                                                    </div>
                                                </a>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>

                                </div>
                            </div>
                            <div class="filter__clear">
                                <a
                                    href="./search"
                                    class="btn btn__outline-red filter__clear-btn"
                                    >Clear filter</a
                                >
                            </div>
                        </div>
                        <!-- list -->
                        <div class="product col-md-9">
                            <div class="container">
                                <c:set var="searchKey" value="${requestScope.searchKey}"/>

                                        <h2 class="product__heading">
                                            Result for:${searchKey}
                                        </h2>
                                 

    

                                <div class="product__list product__list-search row">
                                    <c:set var="productList" value="${requestScope.productList}"/>
                                    <c:forEach var="o" items="${productList}"> 
                                        <a href="${pageContext.request.contextPath}/Product/detail?id=${o.getId()}" class="col-md-4 product__item">
                                            <div class="card">
                                                <img
                                                    src="${o.getImageURL()}"
                                                    class="card-img-top product__img"
                                                    alt="..."
                                                    />
                                                <div class="card-body">
                                                    <p class="product__name text-truncate">${o.getName()}</p>
                                                    <p class="product__price">
                                                        <span>From: </span>
                                                        <span>$${o.getPrice()} </span>
                                                    </p>
                                                </div>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination justify-content-center">
                                        <c:set var="currentPage" value="${requestScope.currentPage}"/>
                                        <c:set var="numberOfPages" value="${requestScope.numberOfPages}"/>

                                        <c:if test="${currentPage != 1}">
                                            <li class="page-item">
                                                <a class="page-link" href="./search?page=${currentPage - 1}" tabindex="-1">Previous</a>
                                            </li>
                                        </c:if>
                                        <c:forEach begin="1" end="${numberOfPages}" varStatus="loop">
                                            <c:choose>
                                                <c:when test="${currentPage == loop.index}">
                                                    <li class="page-item"><a class="page-link" style="background-color:gray; color:white;" href="./search?page=${loop.index}">${loop.index}</a></li>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="./search?page=${loop.index}">${loop.index}</a></li>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                            <c:if test="${currentPage < numberOfPages}">
                                            <li class="page-item">
                                                <a class="page-link" href="./search?page=${currentPage + 1}">Next</a>
                                            </li>
                                        </c:if>

                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <!--  -->
                    </div>
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
