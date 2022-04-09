package org.code.ruyin.minutiae.power.synthetic;

/**
 * @author adsk
 * @date 2022/4/9
 * @title
 * @description
 */
public class MethodSyntheticDemo {


    class MethodDemoInner {

//        private MethodSyntheticDemo this$0;

        //access$000 true
        //access$002 true
        private String methodName;

//        public String access$000(){
//            return methodName;
//        }
//
//        public void access$002(String methodName){
//            this.methodName = methodName;
//        }

    }

    public void setInnerMethodName(String methodName){
//        new MethodDemoInner().access$002(methodName);
        new MethodDemoInner().methodName = methodName;
    }

    public String getInnerMethodName(){
//        return new MethodDemoInner().access$000();
        return new MethodDemoInner().methodName;
    }

}
