package com.ymw.mybatisplus.common;

/**
 * 万创服务抽象类
 *
 * @author xhuatang
 * @since 2017-06-20
 */
public abstract class AbstractRestService {

	/**
	 * 返回错误信息对象
	 *
	 * @param code
	 * @param error
	 * @return
	 */
	protected  <T> ResponseResult<T> buildErrorResult(int code, String error) {
		ResponseResult<T> serviceResult = new ResponseResult<>();
		serviceResult.setCode(code);
		serviceResult.setMessage(error);
		serviceResult.setStatus(0);
		return serviceResult;
	}

	/**
	 * 创建非法参数的结果
	 *
	 * @return 结果
	 */
	protected  <T> ResponseResult<T> buildIllegalParamResult() {
		ResponseResult<T> serviceResult = new ResponseResult<>();
		serviceResult.setMessage("参数非法");
		serviceResult.setStatus(0);
		return serviceResult;
	}

	/**
	 * 创建会话过期的结果
	 *
	 * @return 结果
	 */
	protected  <T> ResponseResult<T> buildUnLoginResult() {
		ResponseResult<T> serviceResult = new ResponseResult<>();
		serviceResult.setStatus(2);
		serviceResult.setMessage("未登录");
		return serviceResult;
	}

	/**
	 * 创建错误的结果
	 *
	 * @param msg 错误的信息
	 * @return 错误的结果
	 */
	protected <T> ResponseResult<T> buildErrorResult(String msg) {
		ResponseResult<T> serviceResult = new ResponseResult<>();
		serviceResult.setStatus(0);
		serviceResult.setMessage(msg);
		return serviceResult;
	}

	/**
	 * 创建提示的结果
	 *
	 * @param msg 错误的信息
	 * @return 错误的结果
	 */
	protected  <T> ResponseResult<T> buildTipResult(String msg) {
		ResponseResult<T> serviceResult = new ResponseResult<>();
		serviceResult.setStatus(3);
		serviceResult.setMessage(msg);
		return serviceResult;
	}

	/**
	 * 创建成功的结果
	 *
	 * @param data 结果的内容
	 * @return 成功的结果
	 */
	protected <T> ResponseResult<T> buildSuccessResult(T data) {
		ResponseResult<T> serviceResult = new ResponseResult<>();
		serviceResult.setContent(data);
		serviceResult.setStatus(1);
		return serviceResult;
	}

	/**
	 * 返回成功的结果
	 *
	 * @param data 结果的内容
	 * @param msg 成功信息
	 * @return 成功的结果
	 */
	protected  <T> ResponseResult<T> buildSuccessResult(T data, String msg) {
		ResponseResult<T> serviceResult = new ResponseResult<>();
		serviceResult.setContent(data);
		serviceResult.setMessage(msg);
		serviceResult.setStatus(1);
		return serviceResult;
	}
}
