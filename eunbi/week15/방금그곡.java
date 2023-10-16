package algorithmStudy;

import java.util.*;

public class Music{
    private int music_len_ = 0;       // 음악 재생 시간
    private String melody_ = "";      // 재생된 멜로디
    private String title_ = "";       // 노래 제목
    private boolean flag_ = false;    // 조건 만족 : true, 만족 x : false
    
    public Music(String[] s){
        title_ = s[2];
        music_len_ = Integer.parseInt(s[1].substring(3, 5)) - Integer.parseInt(s[0].substring(3, 5)) + 60*(Integer.parseInt(s[1].substring(0, 2)) - Integer.parseInt(s[0].substring(0, 2)));
    }
    
    public void set_melody(String melody){ // 재생된 멜로디 계산
        melody_ = melody;
    }
    
    public int get_music_len(){
        return music_len_;
    }

    public void set_flag(String m){
        flag_ = melody_.contains(m);
    }
    
    public boolean get_flag(){
        return flag_;
    }
    
    public String get_title(){
        return title_;
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max_len = 0;
        Music[] music = new Music[musicinfos.length];
        m = convert(m.replace("#", "").length() ,m);
        
        for(int i=0; i<musicinfos.length; i++){
            music[i] = new Music(musicinfos[i].split(","));
            music[i].set_melody(convert(music[i].get_music_len(), musicinfos[i].split(",")[3]));
            music[i].set_flag(m);
        }
        
        for(int i=0; i<music.length; i++){
            if(music[i].get_flag() && max_len < music[i].get_music_len()){
                answer = music[i].get_title();
                max_len = music[i].get_music_len();
            }
        }
        
        return answer;
    }
    
    public String convert(int len, String melody){ // #을 소문자로 변경(contains 이용을 위해)
        String s = "";
        int j=0;

        for(int i=0; i<len; i++){ 
            if(j<melody.length()-1 && melody.charAt(j+1)=='#'){
                s += Character.toLowerCase(melody.charAt(j));
                len++;
            }
            else if(melody.charAt(j)=='#')
                s += "";
            else
                s += melody.charAt(j);
            j++;
            if((i+1)%melody.length()==0)
                j=0;  
        }
        
        return s;
    }
    
}
