//package com.example.reviewapp.infrastructure.config;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.CachingUserDetailsService;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
//
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//@Component
//public class JwAthFilter extends OncePerRequestFilter {
//    CachingUserDetailsService userDetalisService;
//    private final JwUtils jwUtilis;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        final String authHeader = request.getHeader(AUTHORIZATION);
//        final String userEmail;
//        final String jwToken;
//        final boolean isTokenValid;
//
//        if (authHeader == null || !authHeader.startsWith("Bearer")){
//            filterChain.doFilter(request, response);
//            return;
//        }
//        jwToken = authHeader.substring(7);
//        userEmail = jwUtilis.extractUsername(jwToken);
//        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() ==null){
//            UserDetails userDetails = userDetalisService.loadUserByUsername(userEmail);
//
//            if(jwUtilis.isTokenValid(jwToken, userDetails)){
//                UsernamePasswordAuthenticationToken authenticationToken =
//                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//        }
//        filterChain.doFilter(request,response);
//    }
//}