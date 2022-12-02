package com.marwwin.adventofcode2022;

import java.io.IOException;

import com.marwwin.adventofcode2022.day1.Day1;
import com.marwwin.adventofcode2022.day2.Day2;

public class App {
    public static void main(String[] args) throws IOException {
        showHeader();
        
        long startTime = System.currentTimeMillis();
    
        Day1 day1 = new Day1(false);
        day1.printResults();

        Day2 day2 = new Day2(false);
        day2.printResults();

        long endTime = System.currentTimeMillis();
        System.out.println("All solutions took " + (endTime - startTime) + " ms");
    }

    private static void showHeader() {
        System.out.println();
        System.out.println("#############################");
        System.out.println("#### Advent Of Code 2022 ####");
        System.out.println("#############################");
        System.out.println();
    }
}
