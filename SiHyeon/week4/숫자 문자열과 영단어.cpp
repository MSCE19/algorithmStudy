#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    for (int i = 0; i < s.size(); i++)
    {
        if (s[i] >= '0' && s[i] <= '9')
        {
            answer = (answer * 10) + (s[i] - '0');
        }
        else
        {
            switch (s[i])
            {
            case 'z':
                answer = (answer * 10) + 0;
                i += 3;
                break;
            case 'o':
                answer = (answer * 10) + 1;
                i += 2;
                break;
            case 't':
                if (s[i + 1] == 'w')
                {
                    answer = (answer * 10) + 2;
                    i += 2;
                }
                else
                {
                    answer = (answer * 10) + 3;
                    i += 4;
                }
                break;
            case 'f':
                if (s[i + 1] == 'o')
                {
                    answer = (answer * 10) + 4;
                    i += 3;
                }
                else
                {
                    answer = (answer * 10) + 5;
                    i += 3;
                }
                break;
            case 's':
                if (s[i + 1] == 'i')
                {
                    answer = (answer * 10) + 6;
                    i += 2;
                }
                else
                {
                    answer = (answer * 10) + 7;
                    i += 4;
                }
                break;
            case 'e':
                answer = (answer * 10) + 8;
                i += 4;
                break;
            case 'n':
                answer = (answer * 10) + 9;
                i += 3;
                break;
            }
        }
    }
    return answer;
}