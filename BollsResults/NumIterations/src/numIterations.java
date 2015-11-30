import java.util.Arrays;


public class numIterations {
	
	private final double[] e;
	private double zx, zy, cx, cy; 
	private double tmp;
	
	private final int MAX_ITERATIONS = 100000;
	private final int E_LEN = 10;
	private int tmpIterations;
	private int[] iterations = new int[E_LEN/2];
	
	private String[] tmpString = new String[4];
	private String[][] stringFinal = new String[5][4];
	private double tmpPiVal;
	
	public numIterations(double[]  e, double rVal, double cVal){	
		this.e = e;
		this.cx = rVal;
		this.cy = cVal;
		this.zx = 0;
		this.zy = 0;
	}
	
	public void calc(){
		for(int i = 0; i < e.length; i+=2){
			tmpIterations = 0;
			zx = 0;
			zy = 0;
		while(zx * zx + zy * zy < 4 && tmpIterations < MAX_ITERATIONS){
			tmp = zx * zx - zy * zy + cx + e[i];
			zy = 2.0 * zx * zy + cy + e[i+1];
			zx = tmp;
			tmpIterations++;		
		}
		iterations[(i/2)] = tmpIterations;
		
		}
	}
				
	
	
	public String[][] toStringArray(){
		
		for(int i = 0; i < iterations.length; i++){
			
			tmpString = new String[4];
			if(cx==-0.75){
				tmpString[0] = String.valueOf(cx) + " + " + String.valueOf(cy) + "i" + " + ei";
			
				tmpString[1] = String.valueOf(e[i*2 + 1]);
			
				tmpString[2] = "" + iterations[i];
				
				tmpPiVal =  e[i*2 + 1] * iterations[i];
			
				tmpString[3] = "" + tmpPiVal;
				
				stringFinal[i] = tmpString;
			}
			if(cx==0.25){
				tmpString[0] = String.valueOf(cx) + " + " + String.valueOf(cy) + "i" + " + e";
				
				tmpString[1] = String.valueOf(e[2*i]);
			
				tmpString[2] = "" + iterations[i];
			
			
				
				tmpPiVal =  Math.sqrt(e[2*i]) * iterations[i];
			
				tmpString[3] = "" + tmpPiVal;
				
				stringFinal[i] = tmpString;
				
				
			}
			if(cx==-1.25){
				
				tmpString[0] = String.valueOf(cx) + " - e^2 + " + String.valueOf(cy) + "i" + " + ei";
				
				tmpString[1] = String.valueOf(e[i*2 + 1]);
			
				tmpString[2] = "" + iterations[i];
			
				tmpPiVal =  2 * e[i*2 + 1] * iterations[i];
			
				tmpString[3] = "" + tmpPiVal;
				
				stringFinal[i] = tmpString;
				
			}
		}
		
		
		return stringFinal;
		
		
		
		
	}
	
	
	
			
}
