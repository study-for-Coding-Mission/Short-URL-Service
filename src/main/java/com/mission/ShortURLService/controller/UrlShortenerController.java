package com.mission.ShortURLService.controller;

import com.mission.ShortURLService.dto.UrlShortenerRequest;
import com.mission.ShortURLService.dto.UrlShortenerResponse;
import com.mission.ShortURLService.service.UrlShortenerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shorten-URL")
@Getter
@RequiredArgsConstructor
public class UrlShortenerController {
	private final UrlShortenerService urlShortenerService;

	@PostMapping
	public ResponseEntity<UrlShortenerResponse> shortenUrl(@Validated @RequestBody UrlShortenerRequest request) {
		return ResponseEntity.ok(urlShortenerService.getShortenUrl(request));
	}
}


