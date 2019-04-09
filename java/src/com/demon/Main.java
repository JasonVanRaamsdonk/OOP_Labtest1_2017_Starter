package com.demon;

public class Main
{	
	public void cafeRubis()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CafeRubis());
		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.cafeRubis();		
			
	}
}