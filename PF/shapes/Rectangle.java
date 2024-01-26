class Rectangle extends TwoDiamensional{
	double Width,Height;
	Rectangle(double Height,double Width){
		this.Width=Width;
		this.Height=Height;
	}
	public double getArea(){
		return Width*Height;
	}

	public double getCircumference(){
		return 2*(Height+Width);
		
	}
}