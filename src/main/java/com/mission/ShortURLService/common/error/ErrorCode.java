package com.mission.ShortURLService.common.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
	INTERNAL_SERVER_ERROR("G001", "정의되지 않은 에러가 발생했습니다."),

	NOT_FOUND_SHORTEN_URL("U001", "존재하지 않는 URL 입니다."),
	INVALID_URL_FORMAT("U002", "잘못된 URL 형식입니다. 형식에 맞는 URL을 입력하세요.");

	private final String code;
	private final String message;

	ErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
