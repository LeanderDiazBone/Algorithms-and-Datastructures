package DynamicProgramming;

public class Lights {
	public static void main(String[] args) {
		boolean[] lights = {true, true, true, true, false, true, true, false, true, false, true, true, false, false};
		int operations = minOp(lights);
		System.out.println(operations);
	}
	public static int minOp(boolean[] lights) {
		int n =  lights.length;
		int[] dpON = new int[n+1];
		int[] dpOF = new int[n+1];
		dpON[0] = 0;
		dpOF[0] = 0;
		for(int i = 1; i <= n; i++) {
			if(!lights[i-1]) {
				dpOF[i] = dpOF[i-1];
				dpON[i] = Math.min(dpON[i-1], dpOF[i-1])+1;
			}else {
				dpON[i] = dpON[i-1];
				dpOF[i] = Math.min(dpON[i-1], dpON[i-1])+1;
			}
		}
		return dpOF[n];
	}
}
