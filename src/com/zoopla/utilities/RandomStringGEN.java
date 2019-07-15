package com.zoopla.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGEN
{
	// to generate random alphanumeric 
	  public String alhanumeric(int i)
	    {
	    	String pass = RandomStringUtils.randomAlphanumeric(i);
	    	return pass;

	    }
	    // to generate random numeric 
	  public String number(int i)
	    {
	    	String number = RandomStringUtils.randomNumeric(i);
	    	 return number;
	    	
	    }
	    // to generate random alphabetic string for email id
	  public String alpha(int i)
	    {
	    	String abc = RandomStringUtils.randomAlphabetic(i);
	    	return (abc);

	    }
	  public String email(int i)
	    {
	    	String abc = RandomStringUtils.randomAlphabetic(i);
	    	return (abc+"@yopmail.com");

	    }
		public String getRandomInteger(int maximum, int minimum)
		{ 
			int number = ((int) (Math.random()*(maximum - minimum))) + minimum;
			return Integer.toString(number);
		}
	
	

}
