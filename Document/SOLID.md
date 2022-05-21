# 🧱 SOLID 원칙

> 객체 지향 설계의 5원칙

- Single Responsibility Principle (SRP)
- Open Closed Principle (OCP)
- Listov Substitution Principle (LSP)
- Interface Sergeantion Principle (ISP)
- Dependency Inversion Principle (DIP)

## 🧑 Single Responsibility Principle (SRP)
> "A class should have only one reason to change," - Robert C. Martin

> "어떤 클래스를 변경해야 하는 이유는 오직 하나뿐이다."

**단일 책임 원칙**이란, 클래스, 메서드, 속성 등에 책임을 하나만 부과하겠다는 의미이다.

### 예시
```java
class Book {
    public String getTitle() {
        return "A Great Book";
    }
    public String getAuthor() {
        return "John Doe";
    }
    public void turnPage() {}
 
    public void printCurrentPage() {
        System.out.println("Page");
    }
}
```

위 코드는 SRP를 위배하는 코드이다.  
Book 객체가 운용하는 액터가 서로 다르다.  
- GUI 렌더링 : printCurrentPage()
- 책을 정리하는 객체 : getTitle(), getAuthor(), turnPage()
```java
class Book {
    public String getTitle() {
        return "I love Kotlin";
    }
 
    public String getAuthor() {
        return "mammom";
    }
 
    public void turnPage() {}
 
    public String getCurrentPage() {
        return "Page";
    }
}
 
interface Printer {
    void printPage(String page);
}
 
class PlainTextPrinter implements Printer {
    public void printPage(String page) {
        System.out.println(page);
    }
}
 
class HtmlPrinter implements Printer {
    public void printPage(String page) {
        System.out.println(page);
    }
}
```

위 코드는 SRP를 준수하고, 'GUI 렌더링'관련 로직과, '비즈니스 로직'을 분리하였다.  
이와 비슷한 사례로, MVC 패턴에서 M과 V를 분리했다는 측면에서 MVC 패턴은 SRP를 준수하려고 생긴 디자인 패턴이라고 볼 수 있다.

## 🚪 Open Closed Principle (OCP)
> “Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.” - Robert C. Martin

> "소프트웨어 엔티티(클래스, 모듈, 함수 등)는 확장에 대해서는 열려 있어야 하지만 변경에 대해서는 닫혀 있어야 한다."

**개방 폐쇄 원칙**이란, 자신의 확장에는 열려 있고, 주변의 변화에 대해서는 닫혀 있어야 한다.

- 확장  
새로운 타입을 추가함으로써 새로운 기능을 구현할 수 있다.  
- 변경  
확장이 발생했을 떄, 상위 레벨이 영향을 미치지 않아야 한다.

```java
public class Driver {
    public static void main(String[] args) {
        Truck truck = new Truck();
        truck.drive();

        Bus bus = new Bus();
        bus.drive();
    }
}

class Truck {
    public void drive() {
        System.out.println("Truck Drive");
    }
}

class Bus {
    public void drive() {
        System.out.println("Bus Drive");
    }
}
```
위 코드는 OCP를 위배한 코드이다.
운전자의 차 종이 바뀔때마다 운전자는 새로운 drive 메서드를 실행해야한다.

```java
class Car {
    publiv String carType = "";

    public car(String carType) {
        this.carType = carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void drive(String carType) {
        System.out.println(carType + " Drive");
    }
}

class Truck extends Car {
    public Truck() {
        setCarType("Truck");
    }

    @Override
    public void drive() {
        super.drive();
    }
}

class Bus extends Car {
    public Bus() {
        setCarType("Bus");
    }

    @Override
    public void drive() {
        super.drive();
    }
}
```
위 코드처럼 어떤 차종이 오더라도 오버라이딩을 이용하여 재정의하여 사용하게 되면 OCP 원칙을 따른 코드라고 볼 수 있다.

## 👪 Liskov Substitution Principle (LSP)
> “The subtype shall always be replaceable with its own base type.” - Robert C. Martin

> "서브 타입은 언제나 자신의 기반 타입으로 교체할 수 있어야 한다."

