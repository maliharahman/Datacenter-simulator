import core.DataCenterJobExecutor;
import core.DataCentersHandler;
import core.DataLoader;
import core.ResponseDataHandler;
import domain.DataCenter;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<DataCenter> availableDataCenters = new ArrayList<DataCenter>();

        // Data center declaration....
        DataCenter dataCenter1 = new DataCenter("101", "LEEDS", 0, 0);
        availableDataCenters.add(dataCenter1);

        DataCenter dataCenter2 = new DataCenter("102", "HALIFAX", 0, 0);
        availableDataCenters.add(dataCenter2);

        DataCentersHandler dataCentersHandler = DataCentersHandler.getInstance();
        dataCentersHandler.setAvailableDataCenters(availableDataCenters);

        //load data from xls file
        DataLoader dataLoader = new DataLoader();
        dataLoader.loadData();

        System.out.println(ResponseDataHandler.getResponseDataHandlerInstance().getResponseList().toString());
        //algorithm....

        JobDetail job = JobBuilder.newJob(DataCenterJobExecutor.class)
                .withIdentity("dataCenterJob", "group1").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dataCenterJobTrigger", "group1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(10).repeatForever())
                .build();

        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}