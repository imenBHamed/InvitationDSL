package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import invitation.Conferencier;

public class TestConferencier {
	private static final String NOMCONFERENCIER = "Maha";
	private static final String PROFESSION = "ingénieure informatique";
	private String attendu;
	public Conferencier conf;
	public Conferencier confErrorP;
	public Conferencier confErrorN;

	@Before
	public void initConferencierTest() {
		conf = new Conferencier(c -> {
			c.participationDe(NOMCONFERENCIER);
			c.enTantQue(PROFESSION);
		});
		confErrorP = new Conferencier(c -> {
			c.participationDe(NOMCONFERENCIER);
		});

		confErrorN = new Conferencier(c -> {
			c.enTantQue(PROFESSION);
		});
		attendu = NOMCONFERENCIER + "  " + PROFESSION;
	}

	@Test
	public void testajoutConferencier() {
		assertEquals(attendu, conf.toString());
	}

	@Test
	public void testnomConferencier() {
		assertEquals("Alexis", conf.nomConf());
	}

	@Test
	public void testProfessionConferencier() {
		assertEquals("ingenieur", conf.profession());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testajoutIncomplet() {
		  confErrorP.toString();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAjoutIncomplet() {
		confErrorN.toString();
	}
}
