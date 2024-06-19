package com.hyundairoad.hyundairoad.image.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
    private Long imageId;
    private Long memberId;
    private Long placeId;
    private Long coursePlaceId;
    private String savedName;
    private String originalName;
}
