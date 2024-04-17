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

