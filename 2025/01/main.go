package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	startIndex := 50
	counter := 0

	// inputFile, _ := os.Open("exampleinput.txt")
	inputFile, _ := os.Open("input01.txt")
	defer inputFile.Close()

	scanner := bufio.NewScanner(inputFile)

	currentIndex := startIndex

	for scanner.Scan() {

		step := scanner.Text()

		sign := step[0]
		stepValue, err := strconv.Atoi(step[1:])
		if err != nil {
			// show actual error
			panic(err)
		}

		if sign == 'L' {
			// go in correct direction
			stepValue = -stepValue
		}

		// task 2 to compare
		oldIndex := currentIndex
		// move to next correct index
		currentIndex = ((currentIndex+stepValue)%100 + 100) % 100

		// how many times do I pass 0?
		passes := abs(stepValue) / 100
		// each step
		// if we went left and the currentIndex is larger than old index, we passed 0
		if stepValue < 0 && currentIndex > oldIndex && oldIndex != 0 {
			passes++
			// if we went right and the currentIndex is smaller than old index, we passed 0
		} else if stepValue > 0 && currentIndex < oldIndex && oldIndex != 0 {
			passes++
		} else if stepValue < 0 && oldIndex != 0 && currentIndex == 0 {
			passes++
		}

		counter += passes
	}

	fmt.Println(counter)
}

// helper function
func abs(input int) int {
	if input < 0 {
		return -input
	}
	return input
}
