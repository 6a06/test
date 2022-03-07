package model;

public class MutterString {
	public MutterString(){}
	public String mutterString(Mutter m) {
		String a = "<a href=\"DocoTsubuUser?action="+m.getUserName()+"\"  method=\"post\">"+m.getUserId() +"/"+m.getUserName()+ "</a>|" + m.getTweet() + "|" + m.getTime()+"|tid:"+m.getMutterId()+"<br>";
		return a;
	}

}
