package com.strupinski.songapi.service;

import com.strupinski.songapi.entity.Track;

import java.util.Optional;

public interface TrackService {

    Optional<Track> save(Track track);
}
