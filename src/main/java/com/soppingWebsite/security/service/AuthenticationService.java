package com.soppingWebsite.security.service;


import com.soppingWebsite.security.model.AuthenticationRequest;
import com.soppingWebsite.security.model.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;
}