package com.spring.mvc.board.repository;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.board.dto.ModBoard;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Log4j2
//실제 메모리 저장소
public class MemoryBoardRepository implements BoardRepository{


    //메모리 저장소
    private Map<Long, Board> boardMap = new HashMap<>();

    //기본 데이터 초기화
    public MemoryBoardRepository() {
        boardMap.put(1L, new Board("김철수", "토요일", "오늘은 11월 6일 토요일"));
        boardMap.put(2L, new Board("박영희", "일요일", "오늘은 11월 7일 일요일"));
        boardMap.put(3L, new Board("이디야", "월요일", "오늘은 11월 8일 월요일"));
    }


    @Override //게시물 목록 조회
    public List<Board> getArticles() {
        List<Board> boardLists = new ArrayList<>();
        for (Long key : boardMap.keySet()) {
            Board board = boardMap.get(key);
            boardLists.add(board);
        }

        return boardLists;
    }

    @Override //게시물 상세 조회
    public Board getContent(Long boardNo) {
        Board board = boardMap.get(boardNo);
        return board;
    }

    @Override //게시물 등록
    public boolean insert(Board board) {
        boardMap.put(board.getBoardNo(), board);
        log.info(boardMap);
        return true;
    }

    @Override //게시물 삭제
    public boolean delete(Long boardNo) {
        boardMap.remove(boardNo);
        return true;
    }

    @Override //게시물 수정
    public boolean update(ModBoard board) {
        Board target = boardMap.get(board.getBoardNo());
        target.setContent(board.getContent());
        target.setTitle(board.getTitle());
        target.setWriter(board.getWriter());

        return true;
    }
}//end class
