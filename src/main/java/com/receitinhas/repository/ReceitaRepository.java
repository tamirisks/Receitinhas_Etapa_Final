package com.receitinhas.repository;
import com.receitinhas.model.Receita;
import java.util.List;
public interface ReceitaRepository { void salvar(Receita receita); List<Receita> listarTodas(); List<Receita> buscarPorTipo(String tipo); }
