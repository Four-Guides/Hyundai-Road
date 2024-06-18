import './CourseItem.style'
import { Container, DateRange, Dot, ImageBox, ImageGrid, ItemContainer, ItemFooter, UserIcon, UserName, ItemTitle, UserContainer } from './CourseItem.style';

function CourseItem() {
    return (
      <Container>
        <ItemContainer>
          <ImageGrid>
            <ImageBox />
            <ImageBox />
            <ImageBox />
            <ImageBox />
          </ImageGrid>
          <UserIcon />
          <ItemFooter>
            <UserContainer>
              <UserName>JADEN님의 일정</UserName>
              <Dot>·</Dot>
              <DateRange>2박 3일</DateRange>
            </UserContainer>
            <ItemTitle>6일전 예약한 무작정 일본여행</ItemTitle>
          </ItemFooter>
        </ItemContainer>
      </Container>
    )
}

export default CourseItem;