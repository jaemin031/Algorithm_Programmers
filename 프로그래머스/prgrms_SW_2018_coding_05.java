class Solution {
    public int solution(int[] d, int budget) {
        int answer = d.length;
		int spend = 0;
		
		quickSort(d, 0, d.length - 1);
		
		for(int i=0; i<d.length;i++) {
			if(spend+d[i]>budget) {
				return i;
			}else {
				spend += d[i];
			}
		}
		return answer;
		
	}

	static void quickSort(int[] nums, int left, int right) {
		int pl = left;
		int pr = right;
		int x = nums[(pl + pr) / 2];

		do {
			while (nums[pl] < x)
				pl++;
			while (nums[pr] > x)
				pr--;
			if (pl <= pr)
				swap(nums, pl++, pr--);

		} while (pl <= pr);
		if (left < pr)
			quickSort(nums, left, pr);
		if (right > pl)
			quickSort(nums, pl, right);
	}

	static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
