package com.hyunseok.vo;

public class PageInfo {
	
	private int pageSize;				/*페이지 당 조회 갯수*/
	private int page;				/*페이지 번호*/
	private String searchOption;		/*검색 조건*/
	private String keyword;				/*검색어*/
	
	public PageInfo() {
		this.page = 1;
		this.pageSize = 10;
		this.keyword="";
		this.searchOption="all";
	}
		
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize <= 0 || pageSize > 100) {
			this.pageSize = 10;
			return;
		}
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public int getPageStart() {
		return (this.page -1) * pageSize;
	}
		
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		if(searchOption == null || searchOption.equals("")) {
			this.searchOption="all";
		}
		this.searchOption = searchOption;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "PageInfo [pageSize=" + pageSize + ", page=" + page + ", searchOption=" + searchOption + ", keyword="
				+ keyword + "]";
	}
	
	
}
