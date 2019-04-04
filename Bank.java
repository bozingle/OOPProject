import java.util.Random;
public class Bank {
	private double probability;
    private Random rand;
    public Bank(double p){
    	probability = p;
    	rand = new Random();
    }
	public boolean verify(){
	    int prob = rand.nextInt(100);
	    System.out.println(prob);
	    if (prob <= (int)(probability*100))
	      return true;
	    return false;
	  }
}
