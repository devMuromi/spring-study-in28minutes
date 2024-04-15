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