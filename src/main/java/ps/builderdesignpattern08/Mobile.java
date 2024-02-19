package ps.builderdesignpattern08;

public class Mobile {
	
	int ram, storage;

	int battery;

	int camera;

	String processor;

	double screenSize;
	
	public Mobile (MobileBuilder mobileBuilder) {

		this.ram= mobileBuilder.ram;

		this.storage= mobileBuilder.storage;

		this.battery =mobileBuilder.battery;

		this.camera = mobileBuilder.camera;

		this.processor= mobileBuilder.processor;

		this.screenSize = mobileBuilder.screenSize;

}

	@Override
	public String toString() {
	       return "Specifications RAM: " + ram + " Storage: " + storage + " Battery: " + battery
	    		   +" Camera: "+camera+" Processor: "+processor+" Display: "+screenSize;
	       }
	
	
}
