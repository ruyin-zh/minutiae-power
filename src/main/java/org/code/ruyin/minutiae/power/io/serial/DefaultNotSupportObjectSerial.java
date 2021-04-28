package org.code.ruyin.minutiae.power.io.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.ZipFile;

/**
 * @author hjxz
 * @date 2021/4/28
 * @title 4、默认不支持序列化的对象进行序列化
 * @description
 *        当需要使用writeObject(Object)方法对某个类对象序列化时,会首先对这个类对象的所有超类按照继承层次从高到低写出每个超类的数据域,这就存在一个问题:不能保证每个超类都实现了Serializable接口;
 *        对于这些不能序列化的类,jvm会检查这些类是否存在这样的一个方法:private void writeObject(ObjectOutputStream out) throws IOException{},若存在该方法,jvm会调用该方法对该类的数据域进行序列化;
 *
 */
public class DefaultNotSupportObjectSerial {

    //针对默认不可序列化的ZipFile对象进行显式序列化方式
    static class SerializableZipFile implements Serializable {
        private ZipFile zf;

        SerializableZipFile(String filename) throws IOException {
            this.zf = newZipFile(filename);
        }

        private ZipFile newZipFile(String filename) throws IOException {
            return new ZipFile(filename);
        }

        public ZipFile getZf() {
            return zf;
        }

        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.writeObject(zf.getName());
        }

        private Object readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            return ois.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "bac.txt";
        String targetFilename = "bac.zip";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new SerializableZipFile(targetFilename));
            System.out.println("s3 serial end");
    
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            Object o = ois.readObject();
            System.out.println("s3 deserialize end:" + ((SerializableZipFile)o).getZf().getName());
        }
    }

}
