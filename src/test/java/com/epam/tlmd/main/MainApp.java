package com.epam.tlmd.main;

import com.epam.tlmd.tests.Test;

public class MainApp {
	
	public static void main(String[] args){
		boolean runningTest = Test.checkTitle();
		System.out.println(runningTest);
	}

}
