package com.kitri.admin.board.model;

public class BoardListDto extends CategoryDto{

	private int bcode;
	private String bname;
	private int btcode;
	
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getBtcode() {
		return btcode;
	}
	public void setBtcode(int btcode) {
		this.btcode = btcode;
	}
	
}
