package line.trycatch;

/**
 * javap -verbose TCF
 * 
 * @author line
 *
 */
public class TCF {
	public static void main(String[] args) {
		TCF tcf = new TCF();
		System.out.println(tcf.test());
	}

	@SuppressWarnings("finally")
	public String test() {
		String ret = null;
		try {
			ret = "try";
			int i = 1/0;
			return ret;
		} catch (Exception e) {
			ret = "catch";
			return ret;
		} finally {
			ret = "finally";
			return ret;
		}
	}
}
