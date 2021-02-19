package DynamicProgramming;
import java.util.Arrays;

public class Energy {

	public static void main(String[] args) {
		boolean[] road = {true, false, false, true, true, false, true, true, false, true, true, true, true, true, false, true, true, false,
				true,
				true,
				false,
				false,
				true,
				false};
			int energy = energy_for_trip(road);
			System.out.println(energy);

	}
	private static int energy_for_trip(boolean [] road){
	      int n = road.length;
	      int[] energy = new int[n];
	      for(int i = 0; i < n; i++){
	      if(road[i] == false){
	        if((i-6) >= 0){
	          if((energy[i-6]+8) < (energy[i-1]+1)){
	            energy[i] = energy[i-6]+8;
	          }else{
	            energy[i] = energy[i-1]+1;
	          }
	          
	        }else{
	          if(i > 0) {
	            energy[i] = energy[i-1]+1;
	          }else{
	            energy[i] = 1;
	          }
	        }
	        
	      }else{ //wand == true
	        if(i > 0) {
	         energy[i] = energy[i-1] + 2;
	        }else {
	          energy[i] = 2;
	        }
	      }
	      
	    }

	     System.out.println(Arrays.toString(energy));
	    return energy[n-1];
	  
	}
}
