public class Question2 extends Thread
{
    static int maxDiv = 0, num = 0;
    int start;
    public Question2(int start)
    {
        this.start = start;
    }
    public static void main(String[] args)
    {
        Question2 t1 = new Question2(1), t2 = new Question2(10001), t3 = new Question2(20001);
        Question2 t4 = new Question2(30001), t5 = new Question2(40001);
        Question2 t6 = new Question2(50001), t7 = new Question2(60001);
        Question2 t8 = new Question2(70001), t9 = new Question2(80001);
        Question2 t10 = new Question2(90001);
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        try{
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();
        t10.join();
        }catch(Exception e){}
        long end = System.currentTimeMillis();
        System.out.println(num + " has maximum " + maxDiv + " no of divisors.");
        System.out.println("Total time elapsed: " + (end-start));
    }

    public void run()
    {
        int div=0;
        for(int i=start; i<this.start+10000; i++)
        {
            div=0;
            for(int j=1; j<=i; j++)
            {
                if(i%j==0)
                {
                    div+=1;
                }
            }
            if(div>maxDiv)
            {
                synchronized(this)
                {
                    maxDiv = div;
                    num = i;
                }
            }
        }
    }
}