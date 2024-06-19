package com.hyundairoad.hyundairoad.course.service;

import com.hyundairoad.hyundairoad.course.domain.dto.CourseDetailDto;
import com.hyundairoad.hyundairoad.course.domain.dto.CreateCourseDto;
import com.hyundairoad.hyundairoad.course.domain.dto.UpdateCourseDto;
import java.util.List;

public interface CourseService {
    List<CourseDetailDto> getAllCourses(Long memberId);
    CourseDetailDto getCourseDetailsById(Long id, Long memberId);
    void createCourse(CreateCourseDto createCourseDto);
    void updateCourse(UpdateCourseDto updateCourseDto);
}