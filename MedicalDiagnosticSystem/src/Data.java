
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author patrickdaley1
 */
public class Data
{

    public static void main(String[] args)
    {
        Random random = new Random();
        boolean runnyNose;
        boolean cough;
        boolean stomachAches;
        boolean fever;
        boolean chills;
        boolean cold;

        for (int x = 0; x <= 100; x++)
        {
            runnyNose = random.nextBoolean();

            if (runnyNose == true)
            {
                System.out.print("\nTrue");
            } 
            
            else
            {
                System.out.print("\nFalse");
            }
            cough = random.nextBoolean();
            
            if (cough == true)
            {
                System.out.print(",True");
            } 
            
            else
            {
                System.out.print(",False");
            }

            stomachAches = random.nextBoolean();
            
            if (stomachAches == true)
            {
                System.out.print(",True");
            } 
            
            else
            {
                System.out.print(",False");
            }
            fever = random.nextBoolean();
            
            if (fever == true)
            {
                System.out.print(",True");
            } 
            
            else
            {
                System.out.print(",False");
            }
            chills = random.nextBoolean();
            
            if (chills == true)
            {
                System.out.print(",True");
            }
            
            else
            {
                System.out.print(",False");
            }
            cold = random.nextBoolean();
            
            if (cold == true)
            {
                System.out.print(",yes");
            }
            
            else
            {
                System.out.print(",no");
            }
        }
    }
}