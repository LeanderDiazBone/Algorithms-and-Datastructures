package DynamicProgramming;

public class Maximising_an_Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Operand = {9, -9, 3, -8, -3, 4, -4, -2, 2, 4};
		char[] Operator = {'+','*','+','+','+','+','+','+','*'}; 
		//int[] Operand = {9, -9, 3, -8};
		int n = Operand.length;
		//char[] Operator = {'+','*','+'};
		System.out.println("Result: "+maximizing_an_expression(n,Operand,Operator));
	}
	private static int maximizing_an_expression(int n, int[] Operand, char[] Operator) {
		int[][] MinTB = new int[n][n];
		int[][] MaxTB = new int[n][n];
		//Base Cases 
		for(int i = 0; i < n; i++) {
			MinTB[i][i] = Operand[i];
			MaxTB[i][i] = Operand[i];
		}
		
		//fill Tables
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-1-i; j++) {
				int k = j+i+1;
				//for-Schleife um die Operationen durchzugehen
				int max = 0;
				int curmax;
				int min = 0;
				int curmin;
				for(int v = 0; v < i+1; v++) {	//denke ist richtig
					
					char op = Operator[j+v]; //denke ist richtig
					System.out.println("i: "+i+" j: "+j+" k: "+k+ " v: "+v+" "+ "op: "+op);
					if(op == '+') {
					curmax = MaxTB[j][j+v] + MaxTB[j+v+1][k];
					curmin = MinTB[j][j+v] + MinTB[j+v+1][k];	
					
					}else {
					curmax = Math.max(Math.max(MaxTB[j][j+v] * MaxTB[j+v+1][k], MinTB[j][j+v] * MinTB[j+v+1][k]), Math.max(MaxTB[j][j+v] * MinTB[j+v+1][k], MinTB[j][j+v] * MaxTB[j+v+1][k]));
					curmin = Math.min(Math.min(MaxTB[j][j+v] * MaxTB[j+v+1][k], MinTB[j][j+v] * MinTB[j+v+1][k]), Math.min(MaxTB[j][j+v] * MinTB[j+v+1][k], MinTB[j][j+v] * MaxTB[j+v+1][k]));	
					}
					
					if(v == 0) {
						max = curmax;
						min = curmin;
					}else {
						max = Math.max(curmax, max);
						min = Math.min(curmin, min);
					}
				}
				MaxTB[j][k] = max; 
				MinTB[j][k] = min; 
				
				/*
				//Erste Operation berechne max / min aus der Operation, die das erste Element der Zeile mit dem Rest verrechnet
				char ope1 = Operator[j];
				int maxope1;
				int minope1;
				if(ope1 == '+') { 	//Addition
					maxope1 = MaxTB[j][j] + MaxTB[j+1][k];
					minope1 = MinTB[j][j] + MinTB[j+1][k];
				}else {	//Multiplikation
					int maxopt1 = MaxTB[j][j] * MaxTB[j+1][k];
					int maxopt2 = MinTB[j][j] * MinTB[j+1][k];
					int maxopt3 = MaxTB[j][j] * MinTB[j+1][k];
					int maxopt4 = MinTB[j][j] * MaxTB[j+1][k];
					
					maxope1 = Math.max(Math.max(maxopt1, maxopt2),Math.max( maxopt3, maxopt4));
					//System.out.println("Stelle 1: "+j+" Stelle 2: "+k+ " maxope1: "+maxope1);
					
					int minopt1 = MaxTB[j][j] * MaxTB[j+1][k];
					int minopt2 = MinTB[j][j] * MinTB[j+1][k];
					int minopt3 = MaxTB[j][j] * MinTB[j+1][k];
					int minopt4 = MinTB[j][j] * MaxTB[j+1][k];
					minope1 = Math.min(Math.min(minopt1, minopt2),Math.min( minopt3, minopt4));
				}
				
				//Zweite Operation berechne max / min aus der Operation, die den ersten Teil mit dem letzten Element verrechnet
				char ope2 = Operator[k-1]; //Stimmt das?
				int maxope2;
				int minope2;
				if(ope2 == '+') { //Addition
					maxope2 = MaxTB[k][k] + MaxTB[j][k-1];
					minope2 = MinTB[k][k] + MinTB[j][k-1];
				}else { //Multiplikation
					int maxopt1 = MaxTB[k][k] * MaxTB[j][k-1];
					int maxopt2 = MinTB[k][k] * MinTB[j][k-1];
					int maxopt3 = MaxTB[k][k] * MinTB[j][k-1];
					int maxopt4 = MinTB[k][k] * MaxTB[j][k-1];
					
					maxope2 = Math.max(Math.max(maxopt1, maxopt2),Math.max( maxopt3, maxopt4));
					//System.out.println("Stelle 1: "+j+" Stelle 2: "+k+ " maxope2: "+maxope2);
					int minopt1 = MaxTB[k][k] * MaxTB[j][k-1];
					int minopt2 = MinTB[k][k] * MinTB[j][k-1];
					int minopt3 = MaxTB[k][k] * MinTB[j][k-1];
					int minopt4 = MinTB[k][k] * MaxTB[j][k-1];
					minope2 = Math.min(Math.min(minopt1, minopt2),Math.min( minopt3, minopt4));
				}
				
				//Berechne Maximum /Minimum aus beiden Operationen
				MaxTB[j][k] = Math.max(maxope1, maxope2);
				MinTB[j][k] = Math.min(minope1, minope2);
				*/
					
			}
		}
		
		//Print Tables
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(MaxTB[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(MinTB[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		
		return MaxTB[0][n-1];
	}

}
