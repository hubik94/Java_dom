package lista2MJ;

public class Bramka extends Thread{
	Muzeum muzeum;
	
	public Bramka(Muzeum muzeum){
		this.muzeum = muzeum;
	}
	
	public void run(){
		for(int i=0;i<muzeum.Max+5;i++){
			new Klient(muzeum).start();
		}
	}
}
