package com.restapp.ticketmanagement.nonreactive;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeEach
	public void setUp() {
		this.calculator = new Calculator();
	}
	
	@Test
	public void addIntegersTest() {
		assertEquals(20, calculator.addIntegers(15, -5));
	}
	
}