**개방 폐쇄 원칙**이란, 자신의 확장에는 열려 있고, 주변의 변화에 대해서는 닫혀 있어야 한다.

- 하위 클래스 is a kind of 상위 클래스 
- 하위 분류는 상위 분류의 한 종류다. 구현 클래스 is able to 인터페이스: 구현 분류는 인터페이스할 수 있어야 한다.

```java
public interface Animal {
    void eat(String food);
    void sleep();
}

public class Whale implements Animal {
    @Override
    public eat(String food) {
        System.out.println(food + "를 먹다.");
    }

    @Override
    public sleep() {
        System.out.println("잔다.")
    }
}
```

## 🪅 Interface Segregation Principle (ISP)
> “ Clients should not be forced to depend on methods they do not use.” - Robert C. Martin

> "클라이언트는 자신이 사용하지 않는 메소드에 의존 관계를 맺으면 안 된다."

**인터페이스 분리 원칙**은 클라이언트를 기준으로 인터페이스를 분리함으로써,  
클라이언트로부터 발생하는 인터페이스의 여파가 다른 클라이언트에 미치는 영향을 최소화하는 것을 목표로 한다
```java
public interface Car {
    String autoDrive();
    String autoParking();
    String drive();
    String break();
}

class Tesla implements Car {
    @Override
    public String autoDrive() {
        return "autoDrive";
    }

    @Override
    public String autoParking() {
        return "autoParking";
    }

    @Override
    public String drive() {
        return "drive";
    }

    @Override
    public String break() {
        return "break";
    }
}

class K5 implements Car {
    @Override
    public String autoDrive() {
        return "";
    }

    @Override
    public String autoParking() {
        return "";
    }

    @Override
    public String drive() {
        return "drive";
    }

    @Override
    public String break() {
        return "break";
    }
}
```
위 코드는 ISP 원칙을 위배한 코드이다.  
K5에는 자율 주행과 자동 주차 기능이 없어 해당 메서드를 안쓰려고 한다.  
ISP 원칙을 적용하지 않은 경우, 인터페이스를 상속 받았기에 메서드를 쓰지 않으려해도 사용해야한다.

```java
public interface ElectricCar {
    String autoDrive();
    String autoParking();
}

class Tesla implements Car, ElectricCar {
    @Override
    public String autoDrive() {
        return "autoDrive";
    }

    @Override
    public String autoParking() {
        return "autoParking";
    }

    @Override
    public String drive() {
        return "drive";
    }

    @Override
    public String break() {
        return "break";
    }
}

class K5 implements Car {
    @Override
    public String drive() {
        return "drive";
    }

    @Override
    public String break() {
        return "break";
    }
}
```
## 🎫 Dependency Inversion Principle (ISP)
> “고차원 모듈은 저차원 모듈에 의존하면 안 된다. 이 두 모듈 모두 다른 추상화된 것에 의존해야 한다.\
추상화된 것은 구체적인 것에 의존하면 안 된다. 구체적인 것이 추상화된 것에 의존해야 한다.\
자주 변경되는 구체(Concrete) 클래스에 의존하지 마라” - Robert C. Martin

**의존관계 역전 원칙**은 고수준 모듈은 저수준 모듈의 구현에 의존해서는 안 되기에 저수준 모듈이 고수준 모듈에서 정의한 추상 타입에 의존해야 한다는 원칙이다.
```java
class SamsungPay {
    String payment() {
        return "samsung";
    }
}

public class PayService {
    private SamsungPay pay;

    public void setPay(final SamsungPay pay) {
        this.pay = pay;
    }

    public String payment() {
        return pay.payment();
    }
}
```
위 상황에서 KakaoPay 서비스를 추가하려고 하면, 메서드를 하나하나 다 추가하여야 한다.

```java
public interface Pay {
    String payment();
}

class SamsungPay implements Pay {
    @Override
    public String payment() {
        return "samsung";
    }
}

public class KakaoPay implements Pay {
    @Override
    public String payment() {
        return "kakao";
    }
}

public class PayService {
    private Pay pay;

    public void setPay(final Pay pay) {
        this.pay = pay;
    }

    public String payment() {
        return pay.payment();
    }
}
```