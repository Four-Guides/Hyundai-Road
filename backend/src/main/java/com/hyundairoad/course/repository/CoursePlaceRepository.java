package com.hyundairoad.course.repository;

import com.hyundairoad.course.domain.CoursePlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * CoursePlaceRepository
 *
 * 작성자: 김진규, 남진수
 */
public interface CoursePlaceRepository extends JpaRepository<CoursePlace, Long> {
    Optional<CoursePlace> findByCourseIdAndPlaceId(Long courseId, Long placeId);
}
