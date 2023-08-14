import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        ArrayList<Integer> lost_l = new ArrayList<>(Arrays.asList(Arrays.stream(lost).boxed().toArray(Integer[]::new)));
        ArrayList<Integer> reserve_l = new ArrayList<>(Arrays.asList(Arrays.stream(reserve).boxed().toArray(Integer[]::new)));
        ArrayList<Integer> lent = new ArrayList<>();

        for(int i = 1; i <= n ; i++){
            if(lost_l.contains(i)){
                if(reserve_l.contains(i)){
                    reserve_l.remove(Integer.valueOf(i));
                    lent.add(i);
                }
                else if(reserve_l.contains(i-1)){
                    reserve_l.remove(Integer.valueOf(i-1));
                    lent.add(i-1);
                }
                else if(reserve_l.contains(i+1) && !(lost_l.contains(i+1))){
                    reserve_l.remove(Integer.valueOf(i+1));
                    lent.add(i+1);
                }
            }
        }
        System.out.println(lost_l);
        System.out.println(reserve_l);
        System.out.println(lent);
        
        return n - lost_l.size() + lent.size();
    }
}