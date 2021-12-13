import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sql {

    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PASSWORD = "as123456As";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        ResultSet res = null;
        Statement stmt = conn.createStatement();
        System.out.println("-------------------");
        System.out.println("第1题效果");
        System.out.println("-------------------");
        String sql1 = "insert into  students(sno,name,age,College)values('s001','老大',20,'计算机学院'),('s002','老二',19,'计算机学院'),('s003','老三',18,'计算机学院'),('s004','老四',17,'计算机学院')";
        stmt.executeUpdate(sql1);

        String query1 = "select * from students";
        res = stmt.executeQuery(query1);
//2

        while(res.next()){
            String sno = res.getString(1);
            String name =res.getString(2);
            String age = res.getString(3);
            String College = res.getString(4);
            System.out.println(sno+','+name+','+age+','+College);
        }
        System.out.println("-------------------");
        System.out.println("第2题效果");
        System.out.println("-------------------");
        String query2 = "select * from students";
        res = stmt.executeQuery(query2);


        while(res.next()){
            String sno = res.getString(1);
            String name =res.getString(2);
            String age = res.getString(3);
            String College = res.getString(4);
            System.out.println(sno+','+name+','+age+','+College);
        }

        System.out.println("-------------------");
        System.out.println("第3题效果");
        System.out.println("-------------------");
        String sql2 = "delete  from students where sno='s004'";
        stmt.executeUpdate(sql2);
        String query3 = "select * from students";
        res = stmt.executeQuery(query3);


        while(res.next()){
            String sno = res.getString(1);
            String name =res.getString(2);
            String age = res.getString(3);
            String College = res.getString(4);
            System.out.println(sno+','+name+','+age+','+College);
        }



        System.out.println("-------------------");
        System.out.println("第4题效果");
        System.out.println("-------------------");
        String sql3 = "select * from students where sno='s003'";
        res = stmt.executeQuery(sql3);
        while(res.next()){
            String sno = res.getString(1);
            String name =res.getString(2);
            String age = res.getString(3);
            String College = res.getString(4);
            System.out.println("SNO="+sno+','+"Name="+name+','+"Age"+age+','+"College="+College);
        }
        String query4 = "select * from students";
        res = stmt.executeQuery(query4);


        while(res.next()){
            String sno = res.getString(1);
            String name =res.getString(2);
            String age = res.getString(3);
            String College = res.getString(4);
            System.out.println(sno+','+name+','+age+','+College);
        }
        System.out.println("-------------------");
        System.out.println("第5题效果");
        System.out.println("-------------------");
        String sql4 ="update students set sno='s001',name='老大',age = 20,College='通信学院' where sno='s001'";
        String sql5 = "select * from students";
        stmt.executeUpdate(sql4);
        res = stmt.executeQuery(sql5);


        while(res.next()){
            String sno = res.getString(1);
            String name =res.getString(2);
            String age = res.getString(3);
            String College = res.getString(4);
            System.out.println(sno+','+name+','+age+','+College);
        }
    }

}
