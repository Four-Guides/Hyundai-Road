package com.hyundairoad.login.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 * AccessTokenResponse
 *
 * 작성자: 김진규
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE)
public class AccessTokenResponse {
    private String accessToken;
}
