<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Sign In</title>
    <!-- Bootstrap core CSS -->
    <link href="asserts/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="asserts/css/signin.css" rel="stylesheet">
</head>

<body class="text-center" style="background-image: url('asserts/img/background.png')">
<div>
    <img class="mb-4" src="asserts/img/FreeSeed.png" alt="" width="500">
    <form class="form-signin" action="dashboard" method="post">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label class="sr-only">Username</label>
        <input type="email" class="form-control" name="email" placeholder="Email" required="" autofocus="">
        <label class="sr-only">Password</label>
        <input type="password" class="form-control" name="password" placeholder="Password" required="">
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign In</button>
        <a href="/Sign_Up" ><h6>Sign Up</h6></a>
        <p class="mt-5 mb-3 text-muted">© 1999 - ∞</p>
        <!--TODO 国际化-->
        <a class="btn btn-sm" >中文</a>
        <a class="btn btn-sm">English</a>
    </form>
</div>

</body>

</html>