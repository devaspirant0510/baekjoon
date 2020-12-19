#include<stdio.h>


int main(void) {

	char buffer = 0;
	int number = 0;
	int i;
	scanf("%d", &number);
	scanf("%c", &buffer);
	long long sum = 0;
	int box = 0;
	long long list[51] = { 0 };
	list[1] = 1;
	for ( i = 2; i < 51; i++) {
		list[i] = (list[i - 1] * 31) % 1234567891;
	}

	for( i=1;i<=number;i++){
		scanf("%c", &buffer);
		box = buffer %96;
		sum = (sum+box*list[i]) % 1234567891;
	}
	printf("%d", sum % 1234567891);
	return 0;
}
