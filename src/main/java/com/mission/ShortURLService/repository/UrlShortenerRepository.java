package com.mission.ShortURLService.repository;

import com.mission.ShortURLService.entity.Url;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlShortenerRepository extends JpaRepository<Url, Integer> {

	Optional<Url> findByOriginUrl(String urlStr);

	Optional<Url> findByShortenUrl(String shortenUrl);
}
