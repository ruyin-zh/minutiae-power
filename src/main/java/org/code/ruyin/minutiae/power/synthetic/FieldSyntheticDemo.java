package org.code.ruyin.minutiae.power.synthetic;

/**
 * @author adsk
 * @date 2022/4/9
 * @title
 * @description
 */
public class FieldSyntheticDemo {

    public String hello(){
        return "Hello World!";
    }

    class FiledDemoInner {
        //this$0 true
//        private FieldSyntheticDemo this$0;
//
//        public FiledDemoInner(FieldSyntheticDemo demo){
//            this.this$0 = demo;
//        }

        //根据java语法要求,要调用某一个类的实例方法,那就一定要持有一个方法所在类的实例
        public void sayHello(){
            //System.out.println(this$0.hello());
            System.out.println(hello());
        }
    }

}
