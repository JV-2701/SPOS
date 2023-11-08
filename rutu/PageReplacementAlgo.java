import java.util.ArrayList;
import java.util.Arrays;
public class PageReplacementAlgo {
 public static void LRU(int capacity,int[] arr){
 // To represent set of current pages.We use an Arraylist
 ArrayList<Integer> s=new ArrayList<>(capacity);
 int count=0;
 int page_faults=0;
 for(int i:arr)
 {
 // Insert it into set if not present already which represents page fault
 if(!s.contains(i))
 {
 // Check if the set can hold equal pages
 if(s.size()==capacity)
 {
 s.remove(0);
 s.add(capacity-1,i);
 }
 else
 s.add(count,i);
 // Increment page faults
 page_faults++;
 ++count;
 }
 else
 {
 s.remove((Object)i); // Remove the indexes page
 s.add(s.size(),i); // insert the current page
 }
 }
 System.out.println("Page Faults: "+page_faults);
 }
 public static void optimalPage(int[] pg, int pn, int fn) {
// Create an array for given number of frames and initialize it as empty.
 int[] fr = new int[fn];
 Arrays.fill(fr, -1); // set all elements of fr to -1
 // Traverse through page reference array and check for miss and hit.
 int hit = 0;
 for (int i = 0; i < pn; i++) {
 // Page found in a frame: HIT
 boolean found = false;
 for (int j = 0; j < fn; j++) {
 if (fr[j] == pg[i]) {
 hit++;
 found = true;
 break;
 }
 }
 if (found)
 continue;
 // Page not found in a frame: MISS
 // If there is space available in frames.
 boolean emptyFrame = false;
 for (int j = 0; j < fn; j++) {
 if (fr[j] == -1) {
 fr[j] = pg[i];
 emptyFrame = true;
 break;
 }
 }
 if (emptyFrame)
 continue;
 // Find the page to be replaced.
 int farthest = -1, replaceIndex = -1;
 for (int j = 0; j < fn; j++) {
 int k;
 for (k = i + 1; k < pn; k++) {
 if (fr[j] == pg[k]) {
 if (k > farthest) {
 farthest = k;
 replaceIndex = j;
 }
 break;
 }
 }
 if (k == pn) {
 replaceIndex = j;
 break;
 }
 }
 fr[replaceIndex] = pg[i];
 }
 System.out.println("No. of hits = " + hit);
 System.out.println("No. of misses = " + (pn - hit));
 }
 public static void main(String args[]){
 System.out.println("LRU: "); //LRU (Least Recently Used)
 int capacity = 4;
 int arr[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
 LRU(capacity,arr);
 System.out.println("Optimal: "); //Optimal Page Replacement
 int[] pg = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5};
 int pn = pg.length;
 int fn = 4;
 optimalPage(pg, pn, fn);
 }
}

