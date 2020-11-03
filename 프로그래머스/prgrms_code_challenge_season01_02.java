import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        int[][] mat = new int[n][n];
		List<Integer> list = new ArrayList<>();
		int size=0;
		for(int i=1;i<=n;i++) {
			size +=i;
		}
		
		int left = 0;
		int down = n;
		int right = n;
		int up = 0;
		int count=1;
		
        while(count!=size+1) {
        	for(int i=up;i<down;i++) {
        		if(count-1==size)
        			break;
        		mat[i][left] = count;
        		count++;
        	}
        	left++;
        	for(int i=left;i<right;i++) {
        		if(count-1==size)
        			break;
        		mat[down-1][i] = count;
        		count++;
        	}
        	down--;
        	right --;
        	for(int i=down, j=right;i>up&&j>left;i--,j--) {
        		if(count-1==size)
        			break;
        		mat[i-1][j-1] = count;
        		count++;
        	}
        	up +=2;
        	right--;
        }
        for(int i=0;i<mat.length;i++) {
        	for(int j=0; j<mat[i].length;j++) {
        		if(mat[i][j]!=0)
        			list.add(mat[i][j]);
        	}
        }

        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
