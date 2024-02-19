package ps.lambdaexpressions02;

import java.util.Random;

interface MedicineInfo {
 void displayLabel();
}

class Tablet implements MedicineInfo {
	
 @Override
 public void displayLabel() {
     System.out.println("Tablet: Store in a cool dry place");
 }
}

class Syrup implements MedicineInfo {
	
 @Override
 public void displayLabel() {
     System.out.println("Syrup: Shake well before use");
 }
}


class Ointment implements MedicineInfo {
 @Override
 public void displayLabel() {
     System.out.println("Ointment: For external use only");
 }
}

public class TestMedicine {
 public static void main(String[] args) {
     
     MedicineInfo[] medicines = new MedicineInfo[10];

     Random random = new Random();
    

     
     for (int i = 0; i < 10; i++) {
    	 int randomType = random.nextInt(3)+1;
         switch (randomType) {
             case 1:
                 medicines[i] = new Tablet();
                 break;
             case 2:
                 medicines[i] = new Syrup();
                 break;
             case 3:
                 medicines[i] = new Ointment();
                 break;
         }
     }

     
     for (MedicineInfo medicine : medicines) {
         medicine.displayLabel();
     }
 }
}
