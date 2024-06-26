## Section 3
### 3.24
configuration bean들을 그냥 같은 클래스에 넣어서 작업해본다.

이후 Spring에게 PackmanGame Bean생성을 맡기기 위해 PackmanGame @Component를 추가한다.
그러나 오류가 발생하는데, 이는 Spring이 위치를 모르기 때문. 이에 @ComponentScan("~.~.~.game")을 추가하여 Spring이 해당 패키지를 스캔하도록 한다.

이렇게 자동으로 와이어링 되게 함으로써 코드의 양을 크게 줄일 수 있다.

### 3.26
한 interface를 구현한 여러 클래스들이 있을 때, Spring은 어떤 클래스를 사용할지 알 수 없다.
이를 해결하기 위한 방법으로, @Primary를 사용할 수 있다. 이를 사용하면 해당 클래스를 우선적으로 사용하게 된다.
또는 @Qualifier 한정자를 통해 사용할 클래스를 지정할 수 있다.

### 3.27
@Primary를 통해 우선권을 지정하고 @Qualifier를 통해 Primary가 아닌 다른 것을 사용해야 할때 지정해주는 방식으로 두개의 annotation을 사용하면 된다.

이렇게 설정한 뒤 사용하는 측에서 @Autowired를 해주면 자동으로 @Primary로 지정된것을 사용하게 된다. 특정 다른 빈을 사용할때는 @Qualifier로 지정해주면 된다.
Qualifier가 Primary보다 우선권을 지니기 때문이다.

@Quilifier 사용에 팁을 주자면, Bean에 @Qualifier("name")이 지정되지 않았을때도 Bean의 class 이름을 사용해도 된다. 단 class의 첫글자는 소문자로 바꿔주어야 한다.

### 3.28
Spring에서 의존성 주입의 여러 방식

Constructor-based: 생성자를 통해 의존성을 주입하는 방식

Setter-based: Setter를 통해 의존성을 주입하는 방식

Field: 리플렉션을 사용하여 의존성을 주입. 그래서 따로 생성자나 수정자가 없다.

@ComponentScan에 인자를 주지 않으면 현재 패키지를 스캔한다.

이중 무엇을 사용해야 할까? Spring에서는 일단 생성자 인젝션을 추천한다. 모든 초기화가 하나의 메소드에서 발생하기 떄문.

### 3.29
용어 정리

@Component: 스프링이 instance를 관리하게 지정

Dependency: Gamerunner는 GameConsole implement가 필요하기에, MarioGame은 GameRunner의 Dependency(의존성)이다.

Component scan: @ComponentScan()에서 패키지 명을 명시하거나 현재 패키지를 스캔하기.

Dependency Injection(DI, 의존성 주입): Spring이 Component scan을 하고 의존성을 찾아 식별하고 와이어링 하는 전 과정을 의미.

Inversion of Control(IoC, 제어의 역전): 객체를 Spring이 생성하고 와이어링 해주듯, 제어권이 개발자에서 Spring으로 넘어간것. 그래서 제어의 역전.

Spring Bean: 스프링이 관리하는 모든 객체

IoC Container: Bean의 생명주기와 의존성을 관리하는 Spring의 컴포넌트. ApplicationContext와 BeanFactory가 있지만 ApplicationContext를 주로 사용한다.

AutoWiring: Spring이 Bean을 보고 자동으로 필요한것을 식별하고 와이어링 해주는 것.

### 3.30
@Component, @Bean 비교

@Component: 모든 자바 클래스에서 사용 가능
-> 주로 @Component가 더 이용하기 쉽다. @Bean은 일일이 코드를 다 작성해줘야하기 때문.
Field, Setter, Constructor로 의존성 주입 가능.
Spring이 자동으로 Bean을 생성하고 관리한다.
-> 즉 일반적으로 @Component를 사용하는 것이 더 편리하다. 

