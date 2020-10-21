class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
	        int num = 0;
	        int tmp;
	        
	        for(int i=0;i<commands.length;i++) {
	        	int[] ar = new int[commands[i][1]-commands[i][0]+1];
	        	int count=0;
	        	for(int j=commands[i][0]-1;j<commands[i][1];j++) {
	        		ar[count]=array[j];
	        		count++;
	        	}
	        	for(int m=0;m<count-1;m++) {
	        		for(int n=m+1;n<count;n++) {
	        			if(ar[m]>ar[n]) {
	        				tmp=ar[m];
	        				ar[m]=ar[n];
	        				ar[n]=tmp;
	        			}
	        		}
	        	}
	        	answer[num] = ar[commands[i][2]-1];
	        	num++;
	        }

	        return answer;
	    }
}
