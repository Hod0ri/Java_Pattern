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

단일 책임 원칙이란, 클래스, 메서드, 속성 등에 책임을 하나만 부과하겠다는 의미이다.

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

개방 폐쇄 원칙이란, 자신의 확장에는 열려 있고, 주변의 변화에 대해서는 닫혀 있어야 한다.

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
