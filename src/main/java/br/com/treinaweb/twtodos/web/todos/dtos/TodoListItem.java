package br.com.treinaweb.twtodos.web.todos.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoListItem {

    private Long id;

    private String title;

    private LocalDate dueDate;
    
}
