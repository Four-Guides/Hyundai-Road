import styled from 'styled-components';

export const Container = styled.div`
  margin: auto;
  /* padding: 20px; */
`;

export const ItemContainer = styled.div`
  width: 380px;
  display: flex;
  flex-direction: column;
  margin-bottom: 22px;
  border: 1px solid #ccc;
  border-radius: 5px;
  overflow: hidden;
  box-shadow: 0 5px 10px 0 rgba(0, 0, 0, 0.1);
`;

export const ImageGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 1px;
  background-color: #fff;
`;

export const ImageBox = styled.div`
  width: 100%;
  height: 190px;
  display: flex;
  justify-content: center;
  align-items: center;
  img {
    width: 100%;
    height: 100%;
    object-fit: cover; /* 이미지를 박스에 맞게 채움 */
  }
`;

export const ItemFooter = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 0px 25px 20px;
  margin-top: -15px;
  background-color: #fff;
`;

export const UserContainer = styled.div`
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  margin-bottom: 10px;
`;

export const LeftContainer = styled.div`
  display: flex;
  align-items: center;
`;

export const HeartIconContainer = styled.div`
  display: flex;
  align-items: center;
  margin-right: 10px;
`;

export const HeartIcon = styled.img`
  width: 10%;
  background-position: center;
  margin-left: auto;
  z-index: 100;
`;

export const MoreIcon = styled.img`
  width: 10%;
`;

export const UserIcon = styled.img`
  position: relative;
  top: -20px;
  left: 15px;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  margin-right: 10px;
`;

export const UserName = styled.span`
  font-size: 0.9rem;
  color: #888;
`;

export const ItemTitle = styled.div`
  font-size: 17px;
  font-weight: bold;
  color: #2d2d2d;
  margin: 3px 0 6px;
`;

export const ModalBtn = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;

  button {
    width: 100%;
    height: 50%;
    font-size: 16px;
    border: none;
    background: none;
    cursor: pointer;
    padding: 0;
  }
`;

export const ModalTitle = styled.div`
  width: 100%;
  display: block;
  flex-direction: column;
  justify-content: center;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  font-size: 18px;
  font-family: Happiness-Sans-Bold;
  margin-bottom: 10px;
`;
