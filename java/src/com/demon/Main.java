package com.demon;

public class Main
{	
	public void cafeRubis()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CafeRubis());
		
	}
	
	public void starmap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new StarMap());
		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.starmap();
			
	}
}