package miniProjeto1;

import miniProjeto2.Genero;
// Classe abstrata Livro
public abstract class Livro {

 private final Autor autor;
 private final int id;
 private final float preco;
 private final Genero genero;
 private final String titulo;

 public Livro(Autor autor, String titulo, int id, float preco, Genero genero) {
  if (id < 0 || preco < 0) {
   throw new IllegalArgumentException("ID e preço devem ser não negativos");
  }
  this.autor = autor;
  this.id = id;
  this.preco = preco;
  this.genero = genero;
  this.titulo = titulo;
 }

 public Autor getAutor() {
  return autor;
 }

 public int getId() {
  return id;
 }

 public float getPreco() {
  return preco;
 }

 public Genero getGenero() {
  return genero;
 }

 public String getTitulo() {
  return titulo;
 }
 @Override
 public String toString() {
  return String.format("Autor: %s, Título: %s, ID: %d, Gênero: %s, Preço: %.2f",
          autor.getNome(), titulo, id, genero, preco);
 }


 // Método abstrato a ser implementado nas subclasses
 public abstract void metodoAbstrato();

 // Implementação dos métodos da interface Downloadable
 public abstract String getURL();

 public abstract double sizeMB();
}

// Classe concreta LivroFisico
class LivroFisico extends Livro {

 public LivroFisico(Autor autor, String titulo, int id, float preco, Genero genero) {
  super(autor, titulo, id, preco, genero);
 }

 @Override
 public void metodoAbstrato() {
  // Implementação específica para LivroFisico
  System.out.println("Método abstrato implementado em LivroFisico");
 }
 // Implementação dos métodos da interface Downloadable
 @Override
 public String getURL() {
  // Valor stub para a URL
  return "https://example.com/book";
 }

 @Override
 public double sizeMB() {
  // Valor stub para o tamanho em MB
  return 10.5;
 }
}

