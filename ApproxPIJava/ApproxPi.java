import java.util.*;
import java.lang.Math;

public class ApproxPi
{
  public double darts;
  
  public float x,y,areaO,areaSq;
  
  public float[] xCoord , yCoord;
  
  public ApproxPi(int darts)
  {
    this.darts=darts;
    this.xCoord = new float[darts];
    this.yCoord = new float[darts];
  }
  
  public void random(int i)
  {
    Random r = new Random();
    float one = (float) -.5;
    float two= (float).5;
    float x = one + r.nextFloat() * (two - one);
    
    float y = one + r.nextFloat() * (two - one);
    this.x = x;
    this.y = y;
    this.xCoord[i] = x;
    this.yCoord[i] = y;
    //System.out.println("X: "  + x + "  Y:" + y);
  }
  
  public float compute()
  {
    
    double inside = 0;
    double outside = 0;
    for(int i = 0; i<this.darts;i++)
    {
      float d = (float)Math.sqrt((this.x*this.x+this.y*this.y));

      if(Math.abs(d) <= (float)1/2)
        inside++;
      else
        outside++;
      random(i);
    }
    
    //System.out.println(inside);
    float pi = (float)(4*(inside/this.darts));
    //System.out.println((float)1/2);
    return pi;
  }
  
  public float dev(float[] pis, int num)
  {
    
    float meanpi = 0;
    for(int j = 0; j<num;j++)
    {
      meanpi = meanpi+pis[j];
    }
    meanpi = meanpi/num;
    float dev = 0;
    float temp = 0;
    for(int i = 0; i<num;i++)
    {
      temp = pis[i]-meanpi;
      dev = dev + (float)(Math.pow((temp),2));
    }
    dev = dev / num;
    return dev;
  }
  
  
  public static void main(String args[])
  {
    float[] mean = new float[7];
    
    ApproxPi test1 = new ApproxPi(10); //10
    mean[0] = test1.compute();
    System.out.println("Estimate of Pi for 10 "+mean[0]);
    float dev = test1.dev(mean, 1);
    System.out.println("Deviation is pi = "+dev);
    
    test1 = new ApproxPi(100); //100
    mean[1] = test1.compute();
    System.out.println("Estimate of Pi for 100 "+mean[1]);
    dev = test1.dev(mean, 2);
    System.out.println("Deviation is pi = "+dev);
    
    test1 = new ApproxPi(1000); //1000
    mean[2] = test1.compute();
    System.out.println("Estimate of Pi for 1,000 "+mean[2]);
    dev = test1.dev(mean, 3);
    System.out.println("Deviation is pi = "+dev);
    
    test1 = new ApproxPi(10000); //10000
    mean[3] = test1.compute();
    System.out.println("Estimate of Pi for 10,000 "+mean[3]);
    dev = test1.dev(mean, 4);
    System.out.println("Deviation is pi = "+dev);
        
    test1 = new ApproxPi(100000); //100000
    mean[4] = test1.compute();
    System.out.println("Estimate of Pi for 100,000 "+mean[4]);
    dev = test1.dev(mean, 5);
    System.out.println("Deviation is pi = "+dev);
    

    test1 = new ApproxPi(1000000); //1000000
    mean[5] = test1.compute();
    System.out.println("Estimate of Pi for 1,000,000 "+mean[5]);
    dev = test1.dev(mean, 6);
    System.out.println("Deviation is pi = "+dev);
    
    test1 = new ApproxPi(10000000); //10000000
    mean[6] = test1.compute();
    System.out.println("Estimate of Pi for 10,000,000 "+ mean[6]);
    dev = test1.dev(mean, 7);
    System.out.println("Deviation is pi = "+dev);
    

    
  }
}