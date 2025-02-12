package br.com.treinaweb.twtodos.web.todos.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.treinaweb.twtodos.web.todos.dtos.TodoForm;
import br.com.treinaweb.twtodos.web.todos.services.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoWebController {

    private final TodoService todoService;

    @GetMapping
    public ModelAndView index() {
        var context = Map.of("todos", todoService.findAll());
        return new ModelAndView("todos/index", context);
    }

    @GetMapping("/create")
    public ModelAndView create() {
        var context = Map.of(
            "pageTitle", "Criar nova tarefa",
            "todoForm", new TodoForm()
        );
        return new ModelAndView("todos/form", context);
    }

    @PostMapping("/create")
    public String create(
        @Valid TodoForm todoForm,
        BindingResult bindingResult,
        Model model,
        RedirectAttributes attrs
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Criar nova tarefa");
            return "todos/form";
        }

        todoService.create(todoForm);
        attrs.addFlashAttribute("toast", "Tarefa criada com sucesso!");
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        var todo = todoService.findById(id);
        var context = Map.of(
            "pageTitle", "Editar tarefa",
            "todoForm", todo
        );
        return new ModelAndView("todos/form", context);
    }

    @PostMapping("/edit/{id}")
    public String edit(
        @PathVariable Long id,
        @Valid TodoForm todoForm,
        BindingResult bindingResult,
        Model model,
        RedirectAttributes attrs
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Editar tarefa");
            return "todos/form";
        }

        todoService.update(id, todoForm);
        attrs.addFlashAttribute("toast", "Tarefa editada com sucesso!");
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attrs) {
        attrs.addFlashAttribute("toast", "Tarefa excluída com sucesso!");
        todoService.delete(id);
        return "redirect:/todos";
    }
    
}
