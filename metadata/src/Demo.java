import java.sql.Connection;
import java.io.FileInputStream;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.ResultSet; 
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Demo
{
static String url;
static String un;
static String password;
static Connection Con1;
static Connection Con2;

	public static void main(String[] args)throws Exception
	{
		// TODO Auto-generated method stub
Statement stmt;
String path1="E:\\n1 Work space\\Noon batch\\src\\p1\\myconnect.properties";
FileInputStream fis1=new FileInputStream(path1);
Properties p1=new Properties();
p1.load(fis1);
url=p1.getProperty("url");
un=p1.getProperty("un");
password=p1.getProperty("password");
Con1=DriverManager.getConnection(url,un,password);
System.out.println("connection established to student DB");
System.out.println();
stmt=Con1.createStatement();
ResultSet res=stmt.executeQuery("SELECT*FROM DETAILS");
ResultSet  MetaData mres=res.getMetaData();
for(int i=1;i<=mres.getColumncount();i++)
{
	System.out.println("columnName->"+mres.getColumnName(i)+"columnDataType->"+mres.getColumnTypeName(i));
	System.out.println("----------------");
	
	
}

	}

}
