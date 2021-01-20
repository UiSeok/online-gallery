package com.onlinegallery.backend.app.artist.controller;

import com.onlinegallery.backend.app.artist.model.res.ResArtist;
import com.onlinegallery.backend.app.artist.model.res.ResArtistDetail;
import com.onlinegallery.backend.app.artist.service.ArtistService;
import com.onlinegallery.backend.common.model.CommonResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/artist")
@RestController
@RequiredArgsConstructor
public class ArtistController {
    
    private final ArtistService artistService;
    
    @ApiOperation(value = "작가 리스트 조회", response = CommonResponse.class)
    @GetMapping("/")
    public CommonResponse<List<ResArtist>> getArtistList(@PageableDefault(size = 10, page = 0) Pageable pageRequest) {
        return CommonResponse.SUCCESS(
            artistService.getArtistList(pageRequest)
        );
    }
    
    @ApiOperation(value = "작가 상세정보 조회", response = CommonResponse.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "작가 id", required = true)
    })
    @GetMapping("/{artistId}")
    public CommonResponse<ResArtistDetail> getArtist(@PathVariable long artistId) {
        return CommonResponse.SUCCESS(
            artistService.getArtistDetail(artistId)
        );
    }
}
