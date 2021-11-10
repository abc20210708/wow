package com.spring.mvc.board.service;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.board.dto.ModBoard;
import com.spring.mvc.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@Log4j2
//책임: 컨트롤러와 저장소 사이의 중간 데이터 처리 담당
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(
            @Qualifier("br") BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //저장처리 중간 로직
    public void register(Board board) {
        boardRepository.insert(board);
    }

    //전체 조회 중간 처리
    public List<Board> getList() {

        List<Board> articles = boardRepository.getArticles();

        //역정렬
        List<Board> sortedList = new ArrayList<>();
        for (int i = articles.size()-1; i >= 0; i--) {
            sortedList.add(articles.get(i));
        }

        /*//제목에 마킹처리
        for (Board board : boardList) {
            //제목 빼오기
            String title = board.getTitle();

            if (title.length() >= 20) {
              String last = title.substring(0,20);
              board.setTitle(last + "..");
            }

        }*/
        return  sortedList;
    }

    //삭제 중간 처리
    public void remove(Long boardNo) {
        boardRepository.delete(boardNo);
    }

    //상세 조회 중간 처리
    public Board getBoard(Long boardNo) {
        Board board = boardRepository.getContent(boardNo);
        return board;
    }

    //수정 중간 처리
    public void editBoard(ModBoard board) {
      boardRepository.update(board);
    }



}//end class
