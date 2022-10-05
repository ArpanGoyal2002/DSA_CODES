import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

  static PrintWriter out;
  static int MOD = 1000000007;
  static FastReader scan;

  /*-------- I/O usaing short named function ---------*/
  public static String ns() {
    return scan.next();
  }

  public static int ni() {
    return scan.nextInt();
  }

  public static long nl() {
    return scan.nextLong();
  }

  public static double nd() {
    return scan.nextDouble();
  }

  public static String nln() {
    return scan.nextLine();
  }

  public static void p(Object o) {
    out.print(o);
  }

  public static void ps(Object o) {
    out.print(o + " ");
  }

  public static void pn(Object o) {
    out.println(o);
  }

  /*-------- for output of an array ---------------------*/
  static void iPA(int arr[]) {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < arr.length; i++) output.append(arr[i] + " ");
    out.println(output);
  }

  static void lPA(long arr[]) {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < arr.length; i++) output.append(arr[i] + " ");
    out.println(output);
  }

  static void sPA(String arr[]) {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < arr.length; i++) output.append(arr[i] + " ");
    out.println(output);
  }

  static void dPA(double arr[]) {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < arr.length; i++) output.append(arr[i] + " ");
    out.println(output);
  }

  /*-------------- for input in an array ---------------------*/
  static void iIA(int arr[]) {
    for (int i = 0; i < arr.length; i++) arr[i] = ni();
  }

  static void lIA(long arr[]) {
    for (int i = 0; i < arr.length; i++) arr[i] = nl();
  }

  static void sIA(String arr[]) {
    for (int i = 0; i < arr.length; i++) arr[i] = ns();
  }

  static void dIA(double arr[]) {
    for (int i = 0; i < arr.length; i++) arr[i] = nd();
  }

  /*------------ for taking input faster ----------------*/
  static class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  // Method to check if x is power of 2
  static boolean isPowerOfTwo(int x) {
    return x != 0 && ((x & (x - 1)) == 0);
  }

  //Method to return lcm of two numbers
  static int gcd(int a, int b) {
    return a == 0 ? b : gcd(b % a, a);
  }

  //Method to count digit of a number
  static int countDigit(long n) {
    return (int) Math.floor(Math.log10(n) + 1);
  }

  //Method for sorting
  static void sort(int[] a) {
    ArrayList<Integer> l = new ArrayList<>();
    for (int i : a) l.add(i);
    Collections.sort(l);
    for (int i = 0; i < a.length; i++) a[i] = l.get(i);
  }

  //Method for checking if a number is prime or not
  static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (int i = 5; i * i <= n; i = i + 6) if (
      n % i == 0 || n % (i + 2) == 0
    ) return false;
    return true;
  }

  public static void reverse(int a[], int n) {
    int i, k, t;
    for (i = 0; i < n / 2; i++) {
      t = a[i];
      a[i] = a[n - i - 1];
      a[n - i - 1] = t;
    }

    // printing the reversed array
    System.out.println("Reversed array is: \n");
    for (k = 0; k < n; k++) {
      System.out.println(a[k]);
    }
  }

  public static int binarysearch(int arr[], int left, int right, int num) {
    int idx = 0;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (arr[mid] >= num) {
        idx = mid;
        // if(arr[mid]==num)break;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return idx;
  }

  public static void main(String[] args) throws java.lang.Exception {
    OutputStream outputStream = System.out;
    out = new PrintWriter(outputStream);
    scan = new FastReader();
    int t = ni();
    while (t-- > 0) {
      int n=ni();
      int x=ni();
      int y=ni();
      if(x>0&&y>0||x==0&&y==0){
        System.out.println(-1);
        continue;
      }
      int min=Math.min(x, y);
      int max=Math.max(x, y);
      int set=max;
      boolean chk=false;
      String str="";
      for(int i=1;i<=n;i++){
        if(set==0&&n-i+1>max){
          set=max;
        }else{
          chk=true;
          break;
        }
        if(set==max)int ch=""+i;
        while(set-->0){
          str=str+" "+ch;
          i++;
        }
      }
      if(chk){
        System.out.println(-1);
      }else{
        System.out.println(str);
      }
      
    }
    out.flush();
    out.close();
  }
}
