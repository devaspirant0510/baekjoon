#include <stdio.h>
 
int main() {
	int n,el;
	scanf("%d",&n);
	int i, j;
	
	int num[10001] = { 0 };
	for (i=0; i<n; i++){
		scanf("%d",&el);
		num[el]++;
	} 
	


	for (i = 0; i < 10001; i++) {
		if (num[i] != 0) {
			for (j = 0; j < num[i]; j++) {
				printf("%d\n", i);

			}
		}

	}
	return 0;
}
