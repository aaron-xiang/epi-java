package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class IsValidSudoku {
  @EpiTest(testDataFile = "is_valid_sudoku.tsv")

  // Check if a partially filled matrix has any conflicts.
  public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
    // TODO - you fill in here.
    for (int i = 0; i < 9; i++) {
      if (!isValidRow(partialAssignment, i)) return false;
      if (!isValidCol(partialAssignment, i)) return false;
    }
    for (int i = 0; i <= 6; i += 3) {
      for (int j = 0; j <= 6; j += 3) {
        if (!isValidSquare(partialAssignment, i, j)) return false;
      }
    }
    return true;
  }

  private static boolean isValidRow(List<List<Integer>> s, int row) {
    boolean[] check = new boolean[10];
    for (int i = 0; i < 9; i++) {
      int n = s.get(row).get(i);
      if (n == 0) continue;
      else if (check[n]) return false;
      else check[n] = true;
    }
    return  true;
  }

  private static boolean isValidCol(List<List<Integer>> s, int col) {
    boolean[] check = new boolean[10];
    for (int i = 0; i < 9; i++) {
      int n = s.get(i).get(col);
      if (n == 0) continue;
      else if (check[n]) return false;
      else check[n] = true;
    }
    return true;
  }

  private static boolean isValidSquare(List<List<Integer>> s, int x, int y) {
    boolean[] check = new boolean[10];
    for(int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int n = s.get(x+i).get(y+j);
        if (n == 0) continue;
        else if (check[n]) return false;
        else check[n] = true;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsValidSudoku.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
