package proxyDemo.proxyDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationhandler implements InvocationHandler {

    private Object object;

    public DynamicInvocationhandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("---before");
        result = method.invoke(object, args);
        System.out.println("---after");
        return result;
    }
}
