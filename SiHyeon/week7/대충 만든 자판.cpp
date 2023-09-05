#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    for (auto t : targets) //ó�� target����
    {
        int count = 0;
        for (auto c : t) //�� ���ں���
        {
            int mindex = 0; //������ �ּ�Ƚ��
            //���Ű�� ������ ã�ƾ���.
            //��� Ű�� ��ȯ�ϸ鼭 �ּڰ� ã�ƾ���.
            for (int i = 0; i < keymap.size(); i++)
            {
                int index = keymap[i].find(c);
                if (index != string::npos && (mindex == 0 || mindex > index + 1))
                {
                    mindex = index + 1;
                }
            }
            if (mindex != 0) //ã�����
                count += mindex;
            else //��ã�� ��� �״�� 0
            {
                count = -1;
                break;
            }
        }
        answer.push_back(count);
    }
    return answer;
}