
public class Main {
	public static void main(String[] args) {

		int noOfThreads = 5;
		Thread[] threads = new Thread[noOfThreads]; // creating Thread array
		for (int i = 0; i < noOfThreads; ++i)
			threads[i] = new Thread(Main::sendToChocolateBoiler, "Thread " + String.valueOf(i + 1));
		for (int i = 0; i < noOfThreads; ++i)
			threads[i].start();

	}

	public static void sendToChocolateBoiler() {
		ChocolateBoiler boiler = ChocolateBoiler.getUniqueInstance();
		System.out.println("The service reference is " + boiler);

		boiler.fill();
		boiler.boil();
		boiler.drain();

	}

}
