
public class Main {
	
	public static void main(String[] args){
		double[] e = {0.08,0.0,0.007,0.0,0.002,0.0,0.0006,0.0,0.00007,0.0};
		double rVal = 0.25;
		double cVal = 0;
		
		numIterations val = new numIterations(e,rVal,cVal);
		val.calc();
		
		double[] e2 = {0.0,0.06,0.0,0.02,0.0,0.0008,0.0,0.0003,0.0,0.00009};
		double rVal2 = -0.75;
		double cVal2 = 0;
		
		numIterations val2 = new numIterations(e2,rVal2,cVal2);
		val2.calc();
		
		double[] e3 = {(-0.03),Math.sqrt(0.03),(-0.02),Math.sqrt(0.02),(-0.007),Math.sqrt(0.007)
				,(-0.002), Math.sqrt(0.002),(-0.0007),Math.sqrt(0.0007)};
		double rVal3 = -1.25;
		double cVal3 = 0;
		
		numIterations val3 = new numIterations(e3,rVal3,cVal3);
		val3.calc();
		
		String[][] data2 = val2.toStringArray();
		String[][] data1 = val.toStringArray();
		String[][] data3 = val3.toStringArray();
		
		Table tab = new Table(data1, data2, data3);
		
		tab.returnTable();
		
	}

	
}
