package com.hyundairoad.auth.admin;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * AdminOnly 어노테이션
 *
 * 작성자: 김진규
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface AdminOnly {
}
