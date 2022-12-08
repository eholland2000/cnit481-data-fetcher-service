package org.cnit481.group11;

import java.util.concurrent.atomic.AtomicInteger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.quarkus.scheduler.Scheduled;
import org.cnit481.group11.connections.StockDataServiceConnection;

@ApplicationScoped
public class DataFetchBean {

    @Inject
    StockDataServiceConnection stockDataService;

    private final AtomicInteger successCounter = new AtomicInteger();
    private final AtomicInteger errorCounter = new AtomicInteger();

    public int getSuccess() {
        return successCounter.get();
    }

    public int getError() {
        return errorCounter.get();
    }

    /**
     * This method is fired at 11:15pm every day
     */
    @Scheduled(cron="0 15 22 * * ?")
    void triggerDataFetch() {
        if (stockDataService.triggerFetchData()) {
            successCounter.incrementAndGet();
        } else {
            errorCounter.incrementAndGet();
        }
    }

}