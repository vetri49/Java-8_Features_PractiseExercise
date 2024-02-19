package ps.buitlinfunctionalinterfaces04;

import java.util.Comparator;

public class NamesAscendingOrder implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Person p1=(Person)o1;
		Person p2=(Person)o2;
		int num;
		num=p1.getName().compareTo(p2.getName());
		return num;
	}

}
