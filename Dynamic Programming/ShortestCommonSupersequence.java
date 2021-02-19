package DynamicProgramming;

public class ShortestCommonSupersequence {

	public static void main(String[] args) {
		String A="ABCDEFGHIJ";       // Read A as a string
        String B="ABGHIJFEDC";
        int n = 10;
        int m = 10;
        System.out.println(shortest_common_supersequence(n,m,A,B));
        int result = longestcommonsubsequence(n,m,A,B);
        System.out.println("Tada: " + result);
        int realresult = m+n-result;
        System.out.println("Tada2:"+ realresult);
	}
	public static int shortest_common_supersequence(int n, int m, String A, String B){
	      
	      int[][] SCS = new int[n+1][m+1]; // DP-Table 
	      //Base Cases
	      for(int i = 0; i <= n; i++){ //fill first column (A)
	        SCS[i][0] = i;
	      }
	      for(int i = 0; i <= m; i++){ //fill first row (B)
	        SCS[0][i] = i;
	      }
	      for(int i = 1; i <= m; i++){
	    	 //boolean c = false;
	         for(int j = 1; j <= n; j++){ //go through every 
	          if(B.charAt(i-1) == A.charAt(j-1) ){
	        	//System.out.println("A" + j + ": "+ A.charAt(j-1)+ " B"+ i + ": " + B.charAt(i-1));
	        	//c = true;
	            if(SCS[j-1][i] > SCS[j][i-1]){
	              SCS[j][i] = SCS[j-1][i]; 
	            }else{
	              SCS[j][i] = SCS[j][i-1];
	            }
	          }else if(SCS[j-1][i] < SCS[j][i-1] ){
	              SCS[j][i] = SCS[j-1][i] + 1;
	          }else{
	              SCS[j][i] = SCS[j][i-1] + 1;
	          }
	          }
	          
	        }
	     //Test Sequence
	      System.out.print("    ");
	     for(int i = 0; i < m; i++) {
	    	 System.out.print(B.charAt(i)+ " ");
	     }
	     System.out.println();
	     for(int i = 0; i <= n; i++) {
	    	 if(i != 0) {
	    	 System.out.print(A.charAt(i-1)+ " ");
	    	 }else {
	    		 System.out.print("  ");
	    	 }
	    	  for(int j = 0; j <= m; j++) {
	    		  
	    		  System.out.print(SCS[i][j]+ " ");
	    	  }
	    	  System.out.println();
	      }
	      int result = SCS[n][m];
	      return result;
	      
	    }
	public static int longestcommonsubsequence(int n,int m,String A,String B) {
		int[][] dp = new int[n+1][m+1];
		//Base Cases
		for(int i = 0; i <= n || i <= m; i++) {
			if(i <= n) {
				dp[i][0] = 0;
			}
			if(i <= m) {
				dp[0][i] = 0;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				int x = 0;
				if(A.charAt(i-1) == B.charAt(j-1)) {
					x = 1; 	
				}
				if(dp[i-1][j-1] +x > dp[i][j-1] && dp[i-1][j-1]+x > dp[i-1][j] ) {
					dp[i][j] = dp[i-1][j-1]+x;
					System.out.println("von oben links gekommen: i:" +i+ " j:"+ j);
				}else if(dp[i-1][j] > dp[i][j-1]) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = dp[i][j-1];
				}
			} 
		}
		
		System.out.print("    ");
	    for(int i = 0; i < m; i++) {
	    	 System.out.print(B.charAt(i)+ " ");
	    }
	    System.out.println();
		for(int i = 0; i <= n; i++) {
	    	 if(i != 0) {
	    	 System.out.print(A.charAt(i-1)+ " ");
	    	 }else {
	    		 System.out.print("  ");
	    	 }
	    	  for(int j = 0; j <= m; j++) {
	    		  
	    		  System.out.print(dp[i][j]+ " ");
	    	  }
	    	  System.out.println();
	      }
		return dp[n][m];
		
	}
}
