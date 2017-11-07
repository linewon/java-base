package line.callback;

/**
 * wang叫li下班了有空给他回个短信。
 * 
 * wang来实现callback接口，li有空了之后调用wang中的这个方法来给他发短信
 * 
 * Android的onClick方法，也是回调机制，有空去看看源码。
 * 
 * @author line
 *
 */
public interface CallBack {
	public void text(String text);
}
