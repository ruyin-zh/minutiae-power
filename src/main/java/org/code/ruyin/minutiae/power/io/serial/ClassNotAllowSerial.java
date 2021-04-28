package org.code.ruyin.minutiae.power.io.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author hjxz
 * @date 2021/4/23
 * @title 2、父类未实现序列化接口,子类继承父类且实现序列化接口
 * @description 序列化的时候只是将Manager类对象的数据库id写入了文件,在反序列化过程中需要在堆中建立一个新的Manager对象;
 *              而任何一个类对象的建立都需要调用父类的构造器对父类进行初始化,但本例中序列化文件中并没有父类Employee的name数据,
 *              故此时调用Employee(String)构造器会因为没有数据而出现异常(因为此时会调用默认的无参构造器,而Employee类中并无默认的无参构造器);
 *
 * @conclusion 若当前类的所有超类中有一个类不能序列化,也没有无参构造器,那么当前类将不能反序列化;
 *             若存在无参构造器,那么此超类反序列化的数据域将会是null或0或false等默认类型值;
 *
 */
public class ClassNotAllowSerial {


    static class Employee {
        private String name;
        Employee(String name){
            this.name = name;
        }
    }

    static class Manager extends Employee implements Serializable {

        private String name;
        private Integer id;

        Manager(String name, Integer id) {
            super(name);
            this.id = id;
        }

        @Override
        public String toString() {
            return "Manager{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "s2.txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new Manager("s2",111));
            System.out.printf("s2 serial end");

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            //java.io.InvalidClassException: org.code.ruyin.minutiae.power.io.serial.ClassNotAllowSerial$Manager; no valid constructor
            Object o = ois.readObject();
            System.out.printf("s2 deserialize end:" + o.toString());
        }
    }

}
