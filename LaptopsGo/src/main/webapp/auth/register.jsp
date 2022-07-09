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
            <div class="login__main shadow-sm">
                <a class="logo" href="#">
                    <i class="fa-solid fa-laptop-code"></i>
                    <span>LaptopsGo</span>
                </a>
                <form action="" class="login__form">
                    <div class="input__group">
                        <label for="username">Username </label>
                        <input type="text" name="username" required />
                    </div>
                    <div class="input__group">
                        <label for="password">Password </label>
                        <input type="password" name="password" required />
                    </div>
                    <div class="input__group">
                        <label for="confirm-password">Confirm password </label>
                        <input
                            type="password"
                            name="confirm-password"
                            required
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
                        <input
                            type="checkbox"
                            name="role"
                            id="role__checkbox"
                            required
                        />
                        <label for="role__checkbox">Register as Seller </label>
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
