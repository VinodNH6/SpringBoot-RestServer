package demo.schedulers;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
   //Execute the task every minute starting at 9:00 AM and ending at 9:59 AM, every day	
	
//   @Scheduled(cron = "0 * 9 * * ?")
//   public void cronJobSch() {
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//      Date now = new Date();
//      String strDate = sdf.format(now);
//      System.out.println("Java cron job expression:: " + strDate);
//   }
   //The application has started at 09:03:23 and for every one minute from that time the cron job scheduler task has executed.
   
   
//   @Scheduled(fixedRate = 1000)
//   public void fixedRateSch() {
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//
//      Date now = new Date();
//      String strDate = sdf.format(now);
//      System.out.println("Fixed Rate scheduler:: " + strDate);
//   }
//   
//   @Scheduled(fixedDelay = 1000, initialDelay = 3000)
//   public void fixedDelaySch() {
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//      Date now = new Date();
//      String strDate = sdf.format(now);
//      System.out.println("Fixed Delay scheduler:: " + strDate);
//   }
   
   
}