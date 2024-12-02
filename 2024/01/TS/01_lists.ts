const pathToText: string = "numbers.txt";

let list01: number[] = [];
let list02: number[] = [];
let diff: number[] = [];

// read into memory as string
const fileContent = await Deno.readTextFile(pathToText);
// split on each line into a separate object
const eachLine = fileContent.split("\n");
// add to lists
let i: number = 0;
for (i; i < eachLine.length; i++) {
  // need to split the two numbers
  let eachNum = eachLine[i].split(" ");
  // now add first one to list01
  list01.push(Number(eachNum[0]));
  // and list02
  list02.push(Number(eachNum[1]));
}

list01.sort((a, b) => a - b);
list02.sort((a, b) => a - b);

// console.log(list01);
// console.log(list02);

function absoluteDiff(list01, list02) {
  let absoluteDiff: number = 0;
  let e: number = 0;
  for (e; e < eachLine.length; e++) {
    let difference: number = Math.abs(list01[e] - list02[e]);
    absoluteDiff = absoluteDiff + difference;
  }
  //   console.log(absoluteDiff);
  return absoluteDiff;
}

const absoluteDifference = absoluteDiff(list01, list02);

console.log(absoluteDifference);
