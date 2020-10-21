class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder stb = new StringBuilder();
		int l = 9;
		int r = 11;
		for(int n : numbers) {
			if(n==1||n==4||n==7) {
				l=n-1;
				stb.append("L");
			}else if(n==3||n==6||n==9) {
				r=n-1;
				stb.append("R");
			}else {
				if(n==0) {
					n=11;
				}
				n = n-1;
				int dis_l = Math.abs((l/3)-(n/3))+Math.abs((l%3)-(n%3));
				int dis_r = Math.abs((r/3)-(n/3))+Math.abs((r%3)-(n%3));
				
				if(dis_l==dis_r) {
					if(hand.equals("left")) {
						l=n;
						stb.append("L");
					}else {
						r=n;
						stb.append("R");
					}
				}else if(dis_l<dis_r) {
					l=n;
					stb.append("L");
				}else {
					r=n;
					stb.append("R");
				}		
			}
		}
		return stb.toString();
    }
}
