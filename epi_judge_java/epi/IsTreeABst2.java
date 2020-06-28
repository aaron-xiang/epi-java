package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.LinkedList;
import java.util.List;

public class IsTreeABst2 {
    @EpiTest(testDataFile = "is_tree_a_bst.tsv")
    public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
        // TODO - you fill in here.
        List<Integer> list = new LinkedList<>();
        traverse(tree, list);
        return isSorted(list);
    }

    private static boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).intValue() > list.get(i + 1).intValue()) return false;
        }
        return true;
    }

    private static void traverse(BinaryTreeNode<Integer> tree, List<Integer> items) {
        if (tree == null) return;
        traverse(tree.left, items);
        items.add(tree.data);
        traverse(tree.right, items);
    }



    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsTreeABst.java",
                                new Object() {}.getClass().getEnclosingClass())
                        .ordinal());
    }
}
