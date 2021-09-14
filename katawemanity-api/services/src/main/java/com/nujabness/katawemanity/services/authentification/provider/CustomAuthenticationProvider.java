package com.nujabness.katawemanity.services.authentification.provider;

import com.nujabness.katawemanity.beans.commons.UserBean;
import com.nujabness.katawemanity.data.dao.IUserRepository;
import com.nujabness.katawemanity.services.adapter.UserBeanServiceAdapter;
import com.nujabness.katawemanity.services.authentification.CustomUsernamePasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private IUserRepository authenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) {
    	String userMail = authentication.getName();
        String userPassword = authentication.getCredentials().toString();
        UserBean userInfo;
        try {
			 userInfo = UserBeanServiceAdapter.transformToUserBeanService(authenticationService.getUserInfoByEmailAndPassword(userMail, userPassword));

    	} catch (Exception e) {
			throw new BadCredentialsException("Invalid username/password supplied");
		}

    	if (userInfo == null)
    		 throw new BadCredentialsException("Invalid username/password supplied");
    	String token = jwtTokenProvider.createToken(userInfo.getId().toString(),null);
        return new CustomUsernamePasswordAuthenticationToken(userInfo, token);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
