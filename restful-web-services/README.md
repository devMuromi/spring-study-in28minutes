## Section 8: Build Rest API
### 8.130: Hello world
- @RestController: REST API용 Controller임을 나타냄
- @RequestMapping(method, path): HTTP Method와 URI를 매핑
- @GetMapping(path): HTTP GET Method와 매핑

### 8.131: Json return
Bean을 return하면 자동으로 JSON으로 변환됨.

### 8.132: 백엔드에서 벌어지고 있는 일
요청이 왔을 때 
- DispatcherServlet이 요청을 받음: Spring Boot가 알아서 DispatcherServlet을 설정해준다
- 알맞은 컨트롤러에 맵핑

Json으로 변환되는 과정
- @ResponseBody: Bean을 있는 그대로 반환하라는 것. 그럼 메세지 변환이 발생
  - @RestController가 @ResponseBody를 포함하고 있음
- JacksonHttpMessageConverter: Bean을 Json으로 변환해주는 역할, Spring Boot이 자동 설정한것

오류 맵핑을 하는 곳
- ErrorMvcAutoConfiguration에 따라서: Spring Boot가 자동 설정한 것

### 8.133: Path variable 다루기
@PathVariable 를 매게변수에 붙이면 URI의 일부를 매개변수로 받을 수 있다

### 8.135: User Bean, Dao(Data Access Object) 생성

### 8.137: User get 요청 구현

### 8.138: User post 요청 구현
@RequestBody를 통해 웹 요청의 body와 매게변수를 맵핑한다

### 8.139: HTTP Status Code
ResponseEntity<Entity>를 이용해 HTTP Status Code를 지정

location 헤더: 생성된 리소스의 URL을 반환할 때 사용하는 HTTP 헤더. 이를 ReponseEntity.created(location) 처럼 활용한다

### 8.140: Exception Handling
UserNotFoundException 제작, @ResponseStatus(code = HttpStatus.NOT_FOUND)로 exception에 상태 코드 지정하기

### 8.142: Exception Handling advance
Spring의 예외 처리는 ResponseStatusExceptionHandler가 담당한다.
이를 오버라이드해 우리가 정의한 구조가 반환되게 해야 한다.

### 8.143: User delete 요청 구현

### 8.144: 유효성 검증
org.springframework.boot:spring-boot-starter-validation 추가

매게변수에 @Valid, entity field에 @Size, @Past 등 설정 

### 8.148: Open API, Swagger
org.springdoc:springdoc-openapi-starter-webmvc-ui 추가

### 8.149: XML 지원
com.fasterxml.jackson.dataformat:jackson-dataformat-xml 추가

Accept 헤더를 통해 json, xml등 반환 형식에 대한 요청 가능

### 8.150: Internationalization
i18n이라고도 부른다.
Accept-Language 헤더를 통해 언어 설정 가능

Locale locale = LocaleContextHolder.getLocale(); 로 요청에서 언어 정보를 가져오고
messageSource.getMessage() 로 messages_xx.properties에서 메세지를 가져온다

### 8.152, 153: API 버전 관리
버저닝 방식들: URI, Request Parameter, Header, Media Type

여러 버저닝 방식들 고려할 사항
- URI pollution: URI가 복잡해지는 문제. URI나 Request Parameter로 버전을 관리할 경우
- Misuse of HTTP Headers: 원래 헤더는 버전관리용이 아니다. Header, Media Type로 버전을 관리할 경우
- Caching: 버전이 바뀌었는데 같은 URI이면 캐싱이 되어있으면 문제가 생길 수 있다. Header, Media Type로 버전을 관리할 경우
- 브라우저에서 작동하는지: Header, Media Type로 버전을 관리할 경우 쉽게 사용할 수 없다
- API Documentation: API 문서툴은 Header와 Media Type에 따른 구분을 잘 못할 수 있다.

완벽한 방법은 없으나, 같은 방식을 사용하는것이 중요하다.

### 8.154: HATEOAS(Hypermedia as the Engine of Application State)
HAL(JSON Hypertext Application Language): 하이퍼링크를 제공하는 포맷(규격)

스프링 HATEOAS를 사용해본다. org.springframework.boot:spring-boot-starter-hateoas

- EntityModel: 엔티티를 맵핑
- WebMvcLinkBuilder: 컨트롤러 메소드에 따른 url을 가져오기

### 8.155: REST API 정적 필터링
- Serialization: 객체를 스트림으로 변환. EntityModel, 객체등을 JSON, XML으로 변환. 흔히 쓰이는건 Jackson
- reponse시 필드명 변경하기: @JSONProperty("name")으로 변경 가능
- 선택한 필드만 반환하기: 필터링 가능. 동적/정적 필터링이 존재한다.
- Static Filtering: @JsonIgnore(필드에 지정, 권장), @JsonIgnoreProperties(클래스에 지정) 사용
- Dynamic Filtering: @JsonFilter 사용

### 8.156: REST API 동적 필터링
- MappingJacksonValue: 를 이용해 데이터 외에 직렬화 논리도 추가 가능
- SimpleBeanPropertyFilter filter: 직렬화 로직 정의
- FilterProvider filters: 필터 정의
- JsonFilter: 엔티티에 적용할 필터 이름

### 8.157: Spring Boot Actuator
org.springframework.boot:spring-boot-starter-actuator 추가

### 8.158: Spring Boot HAL Explorer
org.springframework.data:spring-data-rest-hal-explorer 추가

이후 localhost:8080 에서 확인 가능

### 8.161: User entity, 테스트 데이터 추가
JPA에서 엔티리를 관리할 수 있게 엔티티에 @Entity 추가

### 8.162: UserRepository 추가
UserRepository interface 생성.
JPA 사용시에는 User에 기본 생성자가 있어야 한다

### 8.163: Post 추가
@OneToMany(mappedBy = "user"), @ManyToOne(fetch = FetchType.LAZY) 로 1:N 관계 설정 가능

이때 fetch 속성을 통해 지연 로딩/즉시 로딩 여부를 결정 가능. 기본은 eager. 굳이 바로 같이 가져올 필요가 없으니 lazy로 설정한다.

mappedBy = "user"로 인해 user_id가 post에 자동으로 생성된다.

### 8.164: Post get

### 8.165: Post post

### 8.166: JPA, Hybernate가 만든 쿼리 살펴보기

### 8.167 ~ 171: MySQL 연동, Docker
Docker로 MySQL 실행
```shell
docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=social-media-user --env MYSQL_PASSWORD=dummypassword --env MYSQL_DATABASE=social-media-database --name mysql --publish 3306:3306 mysql:8-oracle
```
mysqlsh 명령어
```shell
    mysqlsh
    \connect social-media-user@localhost:3306
    \sql
    use social-media-database
    select * from user_details;
    select * from post;
    \quit
```
gradle에 com.mysql:mysql-connector-j 추가

application.properties에 MySQL 설정 추가
```properties
    #spring.datasource.url=jdbc:h2:mem:testdb
    spring.jpa.show-sql=true
    spring.datasource.url=jdbc:mysql://localhost:3306/social-media-database
    spring.datasource.username=social-media-user
    spring.datasource.password=dummypassword
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

