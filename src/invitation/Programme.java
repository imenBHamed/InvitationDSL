package invitation;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Programme {
	private String description;
	private Time heure;
	DateFormat formatter = new SimpleDateFormat("hh:mm a");

	public Programme() {
		this.description = "";
		this.heure = null;
	}

	public Programme(String description, Time heure) {
		this.description = description;
		this.heure = heure;
	}

	public Programme(ProgrammeBuilder d) {
		d.build(this);
	}

	public String description() {
		return description;
	}

	public String heure() {
		String formattedTime = formatter.format(heure);
		return formattedTime;
	}

	@Override
	public String toString() {
		if (!valide()) {
			throw new IllegalArgumentException(
					"Il faut saisir toutes les informations d'un programme");
		}
		return heure + " -- " + description;
	}

	public boolean valide() {
		return heure != null && description != "";
	}

	/****************** m�thodes au DSL *****************/

	public void heure(String heure) {
		try {
			this.heure = new java.sql.Time(formatter.parse(heure).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void presente(String desc) {
		this.description = desc;
	}

}
