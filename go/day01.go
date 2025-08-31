package main

import (
	"fmt"
	"os" 
	"bufio"
)

func main() {
	file, err := os.Open("./files/input.txt")
	if err != nil {
		fmt.Println("Error opening file:", err)
		return
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		fmt.Println(scanner.Text())
	}

	if err:= scanner.Err(); err != nil {
		fmt.Println("Error:", err)
	}
}