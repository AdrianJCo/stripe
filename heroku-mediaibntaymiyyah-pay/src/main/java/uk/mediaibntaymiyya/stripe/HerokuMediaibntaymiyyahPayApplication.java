package uk.mediaibntaymiyya.stripe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import uk.mediaibntaymiyya.stripe.model.Author;
import uk.mediaibntaymiyya.stripe.model.Comment;
import uk.mediaibntaymiyya.stripe.model.Post;
import uk.mediaibntaymiyya.stripe.repository.AuthorRepository;
import uk.mediaibntaymiyya.stripe.repository.PostRepository;

@SpringBootApplication
public class HerokuMediaibntaymiyyahPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerokuMediaibntaymiyyahPayApplication.class, args);
	}

	@Profile({"dev", "prod"})
	@Bean
	CommandLineRunner run(PostRepository postRepository, AuthorRepository autorRepository) {
		return args -> {
			AggregateReference<Author,Integer> author = AggregateReference.to(autorRepository.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega")).id());
			
			Post post = new Post("Dan's first Post", "This is Dan's first Post", author);
			post.addComment(new Comment("Dan", "This is a comment"));
			post.addComment(new Comment("John", "This is another comment"));
			postRepository.save(post);
		};
	}
}
