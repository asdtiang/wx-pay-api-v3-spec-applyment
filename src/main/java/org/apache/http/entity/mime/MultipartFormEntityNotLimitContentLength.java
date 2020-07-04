//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.apache.http.entity.mime;

import org.apache.http.ContentTooLongException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

import java.io.*;

class MultipartFormEntityNotLimitContentLength implements HttpEntity {
  private final AbstractMultipartForm multipart;
  private final Header contentType;
  private final long contentLength;

  MultipartFormEntityNotLimitContentLength(AbstractMultipartForm multipart, ContentType contentType, long contentLength) {
    this.multipart = multipart;
    this.contentType = new BasicHeader("Content-Type", contentType.toString());
    this.contentLength = contentLength;
  }

  AbstractMultipartForm getMultipart() {
    return this.multipart;
  }

  public boolean isRepeatable() {
    return this.contentLength != -1L;
  }

  public boolean isChunked() {
    return !this.isRepeatable();
  }

  public boolean isStreaming() {
    return !this.isRepeatable();
  }

  public long getContentLength() {
    return this.contentLength;
  }

  public Header getContentType() {
    return this.contentType;
  }

  public Header getContentEncoding() {
    return null;
  }

  public void consumeContent() {
  }

  public InputStream getContent() throws IOException {
    if (this.contentLength < 0L) {
      throw new ContentTooLongException("Content length is unknown");
    } else {
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      this.writeTo(outStream);
      outStream.flush();
      return new ByteArrayInputStream(outStream.toByteArray());
    }
  }

  public void writeTo(OutputStream outStream) throws IOException {
    this.multipart.writeTo(outStream);
  }
}
