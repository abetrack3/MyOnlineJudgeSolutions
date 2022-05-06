'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the 'getTotalX' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER_ARRAY b
 */

function getTotalX(a, b) {
    // Write your code here
    let totalGCD = b[0];
    b.forEach(element => {
        totalGCD = gcd(totalGCD, element);
    });
    let totalLCM = a[0];
    a.forEach(element => {
        totalLCM = lcm(totalLCM, element);
    });
    if (totalLCM > totalGCD) return 0;
    if (totalLCM == totalGCD) return 1;
    return numberOfDivisor(totalGCD / totalLCM);
}

function numberOfDivisor(a) {
    let count = 2;
    for(let i = 2; i * i <= a; i++) {
        if(a % i === 0){
            count += 2;
            if (i * i === a) {
                count -= 1;
            }
        }
    }
    return count;
}

function gcd(a, b) {
    if (a === 0 || b === 0)
        return a + b;
    return gcd(b%a, a);
}

function lcm(a, b) {
    return (a * b) / gcd(a, b);
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const firstMultipleInput = readLine().replace(/\s+$/g, '').split(' ');

    const n = parseInt(firstMultipleInput[0], 10);

    const m = parseInt(firstMultipleInput[1], 10);

    const arr = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));

    const brr = readLine().replace(/\s+$/g, '').split(' ').map(brrTemp => parseInt(brrTemp, 10));

    const total = getTotalX(arr, brr);

    ws.write(total + '\n');

    ws.end();
}
