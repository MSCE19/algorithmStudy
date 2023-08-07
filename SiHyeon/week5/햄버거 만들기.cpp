#include <string>
#include <vector>

using namespace std;

int solution(vector<int> ingredient) {
    int answer = 0;
    vector<int> buger = { 1,2,3,1 };
    int index = 0;
    for (int i = 0; i < ingredient.size(); i++)
    {
        if (ingredient[i] == 1 && i + buger.size() <= ingredient.size())
            for (int j = 0; j < buger.size(); j++)
            {
                if (buger[j] != ingredient[i + j]) //시작재료가 아니거나 만들 재료가 부족하거나 재료가 다르면 넘어감
                    break;
                else if (j == buger.size() - 1) //끝까지 했으면 완성
                {
                    ingredient.erase(ingredient.begin() + i, ingredient.begin() + i + j + 1);
                    i = i - 3 > 0 ? i - 3 : -1; //완성을 하면 맨처음부터 다시 찾는것이 아니라 완성된 위치에서 뒤로 2번째부터 찾으면 된다. 그보다 전것은 이미 못만드는 것이기 때문
                    answer++;
                }
            }
    }
    return answer;
}