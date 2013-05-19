package net.sambla.fizzbuzz;

public class FizzBuzz {

	public static String fizzbuzz(int number) {
		if(number <= 0) throw new IllegalArgumentException();
		if(number % 15 == 0) return "FizzBuzz";
		if(number % 3 == 0) return "Fizz";
		if(number % 5 == 0) return "Buzz";	
		return number+"";
	}

}
