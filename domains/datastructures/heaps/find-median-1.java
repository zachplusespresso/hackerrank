import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;




public class FindMedian {


	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		String line = reader.readLine();
		int T = Integer.parseInt(line.trim());
	int temp=0;
	int a[]=new int[T];
		for (int i = 0; i< T; i++) {
			 line = reader.readLine();
			 a[i] = Integer.parseInt(line);
			int j=i-1;
				 int k=a[i];
				 if(j>=0)
				 while(k>a[j]&&j>=0)
				 {
					 a[j+1]=a[j];
					 j--;
					 if(j<0)
						 break;
				 }
				 a[j+1]=k;

			 //Arrays.sort(a,0,i+1);
			if(i%2==0)

				{
				pw.print(a[temp++]+".0\n");

				}
			else
			{
				pw.print((float)((a[temp-1]+a[temp])/2.0)+"\n");
			}
		}
		pw.close();


	}


}
