package com.alacriti.HealthCare.Config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alacriti.HealthCare.Entity.Users;
import com.alacriti.HealthCare.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
        
        String email = oauthUser.getAttribute("email");
        String name = oauthUser.getAttribute("name");
        
        String sessionRole = (String) request.getSession().getAttribute("role");
        
        System.out.println(sessionRole + " " + name + " " + email);
        
        if (sessionRole == null) {
            response.sendRedirect("http://localhost:4200");
            return;
        }

        
        Users user = userService.findUserByEmail(email);
        String redirectUrl = "http://localhost:4200";

        if(user == null) {
        	userService.addUser(email, name, sessionRole);
        	if (sessionRole.equals("doctor")) {
        		
        		redirectUrl += "/profile/create/doctor";
        	}
        	else if (sessionRole.equals("patient")) {
        		redirectUrl += "/profile/create/patient";
        	}
        }
        
        else {
        	if (sessionRole.equals("doctor") && user.getRole().equals("doctor")) {
        		System.out.println(sessionRole + " " + user.getRole());
        		redirectUrl += "/dashboard/doctor";
        	}
        	else if (sessionRole.equals("patient") && user.getRole().equals("patient")) {
        		redirectUrl += "/dashboard/patient";
        	}
        	else {
        		redirectUrl += "";
        	}
        }

        // Redirect to the final URL
        response.sendRedirect(redirectUrl);

        // Set the SecurityContextHolder to the authenticated user
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    
}