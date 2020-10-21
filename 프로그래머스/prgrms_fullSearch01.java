import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
       int[] answer = {0,0,0};
		int[] human1 = {1,2,3,4,5};
		int[] human2 = {2,1,2,3,2,4,2,5};
		int[] human3 = {3,3,1,1,2,2,4,4,5,5};
		int max = 0;
		int[] answer1;
		ArrayList<Integer> arr = new ArrayList<>();
		
		
		for(int i=0;i<answers.length;i++) {
			if((human1[i%5])==answers[i]) {
				answer[0]++;
			}
			if((human2[i%8])==answers[i]) {
				answer[1]++;
			}
			if((human3[i%10])==answers[i]) {
				answer[2]++;
			}
		}
		
		max = Math.max((answer[0]>answer[1] ? answer[0] : answer[1]), answer[2]);
		
		for(int i=0;i<answer.length;i++)
			if(answer[i]==max)
				arr.add(i+1);
		
		answer1 = new int[arr.size()];
		for(int i=0;i<answer1.length;i++)
			answer1[i] = arr.get(i);
        
        return answer1;
    }
}
