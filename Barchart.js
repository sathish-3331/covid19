var connection = new ActiveXObject("ADODB.Connection") ;

var connectionstring="Data Source=<jdbc:oracle:thin:@localhost:1521:XE>;Initial Catalog=<oracle.jdbc.driver.OracleDriver>;User ID=<system>;Password=<oracle>;Provider=SQLOLEDB";

connection.Open(connectionstring);
var rs = new ActiveXObject("ADODB.Recordset");

rs.Open("SELECT * FROM table", connection);
rs.MoveFirst
while(!rs.eof)
{
   document.write(rs.fields(1));
   rs.movenext;
}

rs.close;
connection.close; 