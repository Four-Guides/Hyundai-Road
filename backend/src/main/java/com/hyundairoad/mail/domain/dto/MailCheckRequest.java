package com.hyundairoad.mail.domain.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * MailCheckRequest
 *
 * 작성자: 김진규
 */
@Data
public class MailCheckRequest {
    @Email
    @NotEmpty(message = "이메일을 입력해주세요.")
    private String email;

    @NotEmpty(message = "인증 번호를 입력해주세요.")
    private String code;
}
