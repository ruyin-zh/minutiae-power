package org.code.ruyin.minutiae.power.io.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.ZipFile;

/**
 * @author hjxz
 * @date 2021/4/23
 * @title 1、类实现Serializable接口,但实例属性不可被序列化
 * @description
 */
public class FieldNotAllowSerial implements Serializable {

    static class Employee{

        private ZipFile zipFile;

        Employee(ZipFile zipFile){
            this.zipFile = zipFile;
        }
    }


    public static void main(String[] args) throws IOException {
        String filename = "s1.txt";

        //因为ZipFile未实现序列化接口,将会抛出异常:
        //java.io.NotSerializableException: org.code.ruyin.minutiae.power.io.serial.FieldNotAllowSerial$Employee
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new Employee(new ZipFile("test.zip")));
        }
    }

}
