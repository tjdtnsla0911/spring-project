let index = {
 init:function(){

	 $("#btn-save").on("click",()=>{
		console.log(this);
		this.save();
	 });

	 $("#btn-login").on("click",()=>{
		 console.log(this);
		 this.login();
	 });
 	},//여기가함수의끝
 	save:function(){
 		let data ={
 				username : $("#username").val(),
 				password : $("#password").val(),
 				email : $("#email").val(),
 		};
 		$.ajax({
 			type:"POST",
 			url:"/join",//auth붙은건 권한과 이늦ㅇ이필요없다
 			data:JSON.stringify(data),//json으로 바꾸는방식
 			contentType:"application/json; charset=utf-8",
 			dataType:"json"//적는게좋다 공식
 		}).done(function(resp){
 			alert("회 원 가 입 성 공 !! ㅊㅊㅊ")
 			location.href="/jsp";

 			console.log(resp)

 		}).fail(function(error){
 			alert("회 원 가 입 실 패 !");
 			console.log(error);

 		})
 	},
 	login:function(){
 		let data = {
 				username : $("#username").val(),
 				password : $("#password").val(),
 		};
 		$.ajax({
 			type:"POST",
 			url:"/oauth/jwt/common",
 			data:JSON.stringify(data),

 			contentType:"application/json; charset=utf-8",
 			dataType:"text"
 		}).done(function(resp){

 			if(resp == "안녕"){
 				location.href="/auth/joinForm";
 				return;
 			}

 			alert("로 그 인 성 공");
 			localStorage.setItem('jwtToken', resp);
 			location.href="/jsp";
 			console.log(resp);

 		}).fail(function(error){

 			alert("로그인 실패");
 			console.log('에러 = '+error);
 		})
 	},
}
index.init();