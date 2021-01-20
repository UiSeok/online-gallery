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
public class ArtistEducation {
    @Id
    @Column(columnDefinition = "BIGINT unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artistEducationId;

    @Column(columnDefinition = "VARCHAR(10) NOT NULL")
    private String type;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String name;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private Date entranceAt;

    @Column(columnDefinition = "DATETIME DEFAULT NULL")
    private Date graduationAt;

    @Column(columnDefinition = "VARCHAR(30) DEFAULT NULL")
    private String degree;

    @Column(columnDefinition = "VARCHAR(10) NOT NULL")
    private String state;

    @ManyToOne
    @JoinColumn(name = "artistId") // 외래키
    private Artist artist;
}
