class Triangle extends TwoDiamensional{
	double Base,Height,Side1,Side2,Side3;
	Triangle(double Base,double Height,double Side1,double Side2,double Side3){
		this.Base=Base;
		this.Height=Height;
		this.Side1=Side1;
		this.Side2=Side2;
		this.Side3=Side3;
	}
	public double getArea(){
		return 0.5*Base*Height;
	}

	public double getCircumference(){
		return Side1+Side2+Side3;
	}
}