package org.code.ruyin.minutiae.power.synthetic.nbac;

/**
 * @author adsk
 * @date 2022/4/10
 *
 * NBAC => Nested Based Access Control,解决内部类桥接问题
 *
 * AccessControlInner => nestHost = AccessControlDemo.class
 * AccessControlDemo => nestHost = AccessControlDemo.class
 *
 *
 *
 */
public class NBACDemo {


    public static void main(String[] args) throws Exception {
        //new AccessControlDemo().sayHello();

        //Class中getNestHost()方法是jdk11版本添加
        System.out.println("AccessControlInner嵌套宿主:" + AccessControlDemo.AccessControlInner.class.getNestHost().getName());
        System.out.println("AccessControlDemo嵌套宿主:" +AccessControlDemo.class.getNestHost().getName());

        System.out.println("AccessControlDemo嵌套成员:");
        for (Class<?> nestMembers : AccessControlDemo.class.getNestMembers()){
            System.out.println(nestMembers.getName());
        }

        System.out.println("AccessControlInner嵌套成员");
        for (Class<?> nestMembers : AccessControlDemo.AccessControlInner.class.getNestMembers()){
            System.out.println(nestMembers.getName());
        }

        System.out.println("AccessControlInner是AccessControlDemo嵌套成员?" + AccessControlDemo.AccessControlInner.class.isNestmateOf(AccessControlDemo.class));
        System.out.println("AccessControlInner是NBACDemo嵌套成员?" + AccessControlDemo.AccessControlInner.class.isNestmateOf(NBACDemo.class));
    }

}
