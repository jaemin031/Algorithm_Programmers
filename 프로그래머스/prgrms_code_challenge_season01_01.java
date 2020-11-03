import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<numbers.length-1;i++) {
			int num1 = numbers[i];
			for(int j=i+1;j<numbers.length;j++) {
				int num2 = numbers[j];
				
				if(list.contains(num1+num2)) {
					continue;
				}else {
					list.add(num1+num2);
				}
			}
		}
		
		list.sort(null);
		
		return list.stream().mapToInt(i -> i).toArray();
    }
}
