package kr.playground.dto;

import org.hibernate.validator.constraints.NotBlank;

/** create / update 요청 body 전용 (조회 조건 필드 없음) */
public class MemoRequestDto {

    @NotBlank(message = "title은 필수입니다")
    private String title;

    private String content;
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
