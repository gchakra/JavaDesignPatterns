
package javdpattern;

/**
 *
 * @author gopalchakravarthy
 */
public class PushNotification implements Notification {
    
     
    @Override
    public void notifyUser(String fileName) {
        // TODO Auto-generated method stub
        System.out.println("Sending an Push notification for fileName = " + fileName);
    }

}
