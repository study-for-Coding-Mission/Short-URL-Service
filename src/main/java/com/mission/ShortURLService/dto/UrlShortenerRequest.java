package com.mission.ShortURLService.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

@Getter
public class UrlShortenerRequest {
	@URL
	@NotBlank
	private String originUrl;
}
