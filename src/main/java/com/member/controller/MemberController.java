package com.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import member.service.MemberService;

/* SpringReact/src/main/member/controller/MemberController.java */
@Api(value = "MemberController", description = "회원 관리 API") // Controller에 대한 Swagger 설명
@RestController
@RequestMapping(value = "/member")
@CrossOrigin(origins = "http://www.springreact.store", allowCredentials = "true")
public class MemberController {

    @Autowired
    MemberService memberService;

    @ApiOperation( // API에 대한 Swagger 설명
            value = "로그인",
            notes = "회원 로그인 API입니다.",
            httpMethod = "POST",
            consumes = "application/json",
            produces = "application/json"
    )
    @ApiResponses({ // Response Message에 대한 Swagger 설명
            @ApiResponse(code = 200, message = "로그인 성공"),
            @ApiResponse(code = 401, message = "로그인 실패")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "credentials", value = "로그인 정보", required = true, dataType = "Map", paramType = "body",
                              example = "{\"id\": \"yourId\", \"pwd\": \"yourPassword\"}")
    })
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody Map<String, String> credentials) {
        String id = credentials.get("id");
        String pwd = credentials.get("pwd");
        return memberService.login(id, pwd);
    }
}