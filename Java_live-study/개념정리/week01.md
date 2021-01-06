# 목표
자바 소스 파일(.java)을 JVM으로 실행하는 과정 이해하기.

# 학습목록
1. [JVM이란 무엇인가](#jvm)
2. [컴파일 하는 방법](#howtocompile)
3. [실행하는 방법](#howtoexcute)
4. [바이트코드란 무엇인가](#bytecode)
5. [JIT 컴파일러란 무엇이며 어떻게 동작하는지](#jit)
6. [JVM 구성 요소](#component)
7. [JDK와 JRE의 차이](#jrejdk)





***
## <div id = "jvm"> 1. JVM(Java Virtual Machine) </div>

**Java프로그램을 실행하기 위한 가상머신.**

자바프로그램을 실행시키기 위해 만들어낸 소프트웨어적인 컴퓨터.
컴퓨터와 비교했을 때, 전용 OS와 개발도구가 존재한다.

- OS : JRE
- 개발도구 : JDK

*자바 프로그램의 구동과정*
1. 소스코드의 작성
2. 컴파일러 ( javac.exe ) 에 의한 바이트코드로의 변환
3. 자바 프로그램 실행기 ( java.exe ) 로 JVM을 구동
4. JVM이 바이트코드를 해석하여 프로그램 실행

*Write Once Run AnyWhere* 이라는 특징을 가지고있으며, 본인이 사용중인 플랫폼에 설치된 JVM용의 프로그램을 작성하고 배포하면 각 플랫폼에 맞는 JVM이 구동시켜준다.


즉, 개발자 입장에서 플랫폼별로 별도의 파일을 마련할 필요가없다.


### <div id = "component"> 1.1 구성요소 </div>
- Class Loader
- Execution Engine
- Runtime Data Area
- Garbage Collector

#### 1.1.1 클래스 로더 ( class loader )
javac 명령을 통하여 생성된 클래스파일 ( 목적파일 ) 을 런타임에 메모리로 올려서 실행한다.


바이트코드를 일련의 과정을 통하여 메모리에 로딩시킨다.
1. 메모리로 로딩
2. 안정성 검증
3. 메모리 할당
4. 메모리 처리
5. 목적파일에서 지정된 클래스 변수할당


#### 1.1.2 실행 엔진 ( Execution Engine )
인터프리너와 JIT컴파일러를 이용하여 메모리에 로딩된 클래스파일의 해석을 담당한다.

#### 1.1.3 런타임 데이터 영역 ( Runtime Data Area )
JVM의 메모리 영역.

- Method Area : 인터페이스, 클래스, 메소드, 필드 등의 모든 정보
- Heap : 생성된 인스턴스에 관한 정보
- JVM Stacks : 호출 스택, 메소드의 매개변수나 지역변수등의 임시데이터 저장
- PC Registers : 프로그램 카운터
- Native Method Stacks : 자바 외 언어로 작성된 코드를 위한 스택

> 참조 : https://sjh836.tistory.com/64, https://www.holaxprogramming.com/2013/07/16/java-jvm-runtime-data-area/


#### 1.1.4 Garbage Collector
사용되지 않는 메모리를 알아서 관리해주는 친구.






## <div id = "howtocompile"> 2. 컴파일 하는 방법 </div>
.java 파일을 javac 명령을 통해 컴파일할 수 있다.
~~~cmd
jvavc [파일명].java
~~~

실행결과로 .class 확장자의 파일이 생성된다.




## <div id = "howtoexcute"> 3. 실행하는 방법 </div>
.class 파일을 java명령을 통해 실행할 수 있다.
~~~cmd
java [파일명]
~~~






## <div id = "bytecode"> 4. 바이트코드? </div>

**JVM이 이해할 수 있도록 번역된 코드**이며 개발자가 작성한 코드가 자바 컴파일러를 통해서 번역되는 결과물이다.


**확장자 명은 .class**이며 JVM이 있다면 어떠한 OS에서도 실행될 수 있다.


이후 인터프리터와 JIT컴파일러에 의하여 기계어로 번역된다.






## <div id = "jit"> 5. JIT 컴파일러란? </div>
Just-In-Time 컴파일러의 약자.
자바 컴파일러를 통해 생성된 **바이트코드를 CPU로 보낼 수 있는 명령어로 바꾸는 컴파일러.**

**자바컴파일러는 JVM이 알아들을 수 있게 소스코드를 변환하는 역할**을하고 **JIT컴파일러는 CPU가 알아들을 수 있게 바이트코드를 변환하는 역할**을 맡고있다.


컴파일러와 인터프리터에 대하여 알아두면 유용할거 같다.
> 컴파일러 : 소스코드 전체를 한번에 기계어로 변환


> 인터프리터 : 소스코드를 실행순서에 맞춰 한줄씩 

### 5.1 동작원리
반복되는 메소드의 호출을 jit컴파일러가 저장소에 저장해둬서 다시 해당 메소드가 호출되면 해당 부분의 코드를 읽지않고 저장해둔 Native코드를 가져온다.

> 참조 : https://catch-me-java.tistory.com/11






## <div id = "jrejdk"> 6. JRE와 JDK </div>
### 6.1 JDK : Java Development Kit
자바 개발 도구.


클래스파일을 생성하는 역할을 맡고있다. JRE를 포함한다.
### 6.2 JRE : Java Runtime Enviroment
자바 실행 환경



자바실행기와 JVM을 포함하고있다.
