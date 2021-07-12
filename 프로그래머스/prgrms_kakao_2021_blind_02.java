class Solution {
    static int value;
	static int[][] map;
    public int solution(int n, int s, int a, int b, int[][] fares) {
    map = new int[n][n];
		
		for(int i=0;i<map.length;i++)
			for(int j=0;j<map[i].length;j++)
				map[i][j] = Integer.MAX_VALUE;
		
		for(int[] fare : fares) {
			map[fare[1]-1][fare[0]-1] = fare[2];
			map[fare[0]-1][fare[1]-1] = fare[2];
		}

		for(int i=0;i<n;i++)
			makeMinCostMap(n,i);
		
		for(int i=0;i<n;i++)
			map[i][i]=0;
		
		value = map[s-1][a-1] + map[s-1][b-1];	// 따로 탔을 경우

		
		for(int i=0;i<n;i++) {
			if(map[s-1][i]!=Integer.MAX_VALUE&&map[i][a-1]!=Integer.MAX_VALUE&&map[i][b-1]!=Integer.MAX_VALUE) {
				int value2 = 0;
				if(value>(map[s-1][i]+map[i][a-1]+map[i][b-1])){
					value = map[s-1][i]+map[i][a-1]+map[i][b-1];
				}
			}
		}
		
		return value;
	}
	
	public static void makeMinCostMap(int n, int v) {
		int values[] = new int[n];
		boolean[] visit = new boolean[n];
		
		for(int i=0;i<values.length;i++)
			values[i] = Integer.MAX_VALUE;
		visit[v] = true;
		
		for(int i=0;i<n;i++) {
			if(!visit[i] && map[v][i]!=Integer.MAX_VALUE) {
				values[i] = map[v][i];
			}
		}
		for(int j=0;j<n-1;j++) {
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			
			for(int i=0;i<n;i++) {
				if(!visit[i]&&values[i]<min) {
					min = values[i];
					minIndex = i;
				}
			}
			if(minIndex!=-1) {
				visit[minIndex] = true;
				for(int i=0;i<n;i++) {
					if(!visit[i]&&map[minIndex][i]!=Integer.MAX_VALUE&&(values[minIndex]+map[minIndex][i])<values[i]){ 
						values[i] = values[minIndex] + map[minIndex][i]; 
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			if(values[i]<map[v][i]) {
				map[v][i] = values[i];
				map[i][v] = values[i];
			}
				
		}
		
	}
}
