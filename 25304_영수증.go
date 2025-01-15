package main

import "fmt"

func main() {
	var X, N, a, b int
	sum := 0
	fmt.Scan(&X)
	fmt.Scan(&N)
	for i := 0; i < N; i++ {
		fmt.Scan(&a, &b)
		sum += a * b
	}
	if sum == X {
		fmt.Println("Yes")
	} else {
		fmt.Println("No")
	}

}

