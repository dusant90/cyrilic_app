package com.cyrilic.project.restapi.security;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cyrilic.project.restapi.entity.User;
import com.cyrilic.project.restapi.service.UserService;

@Component
public class AuthenticationFacade {

	@Autowired
	private UserService userService;

	
    public Authentication getAuthentication() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (!(authentication instanceof AnonymousAuthenticationToken))
            return authentication;
        
        return null;
    }
    
    public User getAuthenticatedUser() throws AuthenticationException {
    	Authentication auth = getAuthentication();

    	if (auth == null)
    		throw new AuthenticationException("User is not authenticated");
    	
    	User user = userService.getUserByMail(auth.getName());
    	if (user == null)
    		throw new AuthenticationException("Authenticated user does not exist");
    	
    	return user;
    }
}