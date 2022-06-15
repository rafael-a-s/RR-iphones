package br.unitins.rriphones.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.model.Iphone;
import br.unitins.rriphones.repository.IphoneRepository;

@Named
@ViewScoped
public class DetailsController extends Controller<Iphone> implements Serializable{


	private static final long serialVersionUID = -7522537599706286742L;
	private Iphone iphonePersit;
	
	
	
	public DetailsController() {
		super(new IphoneRepository());
		if(entity == null) {
			Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
			flash.keep("iphoneFlash");
			entity = (Iphone) flash.get("iphoneFlash");
			if(entity != null) {
				
				System.out.println("obj não nulo");
			}
				
			
		}
		
	}
	
	

	public Iphone getIphonePersit() throws CloneNotSupportedException {
		if(iphonePersit == null)
			iphonePersit = new Iphone();
		return iphonePersit;
	}

	public void setIphonePersit(Iphone iphonePersit) {
		this.iphonePersit = iphonePersit;
	}

	@Override
	public Iphone getEntity() {
		if(entity == null)
			entity  = new Iphone();
			
		return entity;
	}

	

	
}
