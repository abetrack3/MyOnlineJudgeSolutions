/*
 * Complete the vowelsAndConsonants function.
 * Print your output using 'console.log()'.
 */
function vowelsAndConsonants(s) {
    let vowels = [];
    let consonants = [];
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (c === 'a' || c === 'e' || c === 'i' || c === 'o' || c === 'u') {
            vowels.push(c);
        } else {
            consonants.push(c);
        }
    }
    vowels.forEach((c) => {console.log(c);})
    consonants.forEach((c) => {console.log(c);})
}

