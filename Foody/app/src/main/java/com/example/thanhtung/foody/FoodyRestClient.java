package com.example.thanhtung.foody;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;

/**
 * Created by Thanh Tung on 5/8/2017.
 */

public class FoodyRestClient {
    private static final String BASE_URL = "http://192.168.43.184/FoodyServer/";
    //private static final String BASE_URL = "http://10.0.3.2/FoodyServer/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(Context context, String url, Header[] headers, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(60*1000);
        client.setConnectTimeout(60*1000);
        client.setResponseTimeout(60*1000);
        client.setMaxConnections(60);
        client.get(context, getAbsoluteUrl(url), headers, params, responseHandler);
    }

    public static void post(String url, Header[] headers, RequestParams params, String contentType, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(60*1000);
        client.setConnectTimeout(60*1000);
        client.setResponseTimeout(60*1000);
        client.setMaxConnections(60);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void register(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(60*1000);
        client.setConnectTimeout(60*1000);
        client.setResponseTimeout(60*1000);
        client.setMaxConnections(60);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }
    public static void login(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(60*1000);
        client.setConnectTimeout(60*1000);
        client.setResponseTimeout(60*1000);
        client.setMaxConnections(60);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }
    public static void changepassword(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(60*1000);
        client.setConnectTimeout(60*1000);
        client.setResponseTimeout(60*1000);
        client.setMaxConnections(60);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }
    public static void changeimage(Context context, String url, HttpEntity entity, String contenType, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(60*1000);
        client.setConnectTimeout(60*1000);
        client.setResponseTimeout(60*1000);
        client.setMaxConnections(60);
        client.post(context, getAbsoluteUrl(url), entity, contenType, responseHandler);
    }
    public static void themdiadiem(Context context, String url, HttpEntity entity, String contenType, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(60*1000);
        client.setConnectTimeout(60*1000);
        client.setResponseTimeout(60*1000);
        client.setMaxConnections(60);
        client.post(context, getAbsoluteUrl(url), entity, contenType, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
