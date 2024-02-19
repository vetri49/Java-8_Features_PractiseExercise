package ps.lambdaexpressions02;


interface Instruements{
	void play();
}
class Piano implements Instruements{
	

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Piano is playing tan tan tan tan");
	}
}
class Flute implements Instruements{

	@Override
	public void play() {
		// TODO Auto-generated method stub
	   System.out.println("Flute is playing toot toot toot toot");	
	}
	
}

class Guitar implements Instruements{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Guitar is playing tin tin tin tin");
	}
	
}
public class TestInstruements {
	
	public static void main (String[] a) {
		
		Instruements[] instruments = new Instruements[10];

        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                instruments[i] = new Piano();
            } else if (i % 3 == 1) {
                instruments[i] = new Flute();
            } else {
                instruments[i] = new Guitar();
            }
        }
		for (int i = 0; i < 10; i++) {
            instruments[i].play();
            if (instruments[i] instanceof Piano) {
                System.out.println("Object at index " + i + ": Piano");
            } else if (instruments[i] instanceof Flute) {
                System.out.println("Object at index " + i + ": Flute");
            } else if (instruments[i] instanceof Guitar) {
                System.out.println("Object at index " + i + ": Guitar");
            }
        }
		
	}

	

}
