package i3305course;

public class Rectangle extends GeometricObject {

	private int a, b;
	public Rectangle(int x, int y)
	{
		this.a = x;
		this.b = y;
	}
	@Override
	public double getArea(){
		return this.a*this.b;
	}
}
