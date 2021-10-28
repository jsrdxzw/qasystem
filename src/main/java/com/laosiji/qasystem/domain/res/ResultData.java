package com.laosiji.qasystem.domain.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyixiao
 * @date 2021/10/27
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultData<T> {

    private int code;
    private String message;
    private T data;
    private long timeStamp;
    public final static int SUCCESS_CODE = 0;
    public final static String SUCCESS_MESSAGE = "成功";
    public final static ResultData SUCCESS = success().build();


    public static <T> ResultData<T> fail(int code, String message) {
        return ResultData.<T>builder()
                .code(code)
                .message(message).build();
    }

    public static <M> ResultDataBuilder<M> success() {
        return ResultData.<M>builder()
                .code(SUCCESS_CODE)
                .message(SUCCESS_MESSAGE)
                .timeStamp(System.currentTimeMillis());
    }
}
