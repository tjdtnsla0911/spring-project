package com.cos.jwtex01.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.jwtex01.config.jwt.JwtProperties;
import com.cos.jwtex01.config.oauth.provider.CommonUser;
import com.cos.jwtex01.config.oauth.provider.GoogleUser;
import com.cos.jwtex01.config.oauth.provider.OAuthUserInfo;
import com.cos.jwtex01.dto.ProductDto;
import com.cos.jwtex01.model.User;
import com.cos.jwtex01.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JwtCreateController {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;




	@GetMapping("/test/index")
	public List<ProductDto> asdf() {
		System.out.println("asdf에 왔습니다.");
		List<ProductDto> dto = userRepository.productDto();
		return dto;
	}





	@PostMapping("/oauth/jwt/common")
	public String commonlogin(@RequestBody Map<String, Object> data) {
		System.out.println("controller.JwtCreateController.java의 jwtCreate에 왔습니다 ");
		System.out.println("여긴 데이터 data = "+data);
		CommonUser commonUser =
				new CommonUser((Map<String, Object>)data);
		System.out.println("------------------------------------------------------------");
		System.out.println("googleUser.getProvider() = "+commonUser.getProvider());
		System.out.println("googleUser.getProviderId() = "+commonUser.getProviderId());
		User userEntity =
				userRepository.findByUsername(commonUser.getName());
		System.out.println("controller.JwtCreateController.java의 jwtCreate의 userEntity = "+userEntity);



		if(userEntity == null) {

			System.out.println("아이디가 틀렸거나 아이디가 없습니다, 회원가입으로 이동");
			return "안녕";

//			System.out.println("controller.JwtCreateController.java의 jwtCreate의 if(userEntity == null)에 왔습니다 ");
//
//
//			User userRequest = User.builder()
//					.username(commonUser.getProvider()+"_"+commonUser.getName())
//					.password(bCryptPasswordEncoder.encode(commonUser.getPassword()))
//					.email(commonUser.getEmail())
//					.provider(commonUser.getProvider())
//					.providerId(commonUser.getProviderId())
//					.roles("ROLE_USER")
//					.build();
//
//			userEntity = userRepository.save(userRequest);
//			System.out.println("controller.JwtCreateController.java의 jwtCreate의 if(userEntity == null)의 userEntity = "+userEntity);
		}

		boolean checkPassword = bCryptPasswordEncoder.matches((String)data.get("password"), userEntity.getPassword());

		if(!checkPassword) {
			System.out.println("비밀번호가 틀렸습니다, 회원가입으로 이동");
			return "안녕";
		}

		String jwtToken = JWT.create()
				.withSubject(userEntity.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
				.withClaim("id", userEntity.getId())
				.withClaim("username", userEntity.getUsername())
				.sign(Algorithm.HMAC512(JwtProperties.SECRET));
		System.out.println("controller.JwtCreateController.java의 jwtCreate의 jwtToken = "+jwtToken);

		return jwtToken;
	}
	@PostMapping("/oauth/jwt/google")
	public String jwtCreate(@RequestBody Map<String, Object> data) {
		System.out.println("controller.JwtCreateController.java의 jwtCreate에 왔습니다 ");
		System.out.println("여긴 데이터 data = "+data);
		System.out.println(data.get("profileObj"));//구글에서 주는양식 .
		OAuthUserInfo googleUser =
				new GoogleUser((Map<String, Object>)data.get("profileObj"));
		System.out.println("------------------------------------------------------------");
		System.out.println("googleUser.getProvider() = "+googleUser.getProvider());
		System.out.println("googleUser.getProvider() = "+googleUser.getProviderId());
		User userEntity =
				userRepository.findByUsername(googleUser.getProvider()+"_"+googleUser.getProviderId());
		System.out.println("controller.JwtCreateController.java의 jwtCreate의 userEntity = "+userEntity);
		if(userEntity == null) {
			System.out.println("controller.JwtCreateController.java의 jwtCreate의 if(userEntity == null)에 왔습니다 ");
			User userRequest = User.builder()
					.username(googleUser.getProvider()+"_"+googleUser.getProviderId())
					.password(bCryptPasswordEncoder.encode("겟인데어"))
					.email(googleUser.getEmail())
					.provider(googleUser.getProvider())
					.providerId(googleUser.getProviderId())
					.roles("ROLE_USER")
					.build();

			userEntity = userRepository.saveGoogle(userRequest);
			System.out.println("controller.JwtCreateController.java의 jwtCreate의 if(userEntity == null)의 userEntity = "+userEntity);
		}

		String jwtToken = JWT.create()
				.withSubject(userEntity.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
				.withClaim("id", userEntity.getId())
				.withClaim("username", userEntity.getUsername())
				.sign(Algorithm.HMAC512(JwtProperties.SECRET));
		return jwtToken;
	}


}
