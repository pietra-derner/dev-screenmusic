package com.dev.screenmusic.repository;

import com.dev.screenmusic.model.Artista;
import com.dev.screenmusic.model.TipoArtista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository <Artista, Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String nome);

    List<Artista> findByTipoArtista(TipoArtista tipoArtista);
}
