package linkedList;

public class ReorderList {

	static public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		ListNode head = new ListNode(arr[0]);
		head.next = new ListNode(arr[1]);
		head.next.next = new ListNode(arr[2]);
		head.next.next.next = new ListNode(arr[3]);
		head.next.next.next.next = new ListNode(arr[4]);

		reorderList(head);

	}

	private static void reorderList(ListNode head) {
		ListNode root = head;
		if (head == null || head.next == null)
			return;
		ListNode beg, mid;
		beg = root;
		mid = middle(head);
		ListNode end = reverse(mid.next);
		mid.next = null;

		ListNode f1 = null;
		ListNode f2 = null;

		while (beg != null && end != null) {
			f1 = beg.next;
			f2 = end.next;

			beg.next = end;
			end.next = f1;
			
			beg= f1;
			end= f2;
			
			
		}
		
	}

	private static ListNode reverse(ListNode head) {

		ListNode curr = head;
		ListNode prev = null;
		ListNode forw = null;
		while (curr != null) {
			forw = curr.next;
			curr.next = prev;
			prev = curr;
			curr = forw;
		}

		return prev;
	}

	private static ListNode middle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
