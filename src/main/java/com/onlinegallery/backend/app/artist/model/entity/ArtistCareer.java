package com.onlinegallery.backend.app.artist.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArtistCareer {
    @Id
    @Column(columnDefinition = "BIGINT unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artistCareerId;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String title;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String type;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String address;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String date;

    @ManyToOne
    @JoinColumn(name = "artistId") // 외래키
    private Artist artist;
}
