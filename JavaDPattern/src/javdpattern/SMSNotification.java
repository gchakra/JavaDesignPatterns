
package javdpattern;

/**
 *
 * @author gopalchakravarthy
 */
public class SMSNotification implements Notification {
   
    
    @Override
    public void notifyUser(String fileName) {
        // TODO Auto-generated method stub
        System.out.println("Sending an SMS notification for fileName = " + fileName);
    }

}
