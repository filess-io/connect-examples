var MongoClient = require("mongodb").MongoClient;

var hostname = "<$hostname>";
var database = "<$database>";
var port = "<$port>";
var username = "<$user>";
var password = "<$password>";

var url =
  "mongodb://" +
  username +
  ":" +
  password +
  "@" +
  hostname +
  ":" +
  port +
  "/" +
  database;

MongoClient.connect(url, function (err, db) {
  if (err) throw err;
  console.log("Connected to database!");
});
