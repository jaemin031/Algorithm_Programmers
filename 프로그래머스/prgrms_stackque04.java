import java.util.PriorityQueue;
class Solution {
    public int solution(int[] priorities, int location) {
        class doc implements Comparable<doc>{
			int id;
			int priority;
			
			public doc(int id, int priority) {
				this.id = id;
				this.priority = priority;
			}

			public int getPriority() {
				return priority;
			}
			
			@Override
		    public int compareTo(doc d) {
		        return this.priority <= d.priority ? 1 : - 1;
		    }
			/*
			@Override
			public String toString() {
				return "id = " + id + " / prior = " + priority;
			}
			*/
		}
		
		int count = 1;
		PriorityQueue<doc> que = new PriorityQueue<>();
		
		for(int i=0;i<priorities.length;i++) {
			que.offer(new doc(i,priorities[i]));
		}
		
		while(!que.isEmpty()) {
			for(int i=0; i<priorities.length;i++)
				if(priorities[i] == que.peek().getPriority()) {
					if(location == i) {
						return count;
					}
					count++;
					que.poll();
				}
		}
		

		
        return count;
    }
}
