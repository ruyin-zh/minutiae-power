/**
 * @author hjxz
 * @date 2021/4/23
 * @title
 * @description
 */
package org.code.ruyin.minutiae.power.io.serial;


/**
 *
 * 1、java对象序列化是将对象的实例域数据(包括私有域)进行持久化存储,而非将整个对象所属的类信息进行存储;
 * 2、jvm堆中存储的对象包含了实例域数据以及指向类信息的指针,而对象所属类信息存在在方法区中;
 * 3、jdk中四种类型类对象绝对不能序列化:
 *      1)、过于依赖底层实现的类:如java.util.zip.Deflater;
 *      2)、对象的状态依赖于jvm内部和不停变化的运行时环境:如java.lang.Thread、java.io.InputStream;
 *      3)、涉及到潜在安全性问题:如java.lang.SecurityManager、java.security.MessageDigest;
 *      4)、全是静态域的类,无对象实例数据;
 *
 * */