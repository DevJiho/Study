# 출처

- [스프링 입문을 위한 객체 지향의 원리와 이해](http://www.yes24.com/Product/Goods/17350624)

# 스프링 삼각형

- IoC / DI
- PSA
- AOP

## `IoC/DI`

IoC ( Inversion of Control ) : 제어의 역전
DI ( Dependency Injection ) : 의존성 주입


### `의존성`

자바에서의 의존성

자바에서의 의존성은 new를 의미한다.

아래의 작성된 코드는 Car 가 Tire에 의존한다.

의존하는 객체( 전체 )와 의존되는 객체( 부분 )사이의 집합관계와 구성관게로 구분할 수 있다. 

자동차를 예로 들어보자<br> 
자동차는 여러가지 부품이 모여서 만들어지므로, 자동차 자체를 의존하는 객체라고 볼 수 있고 자동차의 부품하나하나를 의존되는 객체라고 볼 수 있다.

~~~java

Car car = new Tire();

~~~

<details>
<summary> 집합관게와 구성관계 </summary>

**집합관계** : 부분이 전체와 다른 라이프사이클을 가진다.

**구성관계** : 부분이 전체와 같은 라이프사이클을 가진다.
</details>

* * *

### 스프링을 적용하지 않는 기존 방식에서의 자바코드.

Car 클래스에서 Tire 객체를 생성하므로, Car 클래스는 Tire 인터페이스에 의존한다.

Driver 클래스가 Car 클래스를 이용하므로, Dirver 클래스도 Tire 인터페이스에 의존한다.

~~~java

package expert001_01;

public class AmericaTire implements Tire{
    @Override
    public String getBrand(){
        return "AmericaTire";
    }
}
// Tire 하위 클래스

package expert001_01;

public class KoreaTire implements Tire {

    @Override
    public String getBrand(){
        return "KoreaTire";
    }
}
// Tire 하위 클래스

package expert001_01;

public interface Tire {
    public abstract String getBrand();
}

// Tire 인터페이스

package expert001_01;

public class Car {
    Tire tire;

    Car(){
        tire = new KoreaTire();
        // tire = new AmericaTire();
    }

    public String getTireBrand(){
        return "장착된 타이어 : " + tire.getBrand();
    }
}
// Car 클래스 ( Trie 객체 정의 ) 


package expert001_01;

public class Driver {
    public static void main(String[] args){
        Car car = new Car();
        System.out.println(car.getTireBrand());
    }
}

// main 클래스

~~~

### 스프링 없이 의존성 주입하기 1. 생성자를 통한 주입

Car 클래스의 기본생성자에서 생성되던 Tire 객체를<br>
Driver 클래스에서 생성한 다음 Car 객체의 생성자를 통하여 넘겨주는 방식.

~~~java

package expert001_02;

public class AmericaTire implements Tire{
    @Override
    public String getBrand(){
        return "AmericaTire";
    }
}
// Tire 하위 클래스

package expert001_02;

public class KoreaTire implements Tire {

    @Override
    public String getBrand(){
        return "KoreaTire";
    }
}
// Tire 하위 클래스

package expert001_02;

public interface Tire {
    public abstract String getBrand();
}

// Tire 인터페이스

package expert001_02;

public class Car {
    Tire tire;
    public Car(Tire tire){
      this.tire = tire;
    }

    public String getTireBrand(){
        return "장착된 타이어 : " + tire.getBrand();
    }
}
// Car 

package expert001_02;

public class Driver {
    public static void main(String[] args){
        Tire tire = new KoreaTire();
        Car car = new Car(tire);
        System.out.println(car.getTireBrand());
    }
}

// main 클래스

~~~


### 스프링 없이 의존성 주입하기 2. 속성을 통합 주입

생성자를 사용하지않고, getTire() setTire()를 통해 넘겨받은 파라미터로 의존성을 주입하는 방식

~~~java

package expert001_02;

public class AmericaTire implements Tire{
    @Override
    public String getBrand(){
        return "AmericaTire";
    }
}
// Tire 하위 클래스

package expert001_02;

public class KoreaTire implements Tire {

    @Override
    public String getBrand(){
        return "KoreaTire";
    }
}
// Tire 하위 클래스

package expert001_02;

public interface Tire {
    public abstract String getBrand();
}

// Tire 인터페이스

package expert001_02;

public class Car {
    Tire tire;
    
    public Tire getTire(){
      return this.tire;
    ;
    
    public Tire setTire(Tire tire){
      this.tire = tire;
    }

    public String getTireBrand(){
        return "장착된 타이어 : " + tire.getBrand();
    }
}
// Car 

package expert001_02;

public class Driver {
    public static void main(String[] args){
        Tire tire = new KoreaTire();
        Car car = new Car();
        
        car.setTire(tire);
        
        System.out.println(car.getTireBrand());
    }
}

// main 클래스

~~~

### 스프링을 통한 의존성 주입 - XML 파일사용
