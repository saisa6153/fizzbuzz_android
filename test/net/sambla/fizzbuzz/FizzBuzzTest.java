package net.sambla.fizzbuzz;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTest {

	@Test
	public void _3の倍数でも5の倍数でもない数を渡したらその数自身を返すこと() {
		assertEquals("1", FizzBuzz.fizzbuzz(1));
	}
	
	@Test
	public void _3の倍数で5の倍数ではない数を渡したらFizzを返すこと(){
		assertEquals("Fizz",FizzBuzz.fizzbuzz(3));
	}
	
	@Test
	public void _5の倍数で3の倍数ではないを渡したらBuzzを返すこと(){
		assertEquals("Buzz", FizzBuzz.fizzbuzz(5));
	}
	
	@Test
	public void _3と5の公倍数を渡したらFizzBuzzを返すこと(){
		assertEquals("FizzBuzz", FizzBuzz.fizzbuzz(15));
	}

	@Test(expected=IllegalArgumentException.class)
	public void _0以下の数を渡したら例外を投げること(){
		FizzBuzz.fizzbuzz(0);
	}
}
