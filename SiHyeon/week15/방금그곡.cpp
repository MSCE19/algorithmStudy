#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string> split(string input, char delimiter)
{
    vector<string> answer;
    stringstream ss(input);
    string temp;

    while (getline(ss, temp, delimiter))
    {
        answer.push_back(temp);
    }

    return answer;
}

string traslateString(string str)
{
    const vector<string> exception = {"C#", "D#", "F#", "G#", "A#"};
    for (int i = 0; i < exception.size();)
    {
        int index = str.find(exception[i]);
        if (index == string::npos)
            i++; // 없으면 다음 문자 탐색
        else
        {
            // 있으면 치환
            str.replace(index, 2, to_string(i));
        }
    }
    return str;
}

string solution(string m, vector<string> musicinfos)
{
    // 반복재생된 횟수를 구한다
    // 횟수를 기반으로 반복된 멜로디를 구한다
    // 반복된 멜로디에 m이 있는지 확인한다
    // #을 처리하기위해 #이 붙은 문자를 다른 문자로 바꿔준다
    // C# -> 0, D# -> 1, F# -> 2, G# -> 3, A# -> 4 로 치환해서 계산
    string name = "(None)";
    int time = 0;
    for (auto info : musicinfos)
    {
        vector<string> song = split(info, ',');
        // 재생시간 구하기
        int timeDiff = stoi(song[1].substr(0, 2)) - stoi(song[0].substr(0, 2));
        int minDiff = stoi(song[1].substr(3, 2)) - stoi(song[0].substr(3, 2)) + 1;
        int playTime = ((timeDiff * 60) + minDiff);

        song[3] = traslateString(song[3]);
        m = traslateString(m);

        string melody = ""; // 재생된 멜로디
        for (int i = 0; i < playTime; i++)
            melody.push_back(song[3][i % song[3].length()]);

        printf("%s", melody.c_str());

        if (melody.find(m) != string::npos && time < playTime)
        {
            name = song[2];
            time = playTime;
        }
    }
    return name;
}