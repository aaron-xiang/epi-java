package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class DeleteKthLastFromList {
  @EpiTest(testDataFile = "delete_kth_last_from_list.tsv")

  // Assumes L has at least k nodes, deletes the k-th last node in L.
  public static ListNode<Integer> removeKthLast(ListNode<Integer> L, int k) {
    // TODO - you fill in here.
    ListNode<Integer> d = new ListNode<>(0, L), i = d, j = d;
    for (int l = 0; l <= k; l++) {
      j = j.next;
    }
    while (j != null) {
      i = i.next;
      j = j.next;
    }
    i.next = i.next.next;
    return d.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DeleteKthLastFromList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
