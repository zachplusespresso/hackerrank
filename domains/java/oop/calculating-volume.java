import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
import java.security.Permission;

class Output
{
    public void display(final double volume) {
        System.out.printf("%.3f%n", volume);
    }
}


class Volume
{
    public double main(final int a) {
        final double va = Long.valueOf(a).doubleValue();
        return va * va * va;
    }

    public double main(final int l, final int b, final int h) {
        final double vl = Long.valueOf(l).doubleValue();
        final double vb = Long.valueOf(b).doubleValue();
        final double vh = Long.valueOf(h).doubleValue();
        return vl * vb * vh;
    }

    public double main(final double r) {
        return 2.0d * Math.PI * r * r * r / 3.0d;
    }

    public double main(final double r, final double h) {
        return Math.PI * r * r * h;
    }
}

class Calculate
{
    public final Output output = new Output();
    private BufferedReader br;
    private static Volume vol = new Volume();

    public Calculate() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getINTVal() throws IOException {
        final int res =  Integer.parseInt(br.readLine().trim(), 10);
        if (res <= 0) {
            throw new NumberFormatException("All the values must be positive");
        }
        return res;
    }

    public double getDoubleVal() throws IOException {
        final double res = Double.parseDouble(br.readLine().trim());
        if (res <= 0.0d) {
            throw new NumberFormatException("All the values must be positive");
        }
        return res;
    }

    public static Volume get_Vol() {
        return vol;
    }
}

public class Solution
{

	public static void main(String[] args) {
		Do_Not_Terminate.forbidExit();
		try{
			Calculate cal=new Calculate();
			int T=cal.getINTVal();
			while(T-->0){
			double volume = 0.0d;
			int ch=cal.getINTVal();
			if(ch==1){

				int a=cal.getINTVal();
				volume=Calculate.get_Vol().main(a);


			}
			else if(ch==2){

				int l=cal.getINTVal();
				int b=cal.getINTVal();
				int h=cal.getINTVal();
				volume=Calculate.get_Vol().main(l,b,h);

			}
			else if(ch==3){

				double r=cal.getDoubleVal();
				volume=Calculate.get_Vol().main(r);

			}
			else if(ch==4){

				double r=cal.getDoubleVal();
				double h=cal.getDoubleVal();
				volume=Calculate.get_Vol().main(r,h);

			}
			cal.output.display(volume);
			}

		}
		catch (NumberFormatException e) {
			System.out.print(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}


	}
}
/**
 *This class prevents the user from using System.exit(0)
 * from terminating the program abnormally.
 */
class Do_Not_Terminate {

    public static class ExitTrappedException extends SecurityException {
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}//end of Do_Not_Terminate
