import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] rags) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[]r = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			r[i] = Integer.parseInt(st.nextToken());
		}
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int mini = 3;
			for(int k=i;k<=j;k++) {
				mini = Math.min(mini, r[k]);
			}
			pw.println(mini);
		}
		pw.flush();
	}
}
