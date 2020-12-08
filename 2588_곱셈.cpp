#include <stdio.h>
 
int main() {
    int a, b;
  
    scanf("%d", &a);
    scanf("%d", &b);

    int b1 = b/100;
    int b2 = (b-(b1*100))/10;
    int b3 = b-(b1*100)-(b2*10);


    printf("%d\n",b3*a);
    printf("%d\n",b2*a);
    printf("%d\n",b1*a);
    printf("%d",b*a);
    return 0;
}
