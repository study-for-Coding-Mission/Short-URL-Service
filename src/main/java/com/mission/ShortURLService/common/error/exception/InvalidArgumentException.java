package com.mission.ShortURLService.common.error.exception;

import com.mission.ShortURLService.common.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidArgumentException extends ErrorCodedException {

	public InvalidArgumentException(ErrorCode errorCode) {
		super(HttpStatus.BAD_REQUEST, errorCode);
	}
}
