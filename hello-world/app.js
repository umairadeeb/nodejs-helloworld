const express = require('express');
const mysql = require('mysql');
const app = express();
const port = 3000;
const mysql_host = process.env.MYSQL_HOST;
const mysql_db = process.env.MYSQL_DB;
const mysql_user = process.env.MYSQL_USER;
const mysql_pass = process.env.MYSQL_PASS;

// create connection to database
const db = mysql.createConnection ({
    host: mysql_host,
    user: mysql_user,
    password: mysql_pass,
    database: mysql_db
});

// configure middleware
app.set('port', process.env.port || port); // set express to use this port


// app.get('/', (req, res) => res.send('Hello World!'))

app.get('/', function (req, res) {
  db.connect();

  db.query('SELECT message FROM content', function(err, rows, fields)
  {
      db.end();

      if (err) throw err;

      res.send(rows[0].message);

  });
});





app.listen(port, () => console.log(`Example app listening at http://localhost:${port}`))
