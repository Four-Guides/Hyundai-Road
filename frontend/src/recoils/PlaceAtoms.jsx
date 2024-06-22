import { atom, selector } from 'recoil';

// 현재까지 선택된 장소들의 id
export const selectedPlaceIdsState = atom({
  key: 'selectedPlaceIdsState',
  default: [],
});

// 검색 조건(층)
export const searchedPlacesFloorState = atom({
  key: 'searchedPlacesFloorState',
  default: 5,
});

// 검색 조건(검색어)
export const searchedPlacesKeywordState = atom({
  key: 'searchedPlacesKeywordState',
  default: '',
});

// 장소 검색 결과
export const searchedPlacesState = selector({
  key: 'searchedPlacesState',
  get: ({ get }) => {
    const dummy = get(placeDummyState);
    const floor = get(searchedPlacesFloorState);
    const keyword = get(searchedPlacesKeywordState);

    let searchedPlaces = dummy;
    if (keyword === '') {
      searchedPlaces = searchedPlaces.filter((place) => place.floor === floor);
    } else {
      searchedPlaces = searchedPlaces.filter((place) => place.name.includes(keyword));
    }
    return searchedPlaces;
  },
});

// 지도 검색 조건(층 + 장소번호)
export const searchedMapState = atom({
  key: 'searchedMapState',
  default: '5-0',
});

// 지도 이미지 경로
export const mapImageUrlState = selector({
  key: 'mapImageUrlState',
  get: ({ get }) => {
    const searchedMap = get(searchedMapState);
    return `/maps/${searchedMap}.png`;
    // return searchedMap;
  },
});

