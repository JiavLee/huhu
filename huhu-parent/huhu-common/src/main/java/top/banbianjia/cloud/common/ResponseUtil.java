package top.banbianjia.cloud.common;


import com.sun.deploy.net.HttpRequest;

public class ResponseUtil {
    public ResponseUtil instance = null;

    private ResponseUtil GetInstance() {
        if (instance == null) {
            instance = new ResponseUtil();
        }
        return instance;
    }
}
