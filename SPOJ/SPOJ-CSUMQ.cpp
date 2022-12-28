#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	int size;
	cin >> size;
	int arr[size];
	cin >> arr[0];
	for(int i = 1; i < size; i++)
	{
		cin >> arr[i];
		arr[i] += arr[i - 1];
	}
	int query;
	cin >> query;
	for(int i = 0; i < query; i++)
	{
		int a, b;
		cin >> a >> b;
		if(a) cout << arr[b] - arr[a - 1] << endl;
		else cout << arr[b] << endl;
	}
	return 0;
}