class position{
    int h;
    int w;
    public position(int h, int w){
        this.h = h;
        this.w = w;
    }
}
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] dog = new int[2];
        position dogPosition = new position(-1, -1);
        
        //시작 지점 구하기
        for(int i = 0 ; i < park.length; i++){
            for(int j = 0 ; j < park[0].length() ; j++){
                if(park[i].charAt(j) == 'S'){
                    dog[0] = i;
                    dog[1] = j;
                }
            }
        }
        
        for(int i = 0 ; i < routes.length ; i++){
            if(in_the_map(park, routes[i], dog[0], dog[1])){
                dogPosition = no_X(park, routes[i], dog[0], dog[1]);
                if(dogPosition.h >= 0){
                    dog[0] = dogPosition.h;
                    dog[1] = dogPosition.w;
                }                
            }
        }        
        
        return dog;
    }
    public boolean in_the_map(String[] park, String route, int h, int w){
        char direction = route.charAt(0);
        int distance = route.charAt(2) - '0';
        
        if(direction == 'N')
            h -= distance;
        else if(direction == 'S')
            h += distance;
        else if(direction == 'W')
            w -= distance;
        else if(direction == 'E')
            w += distance;
        
        if(h < 0 || h >= park.length)
            return false;
        if(w < 0 || w >= park[0].length())
            return false;
        
        return true;
    }
    public position no_X(String[] park, String route, int h, int w){
        char direction = route.charAt(0);
        int distance = route.charAt(2) - '0';
        
        if(direction == 'N'){
            for(int i = 0 ; i < distance ; i++){
                h--;
                if(park[h].charAt(w) == 'X')
                    return new position(-1, -1);
            }
        }
        else if(direction == 'S'){
            for(int i = 0 ; i < distance ; i++){
                h++;
                if(park[h].charAt(w) == 'X')
                    return new position(-1, -1);
            }
        }
        else if(direction == 'W'){
            for(int i = 0 ; i < distance ; i++){
                w--;
                if(park[h].charAt(w) == 'X')
                    return new position(-1, -1);
            }
            
        }
        else if(direction == 'E'){
            for(int i = 0 ; i < distance ; i++){
                w++;
                if(park[h].charAt(w) == 'X')
                    return new position(-1, -1);
            }
        }
        
        return new position(h, w);
    }
}