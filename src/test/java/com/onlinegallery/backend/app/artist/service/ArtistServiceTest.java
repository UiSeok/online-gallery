package com.onlinegallery.backend.app.artist.service;

import com.onlinegallery.backend.BackendApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BackendApplicationTests.class)
public class ArtistServiceTest {
    
    @Autowired
    ArtistService artistService;
    
    @Test
    public void 아티스트정보가져오기_테스트() {
        System.out.println(artistService.getArtist(1));
    }
}
