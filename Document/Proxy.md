# 🧑 Proxy Pattern (프록시 패턴) 
> 실제 기능을 수행하는 객체 대신 가상의 객체를 사용해 로직의 흐름을 제어하는 패턴

Proxy 객체에게 프로세스를 대신 시키는 것을 의미한다.  
인터페이스를 사용하고 실행시킬 클래스에 대한 객체가 들어갈 자리에 Proxy 객체를 대신 넣는다.  
- Proxy는 실제 서비스와 같은 이름의 메서드를 구현하는데, 인터페이스를 사용한다.
- Proxy는 실제 서비스에 대한 참조 변수를 갖는다.
- Proxy는 실제 서비스의 같은 이름을 가진 메서드를 호출하고 그 값을 클라이언트로 반환한다.
- Proxy는 실제 서비스의 메서드 호출 전 후에도 별도의 로직을 수행할 수 있다.

### 구현 설명
```java
public class BrowserProxy implements IBrowser{

    private String url;
    private Html html;

    public BrowserProxy(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        // 캐싱
        if (html == null) {
            this.html = new Html(url);
            System.out.println("BrowserProxy loading html from : " + url);
        }

        System.out.println("BrowserProxy use cache html : " + url);
        return html;
    }
}
```
아래 코드는 위 Proxy 객체에 대한 실제 객체이다.
```java
public class Browser implements IBrowser{
    private String url;

    public Browser(String url) {
        this.url = url;
    }


    @Override
    public Html show() {
        System.out.println("Browser Loading HTML From : " + url);
        return new Html(url);
    }
}

```
실 객체를 통해서 브라우저에 대한 HTML 렌더링을 구현하면 아래와 같이 표현된다.
```java
Browser browser = new Browser("www.foo.co.kr");

// 캐싱 기능 없음
browser.show();
browser.show();
browser.show();
browser.show();
browser.show();
browser.show();
browser.show();
```
하지만 위와 같이 구현하게 되면, 캐싱 기능을 사용할 수 없으며, 그에 따라 렌더링 시간이 오래 걸리게 된다.
하지만, Proxy 객체를 사용하여 캐싱 기능을 구현하게 되면 렌더링 시간을 단축 할 수 있다.


### SOLID 관점에서의 Proxy
1. SRP (단일 책임 원칙)
    > 실제 객체와 프록시 객체의 책임이 분리되어있다.

2. OCP (개방 폐쇄 원칙)
    > 프록시 객체를 사용하는 객체 관점에서는 새로운 기능이 추가되어도 여전히 프록시 객체인지 진짜 객체인지 알 수가 없다.
    
3. LSP (리스코프 치환 원칙)
    > 인터페이스를 구현하면서 제공하는 기능이 구현체의 메서드로 대체 가능하다.
    
4. ISP (인터페이스 분리 원칙)
    > 프록시 객체를 사용하는 객체 관점에서 필요한 기능으로 인터페이스를 분리했다.

5. DIP (의존성 역전 원칙)
    > 프록시 객체와 프록시 객체를 사용하는 객체 모두 추상화된 인터페이스에 의존한다.