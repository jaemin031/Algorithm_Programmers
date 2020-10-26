class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int result = n;
		boolean[] std = new boolean[n];
		boolean[] remain = new boolean[n];
		
		for(int i : reserve)
			remain[i-1] = true;
		
		for(int i : lost) {
			if(remain[i-1]) {
				remain[i-1] = false;
				continue;
			}
			std[i-1] = true;
		}
		
		for(int i=0;i<n;i++) {
			if(std[i]) {
				if(i>=1&&remain[i-1]) {
					std[i] = !std[i];
					remain[i-1] = !remain[i-1];
				}else if(i<n-1&&remain[i+1]) {
					remain[i+1] = !remain[i+1];
					std[i] = !std[i];
				}else
					result--;
			}
		}
			
        return result;
    }
}