@Bean: 특정 메소드에 적용됨. 주로 Spring Configuration 클래스의 메소드에 사용.
특정 메소드 사용을 통해 의존성 주입 가능.
Bean 생성 코드를 직접 작성해야 한다.

### 3.31
Dependency가 많은 이유. 우리는 웹 / 비즈니스 / 데이터 레이어를 두고 어플리케이션을 작성한다. 이들간에 서로 의존성이 있기 떄문.

이를 Spring이 자동으로 해주고, 우리는 핵심 로직에 집중할 수 있다.

### 3.32
실습

## Section 4
### 4.35: @Lazy annotation
환경: examples/a0을 복사해 d1 생성.

ClassA를 이용해 초기화를 하는 ClassB 클래스가 존재.
이렇게 ClassA, ClassB를 만들고 실행하면, ClassB Bean을 사용하는 로직이 없음에도 ClassB가 initiallized 되는 것을 볼 수 있다.

이를 막기 위해 @Lazy annotation을 사용할 수 있다.
@Lazy를 하면 CLassB가 사용되거나 참조될때 초기화가 진행된다.

기본적으로 Spring Bean 기본 초기화는 즉시 초기화(Eager)이다. 보통은 Eager을 권장한다. 오류를 바로 발견할 수 있기 때문.

즉 Lazy는 권장되지 않고 잘 사용되지도 않는다.

@Lazy는 @Component와 @Bean이 있는 대부분에 사용 가능하다.
이때 실제 의존성대신 Lazy-resolution proxy가 inject된다.
또한 @Lazy가 @Configuration 클래스에 사용되면 @Configuration 내의 모든 @Bean이 Lazy로 설정된다.

### 4.36: 지연 초기화와 즉시 초기화 비교
Lazy initialization은 메모리를 조금 덜 소모하는데, 그리하여 잘 사용되지 않는 Bean의 경우에는 Lazy init이 좋을 수도 있다.
그러나 대부분의 경우 그냥 Eager을 권장.

### 4.37: 스코프 - 프로토타입과 싱글톤
환경: a0을 복사해 e1 생성

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE) 처럼 작성하면 클래스가 프로토타입 클래스가 된다.

프로토타입 클래스의 차이점은 Bean이 호출될때마다 새로운 인스턴스가 생성된다는 것이다.

context.getBean(NormalClass.class) 와 같이 호출해보았을때 NormalClass는 매번 같은 인스턴스가 검색되지만, PrototypeClass는 매번 다른 인스턴스 인것을 확인할 수 있다.

즉 기본적으로 스프링에서 생성되는 모든 Bean은 싱글톤이다.
그러나 Bean을 참조할 때마다 매번 새로운 인스턴스를 생성하고 싶으면 프로토타입으로 설정하면 된다.

싱글톤은 Spring IoC 컨테이너당 객체 인스턴스가 딱 하나다.
반면에 프로토타입은 여러개가 될 수 있다.

싱글톤과 프로토타입 외에도 웹 어플리케이션에서 사용하는 스코프들이 있다
- Request: HTTP 요청당 하나의 인스턴스
- Session: HTTP 세션당 하나의 인스턴스
- Application: 웹 어플리케이션 전체당 하나의 인스턴스
- WebSocket: WebSocket 인스턴스당 하나의 인스턴스

이때 자바 싱글톤과 스프링 싱글톤에는 차이점이 있는데, 원래 싱글톤은 디자인 패턴이다.
- Spring 싱글톤은 Spring IoC 컨테이너당 객체 인스턴스가 하나라고 정의하는데,
- 자바 싱글톤은 자바 가상 머신 하나당 객체 인스턴스가 하나다.

만약 JVM당 Spring IoC 컨테이너가 하나라면 같은 의미라고 볼 수 있지만, 컨테이너를 여러개 실행하면 다른 의미가 된다. 그러나 보통 여러개를 실행하지는 않는다.

