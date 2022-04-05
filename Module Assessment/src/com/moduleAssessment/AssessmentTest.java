package com.moduleAssessment;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssessmentTest {
	@Test
	// Test case for Deposite method
	public void testDepositeAmount() {
		System.out.println("\nTest case for Deposite method");
		Assessment testObj = new Assessment();
		testObj.depositeAmount();
		assertEquals(testObj.getBalanceAmount(), 1000);
		testObj.depositeAmount();
		assertFalse(testObj.getBalanceAmount() == 800);
	}

	@Test
	// Test case for Close account method
	public void testCloseAccount() {
		System.out.println("\nTest case for Close account method");
		Assessment testObj = new Assessment();
		testObj.setBalanceAmount(100);
		testObj.closeAccount();
		assertEquals(testObj.getBalanceAmount(), 0);
		assertEquals(testObj.getStatus(), "CLOSED");
	}

	@Test
	// Test case for testWithDrawAmount method
	public void testWithDrawAmount() {
		System.out.println("\nTest case for testWithDrawAmount method");
		Assessment testObj = new Assessment();
		testObj.setBalanceAmount(500);
		testObj.withDrawAmount();
		assertEquals(testObj.getBalanceAmount(), 200);
		System.out.println("\nTest case for inactive status in testWithDrawAmount method");
		testObj.setBalanceAmount(100);
		testObj.withDrawAmount();
		assertEquals(testObj.getBalanceAmount(), 1);
		assertEquals(testObj.getStatus(), "INACTIVE");

	}

}
