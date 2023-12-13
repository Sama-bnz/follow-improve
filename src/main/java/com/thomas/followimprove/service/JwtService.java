package com.thomas.followimprove.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class JwtService {





    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);
    @Value("${FollowImprove.jwtSecret}")
    private String jwtSecret;
    @Value("${FollowImprove.jwtExpirationMs}")

    private int jwtExpirationMs;

}
