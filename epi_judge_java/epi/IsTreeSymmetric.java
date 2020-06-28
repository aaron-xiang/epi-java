package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeSymmetric {
  @EpiTest(testDataFile = "is_tree_symmetric.tsv")

  public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
    if (tree == null) return true;
    return checkBalance(tree.left, tree.right);
  }

  private static boolean checkBalance(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
    if (left == null && right == null) return true;
    else if (left == null || right == null) return false;
    else if (left.data.intValue() == right.data.intValue()) {
        return (checkBalance(left.right, right.left) && checkBalance(left.left, right.right));
      }
    else return false;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeSymmetric.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
