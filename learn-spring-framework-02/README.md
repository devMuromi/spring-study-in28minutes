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

