package fr.uvsq.M2.Datascale.GestionMedia.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;

@ManagedBean
@SessionScoped
public class MediasController {
	
	private List<Media> list ;

	public void chargerForTest(){
		list = new ArrayList<>();
		Media m1 = new Media();
		m1.setId("1");
		m1.setTitre("1");
		Media m2 = new Media();
		m2.setTitre("2");
		m2.setId("2");
		Media m3 = new Media();
		m3.setTitre("3");
		m3.setId("3");
		Media m4 = new Media();
		m4.setTitre("4");
		m4.setId("4");
		Media m5 = new Media();
		m5.setTitre("444");
		m5.setId("55");
		Media m6 = new Media();
		m6.setTitre("66");
		m6.setId("6");
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);
		for (Media m : list) {
			System.err.println(m.getTitre());
		}
	}
	
	
	public List<Media> getList() {
		return list;
	}

	public void setList(List<Media> list) {
		this.list = list;
	}
	
	
	

}
