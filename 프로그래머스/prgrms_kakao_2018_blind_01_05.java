class Solution {
    public int solution(String[] lines) {
       int answer = 0;
		if(lines.length==0)
			return 0;
		if(lines.length==1)
			return 1;
		
		int[][] time = new int[lines.length][2];

		for(int i=0;i<lines.length;i++) {
			String[] st = lines[i].split(" ");
			String[] st2 = st[1].split(":");

			time[i][1] = (Integer.parseInt(st2[0])*3600000)+(Integer.parseInt(st2[1])*60000)+(int)(Double.parseDouble(st2[2])*1000);
			time[i][0] = time[i][1]-(int)(Double.parseDouble(st[2].substring(0,st[2].length()-1))*1000)+1;
		}
		
		for(int i=0;i<time.length;i++) {
			for(int j=0;j<2;j++) {
				int checkTime = time[i][j];
				
				int count = timeCalc(time, checkTime, checkTime+1000);
				answer = count>answer?count:answer;
				
				
			}
		}
		
		
        return answer;
    }
	
	public static int timeCalc(int[][] time, int startTime, int endTime) {
		int checkResult = 0;
		for(int i=0;i<time.length;i++) {
			if(startTime<=time[i][0]&&time[i][0]<endTime) {
				checkResult++;
			}else if(startTime<=time[i][1]&&time[i][1]<endTime) {
				checkResult++;
			}else if(time[i][0]<=startTime&&time[i][1]>=endTime) {
				checkResult++;
			}
		}
		return checkResult;
	}
}
