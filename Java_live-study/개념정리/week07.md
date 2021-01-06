# 목표
자바의 패키지에 대해 학습하세요.

# 학습할 것 (필수)
- package 키워드
- import 키워드
- 클래스패스
- CLASSPATH 환경변수
- -classpath 옵션
- 접근지시자

## `package`

> 클래스와 인터페이스의 집합.

- 클래스들을 하나로 묶어놓은 것
- 클래스 간의 이름 중복으로 발생하는 충돌을 막아준다.
- 클래스를 기능별로 분류할 수 있어 식별에 용이해다.

**패키지는 해당 이름을 가진 디렉토리를 의미**한다.


`선언방식`
~~~java

package 패키지이름;

~~~

|  기본 패키지 |                  설명                   |
|:------------:|:---------------------------------------:|
|  java.lang   | 기본적인 클래스 제공 (자동으로 import)  |
|    java.awt  |          GUI에 관한 클래스 제공         |
|    java.io   |     데이터 입출력에 관한 클래스 제공    |
|   java.util  |        유용한 유틸리티 클래스 제공      |
|    java.net  |        네트워크 관련 클래스 제공        |
|  java.text   |          텍스트 관련 클래스 제공        |
|    java.sql  |      데이터베이스 관련 클래스 제공      |
|  java.applet |     애플릿 구현에 필요한 클래스 제공    |

> 출처 : https://blog.hexabrain.net/120

## import 

코드에서 사용할 클래스의 패키지에 대한 정보를 미리 제공하는 역할.

`선언방식
~~~java

import 패키지이름.클래스이름;

~~~

클래스 이름자리에 * (와일드카드) 를 이용하여 해당 패키지내의 모든 클래스를 사용할 수 있다.

> 출처 : http://www.tcpschool.com/java/java_usingClass_package

## CLASSPATH

> 출처 : https://effectivesquid.tistory.com/entry/%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4%ED%8C%A8%EC%8A%A4classpath%EB%9E%80

클래스를 찾기위한 경로.

콜론(:)으로 구분된 디렉토리 및 파일목록.

JVM이 프로그램을 실행할 때, 클래스파일을 찾는 데 기준이 되는 경로를 의미한다.

자바 컴파일러를 통해 바이트코드(.class) 로 변환된 클래스파일을 찾는데 사용되는 파일.


**classpath 지정방법**

1. 환경변수 CLASSPATH를 이용
2. 런타임시 -classpath 사용

**classpath 지정 가능 파일/디렉토리**

- 디렉토리
- zip파일
- jar파일

**사용법**

> CLASSPATH=\[경로\]:\[경로\]|....

패키지에 포함되지 않은 소스파일을 컴파일할 때 classpath를 설정한다.

일반적으로 javac 명령을 통해 클래스파일을 생성할 수 있으며, -d 옵션을 준다면 다른 디렉토리를 지정할 수 도있다.

> 출처 : https://effectivesquid.tistory.com/entry/%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4%ED%8C%A8%EC%8A%A4classpath%EB%9E%80


## -classpath 옵션

~~~cmd

javac -cp [경로]

~~~

위의 선언방식을 통해 CLASSPATH를 지정할 수 있다.

> 출처 : https://payoff.tistory.com/401

## 접근제어 지시자

클래스스나 메소드 혹은 필드값에 대한 접근권한을 설정하는 지시자.

- private : 같은 클래스 내에서만 접근가능
- \[default\] : 같은 패키지 내의 클래스에서만 접근가능.
- protected : 같은 패키지 내의 클래스나 상속받은 클래스에서 사용가능.
- public : 모두가 접근가능.

4종류의 제어자가 존재한다.

`public`

가장 개방적인 접근지시자로 해당 지시자가 붙은 메소드나 필드는 어디에서든 접근이 가능하다.

`protected`

- 같은 클래스
- 같은 패키지
- 자식클래스

에서 접근이 가능하다.

`\[default\]`

아무런 접근지시자를 붙히지 않는 경우를 의미하며, 같은 패키지내에서 접근이 가능하다.

`private`

가장 은밀(?)한 접근지시자.

선언한 클래스 자기자신의 public 메소드를 통해서만 접근이 가능하다.

클래스 내부의 세부적인 동작을 구현하는데 사용된다.

> 출처 : http://www.tcpschool.com/java/java_modifier_accessModifier

