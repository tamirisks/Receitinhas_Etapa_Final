package com.receitinhas.controller;
import com.receitinhas.service.ReceitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PaginaController {
 private final ReceitaService service;
 public PaginaController(ReceitaService service){this.service=service;}
 @GetMapping("/") public String inicio(Model model){model.addAttribute("receitas",service.listar(""));return "tela_inicial";}
 @GetMapping("/login") public String login(){return "tela_login";}
 @GetMapping("/cadastro") public String cadastro(){return "tela_cadastro";}
 @GetMapping("/publique") public String publique(){return "tela_publique";}
 @GetMapping("/doce") public String doce(Model model){model.addAttribute("receitas",service.listar("doce"));return "tela_doce";}
 @GetMapping("/salgado") public String salgado(Model model){model.addAttribute("receitas",service.listar("salgado"));return "tela_salgado";}
 @GetMapping("/restricoes") public String restricoes(Model model){model.addAttribute("receitas",service.listar("restrição"));return "tela_restricoes";}
}
