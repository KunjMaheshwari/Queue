import java.util.*;

class Solution{
    public int minCostRopes(int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        while(pq.size() > 1){
            int min = pq.remove();
            int min2 = pq.remove();

            cost = cost + min + min2;

            pq.add(min + min2);
        }
        return cost;
    }
}