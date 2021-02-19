package DynamicProgramming;

public class LängsteGemeinsameTeilfolge {
	public static void main(String[] args) {
		String a = "Tiger";
		String b = "Ziege";
		System.out.println(lGT(a,b));
		String a1 = "Hund";
		String b1 = "Mund";
		System.out.println(lGT(a1,b1));
	}
	public static String lGT(String a, String b){
		int n = a.length();
		int m = b.length();
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for(int j = 0; j <= m; j++) {
			dp[0][j] = 0;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				int x = 0;
				if(a.charAt(i-1) == b.charAt(j-1)) {
					x++;
				}
				dp[i][j] = Math.max(dp[i-1][j-1]+x, Math.max(dp[i-1][j], dp[i][j-1]));
			}
		}
		/*for(int i = 0; i <= n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}*/
		//Lösung Rekonstruieren
		String r = "";
		int i = n;
		int j = m;
		while(i > 0 && j > 0) {
			if(dp[i][j] == dp[i-1][j]) {
				i--;
			}else if(dp[i][j] == dp[i][j-1]){
				j--;
			}else {
				r += a.charAt(i-1);
				i--; j--;
			}
		}
		String result = "";
		int x = 0;
		while(x < r.length()) {
			result += r.charAt(r.length()-1-x);
			x++;
		}
		return result;
	}
	
}
