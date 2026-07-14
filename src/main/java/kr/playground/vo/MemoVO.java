package kr.playground.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MemoVO {
	private int id;
	private String title;
	private String content;
	private String status;
	private String createdAt;
	private String updatedAt;
	private String delYn;

	/** 조회 조건용 — API 응답 JSON에 안 나감 */
	@JsonIgnore
	private String keyword;
	@JsonIgnore
	private String sort;
	@JsonIgnore
	private String order;
	@JsonIgnore
	private int size;
	@JsonIgnore
	private int offset;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	public String getCreatedAt() { return createdAt; }
	public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
	
	public String getUpdatedAt() { return updatedAt; }
	public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
	
	public String getDelYn() { return delYn; }
	public void setDelYn(String delYn) { this.delYn = delYn; }
	
	public String getKeyword() { return keyword; }
	public void setKeyword(String keyword) { this.keyword = keyword; }

	public String getSort() { return sort; }
	public void setSort(String sort) { this.sort = sort; }

	public String getOrder() { return order; }
	public void setOrder(String order) { this.order = order; }

	public int getSize() {return size;}
	public void setSize(int size) {this.size = size;}
	
	public int getOffset() {return offset;}
	public void setOffset(int offset) {this.offset = offset;}
}
