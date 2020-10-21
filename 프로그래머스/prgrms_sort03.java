class Solution {
    public int solution(int[] citations) {
        int[] sortarr = new int[citations.length];
		int max = 0;
		
		for(int i=0;i<citations.length;i++)
			sortarr[i] = citations[i];
		
		for(int i=0;i<sortarr.length-1;i++) {
			for(int j=i+1;j<sortarr.length;j++) {
				if(sortarr[i]>sortarr[j]) {
					int tmp = sortarr[i];
					sortarr[i] = sortarr[j];
					sortarr[j] = tmp;
				}
			}
		}
		max = sortarr.length;
		
		for(int i=0; i<sortarr.length;++i) {
			if(sortarr[i] >= max)
				return max;
			else max--;
		}
		
		return max;
    }
}
