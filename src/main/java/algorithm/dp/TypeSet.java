package algorithm.dp;

import java.io.BufferedReader;
import java.io.FileReader;

public class TypeSet {
    public static void main(String args[]) {
	if (args.length<2) {
	    System.out.println("Usage: java typset <file> <M>");
	    System.exit(1);
	}

	// read input
	
	try {
	BufferedReader bin = new BufferedReader(new FileReader(args[0]));
	String line = bin.readLine();
	String words[] = line.split(" ");
	int n = words.length;
	int M = Integer.parseInt(args[1]);
	int lens[] = new int[n+1];
	for(int i=1;i<=n; i++) {
	    lens[i] = words[i-1].length();
	    if (lens[i]>M) { 
		System.out.println("word too long");
		System.exit(1);
	    }
	}
	
	int infty = M*M*2;

	// compute S_ij
	int S[][] = new int[n+1][n+1];
	for(int i=1;i<=n;i++) {
	    S[i][i] = M - lens[i];
	    for(int j=i+1; j<=n; j++) {
		S[i][j] = S[i][j-1] - lens[j] - 1;
		if (S[i][j]<0) {
		    while(j<=n) { S[i][j++] = infty; }
		}
	    }
	}

	// compute best_0,...,best_n
	int best[] = new int[n+1];
	int choice[] = new int[n+1];
	best[0] = 0;
	for(int i=1;i<=n;i++) {
	    int min = infty;
	    int ch  = 0;
	    for(int j=0;j<i;j++) {
		int t = best[j] + S[j+1][i]*S[j+1][i];
		if (t<min) { min = t; ch = j;}
	    }
	    best[i] = min;
	    choice[i] = ch;
	}

	for(int i=0;i<=n;i++) {
	    System.out.println(i + " best: " + best[i] + " ch " + choice[i]);
	}

	// backtrack to output linebreaks
	int end = n;
	int start   = choice[end]+1;
	String lines[] = new String[n];
	int cnt = 0;
	while (end>0) {
	    StringBuffer buf = new StringBuffer();
	    for(int j=start; j<=end; j++) {
		buf.append(words[j-1] + " ");
	    }
	    lines[cnt++] = buf.toString();
	    end = start-1;
	    start = choice[end]+1;
	}

	for(int j=cnt-1; j>=0; j-- ) {
	    System.out.println(lines[j]);
	}

	} catch(Exception e) {
	    e.printStackTrace();
	}

    }
}