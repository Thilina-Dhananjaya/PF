class Sphere extends ThreeDiamensional{
	double Radius;
	Sphere(double Radius){
		this.Radius=Radius;
	}

	public double getSurface(){
		return   4 * (22/7) * Radius * Radius;
	}

	public double getVolume(){
		return   4/3 * (22/7) * Radius * Radius * Radius;
	}
}