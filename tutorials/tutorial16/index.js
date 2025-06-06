const express = require('express')
const app = express()
const port = 8080

const phrases = [
    "Get ready to be inspired…",
    "See rejection as redirection.",
    "There is beauty in simplicity.",
    "You can’t be late until you show up.",
    "Maybe life is testing you. Don’t give up.",
    "Impossible is just an opinion.",
    "Alone or not you gonna walk forward.",
]


app.get('/', (req, res) => {
    const number = Math.floor(Math.random() * 7);
    res.send(phrases[number])   
})

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`);
}).on('error', err => {
    console.error('Error starting server:', err.message);
});
