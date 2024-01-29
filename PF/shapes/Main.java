public class Main{
	public static void main(String[] args) {
		//two diamentional class objects
		TwoDiamensional circle=new Circle(10);
		TwoDiamensional rectangle=new Rectangle(10,20);
		TwoDiamensional triangle=new Triangle(10,15,5,1,3);
		
		//three diamentional class objects
		ThreeDiamensional box=new Box(10,15,20);
		ThreeDiamensional cone=new Cone(50,20);
		ThreeDiamensional sphere=new Sphere(50);
		ThreeDiamensional cylinder=new Cylinder(10,50);


		//function call of two diamention classes
		System.out.println(circle.toString()+"Area :"+circle.getArea());
		System.out.println(circle.toString()+"Circumference :"+circle.getCircumference());

		System.out.println(rectangle.toString()+"Area :"+rectangle.getArea());
		System.out.println(rectangle.toString()+"Circumference :"+rectangle.getCircumference());

		System.out.println(triangle.toString()+"Area :"+triangle.getArea());
		System.out.println(triangle.toString()+"Circumference :"+triangle.getCircumference());


		//function call of three diamention classes
		System.out.println(box.toString()+"Surface :"+box.getSurface());
		System.out.println(box.toString()+"Volume :"+box.getVolume());

		System.out.println(cone.toString()+"Surface :"+cone.getSurface());
		System.out.println(cone.toString()+"Volume :"+cone.getVolume());

		System.out.println(sphere.toString()+"Surface :"+sphere.getSurface());
		System.out.println(sphere.toString()+"Volume :"+sphere.getVolume());

		System.out.println(cylinder.toString()+"Surface :"+cylinder.getSurface());
		System.out.println(cylinder.toString()+"Volume :"+cylinder.getVolume());
		
	}
}