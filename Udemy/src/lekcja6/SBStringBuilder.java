package lekcja6;

import lekcja27.*;

class Cos{
	String name;
	public String toString(){
//		StringBuilder sb = new StringBuilder();
//		sb.append(i);
//		return sb.toString();
		return String.format("%-4d : ehehe", 7);
	}
}

public class SBStringBuilder {
	public static void main(String[] args) {
		Cos cos = new Cos();
		System.out.println(cos.toString());
	}
}
