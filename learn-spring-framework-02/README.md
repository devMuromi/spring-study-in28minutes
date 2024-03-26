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

### 2.10
Bean 단순 메소드 명이 아닌 사용자 지정 이름 지정하기. 이름 말고 클래스 이름 형식으로 이용하기. Bean끼리 재활용 하기? Bean에 매게변수 전달하는 방식.

### 2.11 2.12
Spring Container: Bean을 관리하는 컨테이너. Bean의 수명 주기를 관리함. 다른 말로 Spring Context, IOC(Inversion of Control) Container라고도 한다.

일컫는 컨테이너는 2가지로 나뉘는데, Bean Factory와 Application Context가 있다. Bean Factory는 가장 기본적인 컨테이너이고, Application Context는 좀더 고급의 기능을 제공한다.
대부분의 엔터프라이즈 애플리케이션에서는 Application Context를 필요로 하고, 우리도 사용하고 있다. AnnotationConfigApplicationContext이 바로 그것.

### 2.13
POJO(Plain Old Java Object): 오래된 자바 객체. 모든 자바 객체는 POJO이다. POJO는 Java Bean과 달리 아무 제약이 없다.

Java Bean: 옛날에는 EJB(Enterprise Java Bean)이라는 것이 있었는데, EJB는 Java Bean이라는 개념을 도입했다.
Java Bean의 규칙으로는 public no-arg constructor, getter/setter 보유, Serializable 인터페이스를 구현해야한다.
사실 Java Bean은 더이상 중요하지 않은데, 이제 아무도 EJB를 안쓰기 떄문.

Spring Bean: Spring이 관리하는 모든 Java 객체.

### 2.14
context.getBeanDefinitionNames()을 통해 모든 Bean의 이름 출력해보기.

@Primary를 통해 같은 이름의 빈중 우선순위를 정해줄 수 있다.

@Qualifier("string") 한정자를 통해 선택할 수 있다.

### 2.15
Java의 try-with-resource 사용법.

이전의 게임코드들 Bean을 이용해 리펙토링.

### 2.16 2.17
Spring이 대신 객체를 만들어주지는 못하나? -> 다음장에서 Bean을 더 간단하게 다루는 법에 대해 알아보자.