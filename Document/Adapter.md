# 🔌 Adapter Pattern (어댑터 패턴) 
> 한 클래스의 인터페이스를 클라이언트에서 사용하고자하는 다른 인터페이스로 변환하는 패턴

호환되지 않는 인터페이스를 사용하는 클라이언트를 그대로 활용할 수 있다.\
클라이언트와 구현된 인터페이스를 분리시킬수 있으며, 인터페이스가 바뀌더라도 그 변경 내역은 어댑터에 캡슐화 되기 때문에 클라이언트는 바뀔 필요가 없어진다.

### 구현 설명
```java
public class SocketAdapter implements Electronic110V{

    private Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }

    @Override
    public void PowerOn() {
        electronic220V.Connect();
    }
}
```
```java
public interface Electronic110V {

    void PowerOn();
}

public interface Electronic220V {

    void Connect();
}
```
이런식으로, 추상화 되어있는 두개의 인터페이스를 받는 두 클래스를 서로 호환성 있게 사용하기 위해 Adapter를 사용한다.  
```java
Cleaner cleaner = new Cleaner();
Electronic110V adapter = new SocketAdapter(cleaner);
connect(adapter);

```
### SOLID 관점에서의 Adapter
1. SRP (단일 책임 원칙)
    > 구현과 사용 책임이 하나의 클래스에 몰려있다.

    Adapter에서 구현부를, 클라이언트에서 사용부로 분리하고 있기에, 단일 책임 원칙을 따르고 있다.
2. OCP (개방 폐쇄 원칙)
    > Adaptee와 함께 그와 맞는 Adapter를 변경한다면, 클라이언트 코드는 변경할 필요가 없다.
    
3. LSP (리스코프 치환 원칙)
    > Adapter 클래스가 기존 클라이언트의 인터페이스 메서드를 재정의한다.
    
4. ISP (인터페이스 분리 원칙)
    > Adapter 클래스는 잘 분리된 인터페이스를 구현한다.

5. DIP (의존성 역전 원칙)
    > Adapter 클래스와 클라이언트 모두 추상화된 인터페이스에 의존하고 있다.