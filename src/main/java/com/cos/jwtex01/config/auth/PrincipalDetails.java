package com.cos.jwtex01.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.jwtex01.model.User;

public class PrincipalDetails implements UserDetails{

	private User user;

    public PrincipalDetails(User user){
    	System.out.println("auth.PrincipalDetails의 user = "+user);
        this.user = user;
    }

    public User getUser() {
    	System.out.println("auth.PrincipalDetails의getUser의  user = "+user);
		return user;
	}

    @Override
    public String getPassword() {
//    	System.out.println("auth.PrincipalDetails의getPassword의  user.getPassword() = "+user.getPassword());
        return user.getPassword();
    }

    @Override
    public String getUsername() {
    	System.out.println("auth.PrincipalDetails의getPassword의  user.getUsername() = "+user.getUsername());
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
    	System.out.println("auth.PrincipalDetails의 isAccountNonExpired에 왔습니다");
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
    	System.out.println("auth.PrincipalDetails의 isAccountNonLocked에 왔습니다");

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    	System.out.println("auth.PrincipalDetails의 isCredentialsNonExpired에 왔습니다");

        return true;
    }

    @Override
    public boolean isEnabled() {
      	System.out.println("auth.PrincipalDetails의 isEnabled에 왔습니다");
        return true;
    }

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      	System.out.println("auth.PrincipalDetails의 getAuthorities에 왔습니다");

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        user.getRoleList().forEach(r -> {
          	System.out.println("auth.PrincipalDetails의 getAuthorities의 authorities= "+authorities);

        	authorities.add(()->{ return r;});
        });
     	System.out.println("auth.PrincipalDetails의 getAuthorities의 authorities의 완결판= "+authorities);
        return authorities;
    }
}
