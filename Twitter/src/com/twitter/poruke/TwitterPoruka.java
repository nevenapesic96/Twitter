package com.twitter.poruke;
/**
 * 
 * @author Nevena Pesic
 * @version V1.0
 * <ul>sadrzi atribute
 * 	<li>korisnik
 * 	<li>poruka
 * </ul>
 *
 */
public class TwitterPoruka {
	/**
	 * Naziv korisnika
	 */
	private String korisnik;
	/**
	 * Tekst poruke
	 */
	private String poruka;
	/**
	 * 
	 * @return Naziv korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * 
	 * @param korisnik
	 * @throws RuntimeException Ako se unese prazan sting
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * 
	 * @return Tekst poruke
	 */
	public String getPoruka() {
		return "poruka";
	}
	/**
	 * 
	 * @param poruka
	 * @throws RuntimeException Ako je poruka prazna ili ako prelazi 140 karaktera
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || this.poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * @return Naziv korisnika i poruku
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}

