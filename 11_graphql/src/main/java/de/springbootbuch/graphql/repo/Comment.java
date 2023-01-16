package de.springbootbuch.graphql.repo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Access(AccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne
  private Post post;
  @Column(length = 256)
  private String author;
  @Column(length = 2048)
  private String comment;

  public Comment(Post post, String author, String comment) {
    this.post = post;
    this.author = author;
    this.comment = comment;
  }
}
