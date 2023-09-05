package prgmrs;

import java.util.Arrays;

public class 바탕화면정리 {
    public static void main(String[] args) {
        String[] wallpaper = {".....", "....#"};
        solution(wallpaper);
    }

    private static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        char[][] map = new char[wallpaper.length][wallpaper[0].length()];

        Arrays.fill(answer, 0);
        answer[0] = wallpaper.length;
        answer[1] = wallpaper[0].length();

        for (int i = 0; i < wallpaper.length; i++) {
            String line = wallpaper[i];
            for (int j = 0; j < line.length(); j++) {
                map[i][j] =line.charAt(j);
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j]=='#'){
                    System.out.println("i  = "+ i + "j = "+ j);
                    answer[0] = Math.min(answer[0],i);
                    answer[1] = Math.min(answer[1],j);
                    answer[2] = Math.max(answer[2],i+1);
                    answer[3] = Math.max(answer[3],j+1);

                }
            }
        }
        //System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;

    }
}
