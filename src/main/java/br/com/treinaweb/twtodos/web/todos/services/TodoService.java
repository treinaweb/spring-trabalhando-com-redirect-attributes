package br.com.treinaweb.twtodos.web.todos.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.treinaweb.twtodos.core.repositories.TodoRepository;
import br.com.treinaweb.twtodos.web.todos.dtos.TodoForm;
import br.com.treinaweb.twtodos.web.todos.dtos.TodoListItem;
import br.com.treinaweb.twtodos.web.todos.mappers.TodoMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoMapper todoMapper;
    private final TodoRepository todoRepository;

    public List<TodoListItem> findAll() {
        return todoRepository.findAll()
            .stream()
            .map(todoMapper::toListItem)
            .toList();
    }

    public void create(TodoForm todoForm) {
        var todo = todoMapper.toModel(todoForm);
        todoRepository.save(todo);
    }

    public TodoForm findById(Long id) {
        return todoRepository.findById(id)
            .map(todoMapper::toForm)
            .orElseThrow();
    }

    public void update(Long id, TodoForm todoForm) {
        var todo = todoRepository.findById(id)
            .orElseThrow();
        BeanUtils.copyProperties(todoForm, todo, "id");
        todoRepository.save(todo);
    }

    public void delete(Long id) {
        var todo = todoRepository.findById(id)
            .orElseThrow();
        todoRepository.delete(todo);
    }
        
}
