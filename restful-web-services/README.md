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

### 8.152: API 버전 관리
버저닝 방식들: URL, Request Parameter, Header, Media Type