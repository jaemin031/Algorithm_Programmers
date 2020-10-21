import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(int N, int[] stages) {
        class stage implements Comparable<stage>{
			 int num;
			 double miss;
			 
			 public stage(int num, double miss) {
				 this.num = num;
				 this.miss = miss;
			 }

			@Override
			public int compareTo(stage o) {
				if(this.miss == o.miss) {
					return this.num - o.num;
				}else
					return this.miss > o.miss ? -1 : 1;
			}
		 }
		 
		 ArrayList<stage> arr = new ArrayList<>();
		 
		 for(int i=0;i<N;i++) {
			 int arrival = 0;
			 int nClear = 0;
			 for(int j=0;j<stages.length;j++) {
				 if(stages[j]>=i+1) {
					 arrival++;
					 if(stages[j]==i+1) {
						 nClear++;
					 }
				 }
			 }
			 if(arrival==0||nClear==0) {
				 arr.add(new stage(i+1,0));
			 }else {
				 arr.add(new stage(i+1,(double)nClear/arrival));
			 }
		 }
		 Collections.sort(arr);;
		 
		 int[] answer = new int[arr.size()];
		 for(int i=0;i<arr.size();i++) {
			 answer[i] = arr.get(i).num;
		 }
		 
	        return answer;
    }
}
