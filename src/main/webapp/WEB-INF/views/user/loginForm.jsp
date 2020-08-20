<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form class="was-validated" >

     <div class="form-group">
       <label for="username">Username:</label>
       <input id="username" type="text" class="form-control" placeholder="Enter username" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>

     <div class="form-group">
       <label for="pwd">Password:</label>
       <input type="password" id="password"  class="form-control" placeholder="Enter password" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>

     <button type="button" id="btn-login" class="btn btn-primary">로그인</button>
     </form>

</body>
<script src="/user.js"></script>
</html>