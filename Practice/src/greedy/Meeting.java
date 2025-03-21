package greedy;

import java.util.*;

//mo meed of commarator for sher, sher can do comparision wiht sortig method

public class Meeting {
	static class meeting {
		int start;
		int end;
		int pos;

		meeting(int start, int end, int pos) {
			this.start = start;
			this.end = end;
			this.pos = pos;
		}

		public int getEnd() {
			return end;
		}

		public int getPos() {
			return pos;
		}
	}

	/*
	 * static class meetingComparator implements Comparator<meeting> {
	 * 
	 * @Override public int compare(meeting o1, meeting o2) { if (o1.end < o2.end)
	 * return -1; else if (o1.end > o2.end) return 1; else if (o1.pos < o2.pos)
	 * return -1; return 1; } }
	 */
	static void maxMeetings(int start[], int end[], int n) {
		ArrayList<meeting> meet = new ArrayList<>();

		for (int i = 0; i < start.length; i++)
			meet.add(new meeting(start[i], end[i], i + 1));

//		meetingComparator mc = new meetingComparator();
		Collections.sort(meet,
				Comparator.comparing(meeting::getEnd).thenComparing(Comparator.comparingInt(meeting::getPos)));
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(meet.get(0).pos);
		int limit = meet.get(0).end;

		for (int i = 1; i < start.length; i++) {
			if (meet.get(i).start > limit) {
				limit = meet.get(i).end;
				answer.add(meet.get(i).pos);
			}
		}
		System.out.println("The order in which the meetings will be performed is ");
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}

	public static void main(String args[]) {
		int n = 6;
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 5, 7, 9, 9 };
		maxMeetings(start, end, n);

	}
}