### 4.38: 프로토타입과 싱글톤 비교하기
보통은 99.9% 싱글톤이 사용된다.
Stateful Bean을 사용하려고 할때 사용자 정보가 유지되는 빈을 만들고 싶으면 플로토타입을 사용해야 한다. 그러나 보통 Stateless로 쓰는듯.

### 4.39: @PostConstruct와 @PreDestroy
환경: a0을 복사해 f1 생성

SomeClass는 SomeDependency를 의존성으로 가지는데, SomeDependency 의존성이 연결되는데로 어떤 초기화를 실행하려면 어떻게 해야할까?

@PostConstruct를 사용하면 된다. 그럼 의존성이 연결되고, 연결이 완료되면 @PostConstruct로 지정해둔 init()이 실행된다.

@PostConstruct를 사용하면 다른 Bean이 해당 Bean을 사용할 수 있게 되기 전에 메소드를 실행시킬 수 있다.

그렇다면 어플리케이션이 종료되기 전에, 컨텍스트에서 Bean이 삭제되기 전에 무언가를 하고 싶다면?

@PreDestroy를 사용하면 된다. @PreDestory는 컨테이너에서 인스턴스를 삭제하는 과정 중에 있음을 알려주는 콜백 알림으로,
보통 보유하고 있던 리소스를 해제하는데 일반적으로 사용된다.

@PostConstruct는 데이터베이스 등에서 데이터를 가죠오려는 경우 등에 사용할 수 있고,
@PreDestroy는 컨테이너(어플리케이션 컨텍스트)에서 빈이 삭제되기 전에 cleanUp등을 수행하고 싶을때 사용 가능하다. 활성화된 연결을 끊는 다던가...

### 4.40: J2EE, Java EE, Jakarta EE의 역사
Jakarta EE에 속하는 것
- Jakarta Server Page(JSP): 웹앱의 뷰 제작
- Jakarta Standard Tag Library(JSTL): 웹 페이지에 동적 정보를 나타낼 떄 사용하는 태그 라이브러리
- Jakarta Enterprise Beans(EJB)
- Jakarta RESTful Web Services(JAX-RS): 웹 서비스 구축 방법 규격
- Jakarta Bean Validation: Bean 유효성 검사 규격
- Jakarta Contexts and Dependency Injection(CDI): 의존성 주입 규격
- Jakarta Persistence API(JPA): ORM(Object-Relational Mapping) 규격

Spring 6와 Spring Boot에서는 Jakarta EE를 지원한다.

### 4.41: Jakarta CDI(Contexts & Dependency Injection)
환경: a0을 복사해 g1 생성

의존성 주입을 위한 인터페이스. 단지 인터페이스일 뿐이고 구현은 Spring에서 한다. 

CDI 사용을 위해서는 xml에 의존성을 추가해야 한다. 예시는 maven의 pom.xml을 사용하는 방식.
```
<dependency>
    <groupId>jakarta.inject</groupId>
    <artifactId>jakarta.inject-api</artifactId>
    <version>2.0.1</version>
</dependency>
```

cdi를 사용하려면 @Component 대신 @Named를 사용하고, @AutoWired 대신 @Inject를 사용한다.
이런 방식으로 CDI annotation으로 Spring annotation을 대체할 수 있다.

### 4.43: Java Spring XML 설정
환경: a0을 복사해 h1 생성
contextConfiguration.xml 추가

```
    <bean id="name" class="java.lang.String">
        <constructor-arg value="Muromi"/>
    </bean>
```
위와 같은 방식으로 XML을 통해서도 Bean을 생성할 수 있다. 그 외에도 component scan이나 생성자로 의존성 주입도 가능하다. 자세한건 파일을 참고.

그러나 요즘은 XML이 잘 사용되지 않는다.

### 4.44: 자바 어노테이션 vs XML 설정

