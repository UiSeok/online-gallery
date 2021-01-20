package com.onlinegallery.backend.app.artist.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResArtist {
    
    // 작가 아이디
    private long id;
    
    // 작가 필명
    private String nickname;
    
    // 작가 프로필 이미지
    private String profileImage;
}
