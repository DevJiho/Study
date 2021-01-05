# 목표
자바가 제공하는 다양한 연산자 학습하기

> 참고자료 : http://www.devkuma.com/books/pages/11

# 학습목표
- 산술 연산자
- 비트 연산자
- 관계 연산자
- 논리 연산자
- instanceof
- assignment(=) operator
- 화살표(->) 연산자
- 3항 연산자
- 연산자 우선순위
- (optional) Java 13. switch 연산자

| 연산자 종류 | 연산자                               | 피연산자 수               | 결과값        | 설명                                |
|-------------|--------------------------------------|---------------------------|---------------|-------------------------------------|
| 산술        | +, -, *, /, %                        | 2개 (이항)                | 숫자          | 사칙연산과 나머지 연산              |
| 부호        | +, -                                 | 1개 (단항)                | 숫자          | 음수나 양수 표현에 사용             |
| 문자열      | +                                    | 2개 (이항)                | 문자열        | 두 문자열을 합치는데 사용           |
| 대입        | =, +=, -=, *=, /=, %=, \|=, &= etc.. | 2개 (이항)                |               | 우변의 결과를 좌변에 대입           |
| 비트        | ~, &, \|, ^                          | 1개 or 2개 (단항 or 이항) | 숫자, boolean | 비트 NOT, AND, OR, XOR 연산         |
| 비교(관계)  | ==, >=, <=, !=, instancdof           | 2개 (이항)                | boolean       | 두 값의 비교                        |
| 논리        | !, &, \|, &&, \|\|                   | 1개 or 2개 (단항 or 이항) | boolean       | 논리적 NOT, AND, OR 연산            |
| 조건        | (조건식) ? A : B                     | 3개 (삼항)                |               | 조건식에 따라 True => A, False => B |
| 증감        | ++, --                               | 1개 (단항)                | 숫자          | 수의 증감                           |
| 쉬프트      | >>, <<, >>>                          | 2개 (이항)                | 숫자          | 비트를 미는 연산                    |


* * *

<br><br>
## 산술 연산자

수학에서 사용하는 산술식

~~~java
public class Arithmetic{
  public static void main(String[] args){
    int plus = 1 + 2;
    int minus = 1 - 2;
    int mul = 1 * 2;
    double div = 1 / 2;
    
    /* 출력하는 코드있다고 가정 */
   }
 }
~~~

~~~console
plus = 3
minus = -1
mul = 2
div = 0.5
~~~

<br><br>
## 비트 연산자

2진수 비트연산에 사용

~~~java
public class Bit{
  public static void main(String[] args){
    int AND = 2 & 3;
    int OR = 2 | 3;
    int NOT = ~2;
    int XOR = 2 ^ 3;
    int RIGHT = 2 >> 2;
    int LEFT = 2 << 2;
    int ADD_ZERO = -1 >>> 1;
    /* 출력하는 코드있다고 가정 */
  }
}
~~~

~~~console
AND = 2
// 0010 AND 0011 => 0010

OR = 3
// 0010 OR 0011 => 0011

NOT = -3
// NOT 0010  => 1101
// 2의 보수를 취하면 -3

XOR = 1
// 0010 XOR 0011 => 0001

RIGHT = 0
// 0010 => 0000

LEFT = 8
// 0010 => 1000

ADD_ZERO = 2147483647
// 1111 1111 1111 1111 1111 1111 1111 1111-> 0111 1111 1111 1111 1111 1111 1111 1111 == int 최대값.
~~~

<br><br>
## 관계 연산자

두 값의 비교하는 연산자. instanceof 의 경우 인스턴스인지 획인하는 연산자이다.
~~~java
public class Relation{
  public static void main(String[] args){
     int a = 10;
     int b = 20;
     
     boolean EQ = a == b;
     boolean LessEQ = a <= b;
     boolean Less = a < b;
     boolean GreaterEQ = a >= b;
     boolean Greater = a > b;
     boolean NotEQ = a != b;
     
     INSTANCE i = new INSTANCE();
     /* 출력하는 코드가 있다고 가정 */
  }
}
~~~

~~~console
EQ = false
LessEQ = true
Less = true
GreaterEQ = false
Greater = false
NotEQ = true

true
// i instanceof INSTANCE 의 경우

true
// i instanceof notINSTANCE 의 경우

~~~

<br><br>
## 논리 연산자

피연산자의 값을 평가하여 boolean 값을 반환

&& 와 ||의 경우 **앞 조건만으로 판단이 가능하면 뒤 조건을 안본다.**

~~~java
public class Logic{
  public static void main(String[] args){
     boolean a = true;
     boolean b = false;
     
     /* 출력하는 코드가 있다고 가정 */
  }
}
~~~

~~~console
a & b = false
a | b = true
a ^ b = true
a && b = false
a || b = true
!a = false

~~~

<br><br>
## instanceof

> 참조 변수가 **특정 클래스의 인스턴스인지 판단**해서 **boolean 값을 반환**해준다.

<br><br>
## assignment(=) operater

우항의 결과를 좌항에 대입해주는 연산자.

