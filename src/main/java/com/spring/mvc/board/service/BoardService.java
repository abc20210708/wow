package com.spring.mvc.board.service;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.board.dto.ModBoard;
import com.spring.mvc.board.repository.BoardMapper;
import com.spring.mvc.common.paging.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
//책임: 컨트롤러와 저장소 사이의 중간 데이터 처리 담당
public class BoardService {

    private final BoardMapper boardMapper;
/*
    @Autowired
    public BoardService(
            @Qualifier("br") BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }*/

    //저장처리 중간 로직
    public void register(Board board) {
        boardMapper.insert(board);
    }

    //전체 조회 중간 처리
    public List<Board> getList(Page page) {

        List<Board> articles = boardMapper.getArticles(page);

        //역정렬
        /*List<Board> sortedList = new ArrayList<>();
        for (int i = articles.size()-1; i >= 0; i--) {
            sortedList.add(articles.get(i));
        }*/

        /*//제목에 마킹처리
        for (Board board : boardList) {
            //제목 빼오기
            String title = board.getTitle();

            if (title.length() >= 20) {
              String last = title.substring(0,20);
              board.setTitle(last + "..");
            }

        }*/
        //신규 게시물 new 마킹 처리
        return  jedgeNewArticle(articles);
    }

    private List<Board> jedgeNewArticle(List<Board> articles) {
        //해당 리스트에서 게시물 객체를 하나씩 꺼내 작성일자를 추출
        for (Board article : articles) {
            //작성일자
            long regDateTime = article.getRegDate().getTime();
            //현재 날짜 시간
            long nowTime = System.currentTimeMillis();

            //현재 시간 - 작성 시간
            long diff = nowTime - regDateTime;

            long limitTime = 20 * 60 * 1000;
            if (diff < limitTime) {
                article.setNewFlag(true);
            }
        }
        return articles;
    }

    //삭제 중간 처리
    public void remove(Long boardNo) {
        boardMapper.delete(boardNo);
    }

    //상세 조회 중간 처리
    public Board getBoard(Long boardNo) {
        Board board = boardMapper.getContent(boardNo);
        return board;
    }

    //수정 중간 처리
    public void editBoard(ModBoard board) {
      boardMapper.update(board);
    }


    //글쓰기 중간처리
    public boolean write(Board board) {

        return boardMapper.insert(board);
    }

    //총 게시물 수 조회 중간 처리
    public int getCount() {
        return boardMapper.getTotalCount();
    }
}//end class
