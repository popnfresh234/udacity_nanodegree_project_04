package com.dmtaiwan.alexander.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.dmtaiwan.alexander.jokedisplaylibrary.JokeDisplayActivity;
import com.dmtaiwan.alexander.jokedisplaylibrary.Utilities;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Alexander on 7/12/2015.
 */
public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private Context mContext;

    @Override
    protected String doInBackground(Context... params) {
        mContext = params[0];
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://10.0.3.2:8080/hello"); // 10.0.2.2 is localhost's IP address in Android emulator
        try {
            // Execute HTTP Post Request
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity());
            }
            return "Error: " + response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase();

        } catch (ClientProtocolException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(mContext, JokeDisplayActivity.class);
        intent.putExtra(Utilities.JOKE, result);
        mContext.startActivity(intent);
        MainActivity mainActivity=  (MainActivity)mContext;
        mainActivity.hideProgress();
    }
}
