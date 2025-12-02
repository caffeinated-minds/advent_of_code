package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

// Task 1
func main() {
	const startingIndex int = 50

	fmt.Println(howManyZeros(getAllIndeces(startingIndex, getAllSteps())))
}

func getAllSteps() []int {
	var steps []int

	inputFile, err := os.Open("input01.txt")
	if err != nil {
		fmt.Print("Error:", err)
		return nil
	}
	defer inputFile.Close()

	// scanner to read each line
	scanner := bufio.NewScanner(inputFile)

	// Loop through each line to read
	for scanner.Scan() {
		line := scanner.Text()
		// fmt.Println(convertLine(line))
		steps = append(steps, convertLine(line))
	}

	if err := scanner.Err(); err != nil {
		fmt.Println("Error:", err)
	}

	return steps
}

func convertLine(stringToSplit string) int {
	directionChar := stringToSplit[0]

	valueToMove := stringToSplit[1:]

	numberToReturn, err := strconv.Atoi(valueToMove)
	if err != nil {
		fmt.Println("Error:", err)
		return 0
	}

	if directionChar == 'L' {
		return -numberToReturn
	}

	return numberToReturn
}

func getAllIndeces(startingIndex int, convertedValues []int) []int {
	currentIndex := startingIndex
	var allIndeces []int

	for i := 0; i < len(convertedValues); i++ {
		// fmt.Println(currentIndex)
		// fmt.Println(convertedValues[i])

		currentIndex = currentIndex + convertedValues[i]

		currentIndex = ((currentIndex % 100) + 100) % 100

		allIndeces = append(allIndeces, currentIndex)
		// fmt.Println(allIndeces)
	}

	return allIndeces
}

func howManyZeros(sliceToCount []int) int {
	var counter int

	for _, value := range sliceToCount {
		if value == 0 {
			counter++
		}
	}

	return counter
}
