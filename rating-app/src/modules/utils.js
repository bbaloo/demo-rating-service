export const getHumanReadableDate = timestamp => {
    const date = new Date(timestamp * 1000);
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    return `${appendLeadingZeroes(day)}-${appendLeadingZeroes(month)}-${year}`;
};

const appendLeadingZeroes = n =>  (n <= 9) ? "0" + n :  n;