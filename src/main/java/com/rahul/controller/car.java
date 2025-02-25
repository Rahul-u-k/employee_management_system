package com.rahul.controller;


/*public abstract class car {

	public void dis() {
		System.out.println("car");
	}
}
class bike extends car{
	
	
	public void dis() {
		System.out.println("eng");
	}
}
class test{
	public static void main(String[] args) {
		bike b=new bike();
		b.dis();
	}
}
*/
public abstract interface car{
	
	abstract void dis();
	
}

abstract class eng implements car{
	
	@Override
	public void dis() {
		System.out.println("display");
	}
}
