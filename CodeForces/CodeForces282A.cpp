#include <iostream>
using namespace std;

int main() {
	int t, n = 0;
	cin >> t;
	while(t--)
	{
		string s;
		cin >> s;
		if(s == "++X" || s == "X++") n++;
		else n--;
	}
	cout << n;
	return 0;
}