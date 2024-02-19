package ps.builderdesignpattern08;

public class TestBuilderPattern {

	public static void main(String[] a) {
		 Mobile mobile = new MobileBuilder()
	                .withRam(4)
	                .withStorage(0)
	                .withBattery(4000)
	                .withCamera(0)
	                .withProcessor("A12 Bionic")
	                .withScreenSize(000000.00)
	                .createMobile();

	        // Display the specifications
	        System.out.println(mobile);
		
	}
}
