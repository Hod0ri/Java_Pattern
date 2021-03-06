# ๐งฑ SOLID ์์น

> ๊ฐ์ฒด ์งํฅ ์ค๊ณ์ 5์์น

- Single Responsibility Principle (SRP)
- Open Closed Principle (OCP)
- Listov Substitution Principle (LSP)
- Interface Sergeantion Principle (ISP)
- Dependency Inversion Principle (DIP)

## ๐ง Single Responsibility Principle (SRP)
> "A class should have only one reason to change," - Robert C. Martin

> "์ด๋ค ํด๋์ค๋ฅผ ๋ณ๊ฒฝํด์ผ ํ๋ ์ด์ ๋ ์ค์ง ํ๋๋ฟ์ด๋ค."

**๋จ์ผ ์ฑ์ ์์น**์ด๋, ํด๋์ค, ๋ฉ์๋, ์์ฑ ๋ฑ์ ์ฑ์์ ํ๋๋ง ๋ถ๊ณผํ๊ฒ ๋ค๋ ์๋ฏธ์ด๋ค.

### ์์
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

์ ์ฝ๋๋ SRP๋ฅผ ์๋ฐฐํ๋ ์ฝ๋์ด๋ค.  
Book ๊ฐ์ฒด๊ฐ ์ด์ฉํ๋ ์กํฐ๊ฐ ์๋ก ๋ค๋ฅด๋ค.  
- GUI ๋ ๋๋ง : printCurrentPage()
- ์ฑ์ ์ ๋ฆฌํ๋ ๊ฐ์ฒด : getTitle(), getAuthor(), turnPage()
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

์ ์ฝ๋๋ SRP๋ฅผ ์ค์ํ๊ณ , 'GUI ๋ ๋๋ง'๊ด๋ จ ๋ก์ง๊ณผ, '๋น์ฆ๋์ค ๋ก์ง'์ ๋ถ๋ฆฌํ์๋ค.  
์ด์ ๋น์ทํ ์ฌ๋ก๋ก, MVC ํจํด์์ M๊ณผ V๋ฅผ ๋ถ๋ฆฌํ๋ค๋ ์ธก๋ฉด์์ MVC ํจํด์ SRP๋ฅผ ์ค์ํ๋ ค๊ณ  ์๊ธด ๋์์ธ ํจํด์ด๋ผ๊ณ  ๋ณผ ์ ์๋ค.

## ๐ช Open Closed Principle (OCP)
> โSoftware entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.โ - Robert C. Martin

> "์ํํธ์จ์ด ์ํฐํฐ(ํด๋์ค, ๋ชจ๋, ํจ์ ๋ฑ)๋ ํ์ฅ์ ๋ํด์๋ ์ด๋ ค ์์ด์ผ ํ์ง๋ง ๋ณ๊ฒฝ์ ๋ํด์๋ ๋ซํ ์์ด์ผ ํ๋ค."

**๊ฐ๋ฐฉ ํ์ ์์น**์ด๋, ์์ ์ ํ์ฅ์๋ ์ด๋ ค ์๊ณ , ์ฃผ๋ณ์ ๋ณํ์ ๋ํด์๋ ๋ซํ ์์ด์ผ ํ๋ค.

- ํ์ฅ  
์๋ก์ด ํ์์ ์ถ๊ฐํจ์ผ๋ก์จ ์๋ก์ด ๊ธฐ๋ฅ์ ๊ตฌํํ  ์ ์๋ค.  
- ๋ณ๊ฒฝ  
ํ์ฅ์ด ๋ฐ์ํ์ ๋, ์์ ๋ ๋ฒจ์ด ์ํฅ์ ๋ฏธ์น์ง ์์์ผ ํ๋ค.

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
์ ์ฝ๋๋ OCP๋ฅผ ์๋ฐฐํ ์ฝ๋์ด๋ค.
์ด์ ์์ ์ฐจ ์ข์ด ๋ฐ๋๋๋ง๋ค ์ด์ ์๋ ์๋ก์ด drive ๋ฉ์๋๋ฅผ ์คํํด์ผํ๋ค.

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
์ ์ฝ๋์ฒ๋ผ ์ด๋ค ์ฐจ์ข์ด ์ค๋๋ผ๋ ์ค๋ฒ๋ผ์ด๋ฉ์ ์ด์ฉํ์ฌ ์ฌ์ ์ํ์ฌ ์ฌ์ฉํ๊ฒ ๋๋ฉด OCP ์์น์ ๋ฐ๋ฅธ ์ฝ๋๋ผ๊ณ  ๋ณผ ์ ์๋ค.

## ๐ช Liskov Substitution Principle (LSP)
> โThe subtype shall always be replaceable with its own base type.โ - Robert C. Martin

> "์๋ธ ํ์์ ์ธ์ ๋ ์์ ์ ๊ธฐ๋ฐ ํ์์ผ๋ก ๊ต์ฒดํ  ์ ์์ด์ผ ํ๋ค."

