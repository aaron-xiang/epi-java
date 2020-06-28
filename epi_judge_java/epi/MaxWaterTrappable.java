package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class MaxWaterTrappable {
  @EpiTest(testDataFile = "max_water_trappable.tsv")

  public static int calculateTrappingWater(List<Integer> heights) {
    // TODO - you fill in here.
    int[] a = new int[heights.size()];
    for (int i = 0; i < heights.size(); i++) {
      a[i] = heights.get(i);
    }
//    int[] a = heights.stream().mapToInt(i -> i+1).toArray();
    return trappingWater(a, 0, a.length-1);
  }

  private static int trappingWater(int[] a, int l, int r) {
    if (r - l <= 1) return 0;

    //    int d = a[l] < a[r] ? 1 : -1;
    //    int m = Math.min(a[l], a[r]);
    int d, m, i, v = 0;
    if (a[l] < a[r]) {
      d = 1;
      m = a[l];
      i = l + 1;
    } else {
      d = -1;
      m = a[r];
      i = r - 1;
    }
    while (a[i] < m) {
      v += m - a[i];
      i += d;
    }
    if (d == 1 && i < r) return v + trappingWater(a, i, r);
    else if (d == -1 && i > l) return v + trappingWater(a, l, i);
    else return v;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MaxWaterTrappable.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
