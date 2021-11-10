package com.spring.mvc.board.controller;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.board.dto.ModBoard;
import com.spring.mvc.board.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board")
///명령 내리는 책임
public class BoardController {

    /*
    * 게시물 목록요청: /board/list :GET
    * 게시물 상세조회요청: /board/content :GET
    * 게시글 쓰기 화면 요청: /board/write: GET
    * 게시글 등록 요청: /board/write: POST
    * 게시글 삭체 요청: /board/delete: GET
    * 게시글 수정화면 요청: /board/modify: GET
    * 게시글 수정요청: /board/modify: POST
    * */


    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    //게시물 목록요청
    ///서버가 클라이언트에게 전달할 때 쓰는 객체 Model
    @GetMapping("/list")
    public String boardList(Model model) {
        List<Board> boardList = boardService.getList();
        model.addAttribute("articles",boardList);
        log.info("게시물 목록 요청/list" + boardList);
        return "board/list";
    }

    //게시물 상세 조회 요청
    @GetMapping("/content")
    public String content(Long boardNo, Model model) {
        log.info("게시물 상세 조회 요청/content" + boardNo);
        Board board = boardService.getBoard(boardNo);
        model.addAttribute("b",board);
        return "board/content";
    }

    //게시글 쓰기 화면 요청
    @GetMapping("/write")
    public String boardWrite() {
        log.info("게시물 쓰기 화면  요청/write");
        return "board/write";
    }

    //게시글 등록 요청
    @PostMapping("/write")
    public String boardWrite(Board board) {
        log.info("게시물 등록요청 요청/write - POST!!" + board);
        boardService.register(board);
        return "redirect:/board/list";
    }

    //게시글 삭제 요청
    @GetMapping("/delete")
    public String boardDelete(Long boardNo, Model model) {
        log.info("게시물 삭제 요청 ");
        boardService.remove(boardNo);
        return "redirect:/board/list";
    }

    //게시글 수정 화면 요청
    @GetMapping("/modify")
    public String boardModify(Long boardNo, Model model) {
        log.info("게시물 수정 화면 요청!");
        Board board = boardService.getBoard(boardNo);
        model.addAttribute("b",board);
        return "/board/modify";
    }

    //게시글 수정 요청 - POST
    @PostMapping("/modify")
    public String boardModify(ModBoard board) {
        log.info("게시물 수정 요청! POST!!" );
        boardService.editBoard(board);
        log.info("수정된 내용" + board);
        return "redirect:/board/list";
    }



}//end class
