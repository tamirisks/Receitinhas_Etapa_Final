package com.receitinhas.model;
public class Receita {
 private Long id; private String nome; private String ingredientes; private String descricao; private String rendimento; private String tempoDePreparo; private String tipoReceita; private String nivel; private String comentario; private String imagem;
 public Receita(){}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
 public String getIngredientes(){return ingredientes;} public void setIngredientes(String ingredientes){this.ingredientes=ingredientes;}
 public String getDescricao(){return descricao;} public void setDescricao(String descricao){this.descricao=descricao;}
 public String getRendimento(){return rendimento;} public void setRendimento(String rendimento){this.rendimento=rendimento;}
 public String getTempoDePreparo(){return tempoDePreparo;} public void setTempoDePreparo(String tempoDePreparo){this.tempoDePreparo=tempoDePreparo;}
 public String getTipoReceita(){return tipoReceita;} public void setTipoReceita(String tipoReceita){this.tipoReceita=tipoReceita;}
 public String getNivel(){return nivel;} public void setNivel(String nivel){this.nivel=nivel;}
 public String getComentario(){return comentario;} public void setComentario(String comentario){this.comentario=comentario;}
 public String getImagem(){return imagem;} public void setImagem(String imagem){this.imagem=imagem;}
}
