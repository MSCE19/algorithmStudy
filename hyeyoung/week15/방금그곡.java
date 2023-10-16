class Solution {
    public String solution(String m, String[] musicinfos) {
        int maxPlayingTime = 0;
        String answer = "";
        
        // 네오가 기억한 멜로디 변환        
        m = changeMelody(m);
        
        for (String musicInfo : musicinfos) { 
        	String[] info = musicInfo.split(",");

        	// 재생 시간           
        	int playingTime = (Integer.parseInt(info[1].substring(0, 2)) 
            				- Integer.parseInt(info[0].substring(0, 2)))*60  
        				+ Integer.parseInt(info[1].substring(3)) 
                    			- Integer.parseInt(info[0].substring(3));
        	
        	// 악보 정보(=info[3]) #이 붙은 음 변환        	
        	info[3] = changeMelody(info[3]);
        	
        	// 음악 길이 구하기        	
        	int musicLength = info[3].length();
        	
        	// 실제 재생된 음악     	
        	String musicCode = "";
        	
        	// 재생 시간 > 음악 길이 : 처음부터 음악 반복 재생        	
        	if (playingTime > musicLength) {
        		for (int j=0; j<playingTime/musicLength; j++) {musicCode += info[3];}
        		musicCode += info[3].substring(0, playingTime%musicLength);
        	}
        	
        	// 재생 시간 <= 음악 길이 : 처음부터 재생된 시간만큼 재생
        	
        	else {musicCode += info[3].substring(0, playingTime);}
        	
            	// answer = 네오가 기억하는 멜로디 &&
            	// 제일 재생 시간이 긴 음악 제목(=info[2])            
        	if (musicCode.contains(m) && playingTime > maxPlayingTime) {
        		answer = info[2];
        		maxPlayingTime = playingTime;
        	}
        	
        }	
        
        // 조건 일치 음악 X     
        if (maxPlayingTime == 0) { answer = "(None)"; }
        
        return answer;
    }
    
    // #이 붙은 음을 변환    
    public static String changeMelody(String code) {
        code = code.replaceAll("C#", "c");
        code = code.replaceAll("D#", "d");
        code = code.replaceAll("F#", "f");
        code = code.replaceAll("G#", "g");
        code = code.replaceAll("A#", "a");
        
        return code;
    }
}
