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

function getGrade(score) {
    let grade = score > 25  ? "A" :
                score > 20  ? "B" :
                score > 15  ? "C" :
                score > 10  ? "D" :
                score > 5   ? "E" : "F";    
    return grade;
}


function main() {
    const score = +(readLine());
    
    console.log(getGrade(score));
}