package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;
import board.bean.BoardDTO;
import board.service.BoardService;


/* SpringReact/src/main/member/controller/BoardController.java */

//@Controller
@Api(value = "BoardController", description = "게시판 API") // Controller에 대한 Swagger 설명
@RestController
@RequestMapping(value = "/board")
@CrossOrigin(origins = "https://www.springreact.store", allowCredentials = "true")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @ApiOperation(
            value = "게시글 작성",
            notes = "새로운 게시글을 작성하는 API입니다.",
            httpMethod = "GET"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "게시글 작성 성공"),
            @ApiResponse(code = 400, message = "잘못된 요청 파라미터")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "subject", value = "게시글 제목", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "content", value = "게시글 내용", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping(value = "/boardWrite")
    public void boardWrite(@RequestParam String subject, @RequestParam String content) {
        System.out.println(subject);
        boardService.boardWrite(subject, content);
    }

    @ApiOperation(
            value = "게시글 목록 조회",
            notes = "게시글 목록을 조회하는 API입니다.",
            httpMethod = "GET"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "게시글 목록 조회 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @GetMapping(value = "/boardList")
    public List<BoardDTO> boardList() { // List<BoardDTO> 객체를 자동으로 JSON 배열로 변환하여 보냄
        return boardService.boardList();
    }
}
