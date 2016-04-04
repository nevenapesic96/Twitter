package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * 
 * @author Nevena Pesic
 * @version V1.0
 *
 */
public class Twitter {
	/**
	 * Lista poruka koje sadrze naziv korisnika i tekst poruke
	 */
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	/**
	 * 
	 * @return Sve poruke iz liste
	 */
public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
}
/**
 * Pravi novu poruku, puni je podacima koji su prosledjeni i tu poruku unosi na kraj liste
 * @param korisnik Naziv korisnika
 * @param poruka Tekst poruke
 */
public void unesi(String korisnik, String poruka) {
	TwitterPoruka tp = new TwitterPoruka();
	tp.setKorisnik("korisnik");
	tp.setPoruka(poruka);
	poruke.addLast(tp);
}
/**
 * Vraca niz poruka koje u sebi sadrze zadati tag
 * @param maxBroj Maksimalni broj poruka
 * @param tag Tag koji se trazi
 * @return Sve poruke koje u sebi imaju zadati tag
 * @throws RuntimeException Ako tag nije unet
 */
public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
	if (tag==null || tag == "")
		throw new RuntimeException("Morate uneti tag");
	if (maxBroj<=0)
		maxBroj = 100;
	int brojac = 0; 
	TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
//Pretrazuju se poruke i traze se one koje sadrze tag.
//Ako se nadje neka takva, i ako nije prekoracen maxBroj
//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
//se prekida.	
	for (int i = 0; i < poruke.size(); i++)
		if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
			if (brojac < maxBroj){
				rezultat[brojac+1]=poruke.get(i);
				brojac++;
}
			else break;
	return rezultat;
}
} 
