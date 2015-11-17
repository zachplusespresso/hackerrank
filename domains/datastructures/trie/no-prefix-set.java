import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Trie
    {
        boolean EOS;
        Trie[] C;

        public Trie()
            {
                this.EOS = false;
                this.C = new Trie[10];
        }

        public boolean insert(String s)
            {
               // System.out.println("probing String: "+s);

                if(this.C[s.charAt(0)-'a'] == null)
                    {
                        this.C[s.charAt(0)-'a'] = new Trie();
                        if(s.length() == 1)
                            this.C[s.charAt(0)-'a'].EOS = true;
                        else
                          return  this.C[s.charAt(0)-'a'].insert(s.substring(1));
                }

                else
                    {
                        if(s.length() == 1)
                            return false;
                        if(this.C[s.charAt(0)-'a'].EOS == true)
                            return false;

                        return this.C[s.charAt(0)-'a'].insert(s.substring(1));
                }

            return true;
        }
}


public class Solution {

    public static void func(String[] s)
        {

    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N  = Integer.parseInt(sc.nextLine());
        String[] s = new String[N];

        for(int i=0;i<N;i++)
            s[i] = new String(sc.nextLine());

        Trie root = new Trie();
        for(String probe : s)
            {
                //System.out.println("sending String: "+probe);
                if(!root.insert(probe))
                    {
                            System.out.println("BAD SET");
                    System.out.println(probe);
                    return;
                }
        }

        System.out.println("GOOD SET");
    }
}
