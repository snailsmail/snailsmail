package cn.springmvc.controller;

import cn.springmvc.model.Board;
import cn.springmvc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @RequestMapping("/board")
    public String cuisine(Model model){
        List<Board> boards = boardService.getAllBoard();
        model.addAttribute("boards",boards);
        return "views/board/search";
    }

    @RequestMapping("/formBoard")
    public String formBoard(Model model){
        List<Board> boards = boardService.getAllBoard();
        model.addAttribute("boards",boards);
        return "views/board/form";
    }

    @RequestMapping("/deleteBoard")
    public String deleteBoard(@RequestParam("ids") String[] ids,Model model){

        for (String boardno : ids){
            boardService.deleteBoard(boardno);
        }

        List<Board> boards = boardService.getAllBoard();
        model.addAttribute("boards",boards);
        return "views/board/search";
    }

    @RequestMapping("/updateFormBoard")
    public String updateFormBoard(@RequestParam("id") String id,Model model){

        Board board = boardService.getBoard(id);

        model.addAttribute("board",board);
        return "views/board/updateForm";
    }

    @RequestMapping("/infoBoard")
    public String infoBoard(@RequestParam("id") String id,Model model){
        Board board = boardService.getBoard(id);

        model.addAttribute("board",board);
        return "views/board/info";
    }

//    @RequestMapping("/freshBoard")
//    public String freshBoard(Model model){
//        List<Board> boards = boardService.getAllBoard();
//        model.addAttribute("boards",boards);
//        return "views/board/search";
//    }

    @RequestMapping("/saveBoard")
    public String saveBoard(HttpServletRequest request,Model model){

        String boardno = request.getParameter("boardno");
        String bname = request.getParameter("bname");

        boardService.insertBoard(boardno,bname,false);
        List<Board> boards = boardService.getAllBoard();
        model.addAttribute("boards",boards);
        return "views/board/search";
    }

    @RequestMapping("/updateBoard")
    public String updateBoard(HttpServletRequest request,Model model){

        String boardno = request.getParameter("boardno");
        String bname = request.getParameter("bname");
//        String statue = request.getParameter("state");
        int state = Integer.parseInt(request.getParameter("state"));

        boolean b;

        if (state==1){
            b = true;
        }else{
            b = false;
        }

        boardService.updateBoard(bname,b,boardno);

        List<Board> boards = boardService.getAllBoard();
        model.addAttribute("boards",boards);
        return "views/board/search";
    }
}


