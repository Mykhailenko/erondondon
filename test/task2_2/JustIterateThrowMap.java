package task2_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import task1.Product;

public class JustIterateThrowMap {
	private static AbstractArticul getArt(String art){
		return new Articul1(art);
	}
	public static void main(String [] args){
		List<Product> list = new ArrayList<Product>();
		
		list.add(new JustForTest(getArt("qwertryu"), 
				"title0", "prod0", "des0"));
		list.add(new JustForTest(getArt("qwertryasdfsfu"),
				"title1", "prod1", "des1"));
		list.add(new JustForTest(getArt("345qasssssssssssss"), 
				"title2", "prod2", "des2"));
		list.add(new JustForTest(getArt("tryu45678"), 
				"title3", "prod3", "des3"));
		list.add(new JustForTest(getArt("q345345"), 
				"title4", "prod4", "des4"));
		list.add(new JustForTest(getArt("345q345"), 
				"title5", "prod5", "des5"));
		Map<AbstractArticul, Product> map0 = new HashMap<AbstractArticul, Product>();
		Map<AbstractArticul, Product> map1 = new LinkedHashMap<AbstractArticul, Product>();
		for(Iterator<Product> it = list.iterator(); it.hasNext();){
			Product p = it.next();
			map0.put(p.getArticul(), p);
			map1.put(p.getArticul(), p);
		}
		Iterator<Map.Entry<AbstractArticul, Product>> it0 = map0.entrySet().iterator();
		Iterator<Map.Entry<AbstractArticul, Product>> it1 = map1.entrySet().iterator();
		System.out.println("HashMap");
		while(it0.hasNext()){
			Map.Entry<AbstractArticul, Product> entry = it0.next();
			System.out.println(entry.getValue().toString());
		}
		System.out.println("LinkedHashMap");
		while(it1.hasNext()){
			Map.Entry<AbstractArticul, Product> entry = it1.next();
			System.out.println(entry.getValue().toString());
		}
	}
}
