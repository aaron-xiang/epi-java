package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeABst {

  @EpiTest(testDataFile = "is_tree_a_bst.tsv")
  public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
    return areKeysInRange(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean areKeysInRange(BinaryTreeNode<Integer> tree, int minValue, int maxValue) {
    if (tree == null) return true;
    else if (tree.data.intValue() < minValue || tree.data.intValue() > maxValue) return false;
    return areKeysInRange(tree.left, minValue, tree.data) && areKeysInRange(tree.right, tree.data, maxValue);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeABst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
