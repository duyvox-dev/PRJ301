<%-- 
    Document   : detail
    Created on : Jul 9, 2022, 2:41:54 PM
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
                            Detail
                        </li>
                    </ol>
                </div>
            </div>
            <!--  end Breadcrumb-->
            <!-- Product Detail -->
            <div class="detail">
                <c:set var="product" value="${requestScope.product}"/>
                <c:set var="productBrand" value="${requestScope.productBrand}"/>
                <c:set var="productCategory" value="${requestScope.productCategory}"/>
                <c:set var="suggestList" value="${requestScope.suggestList}"/>

                <div class="container">
                    <div class="row">
                        <div class="detail__images col-md-6">
                            <img
                                src="${product.getImageURL()}"
                                alt=""
                                />
                        </div>
                        <div class="detail__info col-md-6">
                            <h2 class="detail__name">${product.getName()}</h2>
                            <div class="detail__stock">
                                <p class="available">${product.getQuantity()} in stock</p>
                                <span>|</span>
                                <p class="sold">
                                    <b>${product.getSoldQuantity()}</b>
                                    sold
                                </p>
                            </div>
                            <div class="product__attr">
                                <div>
                                    <span>Brand: </span>
                                    <b>${productBrand.getName()} </b>
                                </div>
                                <div>
                                    <span>Category: </span>
                                    <b>${productCategory.getName()} </b>
                                </div>
                                <div>
                                    <span>Status: </span>
                                    <b>${product.getIsNew() == 1 ? "New" : "Used"} </b>
                                </div>
                            </div>
                            <div class="detail__description">
                                ${product.getDescription()}
                            </div>
                            <div class="detail__price">
                                <p class="product__price">
                                    <span>From: </span>
                                    <span>$${product.getPrice()} </span>
                                </p>
                            </div>
                            <div class="detail__btn-group">
                                <c:choose>

                                    <c:when test = "${product.getQuantity() == 0}">
                                        <a href="#" class="btn btn-secondary" disabled
                                           >Sold out</a
                                        >
                                    </c:when>



                                    <c:otherwise>
                                        <c:if test="${role == 'admin' || role == 'seller'}">
                                            <a href="#" class="btn btn-secondary" disabled
                                               >Please use buyer account</a
                                            >
                                        </c:if>
                                        <c:if test= "${role == 'buyer'}">
                                            <a href="${pageContext.request.contextPath}/Cart/add?productID=${product.getId()}" class="btn btn__solid-red"
                                               >BUY NOW</a
                                            >
                                        </c:if>
                                        <c:if test= "${ empty role}">
                                            <a href="${pageContext.request.contextPath}/auth/login.jsp" class="btn btn__solid-primary"
                                               >Please login to buy</a
                                            >
                                        </c:if>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="suggest">
                <div class="container">
                    <h2 class="suggest__heading">Other Related Product</h2>
                    <div class="suggest__list">

                        <c:forEach var="o" items="${suggestList}"> 
                            <a href="${pageContext.request.contextPath}/Product/detail?id=${o.getId()}" class="col-md-3 product__item">
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
