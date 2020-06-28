package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class StringIntegerInterconversion {

  public static String intToString(int x) {
    // TODO - you fill in here.
    if (x == 0) return "0";
    StringBuilder stringBuilder = new StringBuilder();
    String sign = x < 0 ? "-" : "";
    long i = x;
    if (i < 0) i = -i;
    while (i > 0) {
      char c = (char) ((i % 10) + '0');
      i = i/10;
      stringBuilder.append(c);
    }
    return stringBuilder.append(sign).reverse().toString();
  }

  public static int stringToInt(String s) {
    // TODO - you fill in here.
    char[] c = s.toCharArray();
    int sign = c[0] == '-' ? -1 : 1;
    int i = 0;
    for (int j = sign == -1 ? 1 : 0; j < c.length; j++) {
      i = i*10 + (c[j] - '0');
    }
    return i * sign;
  }

  @EpiTest(testDataFile = "string_integer_interconversion.tsv")
  public static void wrapper(int x, String s) throws TestFailure {
    if (!intToString(x).equals(s)) {
      throw new TestFailure("Int to string conversion failed");
    }
    if (stringToInt(s) != x) {
      throw new TestFailure("String to int conversion failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StringIntegerInterconversion.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
