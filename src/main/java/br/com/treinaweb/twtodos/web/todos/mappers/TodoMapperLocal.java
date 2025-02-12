package br.com.treinaweb.twtodos.web.todos.mappers;

import org.springframework.stereotype.Component;

import br.com.treinaweb.twtodos.core.models.Todo;
import br.com.treinaweb.twtodos.web.todos.dtos.TodoForm;
import br.com.treinaweb.twtodos.web.todos.dtos.TodoListItem;

@Component
public class TodoMapperLocal implements TodoMapper {

    @Override
    public TodoListItem toListItem(Todo todo) {
        return TodoListItem.builder()
            .id(todo.getId())
            .title(todo.getTitle())
            .dueDate(todo.getDueDate())
            .build();
    }

    @Override
    public Todo toModel(TodoForm todoRequest) {
        return Todo.builder()
            .title(todoRequest.getTitle())
            .dueDate(todoRequest.getDueDate())
            .build();
    }

    @Override
    public TodoForm toForm(Todo todo) {
        return TodoForm.builder()
            .title(todo.getTitle())
            .dueDate(todo.getDueDate())
            .build();
    }
    
}
