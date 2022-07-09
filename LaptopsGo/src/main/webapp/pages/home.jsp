<%-- 
    Document   : home
    Created on : Jun 26, 2022, 8:34:03 PM
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
        <title>LaptopsGo</title>
        <link rel="icon" type="image/x-icon" href="./images/favicon.ico" />
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
        <link rel="stylesheet" href="./css/style.css" />
    </head>
    <body>
        <%@include file="../components/navBar.jsp" %>
        <!-- Content -->
        <!-- Banner -->
             <div
            class="carousel slide banner"
            id="carouselExampleIndicators"
            data-bs-ride="true"
        >
            <div class="carousel-indicators">
                <button
                    type="button"
                    data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="0"
                    class="active"
                    aria-current="true"
                    aria-label="Slide 1"
                ></button>
                <button
                    type="button"
                    data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="1"
                    aria-label="Slide 2"
                ></button>
                <button
                    type="button"
                    data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="2"
                    aria-label="Slide 3"
                ></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img
                        src="https://img.freepik.com/free-vector/online-exam-distant-education-landing-page-banner_33099-2272.jpg?t=st=1656311883~exp=1656312483~hmac=d801cea4dd50bcaf355390e7411633f30aa2c45949e44789f583126b8b6ffbc6&w=1480"
                        class="d-block w-100 banner__img"
                        alt="..."
                    />
                </div>
                <div class="carousel-item">
                    <img
                        src="https://banmualaptop.com/wp-content/uploads/2020/11/lenovo-laptop-thinkpad-banner-1143x357-1.jpg"
                        class="d-block w-100 banner__img"
                        alt="..."
                    />
                </div>
                <div class="carousel-item">
                    <img
                        src="https://leaguefeed.net/wp-content/uploads/2022/04/best-cheap-laptops-for-editing-youtube-videos.jpg"
                        class="d-block w-100 banner__img"
                        alt="..."
                    />
                </div>
            </div>
            <button
                class="carousel-control-prev"
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev"
            >
                <span
                    class="carousel-control-prev-icon"
                    aria-hidden="true"
                ></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button
                class="carousel-control-next"
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next"
            >
                <span
                    class="carousel-control-next-icon"
                    aria-hidden="true"
                ></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <!-- brand -->
        <div class="brand">
            <div class="container">
                <h2 class="brand__heading">Hot Brand</h2>
                <div class="brand__list">
                    <a href="#" class="brand__item">
                        <div class="brand__item-inner">
                            <img
                                src="https://png2.cleanpng.com/sh/f524fadd62ca412acf986c8d8c33d724/L0KzQYm3VMA1N5Roj5H0aYP2gLBuTfhmf51qjOY2cHHme7L5hL1td5h0Rd5ubnB5f37qjB1xfaVqip98b3b3h7L5hb1tbZ90jtG2bHBqf368gfM1QZdnSKoBYkK3Q3A5UMM5O2I8TaMAMkK7Q4a6V8Y2PWI8RuJ3Zx==/kisspng-hewlett-packard-logo-lenovo-computer-software-lenovo-logo-5ac49fb086b243.2038317515228353765517.png"
                                alt=""
                                />
                        </div>
                    </a>

                </div>
            </div>
        </div>
        <!--  -->
        <!-- category -->
        <div class="category">
            <div class="container">
                <h2 class="category__heading">Hot Category</h2>
                <div class="category__list">
                    <a href="#" class="category__item">
                        <span class="category__name">Gaming</span>
                    </a>
                </div>
            </div>
        </div>
        <!--  -->

        <!-- list -->
        <div class="product">
            <div class="container">
                <h2 class="product__heading">All product</h2>
                <div class="product__list row">
                    <a href="./detail.html" class="col-md-3 product__item">
                        <div class="card">
                            <img
                                src="https://media-api-beta.thinkpro.vn/backend/uploads/product/color_images/2021/6/2/alienwarex15r1-1.jpg?w=700&h=700"
                                class="card-img-top product__img"
                                alt="..."
                                />
                            <div class="card-body">
                                <p class="product__name">Alien x15 R1</p>
                                <p class="product__price">
                                    <span>From: </span>
                                    <span>44.990.000 </span>
                                </p>
                            </div>
                        </div>
                    </a>

                </div>
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <li class="page-item disabled">
                            <a class="page-link">Previous</a>
                        </li>
                        <li class="page-item active">
                            <a class="page-link" href="#">1</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">Next</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!--  -->



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
        <script src="./js/script.js"></script>
    </body>
</html>
