package com.hyundairoad.place.service;

import com.hyundairoad.image.service.ImageService;
import com.hyundairoad.place.domain.Place;
import com.hyundairoad.place.domain.PlaceResponse;
import com.hyundairoad.place.domain.dto.CreatePlaceRequest;
import com.hyundairoad.place.domain.dto.UpdatePlaceRequest;
import com.hyundairoad.place.exception.PlaceNotFoundException;
import com.hyundairoad.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * 장소 서비스
 *
 * 작성자: 김진규, 조희정
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final ImageService imageService;

    /**
     * 모든 장소를 조회합니다.
     *
     * @return 모든 장소의 리스트
     */
    public List<PlaceResponse> getAllPlaces() {
        return placeRepository.findAll().stream()
                .map(PlaceResponse::of)
                .toList();
    }

    /**
     * 특정 이름을 포함한 장소를 검색합니다.
     *
     * @param placeName 장소 이름
     * @return 특정 이름을 포함한 장소의 리스트
     */
    public List<PlaceResponse> getSearchedPlaces(String placeName) {
        return placeRepository.findByNameContaining(placeName).stream()
                .map(PlaceResponse::of)
                .toList();
    }

    /**
     * 새로운 장소를 생성합니다.
     *
     * @param createPlaceRequest 장소 생성 요청 정보
     * @return 생성된 장소의 ID
     * @throws IOException 이미지 파일 처리 중 예외 발생
     */
    @Transactional
    public Long createPlace(CreatePlaceRequest createPlaceRequest) throws IOException {
        return placeRepository.save(Place.createPlace(createPlaceRequest, imageService.uploadFile(createPlaceRequest.image()))).getId();
    }

    /**
     * 특정 장소를 수정합니다.
     *
     * @param updatePlaceRequest 장소 수정 요청 정보
     * @return 수정 결과 (null)
     * @throws IOException 이미지 파일 처리 중 예외 발생
     */
    @Transactional
    public Void updatePlace(Long placeId, UpdatePlaceRequest updatePlaceRequest) throws IOException {
        Place place = getPlace(placeId);
        place.updatePlace(updatePlaceRequest, imageService.updateFile(place.getPlaceImgUrl(), updatePlaceRequest.image()));
        return null;
    }

    /**
     * 특정 장소를 조회합니다.
     *
     * @param placeId 장소 ID
     * @return 특정 장소의 상세 정보
     * @throws PlaceNotFoundException 장소를 찾을 수 없는 경우 예외 발생
     */
    public Place getPlace(Long placeId) {
        return placeRepository.findById(placeId).orElseThrow(PlaceNotFoundException::new);
    }
}
