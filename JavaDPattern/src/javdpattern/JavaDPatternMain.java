package javdpattern;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gopalchakravarthy
 */
public class JavaDPatternMain {

    public static void main(String[] args) {

        //Singleton design pattern
        //Get the only object available
        SingleTon singleton = SingleTon.getInstance();

        //connect to database
        MySqlConnect con = singleton.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "select notifyID,notifyKey,filePath from ReportFiles";
        try {
            ps = con.connect().prepareStatement(SQL);//factory get method used
            rs = ps.executeQuery();
            System.out.println("Data retrieved from table RePortFiles");
            while (rs.next()) {
                ReportFilesPojo rFilePojo= new ReportFilesPojo();
                rFilePojo.setNotifyID(rs.getInt(1));
                rFilePojo.setNotifyKey(rs.getString(2));
                rFilePojo.setFilePath(rs.getString(3));
                System.out.print("ID=" + rFilePojo.getNotifyID());
                System.out.print(" ;KEY=" + rFilePojo.getNotifyKey());
                System.out.println(" ;FILE=" + rFilePojo.getFilePath());
                //Factory design pattern
                NotificationService notificationService = new NotificationService();
                notificationService.notify(rFilePojo.getNotifyKey().toUpperCase(), rFilePojo.getFilePath());
          }          

        } catch (SQLException ex) {
            Logger.getLogger(JavaDPatternMain.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (con != null) {
                try {
                    con.connect().close();
                } catch (SQLException ex) {
                    Logger.getLogger(JavaDPatternMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JavaDPatternMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
