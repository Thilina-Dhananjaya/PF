class Circle extends TwoDiamensional{
	double Radius;
	Circle(double Radius){
		this.Radius=Radius;
	}
	public double getArea(){
		return (22/7)*Radius*Radius;
	}

	public double getCircumference(){
		return 2*(22/7)*Radius;
		
	}
}