## Section 7: Build Java Web Application
Spring Framework, Spring Boot, Hibernate를 이용하여 Java Web Application을 만들어보자.

### 7.81: @Controller, @ResponseBody
환경: SayHelloController 생성

@RequestMapping("/hello") 맵핑을 이용해 hello-world 생성. 이때 그냥 스트링을 리턴하면 뷰 이름으로 인식해 @ResponseBody를 해줘야 한다.

### 7.82: HTML 응답하기
하드코딩 하니 불편하다 -> 다음번엔 View를 써보자

### 7.85: JSP 
환경: resources/META-INF/resources/WEB-INF/vie가ws/sayHello.jsp 생성

JSP 컴파일을 위해 dependency애 tomcat-emded-jasper 추

### 7.86: login 제작
환경: LoginController 생성

### 7.87: 웹의 작동방식 Request/Response

### 7.88: Query Parameter, Model
@RequestParam로 파라미터를 받아올 수 있다.

컨트롤러에서 jsp로 뭔가를 전달할 때 Model을 이용해 데이터를 전달할 수 있다. ModelMap 사용.

### 7.89: Logging
적절한 로깅 레벨 선택법과, 로거 사용법. 기본적으로 스트링 부트는 SLF4j를 사용한다.

```
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    logger.debug("Request Param is {}", name);
```

### 7.90: Dispatcher Servlet, 아키텍처
과거의 JSP 사용 방법들
- Model1 Architecture: 컨트롤러 분리등 없이 JSP에 다 떄려박았던 시절
- Model2 Architecture: MVC 구조를 만들었다. 그러나 모든 서블렛에 걸쳐 구현해야 하는 기능들이 있다면?
- Model2 Architecture with Front Controller: Front Controller를 만들어서 모든 요청을 한곳에서 처리하자. 이후 적절히 뷰나 서블릿으로 보낸다.

Dispatcher Servlet은 모델2 프론트 컨트롤러 패턴의 Spring MVC 구현물이다.

디스패쳐 서블릿이 프론트 컨트롤러 역할을 한다. 즉 모든 요청을 받아, 처리한다. URL을 보고, 뭐 그런것들. 그리고 적절한 컨트롤러에게 요청을 넘긴다.

그러면 컨트롤러 메서드는 모델과 뷰 이름을 리턴하고, 디스페쳐 서블릿은 뷰 이름을 보고 적절한 뷰를 식별해서 맵핑한다. 그 다음 모델을 찾아 뷰에게 제공한다. 이후 뷰 실행.

이때 적절한 jsp 파일?을 찾는걸 View Resolver가 한다.

### 7.91: 로그인 양식 만들기

### 7.92: 모델로 JSP에 로그인 자격증명 표시하기
method 방식에 따라 다르게 처리 하기.

### 7.93: ID, Password 검증하기

### 7.94: TodoService
환경: Todo, TodoService 추가

### 7.95: TodoContoller, view

### 7.96: Session, Model, Request
@SessionAttributes로 세션에 데이터를 저장할 수 있다.

세션을 사용하는건 서버 메모리를 먹는등 리소스가 더 필요하니 사용에 주의해야 한다.

### 7.97: JSTL
이때까지는 Expression Language로 ${}만을 jsp에서 사용했다. 더 복잡한 사용을 위해 JSTL 사용하기.

### 7.98: Webjars로 Bootstrap 사용하기

### 7.100: Bootstrap으로 디자인 추가

### 7.101: Todo create View 추가

### 7.102: Todo create Service logic 추가

### 7.103: String Boot Starter Validation
spring-boot-starter-validation 추가

커맨드 빈(양식보조개체): 양방향 바인딩 form을 위함

### 7.104: Validation 추가 
@Valid 추가, BindingResult 추가

### 7.105: Delete todo
