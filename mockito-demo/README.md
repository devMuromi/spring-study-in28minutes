## Section 15: Mocking with Mockito

### 15.270: 테스트 비즈니스 로직 추가
spring-boot-starter-test가 mockito를 불러온다.

### 15.271: Stub
Stub을 이용하면 실제 서비스 로직을 대체해 임시 데이터를 줄 수 있지만, 새로운 메소드가 추가된다면 매번 메소드를 추가로 작성해줘야 한다.

또한 Stub을 이용하면 많은 시나리오를 테스트하기 어려운 단점이 있다.

### 15.272: Mock
```java
DataService dataService = mock(DataService.class);
when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 3});
```
와 같이 mock을 사용할 수 있다.

### 15.273: Mockito Annotations
- @ExtendWith(MockitoExtension.class): mockito를 사용하기 위해 필요하다
- @Mock: mock을 쉽게 생성한다
- @InjectMocks: Mockito가 mock을 주입하게 한다

### 15.274: Advanced Mock
