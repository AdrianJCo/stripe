package uk.mediaibntaymiyya.stripe.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

public class Post {
	
	@Id
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime publishedOn;
    private LocalDateTime updatedOn;
    private final Set<Comment> comments = new HashSet<>();
    private AggregateReference<Author,Integer> author;

    public Post(String title,String content, AggregateReference<Author,Integer> author) {
        this.setTitle(title);
        this.setContent(content);
        this.setAuthor(author);
        this.setPublishedOn(LocalDateTime.now());
    }

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
	
	public void addComments(List<Comment> comments) {
        comments.forEach(this::addComment);
    }
	
	public void addComment(Comment comment) {
        comments.add(comment);
        comment.post = this;
    }

	public Set<Comment> getComments() {
		return comments;
	}

	public AggregateReference<Author,Integer> getAuthor() {
		return author;
	}

	public void setAuthor(AggregateReference<Author,Integer> author) {
		this.author = author;
	}


}
