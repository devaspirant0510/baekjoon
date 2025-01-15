package main

import (
	"fmt"
)

func main() {
	// 불기 연도를 입력받기
	var buddhistYear int
	fmt.Scan(&buddhistYear)

	// 서기 연도로 변환
	gregorianYear := buddhistYear - 543

	// 결과 출력
	fmt.Println(gregorianYear)
}
