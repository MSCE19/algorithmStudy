package prgmrs;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 공원산책 {
    static char[][] map;
    static int[] answer;
    static ArrayDeque<Route> dq = new ArrayDeque<>();

    private static class Route {
        String dir;
        int times;

        public Route(String dir, int times) {
            this.dir = dir;
            this.times = times;
        }
    }

    public static void main(String[] args) {
        String[] park = {"OSO", "OOO", "OXO", "OOO"};
        String[] routes = {"E 2", "S 3", "W 1"};

        solution(park, routes);
    }

    private static int[] solution(String[] park, String[] routes) {
        answer = new int[2];
        map = new char[park.length][park[0].length()];

        for (int i = 0; i < map.length; i++) {
            String line = park[i];
            for (int j = 0; j < map[i].length; j++) {

                char now = line.charAt(j);
                map[i][j] = now;
                if (now == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        for (int i = 0; i < routes.length; i++) {
            String direction = routes[i].split(" ")[0];
            int times = Integer.parseInt(routes[i].split(" ")[1]);
            dq.addLast(new Route(direction, times));
            moveRobot();
        }
        return answer;
    }

    private static boolean checkOutofParkRange(int y, int x) {
        if (y < 0 || x < 0 || y >= map.length || x >= map[0].length || map[y][x] == 'X') {
            return false;
        }
        return true;
    }

    private static void moveRobot() {
        while (!dq.isEmpty()) {
            Route now = dq.pollFirst();
            if (now.dir.equals("E")) {
                for (int i = 1; i <= now.times; i++) {
                    if (!checkOutofParkRange(answer[0], answer[1] + i)) return;

                }
                answer[1] = answer[1] + now.times;
            } else if (now.dir.equals("W")) {
                for (int i = 1; i <= now.times; i++) {
                    if (!checkOutofParkRange(answer[0], answer[1] - i)) return;

                }
                answer[1] = answer[1] - now.times;
            } else if (now.dir.equals("S")) {
                for (int i = 1; i <= now.times; i++) {
                    if (!checkOutofParkRange(answer[0] + i, answer[1])) return;

                }
                answer[0] = answer[0] + now.times;
            } else if (now.dir.equals("N")) {
                for (int i = 1; i <= now.times; i++) {
                    if (!checkOutofParkRange(answer[0] - i, answer[1])) return;
                }
                answer[0] = answer[0] - now.times;
            }


        }
    }
}