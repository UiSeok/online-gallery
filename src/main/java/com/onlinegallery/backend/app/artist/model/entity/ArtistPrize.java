package com.onlinegallery.backend.app.artist.model.entity;

import java.util.Date;
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
public class ArtistPrize {
    @Id
    @Column(columnDefinition = "BIGINT unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artistPrizeId;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String title;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private Date date;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String organization;

    @ManyToOne
    @JoinColumn(name = "artistId") // 외래키
    private Artist artist;
}
