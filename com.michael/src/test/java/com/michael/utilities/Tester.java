package com.michael.utilities;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import com.michael.database.AccountImplementation;
import com.michael.database.AdminImplementation;
import com.michael.database.ClassImplementation;
import com.michael.database.UsersImplementation;
import com.michael.models.Account;
import com.michael.models.Users;

public class Tester 
{
	UsersImplementation usi = new UsersImplementation();
	AccountImplementation ai = new AccountImplementation();
	AdminImplementation adi = new AdminImplementation();
	ClassImplementation ci = new ClassImplementation();
	ProofReader proof = new ProofReader();

	@Test
	public void testUserSelect() 
	{
		Users rightUser = new Users(1, "Michael", "Ord", "mbo2@pct.edu");
		Users testUser = usi.selectUserID(1);
		assertEquals(rightUser, testUser);
	}

	@Test
	public void testAllEmails()
	{
		String wrongEmail = "idonotexist";
		boolean test = usi.checkAllEmails(wrongEmail);
		assertNotEquals(false, true);
	}
	
	@Test
	public void testFullName()
	{
		String rightConcat = "Michael Ord";
		assertEquals(rightConcat, usi.GetFullName(1));
	}
	
	@Test
	public void testStandardLogin()
	{
		Account testnull = ai.StandardLogin(null, null);
		assertNull(testnull);
	}
	
	@Test
	public void testProofRead()
	{
		String valid = "valid";
		assertTrue(proof.checkAll(valid));
	}
	
	//These next three tests use an existing user made for the sole purpose of testing
	@Test
	public void testCreateFramework()
	{
		boolean test = ai.createNewAccount(ai.FindMaxInt(), 17, "Test", "Case");
		assertTrue(test);
	}
	
	@Test
	public void testEditFramework()
	{
		boolean test = usi.ChangeEmail("UpdatedMail@mail.com", usi.selectUserID(17));
		assertFalse(test);
	}
	
	@Test
	public void testDeleteFramework()
	{
		boolean test = ai.DeleteAccount(ai.FindMaxInt()-1);
		assertFalse(test);
	}
	
	@Test
	public void avoidInjection()
	{
		String goodcop = "user";
		String badcop = "pass; select *;";
		boolean goodInput = proof.checkAll(goodcop);
		boolean badInput  = proof.checkAll(badcop );
		assertNotEquals(goodInput, badInput);
	}
	
	@Test
	public void avoidOverflow()
	{
		String goodcop = "user";
		String badcop = "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII; select *;";
		boolean goodInput = proof.checkAll(goodcop);
		boolean badInput  = proof.checkAll(badcop );
		assertNotEquals(goodInput, badInput);
	}
}
