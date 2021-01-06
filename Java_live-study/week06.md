# 목표

자바의 상속에 대해 학습하기

# 학습목표

- 자바 상속의 특징
- super 키워드
- 메소드 오버라이딩
- 다이나믹 메소드 디스패치 ( Dynamic Method Dispatch )
- 추상 클래스
- final 키워드
- Object 클래스

* * *

## 상속

OOP의 4대특성 중 하나. ( 캡상추다 )

- 캡슐화
- 상속
- 추상화
- 다형성

> 출처 : 스프링 입문을 위한 자바 객체 지향의 원리와 이해.

부모 클래스의 필드와 메소드를 자식 클래스에게 물려준다.

extends 를 이용하여 상속받는 클래스를 자식클래스라고 부른다.

**접근제어자가 private인 경우 상속되지 않으며, 패키지가 다를 시에  default도 상속되지 않는다.**

중복코드의 감소와 유지보수, 통일성 다형성 측면에서 이득이다.

자바의 경우, `다중상속`은 불가능하다. 이는 인터페이스를 이용하여 어느정도 해결이 가능하다.

부모클래스는 자식클래스의 필드나 메소드를 사용할 수 없다.

> 출처 : http://blog.naver.com/PostView.nhn?blogId=heartflow89&logNo=220960019390

~~~java
// 상속 사용법

class Child extends Parent{
  
}

~~~


## super 키워드

> 하위 클래스가 상속하는 부모클래스를 의미하는 

1. 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출하는데 사용되는 키워드.
2. 부모 클래스의 필드나 메소드를 참조하는데 사용되는 키워드.


~~~java

class Child extends Parent{
  Child(){
    super("parameter");
    System.out.println(super.Childvar);
  }
  
}

~~~

super() 키워드르 이용하여 파라미터를 가지는 부모생성자를 호출할 수 있다. 호출하지 않으면, 기본 생성자가 호출된다.

부모클래스의 필드나 메소드를 참조할때는 super.변수명, super.메소드명 의 형태로 호출한다.

> 출처 : http://www.tcpschool.com/java/java_inheritance_super



## 메소드 오버라이딩

> 오버로딩 : 동일 이름의 새로운 메소드 정의
> 오버라이딩 : 상속받은 메소드 재정의 

상속관계에 있는 부모 클래스에서 이미 정의된 메소드를 자식 클래스에서 재정의하는 것.

@Override 어노테이션을 통해 표시해준다.

### 조건

1. 메소드의 선언부는 동일해야한다. <br>단, 반환 타입은 부모 클래스의 반환타입으로 변환할 수 있는 타입이라면 변경가능하다.
2. 부모 클래스의 메소드보다 더 좁은 범위로 접근제어자를 변경할 수 없다.
3. 부모 클래스의 메소드보다 더 큰 예외를 선언할 수 없다.

~~~java

class Parent{
  public void 오버라이딩(){ 
    System.out.println("부모 클래스의 메소드");
  }
}

class Child extends Parent{
  @Override
  public void 오버라이딩(){
    System.out.println("자식 클래스의 메소드");
  }
}

~~~

## 다이나믹 메소드 디스패치 ( Dynamic Method Dispatch )

### `메소드 디스패치`

어떤 메소드를 호출할지 결정하여 실제로 실행시키는 과정

### `정적 디스패치`

컴파일 시점에서 메소드가 실행될 것을 명확하게 알고있는 것.

런타임이 되지 않아도 미리 결정한다.

~~~java

Sub sub = new Sub();

~~~

의 경우 정적 디스패치에 해당된다.

명확하게 Sub클래스의 모든 필드와 메소드가 사용될 수 있음을 알 수 있다.


### `동적 디스패치`

인터페이스나 추상클래스의 추상메소드를 호출하는 경우에 해당된다.

~~~java

Super super = new Sub();

~~~

의 경우 동적 디스패치에 해당된다.

Super 클래스의 리턴타입을 가지기 때문에 Sub클래스에만 존재하는 메소드나 필드엔 접근이 불가능하다.

