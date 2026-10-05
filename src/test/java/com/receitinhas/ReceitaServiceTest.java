package com.receitinhas;
import com.receitinhas.model.Receita;
import com.receitinhas.repository.ReceitaRepository;
import com.receitinhas.service.ReceitaService;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class ReceitaServiceTest {
 private final List<Receita> dados=new ArrayList<>();
 private final ReceitaRepository repository=new ReceitaRepository(){public void salvar(Receita r){dados.add(r);}public List<Receita> listarTodas(){return dados;}public List<Receita> buscarPorTipo(String t){return dados.stream().filter(r->r.getTipoReceita().contains(t)).toList();}};
 private final ReceitaService service=new ReceitaService(repository);
 @Test void cadastroReceita(){service.cadastrar(receita());assertEquals(1,dados.size());}
 @Test void nomeVazio(){Receita r=receita();r.setNome("");assertThrows(IllegalArgumentException.class,()->service.cadastrar(r));}
 @Test void buscaPorTipo(){service.cadastrar(receita());assertEquals(1,service.listar("doce").size());}
 private Receita receita(){Receita r=new Receita();r.setNome("Bolo");r.setIngredientes("Farinha");r.setDescricao("Misture e asse");r.setRendimento("8 pessoas");r.setTempoDePreparo("40 min");r.setTipoReceita("doce");r.setNivel("fácil");r.setComentario("Simples");r.setImagem("bolo_de_cenoura.png");return r;}
}
