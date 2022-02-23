#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    while(n-->0)
    {
        string s;
        cin >> s;
        if(s.size()>10)
            cout << s[0] << s.size()-2 << s[s.size()-1] << endl;
        else
            cout << s << endl;
    }
    return 0;
}