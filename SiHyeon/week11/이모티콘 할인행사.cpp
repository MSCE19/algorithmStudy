#include <string>
#include <vector>

using namespace std;

void getDuplicatePermutation(vector<vector<int>> *allDiscount, vector<int> arr, int depth)
{
    if (depth == arr.size())
    {
        allDiscount->push_back(arr);
        return;
    }

    for (int i = 1; i <= 4; i++)
    {
        arr[depth] = i * 10;
        getDuplicatePermutation(allDiscount, arr, depth + 1);
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons)
{
    vector<int> answer = {0, 0};
    vector<int> arr;
    vector<vector<int>> allDiscount;
    arr.assign(emoticons.size(), 0);
    getDuplicatePermutation(&allDiscount, arr, 0); // 모든 할인률의 조합
    for (auto discount : allDiscount)
    {
        int join = 0;
        int totalRevenue = 0;
        for (auto u : users)
        {
            int price = 0;
            for (int i = 0; i < emoticons.size(); i++)
            {
                if (discount[i] >= u[0]) // 구매
                {
                    price += emoticons[i] - (emoticons[i] * (discount[i] / 100.));
                }
            }
            if (price >= u[1]) // 가입하는 경우
            {
                join++;
            }
            else // 가입안하는 경우
            {
                totalRevenue += price;
            }
        }
        // 가입자 수가 많아지거나 같은때 수입이 많아진 경우
        if (join > answer[0] || (join == answer[0] && answer[1] < totalRevenue))
        {
            answer[0] = join;
            answer[1] = totalRevenue;
        }
    }
    return answer;
}