package com.dmtaiwan.alexander.builditbigger;

import android.content.Context;
import android.test.InstrumentationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander on 7/12/2015.
 */
public class AsyncTest extends InstrumentationTestCase {

    final CountDownLatch signal = new CountDownLatch(1);


    public void testAsync() throws Throwable {

        final EndpointsAsyncTask task = new EndpointsAsyncTask() {

            @Override
            protected String doInBackground(Context... params) {
                return super.doInBackground(params);
            }

            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                signal.countDown();
            }
        };

        runTestOnUiThread(new Runnable() {
            Context context = new MainActivity();
            @Override
            public void run() {
                task.execute(context);
            }
        });
        signal.await(30, TimeUnit.SECONDS);
    }


}

