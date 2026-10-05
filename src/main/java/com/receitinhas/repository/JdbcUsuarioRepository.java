package com.receitinhas.repository;
import com.receitinhas.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.Optional;
@Repository
public class JdbcUsuarioRepository implements UsuarioRepository {
 private final String url; private final String user; private final String pass;
 public JdbcUsuarioRepository(@Value("${spring.datasource.url}")String url,@Value("${spring.datasource.username}")String user,@Value("${spring.datasource.password}")String pass){this.url=url;this.user=user;this.pass=pass;}
 private Connection con() throws SQLException{return DriverManager.getConnection(url,user,pass);}
 public void salvar(Usuario u){String sql="INSERT INTO usuario(nome,email,senha,contato) VALUES(?,?,?,?)";try(Connection c=con();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,u.getNome());p.setString(2,u.getEmail());p.setString(3,u.getSenha());p.setString(4,u.getContato());p.executeUpdate();}catch(SQLException e){throw new IllegalStateException("Erro ao salvar usuário.",e);}}
 public Optional<Usuario> autenticar(String nome,String senha){String sql="SELECT id,nome,email,senha,contato FROM usuario WHERE nome=? AND senha=?";try(Connection c=con();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,nome);p.setString(2,senha);try(ResultSet r=p.executeQuery()){if(r.next()){Usuario u=new Usuario();u.setId(r.getLong("id"));u.setNome(r.getString("nome"));u.setEmail(r.getString("email"));u.setSenha(r.getString("senha"));u.setContato(r.getString("contato"));return Optional.of(u);}}}catch(SQLException e){throw new IllegalStateException("Erro no login.",e);}return Optional.empty();}
}
