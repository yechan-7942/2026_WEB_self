package org.example.exam.controller;

import jakarta.validation.Valid;
import org.example.exam.dto.BookRequest;
import org.example.exam.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String list(@RequestParam(defaultValue = "all") String status, Model model) {
        populateModel(status, model);
        return "books";
    }

    @PostMapping("/books")
    public String create(@Valid @ModelAttribute BookRequest request,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            populateModel("all", model);
            model.addAttribute("error", "제목과 저자를 모두 입력하세요.");
            return "books";
        }
        // TODO-02: 검증된 request를 Service에 전달해 도서를 등록하세요.
        return "redirect:/books";
    }

    @PostMapping("/books/{id}/toggle")
    public String toggle(@PathVariable String id) {
        // TODO-05: Service에 ID를 전달해 읽음 상태를 변경하세요.
        return "redirect:/books";
    }

    private void populateModel(String status, Model model) {
        model.addAttribute("books", service.findAll(status));
        model.addAttribute("status", status);
        model.addAttribute("totalCount", service.totalCount());
        model.addAttribute("readCount", service.readCount());
        // TODO-12: unreadCount를 전체 수 - 읽은 수로 계산해 Model에 추가하세요.
    }
}
