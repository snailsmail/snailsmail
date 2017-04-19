package cn.springmvc.service;

import cn.springmvc.model.Board;

import java.util.List;


public interface BoardService {

	public List<Board> getAllBoard();

	public Board getBoard(String boardno);

	public void insertBoard(String boardno, String bname, boolean state);

	public void deleteBoard(String boardno);

	public void updateBoard(String bname, boolean state, String boardno);


}

