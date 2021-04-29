package org.code.ruyin.minutiae.power.synthetic;

/**
 * @author: hjxz
 * @date: 2021/4/30
 * @desc:
 */
public class FooSynthetic {

    private static Object hello = "hello world";
    private static int trick = 0;

    private static int get() {
        return trick;
    }

    private static class BarSynthetic {
        //外部类引用内部类属性
        private String h1 = "abc";
        private String f1 = "bcd";


        //获取外部类属性值
        private void getOuterField(){
            System.out.println(hello);
        }
        //引用外部类方法
        private void invokeOuterMethod(){
            System.out.println(get());
        }
    }


    public static void main(String[] args) {
        FooSynthetic.BarSynthetic bar = new FooSynthetic.BarSynthetic();
        System.out.println(bar.h1);
        System.out.println(bar.f1);
    }
}
