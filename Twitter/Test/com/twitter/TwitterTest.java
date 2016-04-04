/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author NEVEN
 *
 */
public class TwitterTest {
	Twitter tw;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tw=new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tw=null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		TwitterPoruka poruka=new TwitterPoruka();
		poruka.setPoruka("Ovo je poruka");
		poruka.setKorisnik("Korisnik");
		TwitterPoruka poruka2=new TwitterPoruka();
		poruka2.setPoruka("Ovo je poruka2");
		poruka2.setKorisnik("Korisnik2");
		tw.vratiSvePoruke().add(poruka);
		tw.vratiSvePoruke().add(poruka2);
		LinkedList<TwitterPoruka> pom=new LinkedList<>();
		pom.add(poruka);
		pom.add(poruka2);
		assertEquals(pom, tw.vratiSvePoruke());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		TwitterPoruka pom=new TwitterPoruka();
		pom.setKorisnik("Ovo je korisnik");
		pom.setPoruka("Ovo je poruka");
		tw.unesi(pom.getKorisnik(), pom.getPoruka());
		assertEquals(pom.getKorisnik(), tw.vratiSvePoruke().getLast().getKorisnik());
		assertEquals(pom.getPoruka(), tw.vratiSvePoruke().getLast().getPoruka());
	}

	@Test (expected= java.lang.RuntimeException.class)
	public void testUnesiNull(){
		TwitterPoruka pom=new TwitterPoruka();
		pom.setKorisnik(null);
		pom.setPoruka("Ovo je poruka");
		tw.unesi(pom.getKorisnik(), pom.getPoruka());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testUnesiNull2(){
		TwitterPoruka pom=new TwitterPoruka();
		pom.setKorisnik("Ovo je korisnik");
		pom.setPoruka(null);
		tw.unesi(pom.getKorisnik(), pom.getPoruka());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testUnesiPrazanString(){
		tw.unesi("", "Ovo je poruka");
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testUnesiPraznuPoruku(){
		tw.unesi("Ovo je korisnik", "");
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testUnesiPredugaPoruka(){
		TwitterPoruka pom=new TwitterPoruka();
		pom.setKorisnik("Ovo je korisnik");
		pom.setPoruka("Ova poruka ima preko 140 karaktera..............................."
				+ "......................................................................"
				+ ".......................................................................");
		tw.unesi(pom.getKorisnik(), pom.getPoruka());
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected= java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		tw.vratiPoruke(130, "");
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		tw.vratiPoruke(130, null);
	}
	@Test
	public void testVratiPoruke(){
		TwitterPoruka[] niz=new TwitterPoruka[100];
		tw.unesi("Korisnik1", "Poruka1");
		tw.unesi("Korisnik2", "Poruka2");
		TwitterPoruka[] pom=new TwitterPoruka[100];
		TwitterPoruka p1=new TwitterPoruka();
		TwitterPoruka p2=new TwitterPoruka();
		p1.setKorisnik("Korisnik1");
		p1.setPoruka("Poruka1");
		p2.setKorisnik("Korisnik2");
		p2.setPoruka("Poruka2");
		pom[0]=p1;
		pom[1]=p2;
		niz=tw.vratiPoruke(20, "Poruka");
		assertEquals(pom[0].getKorisnik(), niz[0].getKorisnik());
		assertEquals(pom[1].getPoruka(), niz[1].getPoruka());
		assertEquals(pom[1].getKorisnik(), niz[1].getKorisnik());
		assertEquals(pom[0].getPoruka(), niz[0].getPoruka());
		
	}

}
