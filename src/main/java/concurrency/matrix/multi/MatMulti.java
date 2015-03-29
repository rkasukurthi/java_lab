package concurrency.matrix.multi;

import java.lang.*;
import java.util.Random;
import java.io.*;
class MatMulti extends Thread
{
        static int in1[][];
        static int in2[][];
        static int out[];
        static int n=2000;
        int row;
        MatMulti(int i)
        {
                row=i;
                this.start();
        }
        public void run()
        {
                int i,j;
                for(i=0;i<n;i++)
                {
                        out[row]=0;
                        for(j=0;j<n;j++)
                                out[row] +=in1[row][j];
                }
        }
        public static void main(String args[])
        {
                int i,j;
                in1=new int[n][n];
                out=new int[n];
                
                Random rm= new Random();
                for(i=0;i<n;i++)
                {
                        for(j=0;j<n;j++)
                        {
                            in1[i][j]=rm.nextInt(100);
                        }
                }
                
                MatMulti mat[]=new MatMulti[n];
                
                for(i=0;i<n;i++)
                        mat[i]=new MatMulti(i);
                try
                {
                        for(i=0;i<n;i++)
                                mat[i].join();
                }catch(Exception e){}
                
                System.out.println("OUTPUT :");
                for(i=0;i<n;i++)
                        for(j=0;j<n;j++)
                                System.out.println(out[i]);
        }
}
