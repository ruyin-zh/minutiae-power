package org.code.ruyin.minutiae.power.synthetic;

/**
 * @author adsk
 * @date 2022/4/9
 * @title
 * @description
 */
public class ConstructorSyntheticDemo {

    //can access inner class private constructor
    private ConstructorDemoInner demoInner = new ConstructorDemoInner();

    class ConstructorDemoInner {
        private ConstructorDemoInner(){}
    }

}
