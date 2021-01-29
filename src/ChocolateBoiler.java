
public class ChocolateBoiler {

	private boolean empty;
	private boolean boiled;

	private volatile static ChocolateBoiler uniqueInstance;
//	private static final ChocolateBoiler uniqueInstance = new ChocolateBoiler(); // eager initialization

	private ChocolateBoiler() { // singleton class has private constructor
		// TODO Auto-generated constructor stub
		empty = true;
		boiled = false;

		System.out.println("Creating the Object for ChocolateBoiler");
	}


// Thread unsafe code - lazy initialization	
//	public static ChocolateBoiler getUniqueInstance() {
//		
//		if(uniqueInstance == null) {
//			uniqueInstance = new ChocolateBoiler();
//		}
//		return uniqueInstance;
//	}

	public static ChocolateBoiler getUniqueInstance() {


		if (uniqueInstance == null) {
			System.out.println("Going to lock the class " + Thread.currentThread().getName());
			synchronized (ChocolateBoiler.class) {
				System.out.println("Lock acquired by " + Thread.currentThread().getName());
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (uniqueInstance == null) {
					uniqueInstance = new ChocolateBoiler();
				}

			}
			System.out.println("Releasing lock..........." + Thread.currentThread().getName());
		}
		return uniqueInstance;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}

		System.out.println("filled");
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true;
		}
		System.out.println("drained");

	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
		}
		System.out.println("boiled");
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void setBoiled(boolean boiled) {
		this.boiled = boiled;
	}

}
