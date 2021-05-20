package org.code.ruyin.minutiae.power.io.serial;

import org.code.ruyin.minutiae.power.stream.MersennePrimes;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author hjxz
 * @date 2021/5/20
 * @title
 * @description
 *      1、Stream支持三种基本类型: int/long/double
 *      2、Stream pipeline通常是lazy的,在调用最终操作时才会开始计算
 *      3、
 */
public class TestStream {

    @Test
    public void testPrimitiveType(){

        Stream.of(1,2,3);
    }

    @Test
    public void testAnagram(){

    }

    @Test
    public void testMersennePrimes(){
        MersennePrimes.printMersennePrimes();
    }

}
