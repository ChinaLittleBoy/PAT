import java.util.Scanner;



public class Main {
	private static int min = Integer.MAX_VALUE;
	private static int minnum;
	private static int max;
	public static void main(String[] args){
		final int cities, roadNumber, origin, destination;
		Scanner s = new Scanner(System.in);
		cities = s.nextInt();
		roadNumber = s.nextInt();
		origin = s.nextInt();
		destination = s.nextInt();
		
		int[] people = new int[cities];
		for(int i=0;i<cities;i++)
			people[i] = s.nextInt();
		
		int[][] distance = new int[cities][cities];
		for(int i=0;i<cities;i++)
			for(int j=0;j<cities;j++)
				distance[i][j] = Integer.MAX_VALUE;
		for(int i=0;i<roadNumber;i++){
			int d1, d2;
			d1 = s.nextInt();
			d2 = s.nextInt();
			distance[d1][d2] = s.nextInt();
			distance[d2][d1] = distance[d1][d2];
		}
		
		int[] occupy = new int[cities];
		occupy[origin] = 1;
	
		BackTrack(people, distance, occupy, origin, destination, 0, people[origin]);
		
		System.out.println(minnum+" "+max);
		
		s.close();
	}
	
	public static void BackTrack(int[] people, int[][] distance, int[] occupy, int origin, int destination, int cost, int peo){
		if(cost>min) return ;
		if(occupy[destination]==1){
			
			if(cost<min){
				minnum = 1;
				min = cost;
				max = peo;
			}
			else if(cost==min){
				minnum ++;
				max = max > peo ? max : peo;
			}
			
			return ;
		}
		
		for(int i=0;i<occupy.length;i++)
			if(occupy[i]!=1){
				occupy[i] = 1;
				if(!(distance[origin][i]==Integer.MAX_VALUE)){
					BackTrack(people, distance, occupy, i, destination, cost+distance[origin][i], peo+people[i]);
				}
					
				occupy[i] = 0;
			}
	}
}
