package com.mission.ShortURLService.common.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
	NOT_FOUND_SHORTEN_URL("U001", "존재하지 않는 URL 입니다."),
	INVALID_URL_FORMAT("U002", "잘못된 URL 형식입니다. 형식에 맞는 URL을 입력하세요.");

	private final String code;
	private final String message;

	ErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
