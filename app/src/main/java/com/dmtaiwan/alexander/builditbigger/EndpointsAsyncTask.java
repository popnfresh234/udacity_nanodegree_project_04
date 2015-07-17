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
import java.util.ArrayList;

/**
 * Created by Alexander on 7/12/2015.
 */
public class EndpointsAsyncTask extends AsyncTask<Context, Void, ArrayList<String>> {
    private Context mContext;

    @Override
    protected ArrayList<String> doInBackground(Context... params) {
        ArrayList<String> list = new ArrayList<String>();

        mContext = params[0];
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost("http://10.0.3.2:8080/hello"); // local server (genymotion)
//      HttpPost httpPost = new HttpPost("http://10.0.2.2:8080/hello"); //local server (android emulator)
//      HttpPost httpPost = new HttpPost("https://udacityproject04.appspot.com/hello"); // deployed backend
        try {
            // Execute HTTP Post Request
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                list.add(0, Utilities.SUCCESS);
                list.add(1, EntityUtils.toString(response.getEntity()));
                return list;
            }
            list.add(0, Utilities.ERROR);
            list.add(1, "Error: " + response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
            return list;

        } catch (ClientProtocolException e) {
            list.add(0, Utilities.ERROR);
            list.add(1, e.getMessage());
            return list;
        } catch (IOException e) {
            list.add(0, Utilities.ERROR);
            list.add(1, e.getMessage());
            return list;
        }
    }

    @Override
    protected void onPostExecute(ArrayList<String> result) {
        String resultCode = result.get(0);
        String resultString = result.get(1);

        Intent intent = new Intent(mContext, JokeDisplayActivity.class);
        intent.putExtra(Utilities.RESULT, resultString);
        intent.putExtra(Utilities.RESULT_CODE, resultCode);
        mContext.startActivity(intent);
        MainActivity mainActivity = (MainActivity) mContext;
        mainActivity.hideProgress();
    }
}
