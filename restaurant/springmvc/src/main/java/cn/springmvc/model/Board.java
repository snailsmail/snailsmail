package cn.springmvc.model;

public class Board {//餐桌
	private String boardno;
	private String bname;
	private boolean state;

	public Board() {
	}

	public Board(String boardno, String bname, boolean state) {
		super();
		this.boardno = boardno;
		this.bname = bname;
		this.state = state;
	}

	public String getBoardno() {
		return boardno;
	}

	public void setBoardno(String boardno) {
		this.boardno = boardno;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
