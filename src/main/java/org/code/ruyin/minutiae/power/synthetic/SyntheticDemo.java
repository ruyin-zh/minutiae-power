package org.code.ruyin.minutiae.power.synthetic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author adsk
 * @date 2022/4/9
 * @title
 * @description
 *
 * Synthetic: 合成的, 由java编译器在构造阶段自动生成的[构造]
 * JLS: 所有存在于字节码文件中,但是不存在与源代码文件中的[构造],都应该被synthetic关键字标注
 * [构造]: => Constructs ==> Field,Method,Constructor
 *
 * 用js解释: java编译期自动做了 var that = this; 的操作
 *
 */
public class SyntheticDemo {


    public static void main(String[] args) {
        fieldDemo();
        //methodDemo();
        //constructorDemo();
    }

    //this$0 true
    public static void fieldDemo(){
        Field[] fields = FieldSyntheticDemo.FiledDemoInner.class.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getName() + " " + field.isSynthetic());
        }
    }

    //access$000 true
    //access$002 true
    public static void methodDemo(){
        Method[] methods = MethodSyntheticDemo.MethodDemoInner.class.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method.getName() + " " + method.isSynthetic());
        }
    }

    //org.code.ruyin.minutiae.power.synthetic.ConstructorSyntheticDemo$ConstructorDemoInner false
    //2
    //private
    //org.code.ruyin.minutiae.power.synthetic.ConstructorSyntheticDemo$ConstructorDemoInner true
    //4096
    //modifier => 4096 => synthetic
    //Class类中定义的属性SYNTHETIC值为0x00001000=1*16^3
    public static void constructorDemo(){
        Constructor<?>[] constructors = ConstructorSyntheticDemo.ConstructorDemoInner.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors){
            System.out.println(constructor.getName() + " " + constructor.isSynthetic());
            System.out.println(constructor.getModifiers());
            System.out.println(Modifier.toString(constructor.getModifiers()));
        }
    }

}
