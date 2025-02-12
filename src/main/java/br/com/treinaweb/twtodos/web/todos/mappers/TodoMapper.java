package br.com.treinaweb.twtodos.web.todos.mappers;

import br.com.treinaweb.twtodos.core.models.Todo;
import br.com.treinaweb.twtodos.web.todos.dtos.TodoForm;
import br.com.treinaweb.twtodos.web.todos.dtos.TodoListItem;

public interface TodoMapper {

    TodoListItem toListItem(Todo todo);
    Todo toModel(TodoForm todoRequest);
    TodoForm toForm(Todo todo);
    
}
