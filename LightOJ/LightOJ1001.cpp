//Problem F

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin>>n;
    while(n--)
    {
        int a;
        cin>>a;
        if(a>10)
            cout<<10<<" "<<a-10<<endl;
        else
            cout<<0<<" "<<a<<endl;
    }

    return 0;
}
