package com.strupinski.songapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrackDTO {

    @JsonProperty("album")
    private AlbumDTO album;

    @JsonProperty("artists")
    @Embedded
    private List<ArtistDTO> artists;

    @JsonProperty("duration_ms")
    private int durationMs;

    @JsonProperty("href")
    private String href;

    @JsonProperty("name")
    private String name;

    @JsonProperty("popularity")
    private int popularity;
}
