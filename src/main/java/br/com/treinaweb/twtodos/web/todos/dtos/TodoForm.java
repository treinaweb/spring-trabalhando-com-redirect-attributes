package br.com.treinaweb.twtodos.web.todos.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoForm {

    @NotEmpty
    @Size(min = 3, max = 100)
    private String title;
    
    @NotNull
    @FutureOrPresent
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dueDate;
    
}
