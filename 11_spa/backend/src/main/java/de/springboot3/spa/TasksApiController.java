package de.springboot3.spa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TasksApiController {

  @Autowired
  private TaskService service;

  @PostMapping
  public ResponseEntity<Task> create(@RequestBody CreateTaskRequest req) {

    final var task = service.createTask(req.title);

    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(task.getId())
                .toUri()
        )
        .body(task);
  }

  @GetMapping
  public List<Task> getTasks() {
    return service.getTasks();
  }

  public record CreateTaskRequest(String title) {

  }

}
