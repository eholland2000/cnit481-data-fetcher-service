package org.cnit481.group11.connections;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;

@ApplicationScoped
public class StockDataServiceConnection {

    public boolean connected() {
        try {
            HttpUriRequest request = new HttpGet( "http://stock-data-service:8080/hello");
            HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                return true;
            }
        } catch (IOException ioexc) {
            ioexc.printStackTrace();
        }
        return false;
    }

    public boolean triggerFetchData() {
        try {
            HttpUriRequest request = new HttpGet( "http://stock-data-service:8080/fetch");
            HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                return true;
            }
        } catch (IOException ioexc) {
            ioexc.printStackTrace();
        }
        return false;
    }

}
