program MongoDB;

uses
  FireDAC.Comp.Client, FireDAC.Phys.MongoDBWrapper;

var
  Connection: TFDMongoConnection;
  Query: TFDMongoQuery;
  Doc: TJSONObject;
begin
  Connection := TFDMongoConnection.Create(nil);
  try
    Connection.Params.Values['Server'] := 'mongodb://<$user>:<$password>@<$hostname>:<$port>/<$database>';
    Connection.Open;
    Query := TFDMongoQuery.Create(nil);
    try
      Query.Connection := Connection;
      Query.JSON.Add('{find: "test"}');
      Query.Execute;
      while not Query.Eof do
      begin
        Doc := Query.CurrentDoc;
        WriteLn(Doc.ToString);
        Query.Next;
      end;
    finally
      Query.Free;
    end;
  finally
    Connection.Free;
  end;
end.
