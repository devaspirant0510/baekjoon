package main

import (
	"fmt"
)

func main() {
	var h int
	var m int
	var time int
	fmt.Scan(&h, &m)
	fmt.Scan(&time)
	var t = h*60 + m + time
	if t/60 >= 24 {
		fmt.Printf("%d %d", t/60-24, t%60)
	} else {
		fmt.Printf("%d %d", t/60, t%60)

	}

}

