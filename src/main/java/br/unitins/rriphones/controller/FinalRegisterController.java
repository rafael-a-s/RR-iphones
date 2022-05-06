package br.unitins.rriphones.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;

import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.UsuarioRepository;
@Named
@ViewScoped
public class FinalRegisterController extends Controller<Usuario> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean skip;
	
	public FinalRegisterController() {
		super(new UsuarioRepository());
		
	}
	
	public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false; //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }

	@Override
	public Usuario getEntity() {
		if(entity == null)
			entity = new Usuario();
		return entity;
	}

}
