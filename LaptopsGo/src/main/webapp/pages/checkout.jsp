<%-- 
    Document   : checkout
    Created on : Jul 10, 2022, 7:43:44 PM
    Author     : vobao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Checkout - LaptopsGo</title>
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

        <!-- Content -->
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
                            Checkout
                        </li>
                    </ol>
                </div>
            </div>
            <!--  end Breadcrumb-->
            <div class="checkout__page">
                <div class="container">
                    <h2 class="checkout__heading">Checkout</h2>
                    <div class="row">
                        <div class="col-md-7">
                            <div class="cart__list">
                                <div class="cart__item row shadow-sm">
                                    <div class="col-md-2 cart__image">
                                        <img
                                            src="https://media-api-beta.thinkpro.vn/backend/uploads/product/color_images/2021/6/2/alienwarex15r1-1.jpg?w=700&h=700"
                                            alt=""
                                            />
                                    </div>
                                    <div class="col-md-6 car__info">
                                        <h3 class="cart__name">Alienware x15 R1</h3>
                                        <p class="cart__description">
                                            Lorem ipsum dolor sit amet consectetur
                                            adipisicing elit. Possimus illo odit non
                                            nostrum impedit.
                                        </p>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="row">
                                            <div class="col-md-4 cart__num">
                                                <span class="cart__quantity">
                                                    1
                                                </span>
                                            </div>
                                            <div class="col-md-8">
                                                <p class="cart__price">
                                                    <span>44.990.000 đ </span>
                                                </p>
                                                <span
                                                    class="cart__btn cart__delete"
                                                    >
                                                    <span>Delete</span>
                                                    <span
                                                        ><i
                                                            class="fa-regular fa-circle-xmark"
                                                            ></i
                                                        ></span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="cart__item row shadow-sm">
                                    <div class="col-md-2 cart__image">
                                        <img
                                            src="https://media-api-beta.thinkpro.vn/backend/uploads/product/color_images/2021/6/2/alienwarex15r1-1.jpg?w=700&h=700"
                                            alt=""
                                            />
                                    </div>
                                    <div class="col-md-6 car__info">
                                        <h3 class="cart__name">Alienware x15 R1</h3>
                                        <p class="cart__description">
                                            Lorem ipsum dolor sit amet consectetur
                                            adipisicing elit. Possimus illo odit non
                                            nostrum impedit.
                                        </p>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="row">
                                            <div class="col-md-4 cart__num">
                                                <span class="cart__quantity">
                                                    1
                                                </span>
                                            </div>
                                            <div class="col-md-8">
                                                <p class="cart__price">
                                                    <span>44.990.000 đ </span>
                                                </p>
                                                <span
                                                    class="cart__btn cart__delete"
                                                    >
                                                    <span>Delete</span>
                                                    <span
                                                        ><i
                                                            class="fa-regular fa-circle-xmark"
                                                            ></i
                                                        ></span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <h3 class="cart__total-heading">
                                <span>Total</span>
                            </h3>

                            <p class="cart__total-cost">100.000.000 d</p>
                        </div>
                        <div class="col-md-5 checkout__info">
                            <h3 class="checkout__heading">Shipping info</h3>
                            <form action="${pageContext.request.contextPath}/Order/" method="POST">
                                <div class="checkout__form">
                                    <div class="input__group">
                                        <label for="name">Name: </label>
                                        <input type="text" name="name" required />
                                    </div>
                                    <div class="input__group">
                                        <label for="address">Address: </label>
                                        <input type="text" name="address" required />
                                    </div>
                                    <div class="input__group">
                                        <label for="email">Email: </label>
                                        <input type="email" name="email" required />
                                    </div>

                                    <div class="input__group">
                                        <label for="phone">Phone number: </label>
                                        <input
                                            type="text"
                                            name="phone"
                                            pattern="^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$"
                                            required
                                            />
                                    </div>
                                    <input type="text" name="action" value="checkout" hidden/>
                                </div>
                                 <button type="submit"
                                        class="d-block w-100 btn btn__solid-red cart__total-checkout"
                                        >
                                        <span>Order </span>
                                        <i class="fa-solid fa-angle-right"></i>
                                    </button>
                            </form>

                            <div class="checkout__sumary">
                                <div class="">
                                   
                                </div>
                            </div>
                        </div>
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
