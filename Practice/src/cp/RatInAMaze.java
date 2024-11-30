package cp;

import java.util.*;

public class RatInAMaze {

	static int solve(int N, int M, int[] F, int[] B) {
        // Combine front-end and back-end costs into a single list with roles
        List<int[]> developers = new ArrayList<>();
        for (int cost : F) {
            developers.add(new int[]{cost, 0}); // 0 -> front-end
        }
        for (int cost : B) {
            developers.add(new int[]{cost, 1}); // 1 -> back-end
        }

        // Sort developers by cost
        developers.sort(Comparator.comparingInt(a -> a[0]));

        int minCost = 0;
        int frontEndCount = 0, backEndCount = 0;

        // Assign developers
        for (int[] dev : developers) {
            int cost = dev[0];
            int type = dev[1];

            if (type == 0 && frontEndCount < N) {
                minCost += cost;
                frontEndCount++;
            } else if (type == 1 && backEndCount < M) {
                minCost += cost;
                backEndCount++;
            }

            // Break if all requirements are satisfied
            if (frontEndCount == N && backEndCount == M) {
                break;
            }
        }

        return minCost;
	}
	    public static void main(String[] args) {
	        // Example input
	        int[]  fontend= new int[]{1, 1,1};
	        int[] backEndCosts = new int[]{1, 1,1};

	        // Calculate minimum cost for each test case
	       System.out.println(solve(1,2, fontend, backEndCosts)) ;
	    }
	}

