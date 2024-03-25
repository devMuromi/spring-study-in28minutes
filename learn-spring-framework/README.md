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

### 2.7
의존성, 의존성 주입에 대한 설명.
의존성을 주입하는 방식으로 느슨하게 결합하는 것을 이때까지 해보았다. 

이제 Spring에게 의존성 주입을 맡기고 관리하게 해보자.

### 2.8
우선 프로젝트를 좀 정리. 스프링 설정을 만들어준다. 스프링 설정을 만드는 법은 클래스 제작후 @Configuration 어노테이션을 통해 지정해줄 수 있다.

이곳에서 메서드 정의를 통해 Spring Bean을 생성 할수 있는데, Spring Bean이란 Spring에서 관리하는 것들을 말한다.

Configuration에서 name Bean을 만들어보고 이를 사용해보았다. 

### 2.9
JDK16에 추가된 record 기능 설명.

