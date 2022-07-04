package com.mjc.common;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 响应信息主体
 *
 * @param <T>
 * @author lengleng
 */
@Getter
@Setter
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public R(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = ResultCode.SYSTEM_EXCEPTION.getCode();
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> R<T> success(T data) {
        return new R<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> R<T> success(T data, String message) {
        return new R<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> R<T> failed(Throwable errorCode) {
        return new R<T>(ResultCode.SYSTEM_EXCEPTION.getCode(), ResultCode.SYSTEM_EXCEPTION.getMsg(), null);
    }


    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> R<T> failed(String message) {
        return new R<T>(ResultCode.SYSTEM_EXCEPTION.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> R<T> failed(String code, String message) {
        return new R<T>(code, message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R<T> failed(String message, T data) {
        return new R<T>(ResultCode.SYSTEM_EXCEPTION.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R<T> failed(T data) {
        return new R<>(ResultCode.SYSTEM_EXCEPTION.getCode(), ResultCode.SYSTEM_EXCEPTION.getMsg(), data);
    }

    /**
     * 失败返回结果
     *
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R<T> failed(String code, String message, T data) {
        return new R<T>(code, message, data);
    }


    /**
     * 成功返回结果
     */
    public static <T> R<T> success() {
        return success(null);
    }

    /**
     * 失败返回结果
     */
    public static <T> R<T> failed() {
        return failed(ResultCode.SYSTEM_EXCEPTION.getCode(), ResultCode.SYSTEM_EXCEPTION.getMsg());
    }

    /**
     * 未认证返回结果
     */
    public static <T> R<T> unauthorized(T data) {
        return new R<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMsg(), data);
    }

    public static void isSuccess(R r) {
        Assert.isTrue(StrUtil.equals(r.getCode(), ResultCode.SUCCESS.getCode()), r.getMsg());
    }

	/**
	 * 返回是否成功
	 */
	public void isSuccess() {
		isSuccess(this.msg);
	}

	/**
	 * 返回是否成功
	 */
	public void isSuccess(String msg) {
		Assert.isTrue(StrUtil.equals(this.code, ResultCode.SUCCESS.getCode()), msg);
	}
}
