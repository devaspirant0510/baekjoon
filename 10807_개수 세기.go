package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {

	// 입력 준비
	reader := bufio.NewReader(os.Stdin)

	// 첫 번째 줄: N 읽기
	nStr, _ := reader.ReadString('\n')
	N, _ := strconv.Atoi(strings.TrimSpace(nStr))

	// 두 번째 줄: arr 문자열 읽기
	arr, _ := reader.ReadString('\n')
	arr = strings.TrimSpace(arr)

	// 세 번째 줄: v 읽기
	vStr, _ := reader.ReadString('\n')
	v, _ := strconv.Atoi(strings.TrimSpace(vStr))

	// arr 문자열을 공백으로 분리
	split := strings.Split(arr, " ")
	count := 0
	for i := 0; i < N; i++ {
		atoi, _ := strconv.Atoi(split[i])
		if atoi == v {
			count++
		}
	}

	fmt.Print(count)
}

