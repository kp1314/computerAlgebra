public class Julia3 {

private static final int countermax = 50;	
  public static void main(String[] args) {
    Picture newpicture = Utils.createPicture(1051,1051);
      for(int x = 0; x < newpicture.getWidth(); x++) {
        for(int y = 0; y <newpicture.getHeight(); y++){
	      int actualx =0;
	      int actualy =0;
          actualx = convertcomplex_x(newpicture, x); 
          actualy = convertcomplex_y (newpicture,y);
          
		  double z_realvalue = (double)actualx / 400;
		  double z_imgvalue = (double) actualy / 400;
		 
		  double c_realvalue =-0.8;
		  
		  double c_imgvalue = -0.15; 
		  
		  double modulos = 0;	
		  int counter = 0;
		  double temp = 0;
		
	      while (modulos <= 2) {
	        if (counter == countermax) {
	          break;
	        }
	    	temp = (double)Math.pow(z_realvalue, 2.0) - 
	    			Math.pow(z_imgvalue,2.0) + c_realvalue;   
	        z_imgvalue = (double)2*z_realvalue*z_imgvalue + c_imgvalue;
	        z_realvalue = temp;
	        modulos = (double)(Math.sqrt(Math.pow(z_realvalue,2)+ 
	        		Math.pow(z_imgvalue,2)));  
	        counter++;
	    	 
	      }
	      newpicture.setPixel(x, y, colour(counter));
	    }
      }
      Utils.savePicture(newpicture, "/tmp/testing.png");  
  }
   
  public static int convertcomplex_x (Picture newpicture, int x) {
    int width = (newpicture.getWidth());
    int center_x = (int)(width -(width/2));
    int xvalue = x - center_x;
	return xvalue;	 
  } 

  public static int convertcomplex_y (Picture newpicture, int y) {
    int center_y = (newpicture.getHeight()-1)/2;
    int yvalue = center_y-y;
	return yvalue;
  } 
   
  public static Color colour(int counter) {
	double eachstep = 3*Math.PI/(2*countermax); 
	  int red2 = (int) (255*Math.sin(eachstep*counter)); 
	  int green2 = (int)(255*Math.sin(eachstep*counter-(Math.PI/2)));
	  int blue;
	  if(eachstep*counter>=0 && eachstep*counter<= Math.PI/2) {
	    blue = (int) (255*Math.cos(eachstep*counter));
	  }
	  else if(eachstep*counter>= Math.PI && eachstep*counter <= 3*Math.PI/2){
	    blue = (int) (255*Math.sin(eachstep*counter-Math.PI));
	  }else {
	    blue = 0; 
	  }
	  if (red2 < 0 ){
	    red2 = 0;
	  }
	  if (green2 < 0) {
	    green2 = 0;
	  }
	  if(counter == countermax){
	    Color idcolor = new Color(0, 0,0);  
	    return idcolor;	
	  }else{
		Color idcolor = new Color(red2, green2,blue);  
	    return idcolor;
	  }
		   
    } 
  }