### 4.45: Spring Stereotype 어노테이션
이떄까지는 @Component를 사용했다. @Component는 제네릭 어노테이션으로, 모든 클래스에 적용 가능하기 때문.

- @Service: 클래스에 비즈니스 로직이 있음을 나타냄.
- @Controller: 웹 컨트롤러 클래스에 사용
- @Repository: 데이터베이스와 통신하는 경우

@Component, @Service, @Controller, @Repository를 Stereotype 어노테이션이라고 한다.

이떄 최대한 구체적인 어노테이션을 사용하는 것을 권장한다. 프레임워크에 자신이 의도한 바를 더 나타낼 수 있기 때문.
이후 AOP(관점 지향 프로그래밍)을 이용해 부가적인 동작을 추가할 수 있다.

### 4.46: Spring Annotation 정리
- @Configuration: 클래스가 @Bean을 하나 이상 선언함을 나타냄. Java 설정 파일을 만든다는 것.
Java 설정 파일에서는 메서드를 몇 개든 정의할 수 있고, 이러한 메소드에 @Bean 어노테이션을 추가할 수 있다.
그러면 Spring이 모든 메소드 반환 값에 대해 Bean을 자동으로 생성한다.
- @ComponentScan: 컴포넌트를 스캔할 특정 패키지를 정의.
- @Bean
- @Component: 어노테이션 한 클래스가 컴포넌트임을 나타냄. 해당 컴포넌트가 ComponentScan에 들어가면 Bean이 생성 됨.
- @Service
- @Controller
- @Repository


- @Primary: 여러 Bean이 단일 값 의존성에 자동 연결될 후보일때 Bean에 우선순위를 부여함.
- @Qualifier: 여러 Bean이 단일 값 의존성에 자동 연결될 후보일때 특정 Bean을 선택함.
- @Lazy: Bean이 필요할 때까지 초기화를 지연시킴.
- @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE): Bean을 프로토타입으로 정의.
- @PostConstruct: 의존성 주입이 완료된 후 메소드를 실행함.
- @PreDestroy: 컨테이너나 Spring IoC Context에서 Bean이 삭제되기 전에 메소드를 호출함.
- @Named: CDI 어노테이션을 구현하는 규격으로 @Component와 유사
- @Inject: CDI 어노테이션을 구현하는 규격으로 @Autowired와 유사

### 4.47: Spring Framework 개념 복습
- Dependency Injection: 의존성을 Bean에 연결하는 것. 제어의 역전이라고도 한다.
- 의존성 주입의 방식들
  - Constructor Injection: 생성자를 통해 의존성을 주입하는 방식
  - Setter Injection: Setter를 통해 의존성을 주입하는 방식
  - Field Injection: 리플렉션을 사용하여 의존성을 주입하는 방식
- IOC Container: Spring Bean의 수명을 책임지는 Spring IoC Context
  - Bean Factory: Basic Spring IOC Container
  - Application Context: Bean Factory를 확장한 인터페이스. 대부분 이걸 사용.
- Spring Beans: Spring이 관리하는 모든 객체
- Auto-wiring: Spring이 Bean을 보고 자동으로 필요한 것을 식별하고 와이어링 하는 것

### 4.48: Spring 전체 구조 알아보기
Spring core: Spring의 핵심 기능들 무언가?
- Spring Modules: 스프링의 핵심 기능들은 코어 모듈에서 제공한다.
  - Spring MVC
  - Spring WebFlux: Reactive Application을 위한 모듈
  - JDBC, JPA
  - JMS: integration
  - Mock Objects, Spring MVC Test


- Spring Projects:
  - Spring Framework
  - Spring Security
  - Spring Data: DB integration
  - Spring Integration: 다른 앱과 통합. MSA.
  - Spring Cloud

Spring Projects > Spring Framework > Spring Modules

스프링의 장점
- 느슨한 결합
- 보일러플레이트 코드를 줄임
- 아키텍처 유연성
- 시간에 따라 지속적으로 발전
