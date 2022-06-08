package com.mission.ShortURLService.service;

import static com.mission.ShortURLService.common.error.ErrorCode.*;

import com.mission.ShortURLService.common.error.exception.NotFoundResourceException;
import com.mission.ShortURLService.dto.UrlShortenerRequest;
import com.mission.ShortURLService.dto.UrlShortenerResponse;
import com.mission.ShortURLService.entity.Url;
import com.mission.ShortURLService.repository.UrlShortenerRepository;
import com.mission.ShortURLService.utils.BASE62Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UrlShortenerService {

	private final UrlShortenerRepository urlShortenerRepository;

	@Transactional
	public UrlShortenerResponse getShortenUrl(UrlShortenerRequest request) {
		Url url = urlShortenerRepository.findByOriginUrl(request.getOriginUrl())
										.orElseGet(() -> createNewUrl(request));
		url.increaseCnt();
		return new UrlShortenerResponse(url.getShortenUrl(), url.getCnt());
	}

	@Transactional
	public String getOriginUrl(String shortenUrl) {
		Url url = urlShortenerRepository.findByShortenUrl(shortenUrl)
										.orElseThrow(
											() -> new NotFoundResourceException(
												NOT_FOUND_SHORTEN_URL));
		return url.getOriginUrl();
	}

	public Url createNewUrl(UrlShortenerRequest request) {
		Url url = urlShortenerRepository.save(new Url(request.getOriginUrl()));
		url.setShortenUrl(BASE62Utils.encode(url.getId()));
		return url;
	}
}
