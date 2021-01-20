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
public class ArtistGroup {
    @Id
    @Column(columnDefinition = "BIGINT unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artistGroupId;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String name;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private Date startAt;

    @Column(columnDefinition = "DATETIME")
    private Date endAt;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String position;

    @ManyToOne
    @JoinColumn(name = "artistId") // 외래키
    private Artist artist;
}
