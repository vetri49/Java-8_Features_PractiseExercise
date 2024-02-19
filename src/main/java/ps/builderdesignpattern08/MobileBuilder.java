package ps.builderdesignpattern08;

import java.util.function.Consumer;

public class MobileBuilder {
	
	int ram, storage;

	int battery;

	int camera;

	String processor;

	double screenSize;
	
		public MobileBuilder with(Consumer<MobileBuilder> buildFields) {
				buildFields.accept (this);
				return this;
	  }
		// Method to set RAM
        public MobileBuilder withRam(int ram) {
            this.ram = ram;
            return this;
        }

        // Method to set Storage
        public MobileBuilder withStorage(int storage) {
            this.storage = storage;
            return this;
        }

        // Method to set Battery
        public MobileBuilder withBattery(int battery) {
            this.battery = battery;
            return this;
        }

        // Method to set Camera
        public MobileBuilder withCamera(int camera) {
            this.camera = camera;
            return this;
        }

        // Method to set Processor
        public MobileBuilder withProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        // Method to set Screen Size
        public MobileBuilder withScreenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        // Build method to create Mobile object
        public Mobile createMobile() {
            return new Mobile(this);
        }
			
			

}