// 장소 더미 데이터
export const placeDummyState = atom({
  key: 'placeDummyState',
  default: [
    {
      place_id: 1,
      name: '나의 가야',
      phone: '02-3277-0650',
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: '6-1',
      category: '식당',
      rate: 4.3,
      liked: true,
      srcImg: ''
      
    },
    {
      place_id: 2,
      name: '도원 스타일',
      phone: '02-3277-0653',
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: '6-2',
      category: '식당',
      rate: 4.5,
      liked: false
    },
    {
      place_id: 3,
      name: "랑만",
      phone: "02-3277-0656",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-3",
      category: "식당",
      rate: 3.2,
      liked: false
    },
    {
      place_id: 4,
      name: "로바",
      phone: "02-3277-0652",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-4",
      category: "식당",
      rate: 4.7,
      liked: true
    },
    {
      place_id: 5,
      name: "리스토란테 에오",
      phone: "02-3277-0651",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-5",
      category: "식당",
      rate: 3.5,
      liked: false
    },
    {
      place_id: 6,
      name: "송",
      phone: "02-3277-0655",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-6",
      category: "식당",
      rate: 1.8,
      liked: false
    },
    {
      place_id: 7,
      name: "순옥이네 명가",
      phone: "02-3277-0658",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-7",
      category: "식당",
      rate: 3.1,
      liked: true
    },
    {
      place_id: 8,
      name: "이탈리",
      phone: "02-3277-0658",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-8",
      category: "식당",
      rate: 4.0,
      liked: false
    },
    {
      place_id: 9,
      name: "정돈 프리미엄",
      phone: "02-3277-0670",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-9",
      category: "식당",
      rate: 2.7,
      liked: false
    },
    {
      place_id: 10,
      name: "돈까스 1985",
      phone: "02-3277-8553",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-1",
      category: "식당",
      rate: 4.9,
      liked: true
    },
    {
      place_id: 11,
      name: "FIVE GUYS",
      phone: "02-3277-0777",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-2",
      category: "식당",
      rate: 1.6,
      liked: false
    },
    {
      place_id: 12,
      name: "본가스시",
      phone: "02-3277-0765",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-3",
      category: "식당",
      rate: 4.3,
      liked: true
    },
    {
      place_id: 13,
      name: "서울만두",
      phone: "02-3277-0775",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-4",
      category: "식당",
      rate: 0.8,
      liked: false
    },
    {
      place_id: 14,
      name: "여왕떡볶이",
      phone: "02-3277-0779",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-5",
      category: "식당",
      rate: 4.4,
      liked: true
    },
    {
      place_id: 15,
      name: "호우섬",
      phone: "02-3277-0763",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-6",
      category: "식당",
      rate: 2.6,
      liked: false
    },
    {
      place_id: 16,
      name: "도조커피",
      phone: "02-3277-8509",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-7",
      category: "카페",
      rate: 3.7,
      liked: false
    },
    {
      place_id: 17,
      name: "백미당",
      phone: "02-3277-8510",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-10",
      category: "카페",
      rate: 4.2,
      liked: true
    },
    {
      place_id: 18,
      name: "테일러커피",
      phone: "02-3277-8511",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-8",
      category: "카페",
      rate: 2.9,
      liked: false
    },
    {
      place_id: 19,
      name: "블루보틀",
      phone: "02-3277-8512",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-9",
      category: "카페",
      rate: 4.6,
      liked: true
    },
    {
      place_id: 20,
      name: "프롤라",
      phone: "02-3277-8513",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-10",
      category: "카페",
      rate: 4.1,
      liked: true
    },
    {
      place_id: 21,
      name: "카페 오븐",
      phone: "02-3277-8514",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-11",
      category: "카페",
      rate: 3.4,
      liked: false
    },
    {
      place_id: 22,
      name: "공차",
      phone: "02-3277-8515",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-11",
      category: "카페",
      rate: 2.1,
      liked: false
    },
    {
      place_id: 23,
      name: "카멜커피",
      phone: "02-3277-8516",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-12",
      category: "카페",
      rate: 4.7,
      liked: true
    },
    {
      place_id: 24,
      name: "슈퍼말차",
      phone: "02-3277-8517",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-13",
      category: "카페",
      rate: 3.3,
      liked: true
    },
    {
      place_id: 25,
      name: "조앤더주스",
      phone: "02-3277-8518",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-14",
      category: "카페",
      rate: 1.8,
      liked: false
    },
    {
      place_id: 26,
      name: "고디바",
      phone: "02-3277-8519",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-15",
      category: "베이커리",
      rate: 3.0,
      liked: true
    },
    {
      place_id: 27,
      name: "호라이즌16",
      phone: "02-3277-8520",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-12",
      category: "베이커리",
      rate: 2.4,
      liked: true
    },
    {
      place_id: 28,
      name: "금옥당",
      phone: "02-3277-8521",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-13",
      category: "베이커리",
      rate: 1.9,
      liked: true
    },
    {
      place_id: 29,
      name: "카페몬지",
      phone: "02-3277-8522",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-14",
      category: "베이커리",
      rate: 2.7,
      liked: false
    },
    {
      place_id: 30,
      name: "리치몬드 과자점",
      phone: "02-3277-8523",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-16",
      category: "베이커리",
      rate: 2.1,
      liked: false
    },
    {
      place_id: 31,
      name: "뉴발란스 키즈",
      phone: "02-3277-8524",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-15",
      category: "쇼핑",
      rate: 2.5,
      liked: true
    },
    {
      place_id: 32,
      name: "레고LCS",
      phone: "02-3277-8525",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-16",
      category: "쇼핑",
      rate: 0.5,
      liked: false
    },
    {
      place_id: 33,
      name: "매직에디션",
      phone: "02-3277-8526",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-17",
      category: "쇼핑",
      rate: 4.2,
      liked: false
    },
    {
      place_id: 34,
      name: "무냐무냐",
      phone: "02-3277-8527",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-18",
      category: "쇼핑",
      rate: 3.7,
      liked: true
    },
    {
      place_id: 35,
      name: "젤리멜로",
      phone: "02-3277-8528",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-19",
      category: "쇼핑",
      rate: 1.1,
      liked: true
    },
    {
      place_id: 36,
      name: "다이슨",
      phone: "02-3277-8529",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-20",
      category: "쇼핑",
      rate: 4.9,
      liked: false
    },
    {
      place_id: 37,
      name: "삼성 메가 스토어",
      phone: "02-3277-8530",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-21",
      category: "쇼핑",
      rate: 2.0,
      liked: false
    },
    {
      place_id: 38,
      name: "이케아",
      phone: "02-3277-8531",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-22",
      category: "쇼핑",
      rate: 4.4,
      liked: true
    },
    {
      place_id: 39,
      name: "쿠쿠",
      phone: "02-3277-8532",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-23",
      category: "쇼핑",
      rate: 2.9,
      liked: false
    },
    {
      place_id: 40,
      name: "지누스",
      phone: "02-3277-8533",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-17",
      category: "쇼핑",
      rate: 1.9,
      liked: false
    },
    {
      place_id: 41,
      name: "K2",
      phone: "02-3277-8534",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-18",
      category: "쇼핑",
      rate: 3.7,
      liked: false
    },
    {
      place_id: 42,
      name: "디스커버리",
      phone: "02-3277-8535",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-19",
      category: "쇼핑",
      rate: 2.4,
      liked: true
    },
    {
      place_id: 43,
      name: "노스페이스",
      phone: "02-3277-8536",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-20",
      category: "쇼핑",
      rate: 4.8,
      liked: true
    },
    {
      place_id: 44,
      name: "코오롱스포츠",
      phone: "02-3277-8537",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-21",
      category: "쇼핑",
      rate: 1.2,
      liked: true
    },
    {
      place_id: 45,
      name: "나이키 골프",
      phone: "02-3277-8538",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-22",
      category: "쇼핑",
      rate: 3.5,
      liked: true
    },
    {
      place_id: 46,
      name: "폴로",
      phone: "02-3277-8539",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-24",
      category: "쇼핑",
      rate: 0.8,
      liked: false
    },
    {
      place_id: 47,
      name: "메종마르지엘라",
      phone: "02-3277-8540",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-25",
      category: "쇼핑",
      rate: 4.7,
      liked: true
    },
    {
      place_id: 48,
      name: "A.P.C",
      phone: "02-3277-8541",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-26",
      category: "쇼핑",
      rate: 4.1,
      liked: false
    },
    {
      place_id: 49,
      name: "록시땅",
      phone: "02-3277-8542",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-27",
      category: "쇼핑",
      rate: 2.3,
      liked: false
    },
    {
      place_id: 50,
      name: "입생로랑",
      phone: "02-3277-8543",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-28",
      category: "쇼핑",
      rate: 1.6,
      liked: true
    },
    {
      place_id: 51,
      name: "언커먼스토어",
      phone: "02-3277-8544",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-23",
      category: "엔터테인먼트",
      rate: 0.4,
      liked: true
    },
    {
      place_id: 52,
      name: "ALT.1",
      phone: "02-3277-8545",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-24",
      category: "엔터테인먼트",
      rate: 3.4,
      liked: true
    },
    {
      place_id: 53,
      name: "디즈니스토어",
      phone: "02-3277-8546",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-29",
      category: "엔터테인먼트",
      rate: 1.1,
      liked: true
    },
    {
      place_id: 54,
      name: "인사이드아웃 팝업스토어",
      phone: "02-3277-8547",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 6,
      location: "6-25",
      category: "엔터테인먼트",
      rate: 1.0,
      liked: true
    },
    {
      place_id: 56,
      name: "서울포레스트",
      phone: "02-3277-8549",
      start_time: '2024-06-01 13:00',
      end_time: '2024-06-01 20:00',
      floor: 5,
      location: "5-31",
      category: "엔터테인먼트",
      rate: 3.6,
      liked: false
    }
  ],
});
