package com.strupinski.songapi.repository;

import com.strupinski.songapi.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Track, Long> {
}
