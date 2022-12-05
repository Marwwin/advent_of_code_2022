package com.marwwin.adventofcode2022;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.marwwin.adventofcode2022.aoc.BinaryTree.BinaryTree;
import com.marwwin.adventofcode2022.aoc.BinaryTree.Node;
import com.marwwin.adventofcode2022.day1.Day1;
import com.marwwin.adventofcode2022.day2.Day2;
import com.marwwin.adventofcode2022.day3.Day3;
import com.marwwin.adventofcode2022.day4.Day4;
import com.marwwin.adventofcode2022.day5.CargoCrane;
import com.marwwin.adventofcode2022.day5.Day5;
import com.marwwin.adventofcode2022.day5.Move;

public class App {
    public static void main(String[] args) throws IOException {
        showHeader();

        long startTime = System.nanoTime();

        Day1 day1 = new Day1(false);
        day1.printResults();

        Day2 day2 = new Day2(false);
        day2.printResults();

        Day3 day3 = new Day3(false);
        day3.printResults();

        Day4 day4 = new Day4(false);
        day4.printResults();

        long endTime = System.nanoTime();
        System.out.println("All solutions took " + (endTime - startTime) / 1000 + " μs");

        Day5 day5 = new Day5(true);
        day5.part2Str();
    }

    private static void showHeader() {
        System.out.println();
        System.out.println("#############################");
        System.out.println("#### Advent Of Code 2022 ####");
        System.out.println("#############################");
        System.out.println();
    }
}
