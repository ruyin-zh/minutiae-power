package org.code.ruyin.minutiae.power.synthetic.nbac;

import java.lang.reflect.Method;

/**
 * @author adsk
 * @date 2022/4/10
 */
public class AccessControlDemo {

    public void sayHello() throws Exception {
        //new AccessControlInner().sayHello();
        new AccessControlInner().reflectSayHello(new AccessControlDemo());
    }

    private void hello(){
        System.out.println("Hello World!");
    }

    class AccessControlInner {

        //直接调用
        public void sayHello(){
            hello();
        }

        //反射调用
        public void reflectSayHello(AccessControlDemo demo) throws Exception {
            Method hello = demo.getClass().getDeclaredMethod("hello");
            hello.invoke(demo);
        }

    }

}
