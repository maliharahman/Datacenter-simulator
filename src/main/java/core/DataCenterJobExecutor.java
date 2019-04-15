package core;

import domain.DataCenter;
import domain.Response;
import domain.Server;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import utils.Settings;

import java.util.Timer;
import java.util.TimerTask;

import java.util.*;

public class DataCenterJobExecutor extends TimerTask implements Job
{
    private double maxServerCap=Settings.SERVER_MAX_LOAD;
    private double s1=maxServerCap,s2,s3,s4;

    Response response = ResponseDataHandler.getResponseDataHandlerInstance().getResponseList().get(0);
    double size=response.getResponseSize();

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        DataCenter dataCenter1 = DataCentersHandler.getInstance().getAvailableDataCenters().get(0);
        DataCenter dataCenter2 = DataCentersHandler.getInstance().getAvailableDataCenters().get(1);

        /*
         * calculation
         * */

        String Dc1Server1 = dataCenter1.getServerList().get(0).getId();
        String Dc1Server2 = dataCenter1.getServerList().get(1).getId();
        String Dc2Server1 = dataCenter2.getServerList().get(0).getId();
        String Dc2Server2 = dataCenter2.getServerList().get(1).getId();

        if (s1 > size)
        {
            System.out.println(response.getTimestamp() + " { DataCenter ID: " + dataCenter1.getId() +
                    " , Server ID: " + Dc1Server1 + " , Bytes: " + size + " }");

            Timer timer = new Timer();
            TimerTask task = new DataCenterJobExecutor();
            timer.schedule(task,1000,3000);
        }

        //update server1 after 3 seconds

        /*else
            System.out.println(response.getTimestamp()  + " { DataCenter ID: " + dataCenter2.getId() +
                    " , Server ID: " + Dc1Server2 + " , Bytes: " + size + " }");*/

        ResponseDataHandler.getResponseDataHandlerInstance().getResponseList().remove(0);
    }

    public void run()
    {
        s1=s1-size;
        System.out.println("updated server capacity : " + s1 );
    }
}