package com.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import member.service.MemberService;

/* SpringReact/src/main/member/controller/MemberController.java */
@Api(tags = "회원 API") // MemberController에 대한 설명 추가
@Controller
@RequestMapping(value = "/member")
@CrossOrigin(origins = "http://www.springreact.store", allowCredentials = "true")
public class MemberController {

    @Autowired
    MemberService memberService;

    @ApiOperation(value = "로그인", notes = "회원의 아이디와 비밀번호를 입력받아 로그인합니다.")
    @PostMapping("/login")
    @ResponseBody
    public String login(
        @ApiParam(value = "회원 ID", required = true) @RequestBody Map<String, String> credentials) {
        String id = credentials.get("id");
        String pwd = credentials.get("pwd");
        return memberService.login(id, pwd);
    }
}
