package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import board.bean.BoardDTO;
import board.service.BoardService;


/* SpringReact/src/main/member/controller/BoardController.java */

@Api(tags = "게시판 API") // BoardController에 대한 설명 추가
@RestController
@RequestMapping(value = "/board")
@CrossOrigin(origins = "http://www.springreact.store", allowCredentials = "true")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @ApiOperation(value = "게시글 작성", notes = "게시글의 제목과 내용을 입력받아 작성합니다.")
    @GetMapping(value = "/boardWrite")
    public void boardWrite(
        @ApiParam(value = "게시글 제목", required = true) @RequestParam String subject,
        @ApiParam(value = "게시글 내용", required = true) @RequestParam String content) {
        System.out.println(subject);
        boardService.boardWrite(subject, content);
    }

    @ApiOperation(value = "게시글 목록 조회", notes = "모든 게시글을 조회합니다.")
    @GetMapping(value = "/boardList")
    public List<BoardDTO> boardList() {
        return boardService.boardList();
    }
}
