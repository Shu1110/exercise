
public class Circle {
	public static void main(String args[]){
		Circle c=new Circle();
		for(int i=1;i<=20;i++){
			System.out.println(c.duiGui(i));
		}
	}
	public int duiGui(int n)
	{
		
		if(n==1 || n==2)
			return 1;
		else
			return duiGui(n-1)+duiGui(n-2);
	}

}
