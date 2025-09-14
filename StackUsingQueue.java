import java.util.*;

class Solution{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int a){
        q1.add(a);
    }

    int pop(){
        if(q1.isEmpty()){
            return -1;
        }

        while(q1.size() > 1){
            q2.add(q2.remove());
        }

        int data = q1.remove();
        Queue<Integer> temp = new LinkedList<>();
        q1 = q2;
        q2 = temp;

        return data;
    }
}