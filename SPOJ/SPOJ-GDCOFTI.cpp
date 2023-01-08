#include <iostream>
using namespace std;
 
unsigned long long int gcd(long long int a, long long int b)
{
	if(a == 0 || b == 0) return a + b;
	return gcd(b % a, a);
}
 
int main() {
	// your code goes here
	unsigned long long int a, b, c;
	cin >> a >> b >> c;
	cout << gcd(a, gcd(b, c));
	return 0;
}