| 연산자 | 표현법       | 결과              |
|--------|--------------|-------------------|
| =      | op1 = op2    | op1 에 op2 넣기   |
| +=     | op1 += op2   | op1 = op1 + op2   |
| -=     | op1 -= op2   | op1 = op1 - op2   |
| *=     | op1 *= op2   | op1 = op1 * op2   |
| %=     | op1 %= op2   | op1 = op1 % op2   |
| /=     | op1 /= op2   | op1 = op1 / op2   |
| &=     | op1 &= op2   | op1 = op1 & op2   |
| \|=    | op1 \|= op2  | op1 = op1 \| op2  |
| ^=     | op1 ^= op2   | op1 = op1 ^ op2   |
| >>=    | op1 >>= op2  | op1 = op1 >> op2  |
| <<=    | op1 <<= op2  | op1 = op1 << op2  |
| >>>=   | op1 >>>= op2 | op1 = op1 >>> op2 |

<br><br>
## 화살표 ( -> ) 연산자

자바 8에서 추가된 람다식 연산자.

> 람다식 : 식별자없이 실행가능한 메소드, 익명함수를 생성하기위한 식

(매개변수목록) -> { 함수몸체 } 

의 형식으로 작성가능하다.

~~~java
public interface non_Lamda_interface{
  int plusAB(int a, int b);
}

public class non_Lamda implements non_Lamda_interface{
  @Override
  public int plusAB(int a, int b){
    return a + b;
  }
}

public class Main{
  public static void main(String[] args){
    non_Lamde nl = new non_Lamda();
    System.out.println(n1.plusAB(1,2));
  }
}
~~~
**람다식 적용 이전의 인터페이스 선언과 호출**

<br>
~~~java
public interface Lamda{
  int plusAB(int a, int b);
}

public class Main{
  public static void main(String[] args){
    Lamda l = (a,b)-> a + b;
    System.out.println(l.plusAB(1,2));
  }
}
~~~

**람다식 적용 이후의 인터페이스 선언과 호출**

코드가 말도안되게 간결하지는 모습.

> 출처 : http://www.tcpschool.com/java/java_lambda_concept

<br><br>
## 삼항연산자.

> 조건식 ? A : B
형태로 사용하는 연산자.

조건식의 결과가 참이면 A 거짓이면 B를 반환한다.

조건식 ~~(이야?)~~? A ~~(아니야?)~~: B

개인적으로 이런의미로 해석해서 생각한다.

<br><br>
## 연산자 우선순위

| 우선순위 | 연산자       |
|----------|--------------|
| 0        | (), []    |
| 1        | ++, --, ~, ! |
| 2        | * / %        |
| 3        | + -          |
| 4        | >> >>> <<    |
| 5        | > >= < <=    |
| 6        | == !=        |
| 7        | &            |
| 8        | ^            |
| 9        | \|           |
| 10       | &&           |
| 11       | \|\|         |
| 12       | ?:           |
| 13       | 대입연산자    |

<br><br>
## (optional) Java 13. switch 연산자

~~~java
int a = 3;

switch(a){
  case 1:
    /* 어떠한 코드 */
    break;
  case 2:
    /* 어떠한 코드 */
    break;
  case 3:
    /* 어떠한 코드 */
    break;
  default:
    /* 어떠한 코드 */
    break;
}
~~~
기존의 switch-case 문의 형태.

몇 가지의 문제점에 의하여 자바 12, 자바k 13에서 개선되었다.

- 너무 길어서 가독성이 떨어짐.
- 디버깅이 어려움
- break 매번 달아줘야함
- 리턴값 반환이 힘듬

~~~java
int a = 3;
int result = switch(a){
  case 1, 2 -> {
    /* 어떠한 코드 */ 
    break (반환값);
  }
  case 3 -> /* 어떠한 코드 */;
  default -> /* 어떠한 코드 */;
}
~~~
또는
~~~java
int a= 3;
int result = switch(a){
  case 1,2:
    /*특정코드*/
    break (리턴값);
  case 3:
    /*특정코드*/
    break (리턴값);
  default:
    /*특정코드*/
    break (리턴값);
}
~~~
자바 12버전의 코드.
> 출처 : https://ponyozzang.tistory.com/217

람다식이 적용되어 표현식이 사용가능해졌으며, 리턴값을 특정한 변수에 대입할 수 있게 바뀌었다.

var변수를 사용한다면 리턴값을 특정한 타입으로 지정하지 않을수도있다.


~~~java
int a= 3;
int result = switch(a){
  case 1,2:
    /*특정코드*/
    yield (리턴값);
  case 3:
    /*특정코드*/
    yield (리턴값);
  default:
    /*특정코드*/
    yield (리턴값);
}
~~~
자바 13버전의 코드. ( 12버전의 람다식도 사용가능 )
break 대신에 yield 라는 새로운 표현이 추가되었다.

기존의 스위치문과 비교하여 자바 12, 13버전에 오면서 **구문 -> 연산자 or 메소드의 형태**로 변한 느낌이다.

기존엔 if문이나 while문 등등과 같은 구문의 느낌이었다면 이젠 리턴값이 존재하는 메소드나 연산 결과를 반환하는 연산자의 느낌이 짙어진거같다.
> 출처 : https://mkyong.com/java/java-13-switch-expressions/
