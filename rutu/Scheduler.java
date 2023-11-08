import java.util.*;
import java.io.*;
public class Scheduler{
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int choice;
// Choose scheduling algorithm
do{
System.out.println("Choose a scheduling algorithm:");
System.out.println("1. FCFS");
System.out.println("2. SJF (Preemptive)");
System.out.println("3. Priority (Non-Preemptive)");
System.out.println("4. Round Robin (Preemptive)");
choice = scanner.nextInt();
switch (choice) {
 case 1:
FCFS();
break;
 case 2:
SJF();
break;
 case 3:
Priority();
break;
 case 4:
RoundRobin();
break;
}
}while(choice<=4);
scanner.close();
 } 
 static void FCFS(){
 int n,sum=0;
 float total_tt=0,total_waiting=0; 
 Scanner s=new Scanner(System.in);
 System.out.println("Enter Number Of Process U want 2 Execute---"); 
 n=s.nextInt();
 int arrival[]=new int[n];
 int cpu[]=new int[n];
 int finish[]=new int[n];
 int turntt[]=new int[n];
 int wait[]=new int[n];
 int process[]=new int[n]; 
 // int pro[][]=new int[3][3];
 for(int i=0;i<n;i++)
 {
 System.out.println("Enter arrival time of "+(i+1)+" Process : ");
 arrival[i]=s.nextInt();
 System.out.println("Enter CPU time of "+(i+1)+" Process : ");
 cpu[i]=s.nextInt();
 
 process[i]=i+1;
 } 
 for(int i=0;i<n;i++)
 {
 sum=sum+cpu[i];
 finish[i]=sum;
 }
 for(int i=0;i<n;i++)
 {
 turntt[i]=finish[i]-arrival[i]; 
 total_tt=total_tt+turntt[i]; 
 wait[i]=turntt[i]-cpu[i]; 
 total_waiting+=wait[i];
 } 
 System.out.println("\n\nProcess\t\tAT\tCPU_T");
 for(int i=0;i<n;i++)
 {
 System.out.println(process[i]+"\t\t"+arrival[i]+"\t"+cpu[i]);
 } 
 System.out.println("\n\n");
 System.out.println("Total turn around time is : "+(total_tt/n));
 System.out.println("Total waiting time is : "+(total_waiting/n));
 }
 static void SJF(){
 int n,sum=0;
 float total_tt=0,total_waiting=0; 
 Scanner s=new Scanner(System.in);
 System.out.println("Enter Number Of Process U want 2 Execute---"); 
 n=s.nextInt();
 int arrival[]=new int[n];
 int cpu[]=new int[n];
 int finish[]=new int[n];
 int turntt[]=new int[n];
 int wait[]=new int[n];
 int process[]=new int[n]; 
 // int pro[][]=new int[3][3];
 for(int i=0;i<n;i++)
 {
 System.out.println("Enter arrival time of "+(i+1)+" Process : ");
 arrival[i]=s.nextInt();
 System.out.println("Enter CPU time of "+(i+1)+" Process : ");
 cpu[i]=s.nextInt(); 
 process[i]=i+1;
 } 
 for(int i=0;i<n-1;i++)
 {
 for(int j=i+1;j<n;j++)
 {
 if(cpu[i]>cpu[j])
 {
 int temp=cpu[i];
 cpu[i]=cpu[j];
 cpu[j]=temp; 
 temp=arrival[i];
 arrival[i]=arrival[j];
 arrival[j]=temp; 
 temp=process[i];
 process[i]=process[j];
 process[j]=temp; 
 }
 }
 } 
 for(int i=0;i<n;i++)
 {
 sum=sum+cpu[i];
 finish[i]=sum;
 } 
 for(int i=0;i<n;i++)
 {
 turntt[i]=finish[i]-arrival[i]; 
 total_tt=total_tt+turntt[i]; 
 wait[i]=turntt[i]-cpu[i]; 
 total_waiting+=wait[i];
 }
 
 System.out.println("\n\nProcess\t\tAT\tCPU_T");
 for(int i=0;i<n;i++)
 {
 System.out.println(process[i]+"\t\t"+arrival[i]+"\t"+cpu[i]);
 }
 
 System.out.println("\n\n");
 System.out.println("Total turn around time is : "+(total_tt/n));
 System.out.println("Total waiting time is : "+(total_waiting/n));
 }
 static void Priority(){
 Scanner s = new Scanner(System.in); 
 int x,n,p[],pp[],bt[],w[],t[],awt,atat,i; 
 p = new int[10];
 pp = new int[10];
 bt = new int[10];
 w = new int[10];
 t = new int[10];
 System.out.print("Enter the number of process : ");
 n = s.nextInt();
 System.out.print("\n\t Enter burst time : time priorities \n"); 
 for(i=0;i<n;i++)
 {
 System.out.print("\nProcess["+(i+1)+"]:");
 bt[i] = s.nextInt();
 pp[i] = s.nextInt();
 p[i]=i+1;
 }
 for(i=0;i<n-1;i++)
 {
for(int j=i+1;j<n;j++)
{
 if(pp[i]>pp[j])
 {
 x=pp[i];
 pp[i]=pp[j];
 pp[j]=x;
 x=bt[i];
 bt[i]=bt[j];
 bt[j]=x;
 x=p[i];
 p[i]=p[j];
 p[j]=x;
 }
}
}
w[0]=0;
awt=0;
t[0]=bt[0];
atat=t[0];
for(i=1;i<n;i++)
{
 w[i]=t[i-1];
 awt+=w[i];
 t[i]=w[i]+bt[i];
 atat+=t[i];
} 
System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time Priority \n");
for(i=0;i<n;i++)
 System.out.print("\n "+p[i]+"\t\t "+bt[i]+"\t\t "+w[i]+"\t\t "+t[i]+"\t\t "+pp[i]+"\n");
awt/=n;
atat/=n;
System.out.print("\n Average Wait Time : "+awt);
System.out.print("\n Average Turn Around Time : "+atat);
 }
 static void RoundRobin(){
 int n,i,qt,count=0,temp,sq=0,bt[],wt[],tat[],rem_bt[]; 
 float awt=0,atat=0; 
 bt = new int[10]; 
 wt = new int[10]; 
 tat = new int[10]; 
 rem_bt = new int[10]; 
 Scanner s=new Scanner(System.in); 
 System.out.print("Enter the number of process (maximum 10) = "); 
 n = s.nextInt(); 
 System.out.print("Enter the burst time of the process\n"); 
 for (i=0;i<n;i++) 
 { 
 System.out.print("P"+i+" = "); 
 bt[i] = s.nextInt(); 
 rem_bt[i] = bt[i]; 
 } 
 System.out.print("Enter the quantum time: "); 
 qt = s.nextInt(); 
 while(true) 
 { 
 for (i=0,count=0;i<n;i++) 
 { 
 temp = qt; 
 if(rem_bt[i] == 0) 
 { 
 count++; 
 continue; 
 } 
 if(rem_bt[i]>qt) 
 rem_bt[i]= rem_bt[i] - qt; 
 else 
 if(rem_bt[i]>=0) 
 { 
 temp = rem_bt[i]; 
 rem_bt[i] = 0; 
 } 
 sq = sq + temp; 
 tat[i] = sq; 
 } 
 if(n == count) 
 break; 
 } 
 System.out.print("\nProcess\t Burst Time\t Turnaround Time\t Waiting Time\n"); 
 for(i=0;i<n;i++) 
{ 
 wt[i]=tat[i]-bt[i]; 
 awt=awt+wt[i]; 
 atat=atat+tat[i]; 
 System.out.print("\n "+(i+1)+"\t\t "+bt[i]+"\t\t\t "+tat[i]+"\t\t\t\t "+wt[i]+"\n"); 
} 
awt=awt/n; 
atat=atat/n; 
System.out.println("\nAverage waiting Time = "+awt+"\n"); 
System.out.println("Average turnaround time = "+atat); 
 }
}