import Objetos.Album;
import Objetos.Musica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        String titulo, artista;
        int qtdMusicas;

        System.out.println("Título do Album: ");
        titulo = teclado.nextLine();
        System.out.println("Artista do Album: ");
        artista = teclado.nextLine();
        System.out.println("Quantidade de músicas do album: ");
        qtdMusicas = teclado.nextInt();
        teclado.nextLine();

        Musica[] listaMusicas = new Musica[qtdMusicas];

        System.out.println("Músicas do Album");
        for (int i = 0; i < qtdMusicas; i++){
            String musica = teclado.nextLine();
            musica = musica.toUpperCase();
            Musica m = new Musica();
            m.setNome(musica);
            listaMusicas[i] = m;
        }

        Album a1 = new Album(titulo, artista, qtdMusicas, listaMusicas);

        a1.procuraMusica(3);
        a1.imprimeAlbum();
        a1.alteraPosicao("ccc", 1);
        a1.adicionaMusica("Música Nova");
        a1.deletaMusica(2);
        a1.imprimeAlbum();

    }
}