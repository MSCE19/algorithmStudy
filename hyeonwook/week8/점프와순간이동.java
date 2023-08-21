package prgmrs;

public class 점프와순간이동 {
    public static void main(String[] args) {
        int n = 6;
        solution(n);
    }
        private static int solution(int n){
            int val = n;
            int result = 0;

            while (val>0){
                if(val%2 == 1){
                    val-=1;
                    result+=1;
                }

                val/=2;
            }
            System.out.println(result);
            return result;
        }

}
