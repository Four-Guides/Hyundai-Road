package com.hyundairoad.course.controller;

import com.hyundairoad.auth.domain.Accessor;
import com.hyundairoad.auth.member.MemberCheck;
import com.hyundairoad.auth.member.MemberOnly;
import com.hyundairoad.course.domain.dto.CourseCreateRequest;
import com.hyundairoad.course.domain.dto.CourseRecommendRequest;
import com.hyundairoad.course.domain.dto.CourseResponse;
import com.hyundairoad.course.domain.dto.CourseUpdateRequest;
import com.hyundairoad.course.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

/**
 * 코스 컨트롤러
 *
 * 작성자: 김진규, 남진수
 */
@Tag(name = "코스", description = "코스 API입니다.")
@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    /**
     * 모든 코스를 조회합니다.
     *
     * @return 모든 코스의 응답 리스트
     */
    @Operation(summary = "모든 코스를 조회합니다.", description = "모든 코스를 조회하는 API입니다.")
    @GetMapping("/courses")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        return ResponseEntity.ok().body(courseService.getAllCourses());
    }

    /**
     * 회원과 관련된 모든 코스를 조회합니다.
     *
     * @param accessor 인증된 회원 정보
     * @return 회원과 관련된 모든 코스의 응답 리스트
     */
    @Operation(summary = "회원과 관련된 모든 코스를 조회합니다.", description = "회원과 관련된 모든 코스를 조회하는 API입니다.")
    @MemberOnly
    @GetMapping("/courses/m")
    public ResponseEntity<List<CourseResponse>> getAllCoursesWithMember(@MemberCheck Accessor accessor) {
        return ResponseEntity.ok().body(courseService.getAllCoursesWithMember(accessor.getMemberId()));
    }

    /**
     * 특정 코스를 조회합니다.
     *
     * @param id 코스 ID
     * @return 특정 코스의 응답
     */
    @Operation(summary = "특정 코스를 조회합니다.", description = "ID를 기반으로 특정 코스를 조회하는 API입니다.")
    @GetMapping("/course/{id}")
    public ResponseEntity<CourseResponse> getCourseDetail(@PathVariable Long id) {
        return ResponseEntity.ok().body(courseService.getCourseDetail(id));
    }

    /**
     * 회원과 관련된 특정 코스를 조회합니다.
     *
     * @param accessor 인증된 회원 정보
     * @param id       코스 ID
     * @return 특정 코스의 응답
     */
    @Operation(summary = "회원과 관련된 특정 코스를 조회합니다.", description = "ID를 기반으로 특정 코스를 조회하고 회원 정보를 확인하는 API입니다.")
    @MemberOnly
    @GetMapping("/course/m/{id}")
    public ResponseEntity<CourseResponse> getCourseDetailWithMember(@MemberCheck Accessor accessor, @PathVariable Long id) {
        courseService.validateCourseByMember(accessor.getMemberId(), id);
        return ResponseEntity.ok().body(courseService.getCourseDetailWithMember(id, accessor.getMemberId()));
    }

    /**
     * 특정 코스를 삭제합니다.
     *
     * @param accessor 인증된 회원 정보
     * @param id       코스 ID
     * @return 처리 결과
     */
    @Operation(summary = "특정 코스를 삭제합니다.", description = "ID를 기반으로 특정 코스를 삭제하는 API입니다.")
    @MemberOnly
    @DeleteMapping("/course/{id}")
    public ResponseEntity<Void> deleteCourse(@MemberCheck Accessor accessor, @PathVariable Long id) {
        courseService.validateCourseByMember(accessor.getMemberId(), id);
        return ResponseEntity.ok().body(courseService.deleteCourse(id));
    }

    /**
     * 특정 코스를 수정합니다.
     *
     * @param accessor            인증된 회원 정보
     * @param id                  코스 ID
     * @param courseUpdateRequest 코스 수정 요청 정보
     * @return 처리 결과
     * @throws IOException 파일 처리 중 오류 발생 시
     */
    @Operation(summary = "특정 코스를 수정합니다.", description = "ID를 기반으로 특정 코스를 수정하는 API입니다.")
    @MemberOnly
    @PatchMapping(value = "/course/{id}", consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateCourse(@MemberCheck Accessor accessor, @PathVariable Long id, @ModelAttribute @Validated CourseUpdateRequest courseUpdateRequest) throws IOException {
        courseService.validateCourseByMember(accessor.getMemberId(), id);
        return ResponseEntity.ok().body(courseService.updateCourse(id, accessor.getMemberId(), courseUpdateRequest));
    }

    /**
     * 추천 장소를 제공합니다.
     *
     * @param accessor                인증된 회원 정보
     * @param courseRecommendRequest  추천 요청 정보
     * @return 추천 장소 리스트
     */
    @Operation(summary = "추천장소를 제공합니다.", description = "정보를 바탕으로 장소를 추천하는 API입니다.")
    @MemberOnly
    @PostMapping("/recommend")
    public ResponseEntity<List<Map<String, Object>>> recommendCourse(@MemberCheck Accessor accessor, @RequestBody @Validated CourseRecommendRequest courseRecommendRequest) {
        return ResponseEntity.ok().body(courseService.recommendPlaces(courseRecommendRequest));
    }

    /**
     * 새로운 코스를 생성합니다.
     *
     * @param accessor              인증된 회원 정보
     * @param courseCreateRequest   코스 생성 요청 정보
     * @return 생성된 코스 ID
     * @throws IOException 파일 처리 중 오류 발생 시
     */
    @Operation(summary = "새로운 코스를 생성합니다.", description = "새로운 코스를 생성하는 API입니다.")
    @MemberOnly
    @PostMapping(value = "/course", consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> createCourse(@MemberCheck Accessor accessor , @ModelAttribute @Validated CourseCreateRequest courseCreateRequest) throws IOException {
        return ResponseEntity.ok().body(courseService.createCourse(accessor.getMemberId(), courseCreateRequest));
    }

    /**
     * 코스를 검색합니다.
     *
     * @param keyword 검색 키워드
     * @return 검색된 코스 리스트
     */
    @Operation(summary = "코스를 검색합니다.", description = "키워드를 기반으로 코스를 검색하는 API입니다.")
    @GetMapping("/course")
    public ResponseEntity<List<CourseResponse>> getCourseSearched(@RequestParam String keyword) {
        return ResponseEntity.ok().body(courseService.searchCourse(keyword));
    }

    /**
     * 오늘의 추천 코스를 조회합니다.
     *
     * @return 오늘의 추천 코스 리스트
     */
    @Operation(summary = "오늘의 추천 코스를 조회합니다.", description = "오늘의 추천 코스를 조회하는 API입니다.")
    @GetMapping("/today-pick")
    public ResponseEntity<List<CourseResponse>> getTodayPick() {
        return ResponseEntity.ok().body(courseService.getTodayPick());
    }
}
