package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class StoreCategoryHandler extends GeneralException {

    public StoreCategoryHandler(BaseErrorCode errorCode) {super(errorCode);}
}
