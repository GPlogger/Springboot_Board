// Controller : 사용자 요청을 받는 클래스 설정 >> 사용자로부터의 요청을 분석해 RequestMapping 함수에게 전달
package com.practice.board.controller;

import com.practice.board.entity.BOARD;
import com.practice.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class BoardController {
    // 정의한 BoardService 를 boardService 이름으로 사용
    private final BoardService boardService;

    // 해당 경로로 들어왔을 때 Response를 정의하는 함수 지정(GetMapping)
    @GetMapping("/")
    @ResponseBody           // 해당 경로로 들어왔을 때 리턴되는 값을 그대로 띄워주는 어노테이션
    public String main(){
        return "게시물 작성";
    }

    // ~/board/write 접속 시 매핑
    @GetMapping("/board/write")
    public String boardWriteForm() {

        return "boardwrite";    // 템플릿의 html 이름
    }

    // ~/board/write POSt mapping
    @PostMapping("/board/writepro")
    public String boardWritePro(BOARD board) {

        boardService.write(board);

        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {      // 데이터를 담아서 페이지로 보내줘야 함 >> 모델 사용
        // ("보낼 이름", 담을 객체)
        model.addAttribute("list", boardService.boardList());
        return "boardlist";
    }

    @GetMapping("/board/view")  // ~/board/view?id=1   : 1이 파라미터 id로 들어가고, id 값으로 게시글을 불러옴
    public String boardView(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));  //
        return "boardview";
    }


    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {
        boardService.boardDelete(id);
        // id값을 찾아내 그 id값을 메서드에 담아 서비스에 보냄 > 삭제처리 후 list로 리다이렉트
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    // 매핑된 {id}를 인식해 id로 들여옴
    public String boardModify(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, BOARD board) { // 새로입력한 내용 받아옴
        BOARD boardTemp = boardService.boardView(id);   // 임시 board객체 생성
        boardTemp.setTitle(board.getTitle());
        boardTemp.setNickname(board.getNickname());
        boardTemp.setPassword(board.getPassword());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);      // 임시 객체를 덮어씌움

        return "redirect:/board/list";
    }
}
