package cn.springmvc.service.impl;

import cn.springmvc.dao.BoardDAO;
import cn.springmvc.model.Board;
import cn.springmvc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	protected BoardDAO boardDAO;

	public List<Board> getAllBoard(){
		List<Board> boards = boardDAO.getAllBoard();
		return boards;
	}

	public Board getBoard(String boardno){
		Board board = boardDAO.getBoard(boardno);
		return board;
	}

	public void insertBoard(String boardno,String bname,boolean state){
		boardDAO.insertBoard(boardno,bname,state);
	}

	public void deleteBoard(String boardno){
		boardDAO.deleteBoard(boardno);
	}

	public void updateBoard(String bname,boolean state,String boardno){
		boardDAO.updateBoard(bname,state,boardno);
	}




}
