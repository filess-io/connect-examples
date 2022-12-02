const { Client } = require("pg");

const client = new Client({
  user: "<$user>",
  host: "<$hostname>",
  database: "<$database>",
  password: "<$password>",
  port: "<$port>",
});

async function main() {
  await client.connect();

  const res = await client.query("SELECT $1::text as message", [
    "Hello world!",
  ]);
  console.log(res.rows[0].message); // Hello world!
  await client.end();
}

main().catch(console.error);
