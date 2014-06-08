import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		int input1, input2;
		double[] polycoefficients = new double[1001];
		Scanner s = new Scanner(System.in);
		input1 = s.nextInt();
		
		while(input1-->0){
			int exponent;
			double coefficient;
			exponent = s.nextInt();
			coefficient = s.nextDouble();
			polycoefficients[exponent] += coefficient;
		}
		
		input2 = s.nextInt();
		while(input2-->0){
			int exponent;
			double coefficient;
			exponent = s.nextInt();
			coefficient = s.nextDouble();
			polycoefficients[exponent] += coefficient;
		}
		
		int count = 1001;
		int num = 0;
		String res = "";
		while(count-->0){
			if(polycoefficients[count]!=0){
				DecimalFormat dcmFmt = new DecimalFormat("0.0");
				res = res + " " + count + " " + dcmFmt.format(polycoefficients[count]);
				num ++;
			}
		}
		if(res.equals("")){
			res = "0";
		}
		else
			res = num + res;
		
	
		System.out.println(res);
	}
}
