package com.dmtaiwan.alexander.builditbigger;

import android.test.InstrumentationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander on 7/12/2015.
 */
public class AsyncTest extends InstrumentationTestCase {

    final CountDownLatch signal = new CountDownLatch(1);


    public void testAsync() throws Throwable{
        final EndpointsAsyncTask task = new EndpointsAsyncTask(){


            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                assertNotNull(result);
                signal.countDown();
            }
        };

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                task.execute();
            }
        });
        signal.await(30, TimeUnit.SECONDS);
    }


}

