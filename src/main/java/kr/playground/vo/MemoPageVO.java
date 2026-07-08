package kr.playground.vo;

import java.util.List;

public class MemoPageVO {
	private List<MemoVO> items;
	private int total;
	private int page;
	private int size;
	
	public List<MemoVO> getItems() {
		return items;
	}
	public void setItems(List<MemoVO> items) {
		this.items = items;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
