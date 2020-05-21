package i3305course;

public class Circle extends GeometricObject {
	private int radius;
	public Circle(int x)
	{
		this.radius = x;
	}
	@Override
	public double getArea()
	{
		return Math.PI*radius*radius;
	}
}
