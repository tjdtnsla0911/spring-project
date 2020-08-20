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

<div class="container">

   <form class="was-validated" >

     <div class="form-group">
       <label for="username">Username:</label>
       <button type="button" id="btn-username-check" class="btn btn-warning float-right" onclick="usernameCheck()">중복확인</button>
       <input type="text" class="form-control" id="username" placeholder="Enter username" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>
<!-- id로하는이유는 id는하나만 있어야하니까! -->
     <div class="form-group">
       <label for="pwd">Password:</label>
       <input type="password" id="password" class="form-control" id="password" placeholder="Enter password" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>

     <div class="form-group">
       <label for="email">Email:</label>
       <input type="email" id="email" class="form-control" id="email" placeholder="Enter Email"  required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>

     <button id="btn-save" type="button" class="btn btn-primary">회원가입완료</button>
   </form>
</div>


</body>
<script src="/user.js"></script>
</html>