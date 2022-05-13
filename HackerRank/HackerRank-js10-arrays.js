'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

/**
*   Return the second largest number in the array.
*   @param {Number[]} nums - An array of numbers.
*   @return {Number} The second largest number in the array.
**/
function getSecondLargest(nums) {
    if (nums.length == 1) return nums[0];
    let first = nums[0] > nums[1] ? nums[0] : nums[1];
    let second = nums[0] > nums[1] ? nums[1] : nums[0];
    for (let index = 2; index < nums.length; index++) {
        const element = nums[index];
        if (element > first) {
            second = first;
            first = element;
        } else if (first > element && element > second) {
            second = element;
        }
    }
    return second;
}


function main() {
    const n = +(readLine());
    const nums = readLine().split(' ').map(Number);
    
    console.log(getSecondLargest(nums));
}