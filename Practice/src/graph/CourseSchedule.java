package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		int[] indegree = new int[numCourses];
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			res.add(new ArrayList<>());
		}

		for (int[] prerequisite : prerequisites) {
			res.get(prerequisite[1]).add(prerequisite[0]);
			indegree[prerequisite[0]]++;
		}
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}
		
		int pro = 0; 
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			pro++;
			for(int next : res.get(curr)) {
				indegree[next]--;
				if(indegree[next]== 0)
					q.add(next);
			}
		}

		return pro==numCourses;
	}

	public static void main(String[] args) {
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(canFinish(4, prerequisites));
	}

}
