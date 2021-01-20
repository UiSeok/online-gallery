package com.onlinegallery.backend.app.artist.repository;

import com.onlinegallery.backend.app.artist.model.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query(
        value = "SELECT ar FROM Artist ar ORDER BY ar.id DESC",
        countQuery = "SELECT distinct(count(ar)) FROM Artist ar ORDER BY ar.id DESC")
    Page<Artist> findArtistPage(Pageable pageable);
}