그러나, Sub클래스에서 재정의 되었다면 해당 메소드와 같이 동작한다.

### `Double 디스패치`

~~~java

class Main{
   public static void main(String[] args){
    Visitor v = new ConcreteVisitor();
    Element e = new ConcreteElement();
    e.accept(v);
  }
}

class Element implements ConcreteElement{
  public void accept(Visitor v){
    v.visitConcreteElement(this);
  }
}

class Visitor implements ConcreteVisitor{
  /* 어떠한 코드 */
}
~~~

> Visitor Pattern

위 코드에서 
~~~java
e.accpt(v);
~~~
로 호출되는 메소드는 ConcreteElement() 에서 재정의된 메소드이다.

해당 호출로 인하여 아래의 코드가 실행된다.

~~~java

public void accept(Visitor v){
  v.visitConcreteElement(this);
}

~~~

해당 코드에서 visitConcreteElement() 메소드는 Visitor 에서 재정의된 메소드이고 그 인자값으로 this를 넘겨준다.

여기서 this는 자기자신을 의미하므로, 해당 클래스의 객체로 선언된 e 가 인자로 넘어가게 된다.

이와같이 연속으로 디스패치가 일어나는 것을 **Double Dispatch** 라고 부른다.

> 출처 : https://defacto-standard.tistory.com/413

## 추상 클래스

선언시 abstract 키워드로 선언된 클래스.

**추상메소드만 포함하는 클래스**를 의미한다.

### 추상 메소드

메소드의 재정의를 강제하는 메소드.

자식 클래스에서 반드시 재정의해야한다.

선언부만 존재하며, 구현부는 없다.

> 참조 : http://www.tcpschool.com/java/java_polymorphism_abstract

## final 키워드

직역하면 결정적인 이라는 의미를 가진 키워드로 그 의미에 걸맞게 상수를 표현하는데 사용된다.

해당 키워드가 붙은 필드나 지역변수는 **변경할 수 없는 상수**가 된다.

클래스에 사용 시, **상속이 불가능**해진다.

메소드에 사용 시, **재정의가 불가능**해진다.

~~~java

final class FINAL{
  final int a = 1;
  final public void Method{
    /* 코드 */
  }
}

~~~

## Object 클래스

java.lang 패키지내에 존재하는 클래스.

모든 자바 클래스의 최고 조상 클래스이다.

가용 가능한 메소드는 아래와 같다. 

|               메소드               |                                                                                                    설명                                                                                                    |
|:----------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| protected Object clone()           | 해당 객체의 복제본을 생성하여 반환함.                                                                                                                                                                      |
| boolean equals(Object obj)         | 해당 객체와 전달받은 객체가 같은지 여부를 반환함.                                                                                                                                                          |
| protected void finalize()          | 해당 객체를 더는 아무도 참조하지 않아 가비지 컬렉터가 객체의 리소스를 정리하기 위해 호출함.                                                                                                                |
| Class<T> getClass()                | 해당 객체의 클래스 타입을 반환함.                                                                                                                                                                          |
| int hashCode()                     | 해당 객체의 해시 코드값을 반환함.                                                                                                                                                                          |
| void notify()                      | 해당 객체의 대기(wait)하고 있는 하나의 스레드를 다시 실행할 때 호출함.                                                                                                                                     |
| void notifyAll()                   | 해당 객체의 대기(wait)하고 있는 모든 스레드를 다시 실행할 때 호출함.                                                                                                                                       |
| String toString()                  | 해당 객체의 정보를 문자열로 반환함.                                                                                                                                                                        |
| void wait()                        | 해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를 실행할 때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출함.                                                                                 |
| void wait(long timeout)            | 해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를 실행하거나 전달받은 시간이 지날 때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출함.                                                        |
| void wait(long timeout, int nanos) | 해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를 실행하거나 전달받은 시간이 지나거나 다른 스레드가 현재 스레드를 인터럽트(interrupt) 할 때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출함. |

> 출처 : http://www.tcpschool.com/java/java_api_object
