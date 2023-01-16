package de.springbootbuch.graphql.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

  private final PostRepository postRepository;
  private final CommentRepository commentRepository;
  
  @Override
  public void run(ApplicationArguments args) {

    postRepository.save( 
        new Post("GraphQL is awesome!", "GraphQL really is a nice way to express APIs")
    );
    final var post = postRepository.save(
        new Post("Spring Boot 3 available", "Spring boot now finally available!")
    );

    commentRepository.save(new Comment(post, "Martin", "This is interesting!"));
    
  }
}
