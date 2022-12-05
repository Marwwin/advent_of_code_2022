package com.marwwin.adventofcode2022;

import java.io.IOException;

import com.marwwin.adventofcode2022.day1.Day1;
import com.marwwin.adventofcode2022.day2.Day2;
import com.marwwin.adventofcode2022.day3.Day3;
import com.marwwin.adventofcode2022.day4.Day4;
import com.marwwin.adventofcode2022.day5.Day5;

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

        Day5 day5 = new Day5(false);
        day5.printResults();

        long endTime = System.nanoTime();
        System.out.println("All solutions took " + (endTime - startTime) / 1000 + " μs");

    }

    private static void showHeader() {
        System.out.println();
        System.out.println("#############################");
        System.out.println("#### Advent Of Code 2022 ####");
        System.out.println("#############################");
        System.out.println();
    }
}
