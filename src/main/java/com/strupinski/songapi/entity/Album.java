package com.strupinski.songapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "album")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "album_type")
    private String albumType;

    @Column(name = "href")
    private String href;

    @Column(name = "name")
    private String name;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "total_tracks")
    private int totalTracks;
}
