package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.LinkedList;
import java.util.List;

public class ReverseSublist {
  @EpiTest(testDataFile = "reverse_sublist.tsv")
  public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish) {
    // TODO - you fill in here.
    if (L == null) return null;
    ListNode<Integer> dummyHead = new ListNode<>(null, L);
    ListNode<Integer> i = find(dummyHead, start);
    reverse(i, finish - start + 1);
    return dummyHead.next;
  }

  public static ListNode<Integer> find(ListNode<Integer> L, int index) {
    ListNode<Integer> it = L;
    int i = 1;
    while (it != null) {
      if (i == index) return it;
      it = it.next;
      i++;
    }
    return null;
  }

  private static void reverse(ListNode<Integer> L, int n) {
    if (n == 1) return;
    ListNode<Integer> last = L.next;
    while (n-- > 1) {
      ListNode<Integer> temp = last.next;
      last.next = temp.next;
      temp.next = L.next;
      L.next = temp;
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseSublist.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
