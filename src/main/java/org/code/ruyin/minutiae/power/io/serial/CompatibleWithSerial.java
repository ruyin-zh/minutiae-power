package org.code.ruyin.minutiae.power.io.serial;

import java.io.ObjectStreamClass;
import java.io.Serializable;

/**
 * @author hjxz
 * @date 2021/4/28
 * @title 3、序列化兼容问题
 * @description 类定义的不停更新可能会导致之前序列化的就对象很可能不能再反序列化成新类对象;
 *              严格意义上来说除static和transient以外的所有部分都会造成兼容性问题;
 *              jdk采用一种stream unique identifier(SUID)来识别兼容性,SUID通过复杂函数计算类名、接口名、方法及数据域的一个64位hash值;
 *
 * @conclusion 为兼容序列化的不兼容性,可在类中显示定义serialVersionUID的值,这样会跳过JVM的默认兼容性检查,但数据域名称更改会导致反序列化后,改变的数据域只能得到默认的值(null/0/false);
 */
public class CompatibleWithSerial {


    static class Employee implements Serializable {
        //跳过jvm默认的兼容性检查
        private static final long serialVersionUID = 1L;

        private String name;
        //private String name1;

        Employee(String name){
            //this.name1 = name;
            this.name = name;
        }

        public String getName() {
            //return name1;
            return name;
        }
    }

    public static void main(String[] args) {
        //-5465484335505073729
        long serialVersionUID = ObjectStreamClass.lookup(Employee.class).getSerialVersionUID();
        System.out.println(serialVersionUID);
        //更改Employee类中数据域名称name->name1,1613551874455502272
        serialVersionUID = ObjectStreamClass.lookup(Employee.class).getSerialVersionUID();
        System.out.println(serialVersionUID);
    }

}
