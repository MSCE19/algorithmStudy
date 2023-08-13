import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        int n;          // 이름이 불린 선수의 추월 전 기존 등수 - 1(0부터라서)
        String ahead;   // 추월당하는 선수의 이름
        
        HashMap<String, Integer> order1 = new HashMap<>();
        HashMap<Integer, String> order2 = new HashMap<>();
        
        
        for(int i = 0 ; i < players.length ; i++){
            order1.put(players[i], i);
            order2.put(i, players[i]);
        }
        for(String name : callings){
            n = order1.get(name); // 이름이 불린 선수의 추월 전 기존 등수 - 1(0부터라서)
            ahead = order2.get(n-1); // 추월당하는 선수의 이름
            
            order1.put(name, n - 1);
            order1.put(ahead, n);
            order2.put(n-1, name);
            order2.put(n, ahead);
        }
        for(int i = 0 ; i < players.length ; i++){
            answer[i] = order2.get(i);
        }
        return answer;
    }
}