import java.util.*;
import java.io.*;

public class Main {
     public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            String univ = read.readLine();
            String Strength = read.readLine();
            String u[] = univ.trim().split(" ");
            String s[] = Strength.trim().split(" ");
            HashMap<Integer, ArrayList<Long>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int uni = Integer.parseInt(u[i]);
                Long stre = Long.parseLong(s[i]);
                if (map.containsKey(uni)) {
                    ArrayList<Long> list = map.get(uni);
                    list.add(stre);
                } else {
                    ArrayList<Long> list = new ArrayList<>();
                    list.add(stre);
                    map.put(uni, list);
                }
            }

            int maxsize = 0;
            for (int m : map.keySet()) {
                ArrayList<Long> get = map.get(m);
                Collections.sort(get);
                maxsize = Math.max(maxsize, get.size());
                ArrayList<Long> newlist = new ArrayList<>();
                newlist.add((long) get.get(0));
                for (int i = 1; i < get.size(); i++) {
                    long prev = newlist.get(i - 1);
                    newlist.add(prev + get.get(i));
                }
                map.put(m, newlist);
            }

            long arr[]=new long[n];
            for (int m : map.keySet()) {
                ArrayList<Long> get = map.get(m);
                int size=get.size();
                for(int i=1;i<get.size();i++){
                    int idx=(size%i)-1;
                    if (idx >= 0 && idx < size) {
                        arr[i-1] += (get.get(size - 1) - get.get(idx));
                    } else {
                        arr[i-1] += get.get(size - 1);
                    }
                }
            
            }

            for(long i:arr){
                System.out.print(i+" ");
            }
            System.out.println();

        }

    }
}