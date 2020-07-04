package com.wechat.pay.contrib.apache.httpclient;

import org.apache.http.client.methods.HttpUriRequest;

import java.io.IOException;

public interface Credentials {

  String getSchema();

  String getToken(HttpUriRequest request) throws IOException;
}
