class Box extends ThreeDiamensional{
	double Height,Width,Length;
	
	Box(double Height,double Width,double Length){
		this.Height=Height;
		this.Width=Width;
		this.Length=Length;
	}

	public double getSurface(){
		return 2*(Height * Width + Width * Length + Length * Height);

	}
	public double getVolume(){
		return  Height * Width * Length;

	}
}