in28Minutes의 Master Spring Boot 3 & Spring Framework 6 with Java


# 정리

## Section 2
### 2.4
강하게 결합된 마리오 게임 예시

### 2.5
GameRunner가 MarioGame과 강하게 결합되어 있어, 이후 ContraGame을 사용하려면 코드를 수정해야하는 일이 발생한다.
코드는 계속 변하기에 최대한 느슨한 결헙을 하는 것이 좋다. OOP SOLID와 마찬가지.

### 2.6
GamingConsole interface를 도입해 모든 게임이 GamineConsole을 통해 구현되도록 한다.