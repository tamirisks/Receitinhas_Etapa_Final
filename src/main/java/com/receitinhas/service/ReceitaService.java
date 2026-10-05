package com.receitinhas.service;
import com.receitinhas.model.Receita;
import com.receitinhas.repository.ReceitaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ReceitaService {
 private final ReceitaRepository repository;
 public ReceitaService(ReceitaRepository repository){this.repository=repository;}
 public void cadastrar(Receita r){if(r==null||vazio(r.getNome())||vazio(r.getRendimento())||vazio(r.getTempoDePreparo())||vazio(r.getNivel())||vazio(r.getIngredientes())||vazio(r.getDescricao())||vazio(r.getComentario()))throw new IllegalArgumentException("Preencha os campos corretamente.");if(vazio(r.getTipoReceita()))r.setTipoReceita("outras");repository.salvar(r);}
 public List<Receita> listar(String tipo){return vazio(tipo)?repository.listarTodas():repository.buscarPorTipo(tipo);}
 private boolean vazio(String v){return v==null||v.trim().isEmpty();}
}
