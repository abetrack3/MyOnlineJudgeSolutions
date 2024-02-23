//Problem G
#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin>>n;
    for(int i=1;i<=n;i++)
    {
        int nn;
        cin>>nn;
        int max;
        cin>>max;
        for(int j=1;j<nn;j++)
        {
            int temp;
            cin>>temp;
            if(temp>max)
                max=temp;
        }
        cout<<"Case "<<i<<": "<<max<<endl;
    }

    return 0;
}
