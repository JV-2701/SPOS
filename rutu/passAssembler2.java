import java.util.*;
import java.io.*;
class passAssembler2
{
        public static void main(String args[])
        {
                String value=null;
                BufferedReader br,br1,br2;
             
                String input=null;
                String t=null;
                String t1=null;
                String ss=null,ll=null;
                String pvalue,address;
                try
                {
                        br=new BufferedReader(new FileReader("IM.txt"));
                                              
                        while((input=br.readLine())!=null)
                        {                        
                        
                                StringTokenizer st=new StringTokenizer(input," ");
                                 while (st.hasMoreTokens()) 
                                 {
                                        t=st.nextToken();
                      //  System.out.println(t);                
                                        if(t.equals("AD") || t.equals("IS") || t.equals("DL"))
                                        {
                                                System.out.print(t+" ");
                                        }
                                        else if(t.matches("\\d*")&& t.length() > 0 && st.hasMoreTokens())
                                        {
                                                System.out.print(t+" ");
                                        }
                                        
                                        else if(t.matches("\\d*")&& t.length() > 0 && !(st.hasMoreTokens()))
                                        {
                                                System.out.println(t);
                                        }
                                        else
                                        {
                                        	br1=new BufferedReader(new FileReader("ST.txt"));
                        			br2=new BufferedReader(new FileReader("LT.txt"));
                                                if(t.charAt(0)=='S')
                                                {
		                                        char a;
		                                        int aa;
		                                        a=t.charAt(1);
		                                        aa = Character.getNumericValue(a);
		                                                while((t1=br1.readLine())!=null)
		                                                {
		                                                        StringTokenizer st1=new StringTokenizer(t1,"\t");
		                                                        ss=st1.nextToken();
		                                                        int index=Integer.parseInt(ss);
		                                                        if(index==aa)
		                                                        {
		                                                        	pvalue=st1.nextToken();
		                                                                address=st1.nextToken();
		                                                                System.out.println(address); 
		                                                        }
		                                                }
                                                }
                                                else if(t.charAt(0)=='L')
                                                {
                                                        char a;
		                                        int aa;
		                                        a=t.charAt(1);
		                                        aa = Character.getNumericValue(a);
		                                                while((t1=br2.readLine())!=null)
		                                                {
		                                                        StringTokenizer st2=new StringTokenizer(t1,"\t");
		                                                        ss=st2.nextToken();
		                                                        int index=Integer.parseInt(ss);
		                                                        if(index==aa)
		                                                        {
		                                                        	pvalue=st2.nextToken();
		                                                                address=st2.nextToken();
		                                                                System.out.println(address); 
		                                                        }
		                                                        
		                                                }
                                                }
                                                else
                                                {
                                                        System.out.print(t+" ");
                                                }
                                        }
                                        
                                        
                                        
                                }
                        }p.close();
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }
                
        }
}