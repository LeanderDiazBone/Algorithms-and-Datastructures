package Datenstrukturen;
import java.util.InputMismatchException;

public class MyMatrix {
	public static void main(String[] args) {
		double[][] A1 = {{1,-4,8},{8,4,1},{-4,7,4}};
		MyMatrix M1 = new MyMatrix(A1);
		M1.smul((1.0/9.0));
		double[][] A2 = {{1,8,-4},{-4,4,7},{8,1,4}};
		MyMatrix M2 = new MyMatrix(A2);
		double[][] A3 = {{1,0,0},{0,-1,0},{0,0,0}};
		MyMatrix M3 = new MyMatrix(A3);
		System.out.println(M3.toString());
		M3.smul(1.0/9.0);
		MyMatrix R1 = M3.mul(M2);
		System.out.println(R1.toString());
		MyMatrix R = M1.mul(R1);
		System.out.println(R.toString());
		R.smul(9);
		System.out.println(R.toString());
	}
	public double[][] A;
	public int m;
	public int n;
	//Konstruktoren
	public MyMatrix(int m, int n) {
		if(m < 1 || n < 1) {
			throw new InputMismatchException();
		}
		A = new double[m][n];
		this.m = m;
		this.n = n;
	}
	
	public MyMatrix(double[][] A) {	//Konstruktor für eine zwei Dimensionale Tabelle
		this.A = A;
		this.m = A.length;
		this.n = A[0].length;
	}
	
	public MyMatrix(int m) {	//Konstruktor für quadratische Matrizen
		this.A = new double[m][m];
		this.m = m;
		this.n = m;
	}
	
	public void torandomMatrix(){	//Setzt Werte random auf entweder 1 oder 0 zurück
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				A[i][j] = Math.round(Math.random());
			}
		}
	}
	public void torandomMatrix2(int k) {	//Setzt Werte random zwischen 0 und k zurück
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				A[i][j] = Math.random()*k;
			}
		}
	}
	
	public void toIdentity() {
		if(!isQuadratic()) {
			throw new InputMismatchException("Die Matrix ist nicht Quadratisch");
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					A[i][j] = 1.0;
				}else {
					A[i][j] = 0.0;
				}
			}
		}
	}
	public MyMatrix mul(MyMatrix B){
		if(m != B.n) {
			throw new InputMismatchException("Matrizen haben nicht die richtigen Dimensionen");
		}
		MyMatrix C = new MyMatrix(m, B.n);
		for(int i = 0; i < C.m; i++) {
			for(int j = 0; j < C.n; j++) {
				for(int k = 0; k < n; k++) {
					C.A[i][j] += A[i][k] * B.A[k][j];
				}
			}
		}
		return C;
	}
	public MyMatrix add(MyMatrix B) {
		if(n != B.n || m != B.n) {
			throw new InputMismatchException("Matrizen haben nicht die richten Dimensionen!");
		}
		MyMatrix C = new MyMatrix(m,n);
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				C.A[i][j] = A[i][j] + B.A[i][j];
			}
		}
		return C;
	}
	public void smul(double s) {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				A[i][j] = A[i][j] * s;
			}
		}
	}
	public double getDet() { //noch zu implementieren
		if(!isQuadratic()) {
			throw new InputMismatchException("Determinante von einer nicht quadratischen Matrix ist nicht definiert!");
		}
		int det = 1;
		if(isTriangleMatrix()) {
			for(int i = 0; i < m; i++) {
				det *= A[i][i];
			}
		}else {
			throw new InputMismatchException("Unable to compute Gaus");
		}
		return det;
	}
	public MyMatrix gauss() {	//noch zu implementieren
		MyMatrix G = new MyMatrix(this.A);
		return G;
	}
	public int[] getEigenvalues() {	//noch zu implementieren
		if(!isQuadratic()) {
			throw new InputMismatchException("Die Eigenwerte der Matrix können nicht bestimmt werden, da sie nicht quadratisch ist!");
		}
		int[] eig = new int[n];
		
		return eig;
	}
	public boolean isQuadratic() {
		if(m == n) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isDiagonalMatrix() {
		if(!isQuadratic()) {
			return false;
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j && A[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean isTriangleMatrix() {
		if(isUpperTriangleMatrix() || isLowerTriangleMatrix()) {
			return true;
		}else {
			return false;
		}
		
	}
	public boolean isUpperTriangleMatrix() {
		if(!isQuadratic()) {
			return false;
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i < j && A[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean isLowerTriangleMatrix() {
		if(!isQuadratic()) {
			return false;
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i > j && A[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	public String toString() {
		String s = "";
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				s += A[i][j]+" ";
			}
			s += System.lineSeparator();
		}
		return s;
	}
}