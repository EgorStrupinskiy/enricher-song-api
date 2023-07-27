package com.strupinski.songapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ArtistDTO {

    @JsonProperty("href")
    private String href;

    @JsonProperty("name")
    private String name;
}
