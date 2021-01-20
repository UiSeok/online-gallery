package com.onlinegallery.backend.app.artist.service;

import com.onlinegallery.backend.app.artist.model.entity.Artist;
import com.onlinegallery.backend.app.artist.model.res.ResArtist;
import com.onlinegallery.backend.app.artist.model.res.ResArtistDetail;
import com.onlinegallery.backend.app.artist.repository.ArtistRepository;
import com.onlinegallery.backend.common.exception.ErrorMessage;
import com.onlinegallery.backend.common.exception.UserGuideException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArtistService {
    
    private final ArtistRepository artistRepository;
    
    
    /**
     * 작가 리스트 조회
     *
     * @param pageable
     * @return
     */
    public List<ResArtist> getArtistList(Pageable pageable) {
        
        Page<Artist> artistListPage = artistRepository.findArtistPage(pageable);
        
        if (artistListPage.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        
        return makeResArtistList(artistListPage.getContent());
    }
    
    /**
     * 작가 상세정보 조회
     *
     * @param artistId
     * @return
     */
    public ResArtistDetail getArtistDetail(long artistId) {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new UserGuideException(ErrorMessage.ARTIST_NO_MATCHING_ID));
        
        return makeResArtistDetail(artist);
    }
    
    private ResArtistDetail makeResArtistDetail(Artist artist) {
        return ResArtistDetail.builder()
            .id(artist.getId())
            .introduction(artist.getIntroduction())
            .name(artist.getName())
            .nickname(artist.getNickname())
            .note(artist.getNote())
            .profileImage(artist.getProfileImage())
            .build();
    }
    
    private List<ResArtist> makeResArtistList(List<Artist> artistList) {
        return artistList.stream().map(artist -> ResArtist.builder()
            .id(artist.getId())
            .nickname(artist.getNickname())
            .profileImage(artist.getProfileImage())
            .build()
        ).collect(Collectors.toList());
    }
}
