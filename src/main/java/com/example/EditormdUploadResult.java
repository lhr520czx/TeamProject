package com.example;

/**
 * Created by lyc on 2017/3/31.
 */
public class EditormdUploadResult  {

  private int Success;

  private String Url;

  private String Message;

    public EditormdUploadResult() {
    }

    public int getSuccess() {
        return Success;
    }

    public void setSuccess(int success) {
        Success = success;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
