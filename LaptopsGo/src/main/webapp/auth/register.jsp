<%-- 
    Document   : register
    Created on : Jun 30, 2022, 4:10:18 PM
    Author     : vobao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>LaptopsGo- Register</title>
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
        <link rel="stylesheet" href="../css/login.css" />
    </head>
    <body>
        <div class="login__page">
            <c:set var="errors" value="${requestScope.errors}"/>

            <c:if test="${not empty errors['username']}">
                <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                    <div class="toast-header">
                        <img src="..." class="rounded mr-2" alt="...">
                        <strong class="mr-auto">Register error</strong>
                        <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="toast-body">
                        ${errors['username']}
                    </div>
                </div>

            </c:if>
        </c:if>
        <c:if test="${not empty errors['email']}">
            <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                    <img src="..." class="rounded mr-2" alt="...">
                    <strong class="mr-auto">Register error</strong>
                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="toast-body">
                    ${errors['email']}
                </div>
            </div>
        </c:if>
        <c:if test="${not empty errors['confirm-password']}">
            <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                    <img src="..." class="rounded mr-2" alt="...">
                    <strong class="mr-auto">Register error</strong>
                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="toast-body">
                    ${errors['confirm-password']}
                </div>
            </div>
        </c:if>
        <div class="login__main shadow-sm">
            <a class="logo" href="#">
                <i class="fa-solid fa-laptop-code"></i>
                <span>LaptopsGo</span>
            </a>
            <form action="../User/register" class="login__form" method = "POST">
                <div class="input__group">
                    <label for="username">Username </label>
                    <input type="text" name="username" required />
                </div>
                <div class="input__group">
                    <label for="password">Password </label>
                    <input type="password" name="password" required minLength="8" />
                </div>
                <div class="input__group">
                    <label for="confirm-password">Confirm password </label>
                    <input
                        type="password"
                        name="confirm-password"
                        required
                        minLength="8"
                        />

                </div>
                <div class="input__group">
                    <label for="fullname">Full name </label>
                    <input type="text" name="fullname" required />
                </div>
                <div class="input__group">
                    <label for="email">Email </label>
                    <input type="email" name="email" required />
                </div>
                <div class="input__group checkbox">
                    <label for="role">Role </label>
                    <select name="role" id="">
                        <option value="buyer" default>buyer</option>
                        <option value="seller">seller</option>
                    </select>

                </div>
                <button class="login__btn">Register</button>
            </form>
            <p class="link-to">
                <span>Already have account ? </span>
                <a href="${pageContext.request.contextPath}/auth/login.jsp" class="">Login</a>
            </p>
        </div>
    </div>



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

    <!--  -->
    <script src="./js/script.js"></script>
</body>
</html>
