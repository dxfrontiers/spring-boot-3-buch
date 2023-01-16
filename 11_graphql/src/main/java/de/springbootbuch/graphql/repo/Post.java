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
public class Post {

  @Id @GeneratedValue
  private Long id;
  private String title;
  private String content;

  public Post(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
