
package javdpattern;

/**
 *
 * @author gopalchakravarthy
 */
public class NotificationService {
    public void notify(String args, String fileName)
    {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification(args, fileName);
        notification.notifyUser(fileName);
    }
    
}
