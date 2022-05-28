#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    while(n-->0)
    {
        int a;
        cin >> a;
        int c;
        long long b;
        b=a;
        b*=a-1;
        b/=2;
        while(a-->0)
            cin >> c;
        cout << b << endl;
    }
    return 0;
}