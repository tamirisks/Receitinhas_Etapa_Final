package com.receitinhas.service;
import com.receitinhas.model.Usuario;
import com.receitinhas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UsuarioService {
 private final UsuarioRepository repository;
 public UsuarioService(UsuarioRepository repository){this.repository=repository;}
 public void cadastrar(Usuario u){if(u==null||vazio(u.getNome())||vazio(u.getEmail())||!u.getEmail().contains("@")||vazio(u.getSenha())||vazio(u.getContato()))throw new IllegalArgumentException("Preencha os campos corretamente.");repository.salvar(u);}
 public Optional<Usuario> login(String nome,String senha){if(vazio(nome)||vazio(senha))throw new IllegalArgumentException("Informe o login e a senha.");return repository.autenticar(nome.trim(),senha);}
 private boolean vazio(String v){return v==null||v.trim().isEmpty();}
}
