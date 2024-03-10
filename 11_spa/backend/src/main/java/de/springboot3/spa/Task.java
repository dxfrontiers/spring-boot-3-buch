package de.springboot3.spa;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Task {

  private final int id;
  private final String title;
  private boolean done;

  public Task(int id, String title, boolean done) {
    Objects.requireNonNull(title, "title must not be null");
    this.id = id;
    this.title = title;
    this.done = done;
  }
}
