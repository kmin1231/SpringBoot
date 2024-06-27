package com.example.firstproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
    @GetMapping("/random-quote")
    public String randomQuote(Model model) {
        String[] quotes = {
                "The way to get started is to quit talking and begin doing. - Walt Disney",
                "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt",
                "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success. - James Cameron",
                "It is during our darkest moments that we must focus to see the light. - Aristotle"
        };
        int randInt = (int) (Math.random() * quotes.length);
        model.addAttribute("randomQuote", quotes[randInt]);
        return "quote";
    }
}
