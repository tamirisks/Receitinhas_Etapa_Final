package com.receitinhas;
import com.receitinhas.model.Usuario;
import com.receitinhas.repository.UsuarioRepository;
import com.receitinhas.service.UsuarioService;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
class UsuarioServiceTest {
 private final UsuarioRepository repository=new UsuarioRepository(){public void salvar(Usuario u){} public Optional<Usuario> autenticar(String n,String s){return Optional.empty();}};
 private final UsuarioService service=new UsuarioService(repository);
 @Test void cadastroCorreto(){assertDoesNotThrow(()->service.cadastrar(usuario("Tamiris","tamiris@email.com","1234","479999999")));}
 @Test void nomeVazio(){assertThrows(IllegalArgumentException.class,()->service.cadastrar(usuario("","tamiris@email.com","1234","479999999")));}
 @Test void emailSemArroba(){assertThrows(IllegalArgumentException.class,()->service.cadastrar(usuario("Tamiris","tamiris.com","1234","479999999")));}
 @Test void senhaVazia(){assertThrows(IllegalArgumentException.class,()->service.cadastrar(usuario("Tamiris","tamiris@email.com","","479999999")));}
 @Test void contatoVazio(){assertThrows(IllegalArgumentException.class,()->service.cadastrar(usuario("Tamiris","tamiris@email.com","1234","")));}
 private Usuario usuario(String n,String e,String s,String c){Usuario u=new Usuario();u.setNome(n);u.setEmail(e);u.setSenha(s);u.setContato(c);return u;}
}
