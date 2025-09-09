package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    @GetMapping("/feedback")
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedbackForm", new FeedbackForm());
        return "feedback";
    }

    @PostMapping("/feedback")
    public String submitFeedback(@Valid @ModelAttribute("feedbackForm") FeedbackForm feedbackForm,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "feedback"; // Если есть ошибки, возвращаем форму обратно с ошибками
        }
        model.addAttribute("message", "Спасибо за ваш отзыв!");
        return "feedbackSuccess"; // Успешная страница после отправки
    }
}