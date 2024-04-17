## Section 5: Spring Boot
### 5.51: Spring Boot 이전의 세계
pom.xml 만들기가 귀찮았다.

web.xml 설정하기도 귀찮았다.

### 5.52: Spring Initializer로 새 Spring Boot Project 설정하기
start.spring.io로 가서 이것저것 설정.

Dependency로는 Spring Web을 추가한다.

### 5.53: Spring Boot로 간단한 REST API 만들어보기
환경: CourseController

### 5.54
- 빌드를 도와주는 것
  - Spring Initializr
  - Spring Boot Stater Projects
  - Spring Boot Auto Configuration
    - Spring Boot DevTools
- Production-ready 되게 해주는 것
  - Logging
  - Different Configurations for Different Environments
  - Monitoring(Spring Boot Actuator)

### 5.55: Spring Boot Starter Projects
웹앱을 만들때 필요한 것은 Rest API 기능들과 test 기능이다.
이것을 바로 제공해주는 것이 Spring Boot Starter Projects이다.

pom.xml을 보면 spring-boot-starter-web과 spring-boot-starter-test가 있다.
외에도 spring-boot-starter ~ data-jpa, jdbc, tomcat, json, test, security 등 많은 것들이 있다.

이것들이 json 변환, 톰캣, 테스트~ 뭔가 많은것들을 해준다. 아주 편리한 의존성 디스크립터이다.
즉 Rest API를 사용할 거라면 Spring Boot Starter Web을 사용하면 된다.

### 5.56: Spring Boot Auto Configuration
스프링 부트를 사용할때는 많이 설정을 해주어야 한다.
이를 간소화하기 위해 Auto Configuration을 사용할 수 있다.

해당 로직은 Maven에선 Maven Dependencies의 spring-boot-autoconfigure.jar에 있다.

이런 설정에 대해 추가로 설정을 해야한다면 application.properties에 설정을 추가하면 된다.

Bean반환시에 json으로 자동변환 되는것도 JacksonHttpMessageConvertersConfiguration 덕이다.

### 5.57: Spring Boot DevTools
개발자 편의를 위해 서버 자동 재시작등의 기능을 제공한다. 다만 pom.xml등을 변경하면 수동 재시작이 필요하다.

org.springframework.boot:spring-boot-devtools를 추가해서 사용 할 수 있다.

### 5.58: Profile
Dev, QA, stage, prod등의 환경들의 설정을 관리할 수 있다.

dev 환경 설정을 위해 application-dev.properties 처럼 새 파일을 만들어서 설정 가능하다. Pord를 위해선 application-prod 등...

기본적으로 애플리케이션은 프로필을 사용하지 않고 그러면 기본 application.properties를 사용한다.
프로필 설정을 위해서는 application.properties에 spring.profiles.active=dev를 추가하면 된다.

### 5.59: ConfigurationProperties
환경: CurrencyServiceConfiguration, CurrencyConfigurationController class 생성

프로퍼티 값을 설정하고 Spring boot app에서 사용하는 법. 이를 위해 configure property를 사용할 수 있다.

설정을 위해 @ConfigurationProperties를 추가한다. 이때 스프링으로 관리할 것이니 @Component도 추가한다.

이제 이 값을 application.properties에 설정하면 된다.

### 5.60: Embedded Server
배포를 간소화 하는 방법.

옛날에는 WAR 방식을 사용했다. 자바를 설치하고 웹서버를 설치하고 WAR을 배포한다.

요즘은 Embedded Server를 사용한다. JAR에 Tomcat과 같은 서버를 내장하고 있어서, 자바만 설치하면 된다.

Spring Boot는 여러 Embedded 서버를 지원하는데, 디폴트는 spring-boot-starter-tomcat 이다.

### 5.61: Spring Boot Actuator
어플리케이션을 모니터할 수 있다.

여러 엔드포인트를 제공하는데, beans, health, metrics, mappings 등이다.

사용을 위해 pom.xml에서 spring-boot-starter-actuator을 추가한다.
Gradle 기준으로는 implementation 'org.springframework.boot:spring-boot-starter-actuator' 추가하기

이후 http://localhost:8080/actuator 로 접속해 사용 가능하다.

Actuator은 기본적으로 health만 보여주고, 다른 기능을 사용하고 싶으면 application.properties에 설정을 추가해야 한다.

