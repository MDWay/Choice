package de.romjaki.choice;


public class Main {
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("Usage: choice.jar <file>");
			return;
		}
		File f = new File(args[0]);
		try (Scanner s = new Scanner(f)){
			
		}catch(Exception e){
			System.err.println("Error during file parsing: "+e);
		}
	}
}
