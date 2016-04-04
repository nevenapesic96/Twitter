/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author NEVEN
 *
 */
public class TwitterPorukaTest {

	TwitterPoruka tw;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tw=new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tw=null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#getKorisnik()}.
	 */
	@Test
	public void testGetKorisnikSveOk() {
		tw.setKorisnik("Pera");
		String ime=tw.getKorisnik();
		assertEquals("Pera", ime);
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnikSveOk() {
		String ime="Pera";
		tw.setKorisnik(ime);
		assertEquals(ime, tw.getKorisnik());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString(){
		String ime="";
		tw.setKorisnik(ime);
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetKorisnikNull(){
		tw.setKorisnik(null);
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#getPoruka()}.
	 */
	@Test
	public void testGetPorukaSveOk() {
		tw.setPoruka("Poruka");
		String poruka=tw.getPoruka();
		assertEquals("Poruka", poruka);
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		tw.setPoruka(null);
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetPorukaPreko140Karakt(){
		String poruka="Ova poruka ima preko 140 karaktera..............................."
				+ "......................................................................"
				+ ".......................................................................";
		tw.setPoruka(poruka);
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString(){
		String poruka="";
		tw.setPoruka(poruka);
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPorukaSveOk() {
		String poruka="Ovo je poruka";
		tw.setPoruka(poruka);
		assertEquals("Ovo je poruka", tw.getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		tw.setKorisnik("Pera");
		tw.setPoruka("Poruka");
		String string=tw.toString();
		assertEquals("KORISNIK:Pera PORUKA:Poruka", string);
	}

}
