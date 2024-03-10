package de.springboot3.spa;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaskService {

  private final CopyOnWriteArrayList<Task> tasks = new CopyOnWriteArrayList<>();
  private final AtomicInteger counter = new AtomicInteger(0);


  public Task createTask(String title) {
    final var task = new Task(counter.incrementAndGet(), title, false);
    tasks.add(task);
    return task;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public Task getTask(int id) {
    return tasks.stream()
        .filter(task -> task.getId() == id)
        .findFirst().orElse(null);
  }


  @PostConstruct
  public void initSampleData() {
    createTask("By the Spring Boot 3 Book").setDone(true);
    createTask("Learn Spring Boot");
    createTask("Learn more about Vite and React");
    createTask("Program a SPA");
  }
}
