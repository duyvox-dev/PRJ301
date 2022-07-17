<%-- 
    Document   : navBar
    Created on : Jun 27, 2022, 7:39:37 AM
    Author     : vobao
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.fptuni.prj301.assignment.laptopsgo.model.User" %>
<c:set var="user" value="${sessionScope.userSession}"/>
<c:set var="role" value="${user.role}"/>
<c:set var="searchKey" value="${requestScope.searchKey}"/>
<c:if test="${empty role}">
    <header>
        <nav class="navbar fixed-top navbar-expand-lg shadow">
            <div class="container navbar__main">
                <a class="navbar-brand navbar__logo" href="${pageContext.request.contextPath}">
                    <i class="fa-solid fa-laptop-code"></i>
                    <span>LaptopsGo</span>
                </a>
                <span class="navbar__toggler">
                    <i class="fa-solid fa-bars"></i>
                </span>
                <form class="navbar__search" role="search" action="${pageContext.request.contextPath}/Product/search">
                    <input
                        class="navbar__search-text"
                        type="search"
                        placeholder="Search"
                        aria-label="Search"
                        name="searchKey"
                        value ="${searchKey}"
                        />
                    <button
                        class="btn btn-solid navbar__search-btn"
                        type="submit"
                        >
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </form>
                <div class="navbar__action">
                    <!-- !role -->
                    <a href="${pageContext.request.contextPath}/auth/login.jsp" class="btn btn__solid-primary"
                       >Login/Register</a
                    > 
                </div>
            </div>
        </nav>
    </header>
</c:if>
<c:if test="${role == 'buyer'}">
    <header>
        <nav class="navbar fixed-top navbar-expand-lg shadow">
            <div class="container navbar__main">
                <a class="navbar-brand navbar__logo" href="${pageContext.request.contextPath}">
                    <i class="fa-solid fa-laptop-code"></i>
                    <span>LaptopsGo</span>
                </a>
                <span class="navbar__toggler">
                    <i class="fa-solid fa-bars"></i>
                </span>
                <form class="navbar__search" role="search" action="${pageContext.request.contextPath}/Product/search">
                    <input
                        class="navbar__search-text"
                        type="search"
                        placeholder="Search"
                        aria-label="Search"
                        name="searchKey"
                        value ="${searchKey}"
                        />
                    <button
                        class="btn btn-solid navbar__search-btn"
                        type="submit"
                        >
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </form>
                <div class="navbar__action">

                    <!-- buyer -->
                    <a href="${pageContext.request.contextPath}/Cart/" class="navbar__cart">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </a> 
                    <!--  -->

                    <!-- all role -->
                    <div class="navbar__user-container">
                        <a href="#" class="navbar__user">
                            <i class="fa-regular fa-user navbar__user-icon"></i>
                            <span class="navbar__user-name">

                                <!--  -->
                                <span class="">${user.fullname}</span>
                            </span>
                        </a>
                        <div class="navbar__user-dropdown">
                            <a href="${pageContext.request.contextPath}/User/profile">Profile</a>
                            <a href="${pageContext.request.contextPath}/User/buyHistory">Buy history</a>
                        </div>
                    </div>


                    <a
                        href="${pageContext.request.contextPath}/User/logout"
                        data-bs-toggle="tooltip"
                        data-bs-placement="bottom"
                        title="Logout"
                        class="navbar__logout"
                        >
                        <i class="fa-solid fa-arrow-right-from-bracket"></i>
                    </a>
                    <!--  -->
                </div>
            </div>
        </nav>
    </header>
