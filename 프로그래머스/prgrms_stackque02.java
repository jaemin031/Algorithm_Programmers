import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int num = Integer.MIN_VALUE;
        int count = 1;
        int tmp;
        
        for(int i=0; i<progresses.length;i++) {
        	for(int j=1;j<100;j++) {
        		if(progresses[i]+(j*speeds[i])>=100) {
        			que.add(j);
        			break;
        		}
        	}
        }
        
       while(!que.isEmpty()) {
    	   int num2 = que.poll();
    	   if(num>num2) {
    		   arr1.add(num);
    	   }else {
    		   num = num2;
    		   arr1.add(num2);
    	   }
       }

       tmp = arr1.get(0);
       for(int i=1;i<arr1.size();i++) {
    	   if(tmp == arr1.get(i)) {
    		   count++;
    	   }else {
    		   tmp = arr1.get(i);
    		   arr2.add(count);
    		   count = 1;
    	   }
       }
       arr2.add(count);
       
       answer = new int[arr2.size()];
       for(int i=0;i<arr2.size();i++) {
    	   answer[i] = arr2.get(i);
       }
       
        return answer;
    }
}
