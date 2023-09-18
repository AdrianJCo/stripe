package uk.mediaibntaymiyya.stripe.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Transient;

public class Comment {

	private String name;
    private String content;
    private LocalDateTime publishedOn;
    private LocalDateTime updatedOn;
    @Transient
    Post post;
	
	public Comment(String name, String content) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setContent(content);
		this.setPublishedOn(LocalDateTime.now());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getPublishedOn() {
		return publishedOn;
	}

	public void setPublishedOn(LocalDateTime publishedOn) {
		this.publishedOn = publishedOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

}
