package upcasting.downcasting;

class Machine{
	public void start(){
		System.out.println("Machine started");
	}
}

class Camera extends Machine{
	public void start(){
		System.out.println("Camera started");
	}
	
	public void snap(){
		System.out.println("Photo taken");
	}
}

public class Glowna {
	public static void main(String[] args) {
		Machine maszyna1 = new Machine();
		Camera cam1 = new Camera();
		
		maszyna1.start();
		cam1.start();
		cam1.snap();
		
		Machine machine2 = cam1;
		machine2.start();
		
		Machine machine3 = new Camera();
		Camera cam2 = (Camera)machine3;
		cam2.start();
		cam2.snap();
	}
}
