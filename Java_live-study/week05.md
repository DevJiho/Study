# 목표

자바의 Class에 대해 학습하시오.

# 학습할 것

- 클래스 정의하는 방법
- 객체 만드는 방법 ( new 키워드 이해하기 )
- 메소드 정의하는 방법
- 생성자 정의하는 방법
- this 키워드 이해하기

# 과제

- int값을 가지고 있는 이진트리를 나타내는 Node 클래스 정의하기.
- int value, Node left, right를 가지고 있어야한다.
- Binary Tree ( 이진 트리 ) 라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node) 와 dfs(Node node) 메소드 구현하기
- DFS는 왼쪽, 루트, 오른쪽 순회

* * *

## 클래스 정의방법

**[참고 및 출처](https://jeeneee.dev/java-live-study/week5-class/)**

> 클래스 : 자바의 모든 작업을 수행하기 위한 작업공간. 마치 구조체같은 느낌이며 사용자가 정의하는 타입이라고 볼 수 있음.

`기초적인 정의법`

~~~java

public class 클래스이름{
  int instanceInt; // 인스턴스 변수
  static int classInt; // 클래스 변수
  
  static{
    classInt = 1;
  } // 클래스 초기화 블록
  
  {
    instanceInt = 1;
  } // 인스턴스 초기화 블록
  
  클래스이름(){
  
  } // 생성자
  
  void instanceMethod(){
  
  } // 인스턴스 메소드
  
  static void classMethod(){
  
  } // 클래스 

}

~~~

### 구조

- 필드 : 클래스의 상태속성이며, 멤버변수라고도 부름.
  - 인스턴스 변수 : static이 붙지않은 변수. heap영역에 할당.
  - 클래스 변수 : static이 붙은 변수. static영역에 할당. ( 전역변수 )
- 메소드 : C/C++ 에서의 함수와 같은 역할을 맡고있다.
  - 인스턴스 메소드 : 인스턴스를 통하여 호출되는 메소드
  - 클래스 메소드 : 정적 메소드.
- 생성자
  - 자바의 핵심 중 하나라고 생각함 ( 개인적으로 )
  - 클래스의 인스턴스, 즉 객체를 선언시에 사용.
  - 해당 클래스내의 멤버변수들의 초기화를 시켜줌.
- 초기화 블록 : 조건문, 반복문 등을 사용해 초기화가 가능.
  - 클래스 초기화 블록 : 클래스 변수 초기화
  - 인스턴스 초기화 블록 : 인스턴스 변수 초기화

> 인스턴스 초기화 블록의 경우 생성자보다 우선순위가 뒤쳐짐.

### 생성자

클래스의 인스턴스, 즉 객체를 선언시에 사용.

일반적으로 기본생성자에 의해 필드값들이 초기값으로 지정되며, 파라미터값을 받아서 필드값을 원하는대로 초기화시키거나 메소드를 호출하는 등 여러가지 작업이 가능하게 생성자를 선언가능

~~~java
public class 클래스이름{
  
  클래스이름(){
  /* 필드에있는 변수들을 건들 수 있음 */
  } // 기본생성자. 알아서 만들어지나 개발자가 지정도 가능
  
  public static void main(String[] args){
    [변수 타입] [인스턴스 변수] = new [클래스 명](/*파라미터*/); 
    // 객체 선언 시 방법.
  }
}
~~~


### 몇가지 키워드

|   키워드   |                                          설명                                          |
|:----------:|:--------------------------------------------------------------------------------------:|
|  abstract  |                        추상 클래스나 메소드를 의미 ( 틀만 정의 )                       |
|   static   |                             특정 클래스의 전역 변수를 의미                             |
|   private  |                    같은 클래스에서 접근가능. ( 객체에서 접근 불가 )                    |
|  protected |           같은 클래스, 하위 클래스, 같은 패키지내에 있는 클래스에서 접근가능           |
|  [default] |                           같은 패키지내의 클래스에서 접근가능                          |
|   public   |                                     모두가 접근가능                                    |
|    final   |                                       상수를 의미                                      |
|  interface |                             추상 메소드와 상수만 사용 가능                             |
| implements |                              인터페이스를 상속한다는 느낌                              |
|   extends  |                                   뒤에 붙은 클래스를                                   |
|    this    | 객체 자신의 멤버필드를 의미. static이 붙은 메소드는 같은 메모리 영역이므로 사용 불가능 |

### this 키워드

객체 자기자신을 의미한다.

this 단독으로 사용시에는 객체 자기자신을 의미한다.


## 객체

클래스의 인스턴스. 

선언방식은 아래와 같음.

~~~java
[타입] [변수명] = new [클래스명]();
~~~

new 뒤에 붙은 클래스명()의 경우, 해당 클래스의 해당 생성자를 가지고 객체를 만들겠다는 것을 의미.

해당 **생성자를 가지고 만들어낸 객체를 heap에 저장**하고 *주소*를 인스턴스 변수에게 리턴. 

객체를 생성할 때마다 heap 영역에 해당 클래스만큼의 공간이 할당된다고 생각하면됨.


## 메소드

자바에서의 함수라고 볼 수 있음.

~~~java

[메소드의 활동범위(키워드)] [리턴타입] [메소드이름](/*파라미터*/){
  /* 코드 */
}

~~~


## 과제

- int값을 가지고 있는 이진트리를 나타내는 Node 클래스 정의하기.
- int value, Node left, right를 가지고 있어야한다.
- Binary Tree ( 이진 트리 ) 라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node) 와 dfs(Node node) 메소드 구현하기
- DFS는 왼쪽, 루트, 오른쪽 순회

~~~java

public interface NodeInterface {
    void push(int value);
}
// Node 인터페이스 


public class Node implements NodeInterface{
    Integer value;
    Node left, right;
    public static int size;

    @Override
    public void push(int value){
        this.value = value;
    }
}
// Node 클래스

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree{
    Node node;

    BinaryTree(){
        node = null;
    }

    public void bfs(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(true){
            node = q.poll();
            if(node == null) break;
            System.out.println(node.value);
            q.add(node.left);
            q.add(node.right);
        }
    }

    public void dfs(Node node){
        if(node == null) return;
        dfs(node.left);

        System.out.println(node.value);

        dfs(node.right);
    }

    public void findLeaf(Node node, int value){
        if(node == null){
            this.node = new Node();
            this.node.push(value);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(true){
            node = q.poll();
            if(node.left == null){
                node.left = new Node();
                node.left.push(value);
                break;
            }else if(node.right == null){
                node.right = new Node();
                node.right.push(value);
                break;
            }
            q.add(node.left);
            q.add(node.right);
        }
    }

}
// 이진트리 클래스

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        BinaryTree root = new BinaryTree();

        int[] arr = {42,13,12,42,13,16,41};
        Arrays.stream(arr).forEach(item -> root.findLeaf(root.node, item));

        System.out.println("\n print BFS");
        root.bfs(root.node);

        System.out.println("\n print DFS");
        root.dfs(root.node);
    }
}
//main 클래스
