import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] matchNum = {0,0};
		HashSet<Integer> set = new HashSet<>();
        
        for(int i:win_nums)
        	set.add(i);
        
        for(int number:lottos) {
        	if(number!=0) {
        		if(set.contains(number)) {
        			matchNum[0]++;
        			matchNum[1]++;
        		}
        	}else {
        		matchNum[0]++;
        	}
        }
        
        for(int i=0;i<2;i++) {
        	if(matchNum[i]==6) {
        		matchNum[i]=1;
            }else if(matchNum[i]==5) {
            	matchNum[i]=2;
            }else if(matchNum[i]==4) {
            	matchNum[i]=3;
            }else if(matchNum[i]==3) {
            	matchNum[i]=4;
            }else if(matchNum[i]==2) {
            	matchNum[i]=5;
            }else {
            	matchNum[i]=6;
            }
        }
        
        return matchNum;
    }
}
