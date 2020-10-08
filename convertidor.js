//para convertir csv a json
const csvtojson = require('csvtojson');
const dbClientes = 'baseClientesHackaton8Oct.csv'
const dbUsuarios =  'baseUsuarios.csv'
//para guardar el archivo
const fs = require('fs');

//convierte csv a json
csvtojson()
.fromFile(dbUsuarios)
.then((json) => {
    console.log(json);
    //lo escribe en un nuevo archivo en json
    fs.writeFileSync('dbClientes.json', JSON.stringify(json), "utf-8", (err) => {
        if(error) console.log(err)
    })
})
csvtojson()
.fromFile(dbUsuarios)
.then((json) => {
    console.log(json);
    //lo escribe en un nuevo archivo en json
    fs.writeFileSync('dbUsuarios.json', JSON.stringify(json), "utf-8", (err) => {
        if(error) console.log(err)
    })
})