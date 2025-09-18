import java.util.*;

class Solution {
    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while (q.size() > 0) {
            s.push(q.remove());
        }

        while (s.size() > 0) {
            q.add(s.pop());
        }
    }
}