package javdpattern;

/**
 *
 * @author gopalchakravarthy
 */
public class EmailNotification implements Notification {
 
   
    @Override
    public void notifyUser(String fileName) {
        // TODO Auto-generated method stub
        System.out.println("Sending an Email notification for fileName = " + fileName);
    }

}
