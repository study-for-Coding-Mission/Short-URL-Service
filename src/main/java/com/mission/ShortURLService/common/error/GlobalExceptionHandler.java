package com.mission.ShortURLService.common.error;

import static com.mission.ShortURLService.common.error.ErrorCode.*;

import com.mission.ShortURLService.common.error.exception.InvalidArgumentException;
import com.mission.ShortURLService.common.error.exception.NotFoundResourceException;
import com.mission.ShortURLService.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> ExceptionHandler(Exception e) {
		ErrorCode errorCode = INTERNAL_SERVER_ERROR;
		log.warn("Exception: {}", e.getMessage());
		return ResponseEntity
			.internalServerError()
			.body(new ErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				errorCode.getCode(),
				errorCode.getMessage()
			));
	}

	@ExceptionHandler(NotFoundResourceException.class)
	public ResponseEntity<ErrorResponse> NotFoundResourceExceptionHandler(NotFoundResourceException e) {
		log.warn("Exception: {}", e.getMessage());
		return ResponseEntity
			.status(e.getHttpStatus())
			.body(ErrorResponse.of(e));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> InvalidArgumentExceptionHandler(MethodArgumentNotValidException e) {
		log.warn("Exception: {}", e.getMessage());
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(ErrorResponse.of(
				new InvalidArgumentException(INVALID_URL_FORMAT)
			));
	}
}
