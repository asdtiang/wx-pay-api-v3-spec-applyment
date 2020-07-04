package com.wechat.pay.contrib.apache.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;

public interface Validator {
  boolean validate(CloseableHttpResponse response) throws IOException;
}
