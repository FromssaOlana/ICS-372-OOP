
package refrigerator;


public interface RefrigratorDisplay {
    public void setRefrigrator(Refrigrator refrigrator);
 
	public void fridgeturnLightOn();

	
	public void fridgeturnLightOff();

	public void fridgestartCooling();

	public void fridgeidle();
        
       
        public void setFridgeTemp(int value);
        
        //Freezer
        public void freezerturnLightOn();

	
	public void freezerturnLightOff();

	public void freezerstartCooling();

	public void freezeridle();
        
       
        public void setFreezerTemp(int value);
    
}