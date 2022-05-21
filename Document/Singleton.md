# 🧑 Singleton Pattern (싱글톤 패턴) 
> 전역 변수를 사용하지 않고 객체를 하나만 생성 하도록 하며, 생성된 객체를 어디에서든지 참조할 수 있도록 하는 패턴

쉽게 말해서 객체 인스턴스가 오직 1개만 생성되는 패턴이다.  
즉, 객체에 메모리를 최초 1회만 할당한다는 뜻이다.  
주로, 서로의 자원을 공유할 때 사용된다.

### 구현 설명
```java
public class SocketClient {

    // 싱글톤은 자기 자신을 가지고 있어야 함
    private static SocketClient socketClient = null;

    // 기본 생성자 사용 금지
    private SocketClient() { }

    public static SocketClient getInstance() {
        // Null인지 확인
        if(socketClient == null) {
            socketClient = new SocketClient();
        }

        return socketClient;
    }

    public void connect() {
        System.out.println("Connect!");
    }

}
```

우선, 싱글톤 패턴에서의 객체는 자기 자신을 속성으로 가지고 있어야 한다.
```java
private static SocketClient socketClient = null;
```
또한, 기본 생성자를 사용하지 않아야 한다.
```java
private SocketClient() { }
```
객체 생성을 위한 getInstance 메서드를 만들어주는데, Null인 경우 최초 생성을 하며, Null이 아닌 경우, 원래 있는 객체를 반환한다.
```java
public static SocketClient getInstance() {
        // Null인지 확인
        if(socketClient == null) {
            socketClient = new SocketClient();
        }

        return socketClient;
    }
```

### SOLID 관점에서의 Singleton
1. SRP (단일 책임 원칙)
    > 구현과 사용 책임이 하나의 클래스에 몰려있다.

    위 예제를 보면 알겠지만, SocketClient에 구현과 사용에 대한 책임이 몰려있다.  
    이렇게 두 개의 책임이 하나의 클래스에 몰려있기에 단일 책임 원칙을 위배한다.
2. OCP (개방 폐쇄 원칙)
    > 클래스 내부에서 객체를 직접 생성하고 사용하고 있다.
    
    SocketClient 객체에서 객체를 직접 생성하고 사용하며, 만일 싱글톤 기능의 확장으로,  
    추가적으로 다른 객체를 사용해야하는 경우, 코드를 변경하여야 하기에, 개방 폐쇄 원칙을 위배한다.
3. DIP (의존성 역전 원칙)
    > 추상화에 의존하지 않고, 직접 구현체와 결합하여 사용된다.
    
    SocketClient가 추상화에 의존하지 않으며, 직접 구현체인 AClazz와 BClazz에 결합이 되어있기에, 의존성 역전 원칙에 위배된다.