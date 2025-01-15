package main

import "fmt"

func main() {
	var a, b, c int
	var max = -10
	for i := 0; i < 3; i++ {
		if i == 0 {
			fmt.Scan(&a)
			if max < a {
				max = a
			}
		} else if i == 1 {
			fmt.Scan(&b)
			if max < b {
				max = b
			}
		} else {
			fmt.Scan(&c)
			if max < c {
				max = c
			}
		}

	}
	if a == b && b == c {
		fmt.Println(10000 + a*1000)
	} else if a == b || a == c {
		fmt.Println(1000 + a*100)
	} else if b == c {
		fmt.Println(1000 + b*100)
	} else {
		fmt.Println(max * 100)

	}

}