</c:if>
<c:if test="${role == 'seller'}">
    <header>
        <nav class="navbar fixed-top navbar-expand-lg shadow">
            <div class="container navbar__main">
                <a class="navbar-brand navbar__logo" href="${pageContext.request.contextPath}">
                    <i class="fa-solid fa-laptop-code"></i>
                    <span>LaptopsGo</span>
                </a>
                <span class="navbar__toggler">
                    <i class="fa-solid fa-bars"></i>
                </span>
                <form class="navbar__search" role="search" action="${pageContext.request.contextPath}/Product/search">
                    <input
                        class="navbar__search-text"
                        type="search"
                        placeholder="Search"
                        aria-label="Search"
                        name="searchKey"
                        value ="${searchKey}"
                        />
                    <button
                        class="btn btn-solid navbar__search-btn"
                        type="submit"
                        >
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </form>
                <div class="navbar__action">



                    <!-- role == seller -->
                    <a href="${pageContext.request.contextPath}/Seller/add?action=create" class="btn btn__solid-red">
                        <span>Post a product </span>
                        <i class="fa-solid fa-arrow-trend-up"></i>
                    </a>
                    <!--  -->
                    <!-- all role -->
                    <div class="navbar__user-container">
                        <a href="#" class="navbar__user">
                            <i class="fa-regular fa-user navbar__user-icon"></i>
                            <span class="navbar__user-name">
                                <!-- role == admin, seller -->
                                <span class="navbar__user-role text-capitalize">${user.role}</span>
                                <!--  -->
                                <span class="">${user.fullname}</span>
                            </span>
                        </a>
                        <div class="navbar__user-dropdown">
                            <a href="${pageContext.request.contextPath}/User/profile">Profile</a>
                            <a href="${pageContext.request.contextPath}/Seller/dashboard">Seller Dashboard</a>
                        </div>
                    </div>

                    <a
                        href="${pageContext.request.contextPath}/User/logout"
                        data-bs-toggle="tooltip"
                        data-bs-placement="bottom"
                        title="Logout"
                        class="navbar__logout"
                        >
                        <i class="fa-solid fa-arrow-right-from-bracket"></i>
                    </a>
                    <!--  -->
                </div>
            </div>
        </nav>
    </header>
</c:if>
<c:if test="${role == 'admin'}">
    <header>
        <nav class="navbar fixed-top navbar-expand-lg shadow">
            <div class="container navbar__main">
                <a class="navbar-brand navbar__logo" href="${pageContext.request.contextPath}">
                    <i class="fa-solid fa-laptop-code"></i>
                    <span>LaptopsGo</span>
                </a>
                <span class="navbar__toggler">
                    <i class="fa-solid fa-bars"></i>
                </span>
                <form class="navbar__search" role="search" action="${pageContext.request.contextPath}/Product/search">
                    <input
                        class="navbar__search-text"
                        type="search"
                        placeholder="Search"
                        aria-label="Search"
                        value ="${searchKey}"
                        />
                    <button
                        class="btn btn-solid navbar__search-btn"
                        type="submit"
                        >
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </form>
                <div class="navbar__action">
                    <!-- all role -->
                    <div class="navbar__user-container">
                        <a href="#" class="navbar__user">
                            <i class="fa-regular fa-user navbar__user-icon"></i>
                            <span class="navbar__user-name">
                                <!-- role == admin, seller -->
                                <span class="navbar__user-role  text-capitalize">${user.role}</span>
                                <!--  -->
                                <span class="">${user.fullname}</span>
                            </span>
                        </a>
                        <div class="navbar__user-dropdown ">
                            <a href="${pageContext.request.contextPath}/User/profile">Profile</a>
                            <a href="${pageContext.request.contextPath}/Admin/category">Category Management</a>
                            <a href="${pageContext.request.contextPath}/Admin/brand">Brand Management</a>
                            <a href="${pageContext.request.contextPath}/Admin/user">User Management</a>
                            <a href="${pageContext.request.contextPath}/Admin/product">Product Management</a>
                        </div>
                    </div>

                    <a
                        href="${pageContext.request.contextPath}/User/logout"
                        data-bs-toggle="tooltip"
                        data-bs-placement="bottom"
                        title="Logout"
                        class="navbar__logout"
                        >
                        <i class="fa-solid fa-arrow-right-from-bracket"></i>
                    </a>
                    <!--  -->
                </div>
            </div>
        </nav>
    </header>
</c:if>

