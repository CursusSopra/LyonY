/**
 * File modified by : Benoît
 */
package fr.cursusSopra.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Collaborateurs;

public class AboutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 524351754340439768L;

	private List<Collaborateurs> listCollab = new ArrayList<Collaborateurs>();

	public AboutAction() {


		
	}

	@Override
	public String execute() {

		return SUCCESS;
	}

	public List<Collaborateurs> getListCollab() {
		return listCollab;
	}
}
