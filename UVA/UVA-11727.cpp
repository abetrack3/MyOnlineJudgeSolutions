#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin>>n;
    for(int i=1;i<=n;i++)
    {
        int arr[3];
        cin>>arr[0]>>arr[1]>>arr[2];
        sort(arr, arr+3);
        cout<<"Case "<<i<<": "<<arr[1]<<endl;
    }

    return 0;
}