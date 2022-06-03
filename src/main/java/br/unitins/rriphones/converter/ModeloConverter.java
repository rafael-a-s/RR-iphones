package br.unitins.rriphones.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Modelo;
import br.unitins.rriphones.repository.ModeloRepository;

@Named
@FacesConverter(forClass= Modelo.class)
public class ModeloConverter implements Converter<Modelo> {

	@Override
	public Modelo getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.isBlank())
			return null;
		ModeloRepository repo = new ModeloRepository();
		try {
			return repo.findById(Integer.parseInt(value));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Modelo value) {
		if(value == null || value.getId() == null)
			return null;
		return value.getId().toString();
	}

}
