package com.mission.ShortURLService.dto;

import lombok.Getter;

@Getter
public class UrlShortenerResponse {

	private String shortenUrl;
	private int cnt;

	public UrlShortenerResponse(String shortenUrl, int cnt) {
		this.shortenUrl = shortenUrl;
		this.cnt = cnt;
	}
}
