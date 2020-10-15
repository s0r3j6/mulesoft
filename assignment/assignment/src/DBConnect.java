import java.sql.*;


public class DBConnect {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public DBConnect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee-data","root","");
            st=con.createStatement();
        }catch(Exception ex){
            System.out.println("Error:"+ex);
        }
    }
    
    public void getData(){
        try{
            String query="select * from employee";
            rs=st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String ename=rs.getString("ename");
                String eid=rs.getString("eid");
                System.out.println("Name:"+ename+"   "+"Id:"+eid);
            }
                
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
