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

## 0. JUnit5 학습하기

- 인텔리J, 이클립스, VS Code에서 JUnit 5로 테스트 코드 작성하는 방법에 익숙해 질 것.
- 이미 JUnit 알고 계신분들은 다른 것 아무거나!
- 더 자바, 테스트 강의도 있으니 참고하세요~


> JUnit5 Reference : https://junit.org/junit5/docs/current/user-guide/
> 자바용 단위 테스트 프레임워크
> JUnit : JUnit Platform + JUnit Jupiter + JUnit Vintage

- JUnit Platform
	- JVM에서 테스트 프레임워크를 시작하기 위한 기반역할.
	- TestEngine API를 정의
	- JUnit4 기반 Runner 제공.
- JUnit Jupiter
	- 테스트코드 작성에 필요한 junit-jupiter-api 모듈
	- 테스트 실행을 위한 junit-jupiter-engine 모듈
- JUnit Vintage
	- JUnit3 나 JUnit4 기반 테스트를 실행하기 위한 TestEngine 제공.
	
> Annotaion : https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations

## 1. live-study 대시보드 만드는 코드 작성하기

- 깃헙 이슈 1번부터 18번까지 댓글을 순회하며 댓글을 남긴 사용자를 체크 할 것.
- 참여율을 계산하세요. 총 18회에 중에 몇 %를 참여했는지 소숫점 두자리가지 보여줄 것.
- [Github 자바 라이브러리](https://github-api.kohsuke.org/)를 사용하면 편리합니다.
- 깃헙 API를 익명으로 호출하는데 제한이 있기 때문에 본인의 깃헙 프로젝트에 이슈를 만들고 테스트를 하시면 더 자주 테스트할 수 있습니다.

~~~java

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.*;

public class Countingreplyer{
    public static void main(String[] args) throws IOException {
        String token = "/* my git token */";
        GitHub Git = new GitHubBuilder().withOAuthToken(token).build();
        //토큰을 이용한 Git 접근

        GHRepository Gitrepo = Git.getRepository("whiteship/live-study");
        //repo 접근.

        List<GHIssue> issues = Gitrepo.getIssues(GHIssueState.ALL);
        //Issues 접근.

        TreeMap<String, List<Integer>> UserInfo = new TreeMap<String, List<Integer>>();

        for(var item : issues){
            for(var reply : item.getComments()){
                List<Integer> list = new ArrayList<Integer>();
                if(UserInfo.get(reply.getUser().getLogin()) != null){
                    list = UserInfo.get(reply.getUser().getLogin());
                    UserInfo.remove(reply.getUser().getLogin());
                }
                list.add(item.getNumber());
                UserInfo.put(reply.getUser().getLogin(), list);
            }
        }

        Iterator<String> UserInfoIter = UserInfo.keySet().iterator();
        while(UserInfoIter.hasNext()) {
            String ID = UserInfoIter.next();
            List<Integer> list = UserInfo.get(ID);
            double per = ((double)list.size()/18) * 100;
            System.out.println("참여자 : " + ID + " , 참여율 : " + String.format("%.2f", per));
        }
    }
}


~~~

### `결과`
[result](../img/result.png)

## 2. LinkedList 구현하기

- LinkedList에 대해 공부하세요.
- 정수를 저장하는 ListNode 클래스를 구현하세요.
- ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
- ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
- boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.

### `연결 리스트`

- 기본 구조
	- 현재 가지고 있는 값
	- 다음 노드의 주소 값

#### 특징

연결리스트의 어느 위치에서라도 삭제나 삽입이 단일시간내에 가능함.

Head노드는 첫번째 노드를 가르키는 필드만 존재함.

#### `단일 연결리스트`
- 단방향 연결리스트.
- 한쪽 방향으로만 나아감.
#### `이중 연결리스트`
- 양뱡향 연결리스트.
- 자기자신의 이전과 이후의 노드를 기억.
#### `원형 연결리스트`
- 단일리스트의 마지막 노드가 맨 처음 노드를 가리킴.

~~~java
public interface ListNodeInterface {
    public ListNode add(ListNode head, ListNode nodeToAdd, int position);
    public ListNode remove(ListNode head, int positionToRemove);
    public boolean contains(ListNode head, ListNode nodeTocheck);
}
// 리스트 노드 인터페이스

public class ListNode implements ListNodeInterface {
    ListNode next;
    Integer value, size;

    public ListNode(){
        this.next = null;
        this.value = null;
        this.size = 0;
    }

    public ListNode(int value){
        this.next = null;
        this.value = value;
        this.size = 0;
    }

    @Override
    public ListNode add(ListNode head, ListNode nodeToAdd, int position){
        ListNode node = head;
        if(position < 1 || position > head.size + 1){
            System.out.print("Out of range");
            System.exit(1);
        }

        for(int i = 1; i < position; i++){
            node = node.next;
        }
        if(position <= head.size){
            nodeToAdd.next = node.next;
        }
        node.next = nodeToAdd;
        head.size++;
        return head;
    }

    @Override
    public ListNode remove(ListNode head, int positionToRemove){
        ListNode node = head;
        if(positionToRemove < 1 || positionToRemove > head.size){
            System.out.print("Out of range");
            System.exit(1);
        }
        for(int i = 1; i < positionToRemove; i++){
            node = node.next;
        }
        ListNode nextNode = node.next.next;
        node.next = null;
        node.next = nextNode;

        return head;
    }

    @Override
    public boolean contains(ListNode head, ListNode nodeTocheck){
        ListNode node = head.next;
        while(node != null){
            if(node.value.equals(nodeTocheck.value))
                return true;

            node = node.next;
        }
        return false;
    }
}
// 리스트 노드 클래스

public class Main {
    public static void main(String[] args){
        ListNode Head = new ListNode();

        ListNode item = new ListNode(10);
        Head = Head.add(Head, item, 1);

        item = new ListNode(20);
        Head = Head.add(Head, item, 1);

        if(Head.contains(Head, item)){
            System.out.println("Exist!");
        }else{
            System.out.println("Does not exist");
        }
    }
}
// 메인 클래스

~~~


## 3. stack 구현하기

- int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
- void push(int data)를 구현하세요.
- int pop()을 구현하세요.

~~~java

public interface StackInterface {
    public void push(int data);
    public int pop();
}
// 스택 인터페이스

public class StackArray implements StackInterface{
    int[] Arr;
    int pos = 0;

    private StackArray(){ }
    public StackArray(int size){
        Arr = new int[size];
    }

    @Override
    public void push(int data){
        Arr[pos++] = data;
    }

    @Override
    public int pop(){
        return Arr[--pos];
    }

}
//스택본체 클래스.

public class Main {
    public static void main(String[] args){
        StackArray stack = new StackArray(10);
        stack.push(10);
        stack.push(12);

        System.out.println(stack.pop());
    }
}
// 메인 클래스.

~~~

## 4. ListNode로 stack 구현하기

- ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
- void push(int data)를 구현하세요.
- int pop()을 구현하세요.

~~~java

public interface Stack {
    public void push(int data);
    public int pop();
}
// 인터페이스

public class ListNode{
    ListNode next;
    Integer value, size;

    public ListNode(){
        next = null;
        value = null;
        size = 0;
    }

    public ListNode(int data){
        next = null;
        value = data;
        size = 0;
    }
}
//ListNode 클래스


public class ListNodeStack extends ListNode implements Stack{
    ListNode head = new ListNode();

    @Override
    public void push(int data){
        ListNode node = this.head;
        while(node.next != null){
            node = node.next;
        }
        node.next = new ListNode(data);
    }

    @Override
    public int pop(){
        ListNode node = this.head;
        while(node.next.next != null){
            node = node.next;
        }
        int ret = node.next.value;
        node.next = null;
        return ret;
    }
}
// ListNodeStack 클래스

public class Main {
    public static void main(String[] args){
        ListNodeStack Head = new ListNodeStack();
        Head.push(1);
        Head.push(2);
        Head.push(3);

        System.out.println(Head.pop());
        System.out.println(Head.pop());
        System.out.println(Head.pop());
    }
}
// 메인 

~~~

## 5. Queue 구현하기

- 배열을 사용해서 한번
- ListNode를 사용해서 한번.
