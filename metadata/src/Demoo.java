import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.Statement;
public class Demoo {
	static String url;
	static String un;
	static String password;
	static Connection con1;
	static Connection con2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		statement stmt;
		String path1="E:\\n1 Work space\\Noon batch\\src\\p1\\myconnect.properties";
		FileInputStream fis1=new FileInputStream(path1);
		Properties p1=new Properties();
		p1.load(fis1);
		url=p1.getProperty("url");
		un=p1.getProperty("un");
		password=p1.getProperty("password");
		con1=DriverManager.getConnection(url,un,password);
		System.out.println("connection established to student DB");
		System.out.println();
		stmt=con1.createStatement();
		ResultSet res=stmt.executeQuery("SELECT*FROM DETAILS");
	while(res.next()==true)
	{
		System.out.println("Row Number"+res.getRow());
		String u=res.getString("usn");
		String n=res.getString("name");
		int m1=res.getInt("sub1");
		int m2=res.getInt("sub2");
		int m3=res.getInt("sub3");
		
		float avg=res.getFloat("average");
		System.out.println("student Details \n USN->"+u+"\n Name->"+n+"\nmarks1:"+m1+"marks2:"+m2+"marks3:"+m3+"\nTotal average:"+avg);
		System.out.println();
	}
	}

}
