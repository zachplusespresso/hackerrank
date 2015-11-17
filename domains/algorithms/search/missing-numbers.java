import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int n,m;
		int a[],b[];
		Scanner in=new Scanner(System.in);
		n=Integer.parseInt(in.next());
		a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=Integer.parseInt(in.next());

		}
		for(int i=0;i<n;i++)
		{
			if(map.containsKey(a[i]))
			{
				int c=map.get(a[i]);
				map.put(a[i], ++c);
			}
			else
			{
				map.put(a[i], 1);
			}

		}

		//System.out.println(map);
		m=Integer.parseInt(in.next());
		b=new int[m];
		for(int i=0;i<m;i++)
		{
			b[i]=Integer.parseInt(in.next());

		}
		for(int i=0;i<m;i++)
		{
			if(map.containsKey(b[i]))
			{
					int temp=map.get(b[i]);
					//System.out.println(b[i]+" "+temp);
					map.put(b[i], --temp);
					//System.out.println(temp);

			}
			else{
				map.put(b[i], -1);

			}
		}
		//System.out.println(map);
			Set<Integer> keys=map.keySet();
			ArrayList<Integer> li=new ArrayList<Integer>(keys);
			Collections.sort(li);
			Iterator<Integer> it=li.iterator();
			while(it.hasNext())
			{
				int temp=it.next();
				if(map.get(temp)<0)
				{
					System.out.print(temp+" ");
				}
			}


    }
}
