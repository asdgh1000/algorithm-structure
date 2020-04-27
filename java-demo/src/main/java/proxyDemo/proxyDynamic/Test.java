package proxyDemo.proxyDynamic;


import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        DynamicInvocationhandler dynamicInvocationhandler = new DynamicInvocationhandler(helloService);
        HelloService proxy = (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(), dynamicInvocationhandler);
        proxy.test();

        HelloService helloService2 = new HelloServiceImpl2();
        DynamicInvocationhandler dynamicInvocationhandler2 = new DynamicInvocationhandler(helloService2);
        HelloService proxy2 = (HelloService) Proxy.newProxyInstance(helloService2.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(), dynamicInvocationhandler2);
        proxy2.test();

    }
}
