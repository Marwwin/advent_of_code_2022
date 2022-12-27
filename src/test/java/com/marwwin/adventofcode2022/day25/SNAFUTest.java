package com.marwwin.adventofcode2022.day25;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class SNAFUTest {

  @Test
  public void shouldCreateASNAFUNumberGivenInput() {
    assertEquals(BigInteger.valueOf(2), new SNAFU("2").getDecimal());
    assertEquals(BigInteger.valueOf(1), new SNAFU("1").getDecimal());
    assertEquals(BigInteger.valueOf(0), new SNAFU("0").getDecimal());
    assertEquals(BigInteger.valueOf(-1), new SNAFU("-").getDecimal());
    assertEquals(BigInteger.valueOf(-2), new SNAFU("=").getDecimal());
  }

  @Test
  public void shouldCreateA2DigitSNAFUNumberGivenInput() {
    assertEquals(BigInteger.valueOf(3), new SNAFU("1=").getDecimal());
    assertEquals(BigInteger.valueOf(4), new SNAFU("1-").getDecimal());
    assertEquals(BigInteger.valueOf(5), new SNAFU("10").getDecimal());
    assertEquals(BigInteger.valueOf(6), new SNAFU("11").getDecimal());
    assertEquals(BigInteger.valueOf(7), new SNAFU("12").getDecimal());
    assertEquals(BigInteger.valueOf(8), new SNAFU("2=").getDecimal());
    assertEquals(BigInteger.valueOf(9), new SNAFU("2-").getDecimal());
    assertEquals(BigInteger.valueOf(10), new SNAFU("20").getDecimal());
  }

  @Test
  public void shouldCreate3OrMoreDigitNumbers() {
    assertEquals(BigInteger.valueOf(10), new SNAFU("20").getDecimal());
    assertEquals(BigInteger.valueOf(15), new SNAFU("1=0").getDecimal());
    assertEquals(BigInteger.valueOf(20), new SNAFU("1-0").getDecimal());
    assertEquals(BigInteger.valueOf(60), new SNAFU("220").getDecimal());
    assertEquals(BigInteger.valueOf(2022), new SNAFU("1=11-2").getDecimal());
    assertEquals(BigInteger.valueOf(12345), new SNAFU("1-0---0").getDecimal());
    assertEquals(BigInteger.valueOf(314159265), new SNAFU("1121-1110-1=0").getDecimal());
    assertEquals(BigInteger.valueOf(50), new SNAFU("200").getDecimal());
    assertEquals(BigInteger.valueOf(49), new SNAFU("20-").getDecimal());
    assertEquals(BigInteger.valueOf(326204055), new SNAFU("12=2002012210").getDecimal());

  }

  @Test
  public void shouldCreateSNAFUNumberFromInt() {
    assertEquals("1", new SNAFU(1).getSNAFU());
    assertEquals("2", new SNAFU(2).getSNAFU());
  }

  @Test
  public void shouldCreate2DigitSNAFUNumberFromInt() {
    assertEquals("1=", new SNAFU(3).getSNAFU());
    assertEquals("1-", new SNAFU(4).getSNAFU());
    assertEquals("10", new SNAFU(5).getSNAFU());
    assertEquals("11", new SNAFU(6).getSNAFU());
    assertEquals("12", new SNAFU(7).getSNAFU());
    assertEquals("2=", new SNAFU(8).getSNAFU());
    assertEquals("2-", new SNAFU(9).getSNAFU());
    assertEquals("20", new SNAFU(10).getSNAFU());
    assertEquals("1=0", new SNAFU(15).getSNAFU());
    assertEquals("1-0", new SNAFU(20).getSNAFU());
    assertEquals("1=11-2", new SNAFU(2022).getSNAFU());
    assertEquals("1-0---0", new SNAFU(12345).getSNAFU());
    assertEquals("1121-1110-1=0", new SNAFU(314159265).getSNAFU());
  }

  @Test
  public void shouldTestCustomLog() {
    assertEquals(0, SNAFU.customLog(5, 1));
    assertEquals(0, SNAFU.customLog(5, 4));
    assertEquals(1, SNAFU.customLog(5, 5));
    assertEquals(1, SNAFU.customLog(5, 24));
    assertEquals(2, SNAFU.customLog(5, 25));
    assertEquals(2, SNAFU.customLog(5, 124));
  }

  @Test
  public void shouldReturnCorrectPlace() {
    SNAFU num = new SNAFU("0");
    assertEquals(BigInteger.valueOf(1), num.digit(1));
    assertEquals(BigInteger.valueOf(5), num.digit(2));
    assertEquals(BigInteger.valueOf(25), num.digit(3));
    assertEquals(BigInteger.valueOf(125), num.digit(4));
    assertEquals(BigInteger.valueOf(625), num.digit(5));
    assertEquals(BigInteger.valueOf(3125), num.digit(6));
  }
}
