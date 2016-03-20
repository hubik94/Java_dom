package lista2;

public class Museum {
	/// ======== [VARIABLES START] ======== ///
	// Max number of people, which can be in museum in this same time;
	public static final int MAX_CLIENT_IN_MUSEUM = 5;
	
	// Actually number of people in museum; volatile - variable isn't cached;
	private volatile int peopleInMuseum = 0;
	
	// Entrance and Exit
	public Entrance entrance = new Entrance();
	public Exit exit = new Exit();
	/// ======== [VARIABLES END] ======== ///
	
	// Method which check there is free slot.
	private synchronized boolean isFreeSlot(){
		return peopleInMuseum < MAX_CLIENT_IN_MUSEUM;
	}
	
	private void enterMuseum(){
		peopleInMuseum++;
		// 1.Get variable
		// 2.Add one to variable
		// 3.Store variable
		
	}
	
	private void exitMuseum(){
		peopleInMuseum--;
		// 1.Get variable
		// 2.Add one to variable
		// 3.Store variable
	}
	
	//Class which can be created only if Museum is created;
	class Entrance {
		public synchronized boolean enterToMuseum(){
			String name = Thread.currentThread().getName();
			if(isFreeSlot()){
				enterMuseum();
				System.out.println(name + " wchodzi do muzeum.");
				return true;
			} else {
				System.out.println(name + " nie mo¿e wejœæ, muzeum jest pe³ne.");
				return false;
			}
		}
	}
	
	
	
	//Class which can be created only if Museum is created;
	class Exit {
		public synchronized void exitFromMuseum(){
			String name = Thread.currentThread().getName();
			exitMuseum();
			System.out.println(name + " wychodzi z muzeum.");
		}
	}

}



