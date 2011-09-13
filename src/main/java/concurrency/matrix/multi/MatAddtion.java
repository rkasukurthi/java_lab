package concurrency.matrix.multi;

import java.lang.*;
import java.util.Random;
import java.io.*;
class MatAddtion extends Thread
{
        static int in1[][];
        static int in2[][];
        static int out[][];
        static int n=2;
        int row;
        MatAddtion(int i)
        {
                row=i;
                this.start();
        }
        public void run()
        {
                int i,j;
                for(i=0;i<n;i++)
                {
                        out[row][i]=0;
                        for(j=0;j<n;j++)
                                out[row][i]=out[row][i]+in1[row][j]*in2[j][i];
                }
        }
        public static void main(String args[])
        {
                int i,j;
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//                System.out.print("Enter the order of Matrix : ");
//                try
//                {
//                        n=Integer.parseInt(br.readLine());
//                }catch(Exception e){}
                n=100;

                in1=new int[n][n];
                in2=new int[n][n];
                out=new int[n][n];
                
                Random rm= new Random();
                for(i=0;i<n;i++)
                {
                        for(j=0;j<n;j++)
                        {
                            in1[i][j]=rm.nextInt(100);
                        }
                }
                for(i=0;i<n;i++)
                {
                        for(j=0;j<n;j++)
                        {
                            in2[i][j]=rm.nextInt(100);
                        }
                }
                
                MatAddtion mat[]=new MatAddtion[n];
                
                for(i=0;i<n;i++)
                        mat[i]=new MatAddtion(i);
                try
                {
                        for(i=0;i<n;i++)
                                mat[i].join();
                }catch(Exception e){}
                System.out.println("OUTPUT :");
                for(i=0;i<n;i++)
                        for(j=0;j<n;j++)
                                System.out.println(out[i][j]);
        }
}
