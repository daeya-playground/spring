package kr.playground.vo;

public class MemoVO {
	private int id;
	private String title;
	private String content;
	private String status;
	private String createdAt;
	private String updatedAt;
	private String delYn;
	
	private String keyword;

	private int size;
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

	public int getSize() {return size;}
	public void setSize(int size) {this.size = size;}
	
	public int getOffset() {return offset;}
	public void setOffset(int offset) {this.offset = offset;}
}
