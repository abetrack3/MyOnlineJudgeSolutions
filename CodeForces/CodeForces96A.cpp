#include <iostream>

using namespace std;

int main()
{
    string s;
    cin >> s;
    if(s.size()<7)
    {
        cout << "NO" << endl;
        return 0;
    }
    else
    {
        int a=0, c=1;
        for(int i=0;i<s.size();i++)
        {
            if(s[i]!=a)
            {
                a=s[i];
                c=1;
            }
            if(c==7)
            {
                cout << "YES\n";
                return 0;
            }
            c++;
        }
    }
    cout << "NO\n";
    return 0;
}
