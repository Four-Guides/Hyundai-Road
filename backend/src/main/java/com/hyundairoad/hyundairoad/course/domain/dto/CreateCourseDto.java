package com.hyundairoad.hyundairoad.course.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCourseDto {
    private Long courseId;
    private Long memberId;
    private String title;
    private String content;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String withWhom;
    private String theme;
    private Boolean visibility;
    private String savedName;
    private String originalName;
    private List<CreateCoursePlaceDto> coursePlaces;
}