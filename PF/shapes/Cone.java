class Cone extends ThreeDiamensional{
	double Radius,Height;
	Cone(double Radius,double Height){
		this.Radius=Radius;
		this.Height=Height;
	}
	public double getSurface(){
		return  2 * (22/7) * Radius *(Radius + Height);
	}

	public double getVolume(){
		return   1/3 * (22/7) * Radius * Radius * Height;

	}
}