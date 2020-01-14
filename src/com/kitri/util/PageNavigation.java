package com.kitri.util;

public class PageNavigation {

	private String root;
	private boolean nowFirst;
	private boolean nowEnd;
	private int totalArticleCount;
	private int newArticleCount;
	private int totalPageCount;
	private int pageNo;
	private String navigator;
	
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public boolean isNowFirst() {
		return nowFirst;
	}
	public void setNowFirst(boolean nowFirst) {
		this.nowFirst = nowFirst;
	}
	public boolean isNowEnd() {
		return nowEnd;
	}
	public void setNowEnd(boolean nowEnd) {
		this.nowEnd = nowEnd;
	}
	public int getTotalArticleCount() {
		return totalArticleCount;
	}
	public void setTotalArticleCount(int totalArticleCount) {
		this.totalArticleCount = totalArticleCount;
	}
	public int getNewArticleCount() {
		return newArticleCount;
	}
	public void setNewArticleCount(int newArticleCount) {
		this.newArticleCount = newArticleCount;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getNavigator() {
		return navigator;
	}
	public void makeNavigator() {
		int naviCount = BoardConstance.NAVIGATION_COUNT;
		
		StringBuilder navigator = new StringBuilder();
		navigator.append("<div class=\"pagination\" style=\"padding-top: 10px\"> \n");
		navigator.append("	<a href=\"#\" class=\"firstpage\">&laquo;</a> \n");
		int prePage = (pageNo - 1) / naviCount * naviCount;
		if(isNowFirst())
			navigator.append("	&lsaquo; \n");
		else
			navigator.append("	<a href=\"#\" class=\"movepage\" data-page=\"" + prePage + "\">&lsaquo;</a> \n");
		int startPage = prePage + 1; //전단계 마지막
		int endPage = startPage + naviCount - 1;
		if(endPage > totalPageCount)
			endPage = totalPageCount;
		for(int i=startPage;i<=endPage;i++) {
			if(pageNo == i)
				navigator.append("				<a href=\"#\" class=\"active\">" + i + "</a> \n");
			else
				navigator.append("				<a href=\"#\" class=\"movepage\"  data-page=\"" + i + "\">" + i + "</a> \n");
		}
		if(isNowEnd())
			navigator.append("	&rsaquo; \n");
		else
			navigator.append("	<a href=\"#\" class=\"movepage\"  data-page=\"" + (endPage + 1) + "\">&rsaquo;</a> \n");
		navigator.append("	<a href=\"#\" class=\"movepage\"  data-page=\"" + totalPageCount + "\">&raquo;</a> \n");
		navigator.append("</div> \n");
		
		this.navigator = navigator.toString();
	}

}
