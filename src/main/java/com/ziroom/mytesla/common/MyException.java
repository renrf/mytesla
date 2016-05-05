package com.ziroom.mytesla.common;

import com.ziroom.platform.tesla.common.errors.ErrorConstants;
import com.ziroom.platform.tesla.common.errors.ErrorInfo;
import com.ziroom.platform.tesla.server.errors.TeslaException;

/**
 * Created by jian on 1/25/16.
 */
public class MyException extends TeslaException {

    private String errorMsg;

    public int getCode(){
        return 500;
    }

    public ErrorInfo getErrorInfo() {
        return new ErrorInfo(ErrorConstants.SERVER_ERROR_CODE, "My Exception occured");
    }

    public MyException() {
        super();
    }

    public MyException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
