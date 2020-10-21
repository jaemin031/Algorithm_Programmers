import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        class truckVO{
			int weight;
			int time;
			
			truckVO(int weight,int time){
				this.weight = weight;
				this.time = time;
			}
		}
		int time = 0;
		int total = 0;
		Queue<truckVO> truckWait = new LinkedList<>();
		Queue<truckVO> bridge = new LinkedList<>();
		
		for(int i : truck_weights) {
			truckWait.offer(new truckVO(i,0));
		}
		
		while(!truckWait.isEmpty() || !bridge.isEmpty()) {
			time++;
			if(!bridge.isEmpty()) {
				if(time - bridge.peek().time >= bridge_length) {
					total -= bridge.peek().weight;
					bridge.poll();
				}
			}
			
			if(!truckWait.isEmpty()) {
				if(total + truckWait.peek().weight <= weight) {
					total += truckWait.peek().weight;
					bridge.offer(new truckVO(truckWait.peek().weight,time));
					truckWait.poll();
				}
			}
		}
		
        return time;
    }
}
