#include <iostream>

using namespace std;

int main()
{
    string s;
    int n=1;
    cin >> s;
    while(s!="*")
    {
        if(s=="Hajj")
            cout << "Case " << n << ": Hajj-e-Akbar\n";
        else if(s=="Umrah")
            cout << "Case " << n << ": Hajj-e-Asghar\n";
        cin >> s;
        n++;
    }
    return 0;
}
