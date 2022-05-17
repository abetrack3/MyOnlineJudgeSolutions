/*
 * Complete the reverseString function
 * Use console.log() to print to stdout.
 */
function reverseString(s) {
    let reverseS = "";
    try {
        s.split();
        for(let i = s.length - 1; i >= 0; i--) {
            reverseS += s[i];
        }
    } catch (err) {
        console.log(err.message);
        reverseS = s;
    }
    console.log(reverseS);
}

