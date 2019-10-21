import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import java.sql.*;

public class PPA2Service {
    @GET
    @Path("/bmi")
    @Produces(MediaType.TEXT_HTML)
    public String getBmiTable() {
        Statement stat;
        ResultSet rs;
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PPA2DB", "root", "root");
            stat = con.createStatement();
            rs = stat.executeQuery("SELECT * FROM BMI");
            ResultSetMetaData metaData = rs.getMetaData();
            String result = "<html><head><title>BMI Table</title></head><body><table>";
            result += "<tr><th>" + metaData.getColumnLabel(1) + "</th>";
            result += "<th>" + metaData.getColumnLabel(2) + "</th>";
            result += "<th>" + metaData.getColumnLabel(3) + "</th>";
            result += "<th>" + metaData.getColumnLabel(4) + "</th></tr>";
            while(rs.next()) {
                result += "<tr><td>" + rs.getInt(1) + "</td>";
                result += "<td>" + rs.getInt(2) + "</td>";
                result += "<td>" + rs.getInt(3) + "</td>";
                result += "<td>" + rs.getString(4) + "</td></tr>";
            }
            result += "</table></body></html>";
            con.close();
            return result;
        }
        catch(Exception e) { e.printStackTrace(); }
    }

    //Path should be formatted /bmi/feet-inches-pounds, where those are valid args to the PPA1 function.
    @GET
    @Path("/bmi/{args}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcBmi(@PathParam(value="args") String args) {
        String[] splitArgs = args.split("-", 3);
        int[] nums = new int[3];
        for(int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(splitArgs[i]);
        }

        return "Your BMI is " + PPA1.bmiCalculator(nums[0], nums[1], nums[2]) + ", making you" + PPA1.bodyMassIndex(nums[0], nums[1], nums[2]);
    }

    @GET
    @Path("/shortestdistance")
    @Produces(MediaType.TEXT_HTML)
    public String getSDTable() {
        Statement stat;
        ResultSet rs;
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PPA2DB", "root", "root");
            stat = con.createStatement();
            rs = stat.executeQuery("SELECT * FROM Distance");
            ResultSetMetaData metaData = rs.getMetaData();
            String result = "<html><head><title>BMI Table</title></head><body><table>";
            result += "<tr><th>" + metaData.getColumnLabel(1) + "</th>";
            result += "<th>" + metaData.getColumnLabel(2) + "</th>";
            result += "<th>" + metaData.getColumnLabel(3) + "</th>";
            result += "<th>" + metaData.getColumnLabel(4) + "</th>";
            result += "<th>" + metaData.getColumnLabel(5) + "</th></tr>";
            while(rs.next()) {
                result += "<tr><td>" + rs.getDouble(1) + "</td>";
                result += "<td>" + rs.getDouble(2) + "</td>";
                result += "<td>" + rs.getDouble(3) + "</td>";
                result += "<td>" + rs.getDouble(4) + "</td>";
                result += "<td>" + rs.getString(5) + "</td></tr>";
            }
            result += "</table></body></html>";
            con.close();
            return result;
        }
        catch(Exception e) { e.printStackTrace(); }
    }

    //Path should be formatted /shortestdistance/x1-y1-x2-y2, where those are valid args to the PPA1 function.
    @GET
    @Path("/shortestdistance/{args}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcSD(@PathParam(value="args") String args) {
        String[] splitArgs = args.split("-", 4);
        int[] nums = new int[4];
        for(int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(splitArgs[i]);
        }

        return PPA1.shortestDistance(nums[0], nums[1], nums[2], nums[3]);
    }
}
