public class Test {
	public static void main(String args[]){
		double sum=1;
		for(int i=2;i<=100;i++){
			if(i%2==0){
				sum=sum-1/i;
			}
			else{
				sum=sum+1/i;
			}
		}
		System.out.println(sum);
	}

}