package com.marwwin.adventofcode2022;

import java.io.IOException;

import com.marwwin.adventofcode2022.aoc.BinaryTree.BinaryTree;
import com.marwwin.adventofcode2022.aoc.BinaryTree.Node;
import com.marwwin.adventofcode2022.day1.Day1;
import com.marwwin.adventofcode2022.day2.Day2;
import com.marwwin.adventofcode2022.day3.Day3;

public class App {
    public static void main(String[] args) throws IOException {
        showHeader();

        long startTime = System.currentTimeMillis();

        Day1 day1 = new Day1(false);
        day1.printResults();

        Day2 day2 = new Day2(false);
        day2.printResults();

        long endTime = System.currentTimeMillis();
        System.out.println("All solutions took " + (endTime - startTime) + " ns");

        Day3 day3 = new Day3(false);

        int runs = 10000;
        long s1Time = System.nanoTime();
        for (int i = 0; i < runs; i++)
            day3.part1();
        long e1Time = System.nanoTime();
        System.out.println("Part 1 Set intersection " + (e1Time - s1Time) / runs + " ns");

        long s2Time = System.nanoTime();
        for (int i = 0; i < runs; i++)
            day3.part1BT();
        long e2Time = System.nanoTime();
        System.out.println("Part 1 BinaryTree " + (e2Time - s2Time) / runs + " ns");

        long s3Time = System.nanoTime();
        for (int i = 0; i < runs; i++)
            day3.part2();
        long e3Time = System.nanoTime();
        System.out.println("Part 2 Set intersection " + (e3Time - s3Time) / runs + " ns");

        long s4Time = System.nanoTime();
        for (int i = 0; i < runs; i++)
            day3.part2BT();
        long e4Time = System.nanoTime();
        System.out.println("Part 2 BinaryTree " + (e4Time - s4Time) / runs + " ms");

    }

    private static void showHeader() {
        System.out.println();
        System.out.println("#############################");
        System.out.println("#### Advent Of Code 2022 ####");
        System.out.println("#############################");
        System.out.println();
    }
}
