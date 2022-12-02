var mysql = require("mysql");

var hostname = "<$hostname>";
var database = "<$database>";
var port = "<$port>";
var username = "<$user>";
var password = "<$password>";

var con = mysql.createConnection({
  host: hostname,
  user: username,
  password,
  database,
  port,
});

con.connect(function (err) {
  if (err) throw err;
  console.log("Connected!");
});

con.query("SELECT 1+1").on("result", function (row) {
  console.log(row);
});
