
import com.endava.util.CronStarter;
import org.quartz.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws SchedulerException, IOException {
        CronStarter cronManipulator = new CronStarter();
        cronManipulator.startCrons();
    }
}
