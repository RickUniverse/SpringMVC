package com.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author lijichen
 * @date 2020/11/24 - 21:38
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "未知异常")
public class OtherException extends RuntimeException {

}
