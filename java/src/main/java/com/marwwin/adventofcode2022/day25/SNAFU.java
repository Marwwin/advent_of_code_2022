package com.marwwin.adventofcode2022.day25;

import java.math.BigInteger;

public class SNAFU {

  private BigInteger decimal = BigInteger.ZERO;
  private String SNAFU = "";

  public SNAFU(String n) {
    int complement = n.length();
    for (String digit : n.split("")) {
      BigInteger currentDigit = BigInteger.valueOf(stringToSNAFU(digit))
          .multiply(digit(complement));
      decimal = decimal.add(currentDigit);
      complement -= 1;
    }
  }

  private int stringToSNAFU(String n) {
    if (n.equals("2"))
      return 2;
    if (n.equals("1"))
      return 1;
    if (n.equals("-"))
      return -1;
    if (n.equals("="))
      return -2;
    return 0;
  }

  public BigInteger digit(int length) {
    BigInteger five = BigInteger.valueOf(5);
    return five.pow(length - 1);
  }

  public SNAFU(int n) {
    int power = customLog(5, n) + 1;
    SNAFU = removeLeadingZero(calcSnafu(n, power));
  }

  public SNAFU(BigInteger n) {
    int power = customLog(5, n.doubleValue()) + 1;
    SNAFU = removeLeadingZero(calcSnafu(n.doubleValue(), power));
  }

  public String calcSnafu(double n, int power) {
    if (n < 5 && power == 0)
      return convertIntToSNAFU((int) n);
    return convertIntToSNAFU((int) Math.round(n / Math.pow(5, power)))
        + calcSnafu((long) (n % Math.pow(5, power)), power - 1);
  }

  public String convertIntToSNAFU(int n) {
    if (n == -1 || n == 4)
      return "-";
    if (n == -2 || n == 3)
      return "=";
    if (n == 2)
      return "2";
    if (n == 1)
      return "1";
    return "0";
  }

  private String removeLeadingZero(String calcSnafu) {
    return calcSnafu.charAt(0) == '0'
        ? calcSnafu.substring(1)
        : calcSnafu;
  }

  public static int customLog(double base, double logNumber) {
    return (int) (Math.log(logNumber) / Math.log(base));
  }

  public BigInteger getDecimal() {
    return decimal;
  }

  public String getSNAFU() {
    return SNAFU;
  }

}
