package com.receitinhas.repository;
import com.receitinhas.model.Receita;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.*;
@Repository
public class JdbcReceitaRepository implements ReceitaRepository {
 private final String url; private final String user; private final String pass;
 public JdbcReceitaRepository(@Value("${spring.datasource.url}")String url,@Value("${spring.datasource.username}")String user,@Value("${spring.datasource.password}")String pass){this.url=url;this.user=user;this.pass=pass;}
 private Connection con() throws SQLException{return DriverManager.getConnection(url,user,pass);}
 public void salvar(Receita r){String sql="INSERT INTO receita(nome,ingredientes,descricao,rendimento,tempo_de_preparo,tipo_receita,nivel,comentario,imagem) VALUES(?,?,?,?,?,?,?,?,?)";try(Connection c=con();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,r.getNome());p.setString(2,r.getIngredientes());p.setString(3,r.getDescricao());p.setString(4,r.getRendimento());p.setString(5,r.getTempoDePreparo());p.setString(6,r.getTipoReceita());p.setString(7,r.getNivel());p.setString(8,r.getComentario());p.setString(9,r.getImagem());p.executeUpdate();}catch(SQLException e){throw new IllegalStateException("Erro ao salvar receita.",e);}}
 public List<Receita> listarTodas(){return buscar("SELECT * FROM receita",null);}
 public List<Receita> buscarPorTipo(String tipo){return buscar("SELECT * FROM receita WHERE tipo_receita LIKE ?","%"+tipo+"%");}
 private List<Receita> buscar(String sql,String param){List<Receita> lista=new ArrayList<>();try(Connection c=con();PreparedStatement p=c.prepareStatement(sql)){if(param!=null)p.setString(1,param);try(ResultSet r=p.executeQuery()){while(r.next()){Receita x=new Receita();x.setId(r.getLong("id"));x.setNome(r.getString("nome"));x.setIngredientes(r.getString("ingredientes"));x.setDescricao(r.getString("descricao"));x.setRendimento(r.getString("rendimento"));x.setTempoDePreparo(r.getString("tempo_de_preparo"));x.setTipoReceita(r.getString("tipo_receita"));x.setNivel(r.getString("nivel"));x.setComentario(r.getString("comentario"));x.setImagem(r.getString("imagem"));lista.add(x);}}}catch(SQLException e){throw new IllegalStateException("Erro ao consultar receitas.",e);}return lista;}
}
