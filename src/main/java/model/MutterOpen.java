package model;

import java.util.ArrayList;
import java.util.List;

public class MutterOpen {
	MutterString ms=new MutterString();
	public String mutterOpen(MutterList ml) {
	List<Mutter> l=ml.getmL();
	StringBuilder sb=new StringBuilder();

	for (int i = l.size() - 1; i >= 0; i--) {
		Mutter m = l.get(i);
		String a =ms.mutterString(m);
		sb.append(a);
	}
	String s=sb.toString();
	return s;
	}

	public String mutterOpen(MutterList ml,User u) {
	List<Mutter> l=ml.getmL();
	List<Follow> fl=u.getFollow().getFl();
	StringBuilder sb=new StringBuilder();
	List<Integer> il=new ArrayList<>();
	il.add(u.getId());
	for(Follow f:fl) {
		il.add(f.getFollow());
	}

	for (int i = l.size() - 1; i >= 0; i--) {

		Mutter m = l.get(i);
		for(int id:il) {
			if(id==m.getUserId()) {

				String a =ms.mutterString(m);
				sb.append(a);

			}
		}
	}
	String s=sb.toString();
	return s;
	}

}
