package javdpattern;

/**
 *
 * @author gopalchakravarthy
 */
public class SingleTon {
    
    //create an object of SingleTon
   private static SingleTon dbHandle = new SingleTon();

   //make the constructor private so that this class cannot be
   //instantiated
   private SingleTon(){}

   //Get the only object available
   public static SingleTon getInstance(){
       if (dbHandle==null) {
           dbHandle = new SingleTon();
       }
      return dbHandle;
   }

   public MySqlConnect getConnection(){
      MySqlConnect mysqlConnect = new MySqlConnect();
      System.out.println("You are now connected to the database!");
      return mysqlConnect;
   }
    
}
