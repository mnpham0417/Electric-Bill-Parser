import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	private String text;
	private String bankname = "default";
	private String price_str;
	private long price_long;
	
	//Constructor
	Parser(){}
	
	//Constructor
	Parser(String text){
		this.text = text;
	}
	
	//Constructor
	Parser(String text, String bankname){
		this.text = text;
		this.bankname = bankname.toUpperCase();
		
	}
	
	/*Function that return the text
	 * @param None
	 * @return this.text
	 */
	public String get_text() {
		return this.text;
	}
	
	/*Function that return the bankname
	 * @param None
	 * @return this.bankname
	 */
	public String get_bankname() {
		return this.bankname;
	}
	
	/*Function that return the price as string
	 * @param None
	 * @return this.price_str
	 */
	public String get_price_Str() {
		return this.price_str;
	}
	
	/*Function that return the price as long
	 * @param None
	 * @return this.price_long
	 */
	public long get_price_long() {
		return this.price_long;
	}
	
	/*Function that checks if the text is related to electric bill
	 * @param None
	 * @return True if the text is related to electric bill and False otherwise
	 */
	public boolean isElectricText() {
		String hasElectric = "(((?i)tien)?\\s?(?i)dien)";
		Pattern pattern = Pattern.compile(hasElectric);
	    Matcher matcher = pattern.matcher(this.text);
	    boolean check = matcher.find();
	    if(!check) return false;
	    return true;
	}
	/*Function that remove unnecessary patterns from text
	 * @param None
	 * @return None
	 */
	public void clean_up() {
		String pattern_date = "(\\d{2}\\/\\d{2}\\/\\d+)|(\\d{2}\\/\\d{2}\\/\\d{4})|(\\d{2}\\-\\d{2}\\-\\d{4})|(\\d\\/\\d{4})|(T([1-9]|(1[0-2]))\\D)(\\d{4})?|(\\d{2}\\/\\d{2})|(\\d{2}\\/\\d{4})|(thang ([1-9]|1[0-2]) nam \\d{4})|(\\d{1,2}\\s\\d{1,2}\\s\\d{4})|(nam \\d{4})|(T\\d{1,2}[.]\\d{4})";
		String pattern_time = "(\\d{1,2}\\:\\d{2}(\\:\\d{2})?)|(\\d+h\\d+)";
		String pattern_ID = "((\\s|^)[A-Za-z]{1,3}[0-9](\\w|\\-){2,})|(#\\s?\\d+\\s)|(((?i)mkh)\\s\\d+)|(CSM \\d+)|(OTP(:)?\\s\\d+)|((?i)Chi (?i)so (?i)moi: \\d+)|((?i)phieu:\\s?\\d+)|(((?i)ma|(?i)(so chot)) \\w+)|(chi so cuoi\\s?(ky\\s)?\\d+)|((?i)CSCT(:)?\\s?\\d+)|((c|d).ky\\d+)|(So GD.+\\d+)";
		String pattern_account_num = "(((?)TK(:)?(\\s(?i)VND)?(\\s(so))?)\\s?(\\w|\\.)+)|(((?i)so tai khoan)(:)?\\s?\\d+)|((?i)account(:)?\\s?\\d+)|(((Acc no.)|(TK))\\s?\\*{2}\\d+)";
		String pattern_kwh = "((?i)DNTT(:)?.+(?i)kwh)|(\\d+(\\s)?((?i)kwh))|((?i)(so\\s?dien)\\s?\\d+)";
		String dot_comma_space = "(\\d{1,3})(\\,|\\.|\\s)(\\d{3})";
		String phone = "((?i)sdt(:)?\\s?\\d{4,})|((1900)\\d{4})|((?i)((lh(:)?)|(dt(:)?)|((?i)hotline(:)?)(\\s+)?\\d{4,}))";
		String ck = "ck \\d+";
		String outliers_num = "\\D\\d{1,3}(?!(?i)(dong|d|vnd))\\D";
		String balance = "(((?i)sd(c)?(:)?\\s?((?i)dau|(?i)cuoi)?)(\\s)?[^a-zA-Z]+)|((?i)(so du(:)?)(\\D+)?\\s?[+-]?(\\d|\\,|\\.)+\\.)|(((?i)sd (?i)kha (?i)dung:)\\s?\\d+)|((?i)(so du tk).+\\d+)|(((?i)sodu:).+$)|((?i)balance(:)?\\s?(VND\\s)?(\\,|\\.|\\d)+)";
		String cust = "((?i)KH(:)?\\s?((?i)ma)?\\s?\\S+)|((?i)khach\\s?(?i)hang\\s?\\d+)";
		String increase = "((?i)tang\\s?)(?=\\d+)";
		String decrease = "((?i)giam\\s?)(?=\\d+)";
		String ads = "(?i)(trung thuong)\\s?(\\d|\\,\\,)+";
		String website = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		
		//Delete parentheses around -+ just to make cleaning things easier
	 	this.text = this.text.replaceAll("([(])([+-])([)])", "$2"); //OCB, MSB
		//Delete phone
		this.text = this.text.replaceAll(phone, "");
		//Delete website
	 	this.text = this.text.replaceAll(website, ""); //vccorp
	 	//Delete balance
	 	this.text = this.text.replaceAll(balance, "");
		//Replace increase with +
		this.text = this.text.replaceAll(increase, "+");
		//Replace increase with +
		this.text = this.text.replaceAll(decrease, "-");
		//Delete cust
		this.text = this.text.replaceAll(cust, "");
		//Delete account number
		this.text = this.text.replaceAll(pattern_account_num, "");
		//Delete date
		this.text = this.text.replaceAll(pattern_date, "");
		//Delete time
		this.text = this.text.replaceAll(pattern_time, "");
		//Delete ID
		this.text = this.text.replaceAll(pattern_ID, "");
		
		//Delete dot_comma_space
		if(this.bankname.equals("VIETTELPAY")) {
			dot_comma_space = "(\\d{1,3})(\\.|\\,)(\\d{3})";
		}
		
		//Remove , and . between numbers
		Pattern pattern = Pattern.compile(dot_comma_space);
	    Matcher matcher = pattern.matcher(this.text);
	    do {
	    		this.text = this.text.replaceAll(dot_comma_space, "$1$3");
	    }
		while(matcher.find());
			
		//Delete kwh
		this.text = this.text.replaceAll(pattern_kwh, "");
		
		//Delete ck
		this.text = this.text.replaceAll(ck, "");
		
		//Delete too small num
		this.text = this.text.replaceAll(outliers_num, "");
		
		//Delete ads
		this.text = this.text.replaceAll(ads, "");
	}
	
	/*Function that extract the electric bill price as string
	 * @param None
	 * @return None
	 */
	public void reduce_price_str() {
		String pattern_price = "(Tien dien \\d+)|((\\D|^)(?!(\\+))(-)?(\\s)?(\\d{4,10}|0)((?i)(dong|d|vnd|\\s|$|\\,|\\.)))";
		
		//For some cases manually select pattern_price
		if(this.bankname.equals("VNEDU")) {
			pattern_price = "Tien dien \\d+";
		}
		else if(this.bankname.equals("EVNCPC")){
			pattern_price = "((?i)tong\\s(?i)tien(:)?\\s?\\d+)|((?i)so\\s?(?i)tien\\s?(=)?\\s?\\d+)";
		}
		else if(this.bankname.equals("CTCPD-MODUC")) {
			pattern_price = "(?<=(so tien:))\\s?\\d+";
		}
		else if(this.bankname.equals("DONGA BANK")) {
			pattern_price = "\\d+";
		}
		else if(this.bankname.equals("VIETTELPAY")) {
			pattern_price = "(\\d+VND)|(((?i)tien\\s(?i)dien)\\s?\\d+)";
		}else if(this.bankname.equals("HTXHOPTHINH")) {
			pattern_price = "(?<=(?i)(so\\s?tien\\s?))\\d+";
		}
		
	    Pattern pattern = Pattern.compile(pattern_price);
	    Matcher matcher = pattern.matcher(this.text);
	    boolean check = matcher.find();
	    if(check) {
	    		this.price_str = matcher.group(0);	
	    }  
	}
	
	/*Functions that remove non-digit char from price_str and convert to long
	 * @param None
	 * @return electric bill as long
	 */
	public long convert_int() {
		if((this.price_str == null)||(isElectricText()==false)) {
			return -1L;
		}
		
		//Not accept positive price
		String positive = "\\+\\s?\\d+";
		Pattern pattern_pos = Pattern.compile(positive);
		Matcher matcher_pos = pattern_pos.matcher(this.price_str);
		if(matcher_pos.find()) {
			return -1L;
		}
		
		//Delete non-digit char
		this.price_str = this.price_str.replaceAll("\\D", "");
		
		//Convert to long
		this.price_long = Long.parseLong(this.price_str);
		return this.price_long;
	}
	

}
