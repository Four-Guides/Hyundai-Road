package com.hyundairoad.place.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * CreatePlaceRequest
 *
 * 작성자: 김진규
 * 작성일: 2024-06-29
 */
public record CreatePlaceRequest (String name,
                                  String phone,
                                  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
                                  LocalDateTime startTime,
                                  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
                                  LocalDateTime endTime,
                                  Integer startAge,
                                  Integer endAge,
                                  Integer floor,
                                  String location,
                                  String withWhom,
                                  String category,
                                  String theme1,
                                  Integer weight1,
                                  String theme2,
                                  Integer weight2,
                                  String theme3,
                                  Integer weight3,
                                  MultipartFile image) {
}
