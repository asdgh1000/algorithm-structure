package proxyDemo.proxyStatic;

public class Test {
    public static void main(String[] args) {
        HelloService proxy = new HelloServiceProxy(new HelloServiceImpl());
        proxy.test();
    }
}
