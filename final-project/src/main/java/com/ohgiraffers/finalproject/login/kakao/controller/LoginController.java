package com.ohgiraffers.finalproject.login.kakao.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoProfileDTO;
import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.login.kakao.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/*")
public class LoginController {

    @Autowired
    private LoginService loginService;



    @Operation(summary = "카카오 로그인 메소드", description = "sns 카카오 로그인 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " 로그인 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @RequestMapping("/oauth/*")
    public UserEntity kakaoLogin(HttpServletRequest request) throws JsonProcessingException {
        String code = request.getParameter("code");
        UserEntity profile = loginService.getAccessToken(code);

        return profile;
    }

}
