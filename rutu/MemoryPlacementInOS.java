import java.util.Arrays;
public class MemoryPlacementInOS {
static void bestFit(int blockSize[], int m, int processSize[],int n) {
int allocation[] = new int[n];
for (int i = 0; i < allocation.length; i++)
allocation[i] = -1;
for (int i = 0; i < n; i++) {
int bestIdx = -1;
for (int j = 0; j < m; j++) {
if (blockSize[j] >= processSize[i]) {
if (bestIdx == -1)
bestIdx = j;
else if (blockSize[bestIdx] > blockSize[j])
bestIdx = j;
}
}
if (bestIdx != -1) {
allocation[i] = bestIdx;
blockSize[bestIdx] -= processSize[i];
}
}
System.out.println("\nPr. No.\tProcess Size\tBlock no.");
for (int i = 0; i < n; i++) {
System.out.print(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
if (allocation[i] != -1)
System.out.print(allocation[i] + 1);
else
System.out.print("Not Allocated");
System.out.println();
}
}
//first fit
static void firstFit(int blockSize[], int m,int processSize[], int n) {
int allocation[] = new int[n];
for (int i = 0; i < allocation.length; i++)
allocation[i] = -1;
for (int i = 0; i < n; i++) {
for (int j = 0; j < m; j++) {
if (blockSize[j] >= processSize[i]) {
allocation[i] = j;
blockSize[j] -= processSize[i]; // Reduce available memory in this block. break;
}
}
}
System.out.println("\nProcess No.\tProcess Size\tBlock no.");
for (int i = 0; i < n; i++) {
System.out.print(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
if (allocation[i] != -1)
System.out.print(allocation[i] + 1);
else
System.out.print("Not Allocated");
System.out.println();
}
}
// worst fit
static void worstFit(int blockSize[], int m, int processSize[],int n) {
int allocation[] = new int[n];
for (int i = 0; i < allocation.length; i++)
allocation[i] = -1;
for (int i = 0; i < n; i++) {
int wstIdx = -1;
for (int j = 0; j < m; j++) {
if (blockSize[j] >= processSize[i]) {
if (wstIdx == -1)
wstIdx = j;
else if (blockSize[wstIdx] < blockSize[j])
wstIdx = j;
}
}
if (wstIdx != -1) {
allocation[i] = wstIdx;
blockSize[wstIdx] -= processSize[i];
}
}
System.out.println("\nProcess No.\tProcess Size\tBlock no.");
for (int i = 0; i < n; i++) {
System.out.print(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
if (allocation[i] != -1)
System.out.print(allocation[i] + 1);
else
System.out.print("Not Allocated");
System.out.println();
}
}
// next fit
static void NextFit(int blockSize[], int m, int processSize[], int n) {
int allocation[] = new int[n], j = 0, t = m - 1;
Arrays.fill(allocation, -1);
for (int i = 0; i < n; i++) {
while (j < m) {
if (blockSize[j] >= processSize[i]) {
allocation[i] = j;
blockSize[j] -= processSize[i];
t = (j - 1) % m;
break;
}
if (t == j) {
t = (j - 1) % m;
break;
}
j = (j + 1) % m;
}
}
System.out.print("\nProcess No.\tProcess Size\tBlock no.\n");
for (int i = 0; i < n; i++) {
System.out.print(i + 1 + "\t\t" + processSize[i] + "\t\t");
if (allocation[i] != -1) {
System.out.print(allocation[i] + 1);
} else {
System.out.print("Not Allocated");
}
System.out.println("");
}
}
public static void main(String[] args) {
int blockSize[] = {100, 500, 200, 300, 600};
int processSize[] = {212, 417, 112, 426};
int m = blockSize.length;
int n = processSize.length;
System.out.println("\n--------Best Fit--------");
bestFit(blockSize, m, processSize, n);
System.out.println("\n--------First Fit--------");
firstFit(blockSize, m, processSize, n);
System.out.println("\n--------Worst Fit--------");
worstFit(blockSize, m, processSize, n);
System.out.println("\n--------Next Fit--------");
NextFit(blockSize, m, processSize, n);
}
}