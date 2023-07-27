package com.strupinski.songapi.entity;

// Track.java (Entity)
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "track")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Album album;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Artist> artists;

    @Column(name = "duration_ms")
    private int durationMs;

    @Column(name = "href")
    private String href;

    @Column(name = "name")
    private String name;

    @Column(name = "popularity")
    private int popularity;
}

