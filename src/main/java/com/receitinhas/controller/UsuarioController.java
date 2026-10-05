package com.receitinhas.controller;
import com.receitinhas.model.Usuario;
import com.receitinhas.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
 private final UsuarioService service;
 public UsuarioController(UsuarioService service){this.service=service;}
 @PostMapping("/cadastrar") public String cadastrar(Usuario usuario,RedirectAttributes a){try{service.cadastrar(usuario);a.addFlashAttribute("mensagem","Cadastro realizado!");return "redirect:/login";}catch(Exception e){a.addFlashAttribute("erro",e.getMessage());return "redirect:/cadastro";}}
 @PostMapping("/login") public String login(Usuario usuario,HttpSession session,RedirectAttributes a){try{if(service.login(usuario.getNome(),usuario.getSenha()).isPresent()){session.setAttribute("usuario",usuario.getNome());return "redirect:/";}a.addFlashAttribute("erro","Login ou senha incorretos.");}catch(Exception e){a.addFlashAttribute("erro",e.getMessage());}return "redirect:/login";}
}
