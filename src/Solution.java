import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        boolean[] hm;
        int t = sc.nextInt();
        String ss;
        int ans = 0;
        
        while(t-- > 0){
            n = sc.nextInt();
            ss = sc.next();
            hm = new boolean[26];
            for(char c: ss.toCharArray()){
                if(!hm[c - 'A']){
                    hm[c - 'A'] = true;
                    ans += 2;
                }else{
                    ans++;
                }
            }

            System.out.println(ans);
        }
        
        sc.close();
    }
}