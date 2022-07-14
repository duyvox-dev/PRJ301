<%-- 
    Document   : editProduct
    Created on : Jul 13, 2022, 8:26:17 PM
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
        <title>Seller - LaptopsGo</title>
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

        <div class="container py-5">
            <c:set var="action" value="${requestScope.action}"/>
            <c:set var="product" value="${requestScope.product}"/>
            <c:set var="categoryList" value="${requestScope.categoryList}"/>
            <c:set var="brandList" value="${requestScope.brandList}"/>
            <div
                style="--bs-breadcrumb-divider: '>'"
                class="breadcrumb__container"
                aria-label="breadcrumb"
                >
                <div class="container">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/Seller/dashboard">Seller Dashboard</a></li>

                        <li class="breadcrumb-item active text-capitalize" aria-current="page">
                            ${action} Product
                        </li>
                    </ol>
                </div>
            </div>
            <!--  end Breadcrumb-->

            <h2 class="checkout__heading text-capitalize">${action} product</h2>

            <form action="${pageContext.request.contextPath}/Seller/edit" class="" method = "POST">
                <c:if test="${not empty role && product.getId() != ''}">
                    <div class="input__group">
                        <label for="productID">Id</label>
                        <input type="text" name="productID" required readonly  value="${product.getId()}" />
                    </div>
                </c:if>

                <div class="input__group">
                    <label for="name">Name </label>
                    <input type="text" name="name" required  value="${product.getName()}"/>
                </div>
                <div class="input__group">
                    <label for="description">Description </label>
                    <textarea name="description"  style="  width: 100%;
                              height: 150px;">${product.getDescription()}</textarea>
                </div>
                <div class="input__group">
                    <label for="imageURL">ImageURL </label>
                    <input type="text" name="imageURL" required  value="${product.getImageURL()}"/>
                </div>
                <div class="input__group">
                    <label for="quantity">Quantity </label>
                    <input type="number" name="quantity" min="0" required  value="${product.getQuantity()}"/>
                </div>
                <div class="input__group">
                    <label for="price">Price in $ </label>
                    <input type="text" name="price" required  value="${product.getPrice()}"/>
                </div>
                <div class="input__group">
                    <label for="categoryID">Category </label>
                    <select class="form-select" name="categoryID">
                        <c:forEach var="o" items="${categoryList}">
                            <c:choose>
                                <c:when test = "${o.getId() == product.getCategoryID()}">
                                    <option value="${o.getId()}" selected>${o.getName()}</option>
                                </c:when>



                                <c:otherwise>
                                    <option value="${o.getId()}">${o.getName()}</option>

                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="input__group">
                    <label for="BrandID">Brand </label>
                    <select class="form-select" name="brandID">
                        <c:forEach var="o" items="${brandList}">
                            <c:choose>

                                <c:when test = "${o.getId() == product.getBrandID()}">
                                    <option value="${o.getId()}" selected>${o.getName()}</option>

                                </c:when>



                                <c:otherwise>
                                    <option value="${o.getId()}">${o.getName()}</option>

                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="input__group">
                    <label for="isNew">Status </label>
                    <select class="form-select" name="isNew">
                        <c:choose>

                            <c:when test = "${0 == product.getIsNew()}">
                                <option value="0" selected>Used</option>


                            </c:when>



                            <c:otherwise>
                                <option value="0">Used</option>

                            </c:otherwise>
                        </c:choose>
                        <c:choose>

                            <c:when test = "${1 == product.getIsNew()}">
                                <option value="1" selected>New</option>


                            </c:when>



                            <c:otherwise>
                                <option value="1">New</option>

                            </c:otherwise>
                        </c:choose>


                    </select>
                </div>
                <c:if test="${success != ''}">
                    <p class = "text-success">${success}</p>
                </c:if>
                <input type="text" hidden value="${action}" name="action">
                <button class="btn btn__solid-red">Save</button>
            </form>
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
