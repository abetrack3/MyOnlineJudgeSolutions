#include <bits/stdc++.h>
using namespace std;

int main()
{
    vector <int> v;
    int n, d;
    cin >> n;
    while(n-->0)
    {
        cin >> d;
        v.push_back(d);
    }
    sort(v.begin(), v.end());
    for(int i=0;i<v.size()-1;i++)
        cout << v[i] << " ";
    cout << v[v.size()-1] << endl;
    return 0;
}
