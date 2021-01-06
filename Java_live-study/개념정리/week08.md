# 목표
자바의 인터페이스에 대해 학습하세요.

# 학습할 것 (필수)

- 인터페이스 정의하는 방법
- 인터페이스 구현하는 방법
- 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
- 인터페이스 상속
- 인터페이스의 기본 메소드 (Default Method), 자바 8
- 인터페이스의 static 메소드, 자바 8
- 인터페이스의 private 메소드, 자바 9

# 참고 및 출처

- 스프링 입문을위한 자바 객체 지향의 원리와 이해
- http://www.tcpschool.com/java/java_polymorphism_interface
- https://beomseok95.tistory.com/272
- https://jeong-pro.tistory.com/209
- https://flyburi.com/605
- https://www.vojtechruzicka.com/java-interface-history/
- https://grokonez.com/java/java-9-private-interface-method

* * *

## 인터페이스( interface )

### 선언

자바에서 다중상속을 포기하고 도입한 기능.

> 다중상속의 경우 오버라이딩된 메소드가 제 기능을 하지 못할 가능성이 있기때문에.

클래스와 인터페이스의 관계를 풀어서 말해보면 다음과 같다.

> 클래스는 인터페이스 할 수 있다.

인터페이스는 하위클래스로 하여금 특정 메소드의 기능을 강제할 수 있으며, 상수를 정의할 수 있다.

하위클래스는 반드시 인터페이스의 추상메소드를 재정의하여 사용해야한다. ( 자바 8 이전 )


~~~java

interface Name{
  /* 추상 메소드 */
  /* 상수 정의 */
}

~~~

### 구현

클래스 선언 시, implements 를 이용하여 인터페이스를 상속받는 형식으로 구현된다.

클래스의 상속과는 다르게 여러개의 인터페이스를 상속받는 것이 가능하다.

이러한 인터페이스르 제공받은 클래스는 인터페이스의 추상메소드를 **반드시 재정의**해야 한다.

~~~java

interface fly{
  /* 추상 메소드 */
  /* 상수 정의 */
}

public class Animal implement fly{
   @Override
   /* fly의 추상메소드 재정의 */
}

~~~

### 인터페이스의 기본 메소드 ( public default ), 자바 8

~~~java

interface Interface{
  public default void something(String name){
    System.out.println(name);
  }
}

~~~

default 키워드를 통하여 메소드를 선언하면 구현부의 작성이 가능하게 되었다. 

참조변수를 통한 호출이 가능하다.

작성된 구현부는 해당 인터페이스를 상속한 클래스에서 재정의를 하지 않았으면 작성된 그대로의 기능을 수행한다.

### 인터페이스의 정적 메소드 ( public static ), 자바 8

~~~java

public interface Interface{
  public static void Method(){
    System.out.println("static");
  }
}
~~~

기본적으로 오버라이딩이 불가능하다.

인터페이스 명을 이용한 접근이 가능하다.

### 인터페이스의 private 메소드 , 자바 9

`등장 배경` 

자바 8의 default 와 static 메소드의 도입으로 인터페이스에 구현기능이 추가되었다. <br>

이러한 메소드에 작성되는 구현내용은 대부분 public하지 않아도 되는 내용이다.

외부 클래스나 인터페이스에서 해당 메소드에 접근할 필요가 없다.

이러한 상황에서 자바8 버전까지의 경우엔 interface 에서 private 선언이 불가능 하였다.

`제공 기능`

~~~java

public interface Private{
  private void method01(){
  
  }
  
  private static void method02(){
  
  }
}
~~~

위와 같이 선언된 메소드는 몇가지 특징이 있다.

1. 추상메소드가 아니며, 구현부가 존재한다.
2. 정적메소드로 선언이 가능하다
3. 상속되지 않는다 ( private 니까 )
4. 인터페이스 내에서 다른 메소드의 호출이 가능하다.

non-static 메소드의 경우 private, abstract, default, static 메소드의 호출이 가능하며 <br>
static 메소드의 경우 static, static private 메소드만 호출할 수 있다.
