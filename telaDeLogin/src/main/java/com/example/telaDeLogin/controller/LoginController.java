package com.example.telaDeLogin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.telaDeLogin.model.User;
import com.example.telaDeLogin.repository.UserRepository;

@Controller
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/recoverpassword")
    public String recoverpassword() {
        return "recoverpassword";
    }

    @PostMapping("/register")
    public String handleRegister(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("cpf") String cpf,
            @RequestParam("senha") String senha) {
                
                // para salvar o usuário na própria controller
                User user = new User(nome, email, cpf, senha);
                userRepository.save(user);

                System.out.println("Registro concluido com sucesso, redirecionando para a página de login");
                return "redirect:/login";
            }

    

            




}
