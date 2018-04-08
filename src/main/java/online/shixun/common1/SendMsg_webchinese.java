package online.shixun.common1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg_webchinese {
	public static final String UID = "yangtao19940620";
	public static final String KEY = "d41d8cd98f00b204e980";
	public static final String SMS_SEND_URI = "http://utf8.sms.webchinese.cn";
	public static final String SMS_NUM_URI = "http://sms.webchinese.cn/web_api/SMS/?Action=SMS_Num";

	// 发送短信
	public static int sendMessage(String phone, String smsText) throws HttpException, IOException {
		PostMethod post = new PostMethod(SMS_SEND_URI);
		NameValuePair[] data = { new NameValuePair("Uid", UID), new NameValuePair("Key", KEY),
				new NameValuePair("smsMob", phone), new NameValuePair("smsText", smsText) };
		String result = executeMethod(post, data);
		System.out.println("发送短信数量：" + result + "，手机号：" + phone + "信息：" + smsText);
		post.releaseConnection();
		return Integer.parseInt(result);
	}

	// 获取短信数量
	public static int smsNum() throws UnsupportedEncodingException, IOException {
		PostMethod post = new PostMethod(SMS_NUM_URI);
		NameValuePair[] data = { new NameValuePair("Uid", UID), new NameValuePair("Key", KEY) };
		String result = executeMethod(post, data);
		System.out.println("短信数量：" + result);
		post.releaseConnection();
		return Integer.parseInt(result);
	}

	private static String executeMethod(PostMethod post, NameValuePair[] data) throws HttpException, IOException {
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		post.setRequestBody(data);
		HttpClient client = new HttpClient();
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		return new String(post.getResponseBodyAsString().getBytes("utf-8"));
	}
	

}
