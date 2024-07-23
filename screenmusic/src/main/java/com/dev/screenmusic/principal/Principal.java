package com.dev.screenmusic.principal;

import com.dev.screenmusic.model.Artista;
import com.dev.screenmusic.model.Musica;
import com.dev.screenmusic.model.TipoArtista;
import com.dev.screenmusic.repository.ArtistaRepository;
import com.dev.screenmusic.repository.MusicaRepository;
import com.dev.screenmusic.service.ConsultaChatGPT;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final ArtistaRepository repositorio;
    private final MusicaRepository repositorioMusica;
    Scanner scanner = new Scanner(System.in);

    public Principal(ArtistaRepository repositorio, MusicaRepository repositorioMusica) {
        this.repositorio = repositorio;
        this.repositorioMusica = repositorioMusica;
    }

    public void exibeMenu(){
        int opcao;
        System.out.println("""
                Bem-vindo ao Dev's Screen Music!
                Digite o número da opção desejada:
                1 - Cadastrar artistas
                2 - Cadastrar músicas
                3 - Listar músicas cadastradas
                4 - Buscar músicas por artistas
                5 - Pesquisar dados sobre um artista
                6 - Listar artistas cadastrados
                7 - Buscar músicas cadastradas pelo nome
                8 - Buscar artistas por categoria
                
                0 - Sair
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
        while (opcao != 0){
            switch (opcao){
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicasCadastradas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    pesquisaDadosArtista();
                    break;
                case 6:
                    listarArtistasCadastrados();
                    break;
                case 7:
                    buscarMusicaPorNome();
                    break;
                case 8:
                    buscarArtistasPorCategoria();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println("""
                Digite o número da opção desejada:
                1 - Cadastrar artistas
                2 - Cadastrar músicas
                3 - Listar músicas cadastradas
                4 - Buscar músicas por artistas
                5 - Pesquisar dados sobre um artista
                6 - Listar artistas cadastrados
                7 - Buscar músicas cadastradas pelo nome
                8 - Buscar artistas por categoria
                
                0 - Sair
                """);
            opcao = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Até a próxima!\nSaindo da aplicação...");
    }

    private void cadastrarArtistas(){
        var cadastrarOutro = "S";

        while (cadastrarOutro.equalsIgnoreCase("s")){
            System.out.println("Digite o nome do artista que deseja cadastrar:");
            var nome = scanner.nextLine();
            System.out.println("Qual é a categoria do artista? (SOLO-DUPLA-BANDA)");
            var tipo = scanner.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);

            repositorio.save(artista);
            System.out.println("Artista cadastrado!");

            System.out.println("Deseja cadastrar outro artista? S/N");
            cadastrarOutro = scanner.nextLine();
        }
    }

    private void cadastrarMusicas() {
        String cadastraOutraMusica = "s";

        System.out.println("Qual é o nome do artista que deseja cadastrar uma música:");
        var nome = scanner.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);

        if (artista.isPresent()) {
            while (cadastraOutraMusica.equalsIgnoreCase("s")) {
                System.out.println("Digite o título da música que deseja cadastrar:");
                var nomeMusica = scanner.nextLine();

                Musica musica = new Musica(nomeMusica);
                musica.setArtista(artista.get());
                artista.get().getMusicas().add(musica);

                repositorioMusica.save(musica);
                System.out.println("Música cadastrada!");

                System.out.println("Deseja cadastrar outra música deste mesmo artista? S/N");
                cadastraOutraMusica = scanner.nextLine();
            }
        } else {
            System.out.println("Artista não encontrado/a!");
        }
    }

        private void listarMusicasCadastradas(){
            List<Musica> musica = repositorioMusica.findAll();
            musica.forEach(System.out::println);
        }

        private void buscarMusicaPorArtista(){
            System.out.println("Qual é o nome do artista que deseja procurar uma música:");
            var nome = scanner.nextLine();
            Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);

            if (artista.isPresent()) {
                System.out.println("Música(s) encontrada(s):");
                artista.ifPresent(a -> System.out.println(a.getMusicas()));
            } else {
                System.out.println("Artista não encontrado/a!");
            }
        }

        private void pesquisaDadosArtista(){
            System.out.println("Digite o nome do/a artista para saber mais sobre ele/a:");
            var artistaBuscado = scanner.nextLine();
            System.out.println(ConsultaChatGPT.saberMais(artistaBuscado).trim());
        }

        private void listarArtistasCadastrados(){
            List<Artista> artistas = repositorio.findAll();
            artistas.forEach(a -> System.out.println(a.getNome()));
        }

        private void buscarMusicaPorNome(){
            System.out.println("Digite o nome da música que deseja localizar:");
            var nomeMusica = scanner.nextLine();
            Optional<Musica> musica = repositorioMusica.findByTituloContainingIgnoreCase(nomeMusica);

            if (musica.isPresent()) {
                musica.ifPresent(m -> System.out.println("Artista: " + m.getArtista().getNome() + " - Música: " + m.getTitulo()));
            } else {
                System.out.println("Música não encontrada!");
            }
        }

        private void buscarArtistasPorCategoria(){
            System.out.println("Qual categoria gostaria de pesquisar? (SOLO-DUPLA-BANDA)");
            var nomeCategoria = scanner.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(nomeCategoria.toUpperCase());

            List<Artista> artistaPorCategoria = repositorio.findByTipoArtista(tipoArtista);
            System.out.println("Artistas desta categoria: ");
            artistaPorCategoria.forEach(a -> System.out.println(a.getNome()));
        }

    }
