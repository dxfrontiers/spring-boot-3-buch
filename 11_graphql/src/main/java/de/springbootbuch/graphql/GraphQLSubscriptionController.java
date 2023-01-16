package de.springbootbuch.graphql;

import de.springbootbuch.graphql.repo.Comment;
import org.springframework.context.event.EventListener;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

@Controller
public class GraphQLSubscriptionController {

  private final CopyOnWriteArrayList<Consumer<Comment>> commentConsumers = new CopyOnWriteArrayList<>();
  
  @SubscriptionMapping
  public Flux<Comment> onCommentAdded() {
    return Flux.create(sink -> {
      
      final Consumer<Comment> consumer = sink::next;

      commentConsumers.add(consumer);
      
      sink.onDispose(() -> commentConsumers.remove(consumer));
    });
  }

  @EventListener
  public void onCommentAdded(CommentAddedEvent e) {
    commentConsumers.forEach(consumer -> consumer.accept(e.comment()));
  }
}
