package Objetos;

import java.util.Objects;

public class Album {
    private String titulo, artista;
    private int qtdMusicas;
    private Musica[] listaMusicas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getQtdMusicas() {
        return qtdMusicas;
    }

    public void setQtdMusicas(int qtdMusicas) {
        this.qtdMusicas = qtdMusicas;
    }

    public Musica[] getListaMusicas() {
        return listaMusicas;
    }

    public void setListaMusicas(Musica[] listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    public Album(String titulo, String artista, int qtdMusicas, Musica[] listaMusicas) {
        this.titulo = titulo;
        this.artista = artista;
        this.qtdMusicas = qtdMusicas;
        this.listaMusicas = listaMusicas;
    }

    public boolean musicaNoAlbum(String musica){
        for (int i = 0; i < this.listaMusicas.length; i++){
            if (Objects.equals(this.listaMusicas[i].getNome(), musica.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public void procuraMusica(int n){
        System.out.println(this.listaMusicas[n - 1].getNome());
    }

    public void imprimeAlbum(){
        System.out.println("Título: " + this.titulo);
        System.out.println("Artista: " + this.artista);
        System.out.println("Lista de Músicas: ");
        for (int i = 0; i < this.qtdMusicas; i++){
            System.out.println((i + 1) + "." + this.listaMusicas[i].getNome());
        }
    }

    public void alteraPosicao(String musica, int n){
        String aux;
        if (!musicaNoAlbum(musica.toUpperCase()))
            System.out.println("A música solicitada não existe.");
        else{
            for (int i = 0; i < this.listaMusicas.length; i++){
                if (Objects.equals(this.listaMusicas[i].getNome(), musica.toUpperCase())){
                    aux = this.listaMusicas[n - 1].getNome();
                    this.listaMusicas[n - 1].setNome(this.listaMusicas[i].getNome());
                    this.listaMusicas[i].setNome(aux);
                }
            }
        }
    }

    public void adicionaMusica(String musica){
        this.qtdMusicas++;
        Musica m = new Musica();
        m.setNome(musica);
        Musica[] lista = new Musica[this.qtdMusicas];
        for (int i = 0; i < this.qtdMusicas - 1; i ++){
            lista[i] = this.listaMusicas[i];
        }
        lista[this.qtdMusicas - 1] = m;
        this.listaMusicas = lista;
    }

    public void deletaMusica(int n){
        for (int i = n; i < this.listaMusicas.length; i++){
            listaMusicas[i-1] = listaMusicas[i];
        }
        this.qtdMusicas--;
    }
}