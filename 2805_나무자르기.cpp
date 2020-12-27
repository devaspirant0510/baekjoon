#include <stdio.h>



int  tree[1000001];



int main(void){

 

    int N, M;

    long long max = 0;

    long long left, right;

    long long result = 0;

    scanf("%d %d", &N, &M);

 

    for (long long i = 0; i < N; i++){

        

		scanf("%d", &tree[i]);

        

		if (max < tree[i])

            max = tree[i];

				

    }



    left = 0; right = max;

 

    while (left <= right){

        long long mid = (left + right) / 2;

        long long total = 0;

        for (long long i = 0; i < N; i++)

            if (mid < tree[i])

                total += tree[i]-mid;

 

        if (total >= M){

            if (result<mid)

                result = mid;

            left = mid + 1;

        }

        else{

            right = mid - 1;

        }

 

    }

 

    printf("%lld\n", result);

 

    return 0;

}




