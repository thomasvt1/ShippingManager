
public class Shore {
	
	private Container[] storage;
	
	public Shore(int size) {
		storage = new Container[size];
	}
	
	void printStatus() {
		System.out.println("////////// ~ SHORE STATUS START \\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("Max storage: " + storage.length);
		System.out.println("Currently used: " + getStorageSize());
		//System.out.println("////////// ~ SHORE STATUS END \\\\\\\\\\\\\\\\\\\\\\");
	}
	
	synchronized void addContainer(Container c) throws FullException{
		for (int i = 0; i < storage.length; i ++) {
			if (storage[i] == null) {
				storage[i] = c;
				return;
			}
		}
		throw new FullException();
	}
	
	private int getFirstContainer() throws EmptyException {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				System.out.println("SHORE: FirstNextContainer: " + i);
				return i;
			}
		}
		throw new EmptyException();
	}
	
	public Container pickupContainer() throws EmptyException {
		int i = getFirstContainer();
		Container x = storage[i];
		
		storage[i] = null;
		
		return x;
	}
	
	int getMaxCargo() {
		return storage.length;
	}

	public int getStorageSize() {
		int x = 0;
		for (Container c : storage) {
			if (c != null)
				x++;
		}
		return x;
	}
	
	boolean isEmpty() {
		if (getStorageSize() == 0)
			return true;
		
		return false;
	}
	
	boolean isFull() {
		if (getMaxCargo() == getStorageSize())
			return true;
		
		return false;
	}

}