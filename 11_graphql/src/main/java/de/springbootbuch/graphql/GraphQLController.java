package de.springbootbuch.graphql;

import de.springbootbuch.graphql.repo.Comment;
import de.springbootbuch.graphql.repo.CommentRepository;
import de.springbootbuch.graphql.repo.Post;
import de.springbootbuch.graphql.repo.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLController {

  private final PostRepository postRepository;
  private final CommentRepository commentRepository;
  private final ApplicationEventPublisher eventPublisher;

  @QueryMapping
  public List<Post> posts() {
    return postRepository.findAll();
  }

  @SchemaMapping(typeName = "Post", field = "comments")
  public List<Comment> postComments(Post parent) {
    return commentRepository.findByPost(parent);
  }

  @MutationMapping
  public Post createPost(@Argument String title, @Argument String content) {
    return postRepository.save(new Post(title, content));
  }

  @MutationMapping
  public Comment addComment(@Argument String postId, @Argument String author, @Argument String comment) {

    // FIXME exception handling
    final var post = postRepository.findById(Long.valueOf(postId))
        .get();

    final var commentObject = commentRepository.save(new Comment(post, author, comment));
    
    eventPublisher.publishEvent(new CommentAddedEvent(commentObject));
    
    return commentObject;
  }
}
