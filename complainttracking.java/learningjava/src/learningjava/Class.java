package learningjava;

import java.util.Scanner;

public class Class {
  public String veichle;
  public String id;
  public String colour;
	
	
	Class(){
	  Scanner s = new Scanner(System.in);
	  System.out.println("enter you veichle name");
	  veichle = s.nextLine();
	  System.out.println("enter your veichel id");
	  id = s.nextLine();
	  System.out.println("enter your car colur");
	  colour=s.nextLine();
	  
	  
	 
	  
	}

}
