import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] nums) {
        List<Integer> list = new ArrayList<>();
        dfs(list,0,nums,0);
        return answer;
    }

	public void dfs(List<Integer> list, int sum, int[] nums,int now) {
		if(list.size()==3) {
			Set<Integer> set = new HashSet<>(list);
			if(set.size()==3&&isPrime(sum))
				answer++;
			return;
		}else {
			for(int i = now;i<nums.length;i++) {
				List<Integer> list2 = new ArrayList<>(list);
				list2.add(nums[i]);
				dfs(list2,sum+nums[i],nums,i);
			}
			
		}
		
	}
	
	public boolean isPrime(int n) {
		for(int i = 2; i<n;i++)
			if(n%i==0)
				return false;
		return true;
	}
}
