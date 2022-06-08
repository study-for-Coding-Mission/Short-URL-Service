package com.mission.ShortURLService.common.error.exception;

import com.mission.ShortURLService.common.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundResourceException extends ErrorCodedException {

	public NotFoundResourceException(ErrorCode errorCode) {
		super(HttpStatus.NOT_FOUND, errorCode);
	}
}
