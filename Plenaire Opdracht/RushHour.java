import java.util.*;
import java.io.*;

public class RushHour {


	public static void main(String args[]) {
		RushHour game = new RushHour();
		game.preparations();
	}

	public void preparations() {

		int s;

		Scanner input = new Scanner(System.in);

		System.out.println("Which game do you want to play? 1, 2 or 3?");
		s = input.nextInt();

		if(s == 1) {
			System.out.println("You entered one.");
		}else if(s == 2) {
			System.out.println("You entered two.");
		}else if(s == 3) {
			System.out.println("You entered three.");
		}else {
			System.out.println("Please enter '1', '2' or '3'.");
		}
	}

}