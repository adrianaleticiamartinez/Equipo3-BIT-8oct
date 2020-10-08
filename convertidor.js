//para convertir csv a json
const csvtojson = require('csvtojson');
const csvFilepath = 'db.csv'

//para guardar el archivo
const fs = require('fs');

//convierte csv a json
csvtojson()
.fromFile(csvFilepath)
.then((json) => {
    console.log(json);
    //lo escribe en un nuevo archivo en json
    fs.writeFileSync('output.json', JSON.stringify(json), "utf-8", (err) => {
        if(error) console.log(err)
    })
})