package org.code.ruyin.minutiae.power.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hjxz
 * @date 2021/5/20
 * @title Stream api与old school优劣对比
 * @description Stream api实现与old school版本对比
 */
public class Anagrams {

    /**
     *
     * type1:老派处理方式
     *
     * */
    public static void anagramsOldSchool(String filename, int groupSize) throws IOException {
        File dictionary = new File(filename);
        int minGroupSize = groupSize;

        Map<String, Set<String>> groups = new HashMap<>();
        try(Scanner scan = new Scanner(dictionary)) {
            while (scan.hasNext()){
                String word = scan.next();
                groups.computeIfAbsent(alphabetize(word),(unused) -> new TreeSet<>()).add(word);
            }
        }

        for (Set<String> group : groups.values()){
            if (group.size() >= minGroupSize){
                System.out.println(group.size() + ":" + group);
            }
        }
    }


    /**
     *
     * type2: 纯粹的stream api操作,滥用api导致可读性差,装x还行
     *
     * */
    public static void anagramsPureStream(String filename, int groupSize) throws IOException {
        Path dictionary = Paths.get(filename);
        int minGroupSize = groupSize;

        try(Stream<String> words = Files.lines(dictionary)) {
            words.collect(Collectors.
                    groupingBy(word -> word.chars().
                            sorted().
                            collect(StringBuilder::new,(sb,c) -> sb.append((char) c),StringBuilder::append).toString())).
                    values().stream().
                    filter(group -> group.size() >= minGroupSize).map(group -> group.size() + ": " + group).
                    forEach(System.out::println);
        }

    }


    /**
     *
     * type3:结合stream api的简洁与老派的可读性
     *
     * */
    public static void anagramsCombine(String filename, int groupSize) throws IOException {
        Path dictionary = Paths.get(filename);
        int minGroupSize = groupSize;

        try(Stream<String> words = Files.lines(dictionary)){
            words.collect(Collectors.groupingBy(Anagrams::alphabetize)).
                    values().stream().
                    filter(group -> group.size() >= minGroupSize).
                    forEach(g -> System.out.println(g.size() + ": " +g));
        }
    }


    private static String alphabetize(String s){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

}
