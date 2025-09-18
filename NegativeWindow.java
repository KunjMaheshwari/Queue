import java.util.*;

class Solution {
    public static ArrayList<Integer> solve(int arr[], int k) {
        Deque<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int n = arr.length;

        //Step 1 - > Process the first K Size elements.
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                q.addLast(i);
            }
        }

        if(!q.isEmpty()){
            result.add(arr[q.peekFirst()]);
        }else{
            result.add(0);
        }

        for(int i=k;i<n;i++){
            int windowSize = i-k+1;

            if(!q.isEmpty() && q.peekFirst() < windowSize){
                q.removeFirst();
            }

            if(arr[i] < 0){
                q.addLast(i);
            }

            if(!q.isEmpty()){
                result.add(arr[q.peekFirst()]);
            }else{
                result.add(0);
            }
        }
        return result;
    }
}