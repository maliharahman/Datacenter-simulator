package core;

import domain.DataCenter;
import domain.Response;
import domain.Server;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Settings;
import utils.Utils;

public class DataCenterJobExecutor implements Job
{
    private static Logger log = LoggerFactory.getLogger(DataCenterJobExecutor.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Tick started");
        log.info("");
        log.info("server status:-");
        log.info("-------------------------------------------");
        for (DataCenter dataCenter : DataCentersHandler.getInstance().getAvailableDataCenters())
        {
            dataCenter.updateServers();
            for (Server server: dataCenter.getServerList()) {
                log.info(server.toString());
            }
        }
        log.info("-------------------------------------------");

        Response response = ResponseDataHandler.getResponseDataHandlerInstance().getResponseList().get(0);
        int tickCount = Utils.calculateTickCount((long) response.getResponseSize());
        boolean isServed = false;

        for (DataCenter dataCenter : DataCentersHandler.getInstance().getAvailableDataCenters()) {
            if (isServed) {
                break;
            }

            for (Server server : dataCenter.getServerList()) {
                if (server.isBusy()) {
                    log.info("Redirected to another server.");
                    continue;
                } else {
                    server.setBusy(true);
                    server.setBusyTickCount(tickCount);
                    log.info(server.toString() + " served response: " + response.toString());
                    ResponseDataHandler.getResponseDataHandlerInstance().getResponseList().remove(0);
                    isServed = true;
                    break;
                }
            }
            log.info("Redirected to another Data-center");
        }

        log.info("Tick ended");
        log.info("\n");
        log.info("\n");
    }
}