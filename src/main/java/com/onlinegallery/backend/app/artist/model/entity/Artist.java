package com.onlinegallery.backend.app.artist.model.entity;

import com.onlinegallery.backend.common.model.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Artist")
public class Artist extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artistId")
    private long id;
    
    @Column(name = "introduction")
    private String introduction;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "nickname")
    private String nickname;
    
    @Column(name = "note")
    private String note;
    
    @Column(name = "profileImage")
    private String profileImage;
}
