/* 
    Cracking the Coding Interview
*/

const zeroMatrix = function(matrix) {
    let rowsLength = matrix.length;
    let colsLength = matrix[0].length;
    let rows = new Array(rowsLength);
    let cols = new Array(colsLength);

    for(let i = 0; i < rowsLength; i++) {
        for(let j = 0; j < colsLength; j++) {
            if(matrix[i][j] === 0) {
                rows[i] = true;
                cols[j] = true;
            }
        }
    }

    for(let i = 0; i < rows.length; i++) {
        if(Boolean(rows[i])) {
            for(let j = 0; j < colsLength; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    for (let i = 0; i < cols.length; i++) {
        if (Boolean(cols[i])) {
            for (let j = 0; j < rowsLength; j++) {
                matrix[j][i] = 0;
            }
        }
    }

    return matrix;
};

console.log(zeroMatrix([
    [1, 2, 0, 4],
    [0, 3, 7, 2],
    [0, 2, 2, 1]
]));

console.log(zeroMatrix([
    [1, 2, 3, 4],
    [0, 3, 7, 2],
    [0, 2, 2, 1]
]));

console.log(zeroMatrix([
    [1, 2, 3],
    [0, 3, 7],
    [1, 2, 2],
    [0, 2, 0]
]));

