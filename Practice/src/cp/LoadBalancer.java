package cp;

import java.util.*;

public class LoadBalancer {
    static class Server {
        int id, requestCount;
        Server(int id, int requestCount) {
            this.id = id;
            this.requestCount = requestCount;
        }
    }

    public static List<Integer> assignRequests(int numServers, int[] requests) {
        List<Integer> assignedServers = new ArrayList<>();
        int[] serverRequests = new int[numServers]; // Track requests for each server

        // Min Heap to get the server with least requests & smallest ID
        PriorityQueue<Server> pq = new PriorityQueue<>(
            (a, b) -> a.requestCount == b.requestCount ? a.id - b.id : a.requestCount - b.requestCount
        );

        // Initialize priority queue with all servers
        for (int i = 0; i < numServers; i++) {
            pq.add(new Server(i, 0));
        }

        for (int req : requests) {
            // Find the server in the range [0, req] with the minimum requests
            List<Server> temp = new ArrayList<>();
            Server bestServer = null;

            while (!pq.isEmpty() && pq.peek().id <= req) {
                Server cur = pq.poll();
                temp.add(cur);
                if (bestServer == null || cur.requestCount < bestServer.requestCount || 
                    (cur.requestCount == bestServer.requestCount && cur.id < bestServer.id)) {
                    bestServer = cur;
                }
            }

            // Assign request to the best server
            if (bestServer != null) {
                assignedServers.add(bestServer.id);
                bestServer.requestCount++; // Increment request count
                serverRequests[bestServer.id] = bestServer.requestCount;
            }

            // Push all servers back into the heap
            for (Server s : temp) {
                pq.add(s);
            }
        }
        
        return assignedServers;
    }

    public static void main(String[] args) {
        int numServers = 5;
        int[] requests = {3, 2, 4};

        List<Integer> result = assignRequests(numServers, requests);
        System.out.println(result);
    }
}
