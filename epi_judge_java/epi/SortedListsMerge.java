package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SortedListsMerge {
  @EpiTest(testDataFile = "sorted_lists_merge.tsv")
  //@include
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                      ListNode<Integer> L2) {
    // TODO - you fill in here.
    ListNode<Integer> head = new ListNode<>(0, null),
            tail = head, it1 = L1, it2 = L2;
    while (it1 != null && it2 != null) {
      if (it1.data > it2.data) {
        tail.next = it2;
        tail = tail.next;
        it2 = it2.next;
      }
      else {
        tail.next = it1;
        tail = tail.next;
        it1 = it1.next;
      }
    }
//    if (it1 == null) tail.next = it2;
//    else if (it2 == null) tail.next = it1;
    tail.next = it1 != null ? it1 : it2;
    return head.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
