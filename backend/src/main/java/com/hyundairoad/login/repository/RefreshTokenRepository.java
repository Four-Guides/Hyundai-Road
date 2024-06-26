package com.hyundairoad.login.repository;

import com.hyundairoad.login.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

/**
 * RefreshTokenRepository
 *
 * 작성자: 김진규
 */
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
