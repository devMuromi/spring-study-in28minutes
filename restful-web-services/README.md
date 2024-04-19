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