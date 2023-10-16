#include <string>
#include <vector>

using namespace std;

string solution(int a, int b)
{
    int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};   // 1~12월 날 수
    string day[] = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"}; // 금요일부터 시작
    int index = 0;                                                    // 월의 날 수를 다 더한 값
    for (int i = 0; i < a - 1; i++)
        index += month[i];
    index = (index + b) % 7 - 1;
    return day[index == -1 ? 6 : index];
}