package main

import "fmt"

func main() {
	var X int
	fmt.Scan(&X)
	s := ""
	for i := 0; i < X/4-1; i++ {
		s += "long "
	}
	s += "long int"
	fmt.Println(s)

}

