package com.onlinegallery.backend.app.artist.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResArtistDetail {
    
    // 작가 아이디
    private long id;
    
    // 작가 소개
    private String introduction;
    
    // 작가 이름
    private String name;
    
    // 작가 필명
    private String nickname;
    
    //
    private String note;
    
    private String profileImage;
}
