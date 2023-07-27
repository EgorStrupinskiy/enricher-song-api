package com.strupinski.songapi.repository;

import com.strupinski.songapi.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Track, Long> {
    boolean existsByHref(String href);

    Optional<Track> findByHref(String href);
}
