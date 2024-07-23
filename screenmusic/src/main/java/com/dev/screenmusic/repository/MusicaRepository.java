package com.dev.screenmusic.repository;

import com.dev.screenmusic.model.Artista;
import com.dev.screenmusic.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicaRepository extends JpaRepository <Musica, Long> {
    Optional<Musica> findByTituloContainingIgnoreCase(String titulo);
}