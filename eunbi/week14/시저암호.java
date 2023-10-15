package algorithmStudy;

class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        
        for(int i=0; i<s.length(); i++){
            if((arr[i]>='a' && arr[i]<='z'))
                arr[i] = caesar(arr[i], n, 0);
            else if((arr[i]>='A' && arr[i]<='Z'))
                arr[i] = caesar(arr[i], n, 1);
        }
        
        return String.valueOf(arr);
    }
    
    public char caesar(char c, int n, int flag){
        if((c + n) > 'z')
            c += (char)(n + 'a'- 1 - 'z');
        else if((c + n) > 'Z' && flag==1)
            c += (char)(n + 'A' - 1 - 'Z');
        else
            c += n;
       
        return c;
    }
}
