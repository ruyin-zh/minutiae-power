package org.code.ruyin.minutiae.power.stream;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * @author hjxz
 * @date 2021/5/21
 * @title 梅森素数--2^q-1
 * @description
 */
public class MersennePrimes {

    private final static BigInteger TWO = new BigInteger("2");
    private final static BigInteger ONE = new BigInteger("1");

    public static void printMersennePrimes(){
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE)).
                filter(mersenne -> mersenne.isProbablePrime(50)).
                limit(20).
                forEach(System.out::println);
    }


    static Stream<BigInteger> primes(){
        return Stream.iterate(TWO,BigInteger::nextProbablePrime);
    }

}
