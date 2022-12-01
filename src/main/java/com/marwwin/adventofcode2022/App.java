package com.marwwin.adventofcode2022;

import java.io.IOException;

import com.marwwin.adventofcode2022.day1.Day1;

public class App {
    public static void main(String[] args) throws IOException {
        showHeader();

        Day1 day1 = new Day1(false);
        day1.printResults();
    }

    private static void showHeader() {
        System.out.println();
        System.out.println("#############################");
        System.out.println("#### Advent Of Code 2022 ####");
        System.out.println("#############################");
        System.out.println();
    }
}
