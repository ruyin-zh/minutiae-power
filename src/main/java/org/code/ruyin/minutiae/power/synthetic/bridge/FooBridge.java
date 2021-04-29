package org.code.ruyin.minutiae.power.synthetic.bridge;

/**
 * @author: hjxz
 * @date: 2021/4/30
 * @desc:
 */
public class FooBridge {

    //BridgeMethodResolver

    public interface FooSuper<T> {

        T doTrick(T obj);

    }

    public class BarSub implements FooSuper<String>{

        @Override
        public String doTrick(String obj) {
            return obj;
        }
    }
}
