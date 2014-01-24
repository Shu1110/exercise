
public class Box {
	public static void main(String[] args){
		Box b=new Box(2,2,2);
		b.surfaceArea();
		b.volume();
	}
	double length,width,height;
	Box(double l,double w,double h){
		this.length=l;
		this.width=w;
		this.height=h;
		
	}
	void surfaceArea(){
		System.out.println("surface area:"+(length*width+width*height+length*height)*2);
	}
	void volume(){
		System.out.println("volume:"+length*width*height);
	}

}

