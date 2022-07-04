package com.mjc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * web层通用数据处理
 * 
 * @author tianyuan
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 返回成功
     */
    public R success()
    {
        return R.success();
    }

    /**
     * 返回失败消息
     */
    public R error()
    {
        return R.failed();
    }

    /**
     * 返回成功消息
     */
    public R success(String message)
    {
        return R.success(message);
    }

    /**
     * 返回失败消息
     */
    public R error(String message)
    {
        return R.failed(message);
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected R toR(int rows)
    {
        return rows > 0 ? R.success() : R.failed();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected R toR(boolean result)
    {
        return result ? success() : error();
    }

}
