package com.pebblepost.todo;

import java.util.concurrent.*;
import org.junit.*;
import org.junit.runner.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.context.junit4.*;
import org.springframework.web.server.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoControllerTest {
   private static final Logger log = LoggerFactory.getLogger(TodoControllerTest.class);

   @Autowired
   private TodoController todoController;

   @Autowired
   public TodoRepository todoRepository;

   @Test
   public void testGetTodo() {
      log.debug("testGetTodo ...");
      var todo = todoRepository.save(new Todo("write code"));
      assertEquals("todo:", todo.text, todoController.getOne(todo.id).text);
   }
}
