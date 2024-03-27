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