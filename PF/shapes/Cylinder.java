class Cylinder extends ThreeDiamensional{

	double Radius,Height;
	Cylinder(double Radius,double Height){
		this.Radius=Radius;
		this.Height=Height;
	}
	public double getSurface(){
		return  2 * (22/7) * Radius* (Radius + Height);
	}

	public double getVolume(){
		return  (22/7) * Radius * Radius * Height;

	}
}