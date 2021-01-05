# 목표
자바가 제공하는 제어문 학습하기.

# 학습목표
- 선택문
- 반복문

# 과제
1. JUnit5로 테스트코드 작성하는 방법 익히기
2. live-study 대시보드 만드는 코드 작성하기
3. LinkedList 구현하기
4. stack 구현하기
5. ListNode로 stack 구현하기
6. Queue 구현하기

* * *

### `선택문`

조건-분기문

#### `if` 구문
~~~java
if(condition) { /* 실행될 코드 */ }
~~~

#### `if-else` 구문
~~~java
if(condition) { /* 실행될 코드 */ }
else { /* 실행될 코드 */ }
~~~

#### `switch` 구문
~~~java
public class HelloSpringApplication {
	public static int before12(int num){
		int tmp = 0;
		switch(num){
			case 0:
				tmp = 0;
				break;
			case 1:
			case 2:
				tmp = 2;
				break;
			case 3:
				tmp = 3;
				break;
			default:
				tmp = -1;
				break;
		}
		return tmp;
	}
  // 기존의 스위치문
  
	public static int after12(int num){
		int ret = switch(num){
			case 0 -> 0;
			case 1, 2 -> 2;
			case 3 -> 3;
			default -> -1;
		};
		return ret;
	}
  // 자바 12버전 이후의 스위치문.
  // 람다식의 사용과 반환값이 생김
  
	public static int after13(int num){
		int ret = switch(num){
			case 0 : yield 0;
			case 1,2 : yield 2;
			case 3 : yield 3;
			default : yield -1;
		};
		return ret;
	}
  // 자바 13버전 이후의 스위치문.
  // 12버전의 사용법 + yield 를 통한 값의 반환
  
  
	public static void main(String[] args){
		System.out.println(before12(1));
		System.out.println(after12(5));
		System.out.println(after13(0));

	}
}
~~~

자바 12, 13버전을 거치면서 다양한 기능이 추가되었음.

- 값의 반환
- ,를 이용하여 한 case에 여러 조건 넣기 
- etc

### `제어문`

실행흐름 제어문.

#### `for` 문
~~~java
for( 초기값; 조건; 값의 변화 ){
  /* 실행코드 */
}
~~~

#### `for-each` 문
~~~java
for( 참조변수 : 참조대상 ){
  /* 실행 코드 */
}
~~~
>for-each문의 예시

향상된 for문이라고도 불리우며 참조대상의 주소가 참조변수에 순차적으로 들어간다. 

#### `while`문

~~~java
whicondition){
	/* 실행 코드 */
}
~~~
> while문 예시

조건문이 참이면 계속해서 실행코드를 반복한다.

#### `do-while`문
~~~java
int a = 0;
do{
  System.out.println(a);
  a++;
}while (a < 0);
~~~
> do-while문 예시

do를 먼저 실행하는 것을 제외하고 while 문과 동일.

***

## 1. JUnit5로 테스트코드 작성하는 방법 익히기

> JUnit5 Reference : https://junit.org/junit5/docs/current/user-guide/
> JUnit : JUnit Platform + JUnit Jupiter + JUnit Vintage

- JUnit Platform
- JUnit Jupiter
- JUnit Vintage

## 2. live-study 대시보드 만드는 코드 작성하기

## 3. LinkedList 구현하기

## 4. stack 구현하기

## 5. ListNode로 stack 구현하기

## 6. Queue 구현하기
