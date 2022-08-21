#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin >> t;
	for(int i = 1; i <= t; i++)
	{
		int a, b;
		cin >> a >> b;
		int sum = a + b;
		cout << "Case " << i << ": " << sum << endl;
	}
	return 0;
}