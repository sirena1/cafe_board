package com.kitri.board.model;

public class AlbumDto extends BoardDto {

	private int aseq;
	private String orignPicture;
	private String savePicture;
	private String saveFolder;
	private int ptype;
	
	public int getAseq() {
		return aseq;
	}
	public void setAseq(int aseq) {
		this.aseq = aseq;
	}
	public String getOrignPicture() {
		return orignPicture;
	}
	public void setOrignPicture(String orignPicture) {
		this.orignPicture = orignPicture;
	}
	public String getSavePicture() {
		return savePicture;
	}
	public void setSavePicture(String savePicture) {
		this.savePicture = savePicture;
	}
	public String getSaveFolder() {
		return saveFolder;
	}
	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}
	public int getPtype() {
		return ptype;
	}
	public void setPtype(int ptype) {
		this.ptype = ptype;
	}
	
	
}
