package proxyDemo.proxyStatic;

public class HelloServiceProxy implements HelloService {

    HelloService helloService;

    public HelloServiceProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void test() {
        System.out.println("before");
        helloService.test();
        System.out.println("after");
    }
}
