package com.pebblepost.todo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.*;

@RestController()
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @GetMapping
    public List<Todo> getAll() {
        return StreamSupport.stream(todoRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Todo getOne(@PathVariable("id") Long id) {
        return todoRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Todo put(@PathVariable("id") Long id, @RequestBody Todo todo) {
        var existingTodo = todoRepository.findById(id).get();
        existingTodo.text = todo.text;
        return todoRepository.save(existingTodo);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        todoRepository.deleteById(id);
    }
}
