package com.receitinhas.controller;
import com.receitinhas.model.Receita;
import com.receitinhas.service.ReceitaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/receitas")
public class ReceitaController {
 private final ReceitaService service;
 public ReceitaController(ReceitaService service){this.service=service;}
 @PostMapping("/cadastrar") public String cadastrar(Receita receita,RedirectAttributes a){try{service.cadastrar(receita);a.addFlashAttribute("mensagem","Receita cadastrada com sucesso!");return "redirect:/";}catch(Exception e){a.addFlashAttribute("erro",e.getMessage());return "redirect:/publique";}}
}
