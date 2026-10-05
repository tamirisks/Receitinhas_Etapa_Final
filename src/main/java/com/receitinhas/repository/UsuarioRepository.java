package com.receitinhas.repository;
import com.receitinhas.model.Usuario;
import java.util.Optional;
public interface UsuarioRepository { void salvar(Usuario usuario); Optional<Usuario> autenticar(String nome,String senha); }
