package com.strupinski.songapi.service.impl;

import com.strupinski.songapi.entity.Track;
import com.strupinski.songapi.repository.SongRepository;
import com.strupinski.songapi.service.TrackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final SongRepository songRepository;

    @Override
    public Optional<Track> save(Track track) {
        log.info("Checking if this song already exists in repository");
        if (!songRepository.existsByHref(track.getHref())) {
            log.info("There is no such composition. Saving this track to repository");
            return Optional.of(songRepository.save(track));
        }
        return songRepository.findByHref(track.getHref());
    }
}