**๊ฐ๋ฐฉ ํ์ ์์น**์ด๋, ์์ ์ ํ์ฅ์๋ ์ด๋ ค ์๊ณ , ์ฃผ๋ณ์ ๋ณํ์ ๋ํด์๋ ๋ซํ ์์ด์ผ ํ๋ค.

- ํ์ ํด๋์ค is a kind of ์์ ํด๋์ค 
- ํ์ ๋ถ๋ฅ๋ ์์ ๋ถ๋ฅ์ ํ ์ข๋ฅ๋ค. ๊ตฌํ ํด๋์ค is able to ์ธํฐํ์ด์ค: ๊ตฌํ ๋ถ๋ฅ๋ ์ธํฐํ์ด์คํ  ์ ์์ด์ผ ํ๋ค.

```java
public interface Animal {
    void eat(String food);
    void sleep();
}

public class Whale implements Animal {
    @Override
    public eat(String food) {
        System.out.println(food + "๋ฅผ ๋จน๋ค.");
    }

    @Override
    public sleep() {
        System.out.println("์๋ค.")
    }
}
```

## ๐ช Interface Segregation Principle (ISP)
> โ Clients should not be forced to depend on methods they do not use.โ - Robert C. Martin

> "ํด๋ผ์ด์ธํธ๋ ์์ ์ด ์ฌ์ฉํ์ง ์๋ ๋ฉ์๋์ ์์กด ๊ด๊ณ๋ฅผ ๋งบ์ผ๋ฉด ์ ๋๋ค."

**์ธํฐํ์ด์ค ๋ถ๋ฆฌ ์์น**์ ํด๋ผ์ด์ธํธ๋ฅผ ๊ธฐ์ค์ผ๋ก ์ธํฐํ์ด์ค๋ฅผ ๋ถ๋ฆฌํจ์ผ๋ก์จ,  
ํด๋ผ์ด์ธํธ๋ก๋ถํฐ ๋ฐ์ํ๋ ์ธํฐํ์ด์ค์ ์ฌํ๊ฐ ๋ค๋ฅธ ํด๋ผ์ด์ธํธ์ ๋ฏธ์น๋ ์ํฅ์ ์ต์ํํ๋ ๊ฒ์ ๋ชฉํ๋ก ํ๋ค
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
์ ์ฝ๋๋ ISP ์์น์ ์๋ฐฐํ ์ฝ๋์ด๋ค.  
K5์๋ ์์จ ์ฃผํ๊ณผ ์๋ ์ฃผ์ฐจ ๊ธฐ๋ฅ์ด ์์ด ํด๋น ๋ฉ์๋๋ฅผ ์์ฐ๋ ค๊ณ  ํ๋ค.  
ISP ์์น์ ์ ์ฉํ์ง ์์ ๊ฒฝ์ฐ, ์ธํฐํ์ด์ค๋ฅผ ์์ ๋ฐ์๊ธฐ์ ๋ฉ์๋๋ฅผ ์ฐ์ง ์์ผ๋ คํด๋ ์ฌ์ฉํด์ผํ๋ค.

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
## ๐ซ Dependency Inversion Principle (ISP)
> โ๊ณ ์ฐจ์ ๋ชจ๋์ ์ ์ฐจ์ ๋ชจ๋์ ์์กดํ๋ฉด ์ ๋๋ค. ์ด ๋ ๋ชจ๋ ๋ชจ๋ ๋ค๋ฅธ ์ถ์ํ๋ ๊ฒ์ ์์กดํด์ผ ํ๋ค.\
์ถ์ํ๋ ๊ฒ์ ๊ตฌ์ฒด์ ์ธ ๊ฒ์ ์์กดํ๋ฉด ์ ๋๋ค. ๊ตฌ์ฒด์ ์ธ ๊ฒ์ด ์ถ์ํ๋ ๊ฒ์ ์์กดํด์ผ ํ๋ค.\
์์ฃผ ๋ณ๊ฒฝ๋๋ ๊ตฌ์ฒด(Concrete) ํด๋์ค์ ์์กดํ์ง ๋ง๋ผโ - Robert C. Martin

**์์กด๊ด๊ณ ์ญ์  ์์น**์ ๊ณ ์์ค ๋ชจ๋์ ์ ์์ค ๋ชจ๋์ ๊ตฌํ์ ์์กดํด์๋ ์ ๋๊ธฐ์ ์ ์์ค ๋ชจ๋์ด ๊ณ ์์ค ๋ชจ๋์์ ์ ์ํ ์ถ์ ํ์์ ์์กดํด์ผ ํ๋ค๋ ์์น์ด๋ค.
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
์ ์ํฉ์์ KakaoPay ์๋น์ค๋ฅผ ์ถ๊ฐํ๋ ค๊ณ  ํ๋ฉด, ๋ฉ์๋๋ฅผ ํ๋ํ๋ ๋ค ์ถ๊ฐํ์ฌ์ผ ํ๋ค.

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