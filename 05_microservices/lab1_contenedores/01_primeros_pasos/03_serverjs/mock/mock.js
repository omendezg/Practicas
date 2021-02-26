var express = require('express') //llamamos a Express
var app = express()   
var port = process.env.PORT || 8000


app.get('/version', function(req, res) {
    res.json({ mensaje: '¡Hola Mundo!' })   
        console.log("¡Hola Mundo!");    
  })
  
  app.get('/cervezas', function(req, res) {
    res.json({ mensaje: '¡A beber cerveza!' })  
    console.log("¡A beber cerveza!");    
  })
  
  app.post('/', function(req, res) {
    res.json({ mensaje: 'Método post' })  
        console.log("¡Método post!");     
  })
  
  app.del('/', function(req, res) {
    res.json({ mensaje: 'Método delete' })  
    console.log("¡Método delete!"); 
  })

app.listen(port)
