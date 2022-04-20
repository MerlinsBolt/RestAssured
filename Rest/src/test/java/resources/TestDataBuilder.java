package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddplacePOJO;
import pojo.Locations;

public class TestDataBuilder {
	
	
	public AddplacePOJO addplacePayload() {
		AddplacePOJO ad= new AddplacePOJO();
		Locations l= new Locations();
		l.setLat(20.6);
		l.setLng(30.6);
		ad.setAccuracy(50);
		ad.setAddress("Prasan Niwas");
		ad.setLanguage("English");
		ad.setLocation(l);
		ad.setName("Vijay Yadav");
		ad.setPhone_number("8689946239");
		ad.setWebsite("ww.gmail.om");
		List<String> list= new ArrayList<>();
		list.add("shoe park");
		list.add("shop");
		ad.setTypes(list);
		
		return ad;
	}

}
