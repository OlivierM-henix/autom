package org.autom5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;  // main one
import static org.assertj.core.api.Assertions.atIndex; // for List assertions
import static org.assertj.core.api.Assertions.entry;  // for Map assertions
import static org.assertj.core.api.Assertions.tuple; // when extracting several properties at once
import static org.assertj.core.api.Assertions.fail; // use when writing exception tests
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown; // idem
import static org.assertj.core.api.Assertions.filter; // for Iterable/Array assertions
import static org.assertj.core.api.Assertions.offset; // for floating number assertions
import static org.assertj.core.api.Assertions.anyOf; // use with Condition
import static org.assertj.core.api.Assertions.contentOf; // use with File assertions

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.autom5.PagesMenuCalendrier.PageCreerProjet;
import org.autom5.PagesMenuCalendrier.PageDetailProjet;
import org.autom5.PagesMenuRessources.PageCreerCritere;
import org.autom5.PagesMenuRessources.PageCritere;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PRO_01_Creation extends PageAbstract {



	WebDriver driver;

	@Before
	public void initialisations() throws InterruptedException {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		//Accéder à l’application et se connecter en tant que admin/admin
		driver.get("http://localhost:8081/libreplan/");	
		PageCnx pageCnx = PageFactory.initElements(driver, PageCnx.class);
		PageIndex pageIndex = pageCnx.sidentifier("admin", "admin", driver);
		Thread.sleep(5000);

		//Vérifier la bonne connexion
		assertTrue(pageIndex.btn_deconnexion.isEnabled());
		assertEquals(pageIndex.txt_utilisateurConnecte.getText(),"utilisateur: admin");

		// Se rendre sur la page à tester l'aide de la méthode selectionnerMenu de la PageAbstract: exemple avec Ressources / Formulaires Qualité
		// Adapter les noms à votre page !!!
		//PAS NECESSAIRE DANS LE TEST CALENDRIER CAR ONGLET PAR DEFAUT
		//pageIndex.selectionnerMenu(driver, "Ressources", "Critère");
		//PageFormulaireQualite pageFormulaireQualite = PageFactory.initElements(driver, PageFormulaireQualite.class);

		PageIndex pageindex = PageFactory.initElements(driver, PageIndex.class);

		//Acc�der au formulaire de cr�ation d'un projet
		//Cliquer sur l'ic�ne "Cr�er un nouveau projet" (1�re ic�ne "+" situ�e en dessous du logo "LibrePlan")
		driver.findElement(By.xpath("//span[@class='planner-icon z-button']//img")).click();
		PageCreerProjet PageCreerProjet = PageFactory.initElements(driver, PageCreerProjet.class);

		//v�rifier que le champ "nom" est pr�sent
		assertEquals("Nom", PageCreerProjet.label_nomprojet.getText());
		//log 	

		//v�rifier que le champ "nom" du projet est vide par d�faut
		assertThat(PageCreerProjet.input_nomprojet.getText().isEmpty());
		// log 			

		//V�rifier que le champ "modele" est pr�sent
		assertEquals("Modele", PageCreerProjet.label_modeleprojet.getText());	
		// log 

		//v�rifier que le log le champ "modele" est vide par d�faut 
		assertThat(PageCreerProjet.input_modeleprojet.getText().isEmpty());

		// V�rifier que le champ "modele" est une liste deroulante
		assertThat(PageCreerProjet.input_modeleprojet.getAttribute("class").contains("bandbox"));
		//("le champ modele est une bandbox/liste d�roulante", PageCreerProjet.input_modeleprojet.getAttribute("class") );	

		//v�rifier que le label code est pr�sent
		assertEquals("Code", PageCreerProjet.label_codeprojet.getText());
		// log 
		
		// V�rifier que date de d�but est pr�sent
		assertEquals("Date de debut", PageCreerProjet.label_datedebut_projet.getText());
		// log 
		
		
		assertEquals(OutilTechnique.formatdate() , PageCreerProjet.datedebut_projet.getText());
		//la date du jour est �gale au champ datedebut => la valeur par d�faut est la date du jour

		// V�rifier que label �ch�ance est affich� (atttention= is displayed)
		assertEquals("Echeance", PageCreerProjet.label_dateecheance_projet.getText());
		// log 

		// Verifier que la date d'�echance du projet est vide par d�faut
		assertThat(PageCreerProjet.input_dateecheanceprojet).isNull();;
		// log


		assertEquals("Client", PageCreerProjet.label_clientprojet.getText());
		// log champ client existe
		assertThat(PageCreerProjet.input_clientprojet).isNull();
		// champ client vide par d�faut



		assertEquals("Calendrier", PageCreerProjet.label_calendrierprojet.getText());
		// log 	
		assertEquals("Default", PageCreerProjet.combobox_calendrierprojet.getText());
		// log 	




		assertEquals("Accepter", PageCreerProjet.bouton_accepterprojet.getText());
		// log Bouton Accepter est pr�sent


		assertEquals("Annuler", PageCreerProjet.bouton_annulerprojet.getText());
		// log Bouton Annuler est pr�sent



		//Creation du projet
		// Initialisation de la Page : verification des champs dans le tableau et clic sur le bouton "Continuer"

		OutilTechnique.remplirChampTexte(PageCreerProjet.input_nomprojet, "PROJET_TEST1");
		PageCreerProjet.checkbox_codeprojet.click();
		assertTrue(PageCreerProjet.checkbox.equals(null));
		OutilTechnique.remplirChampTexte(PageCreerProjet.input_codeprojet, "PRJTEST001");

		//- Date de d�but : S�lectionner dans le calendrier date J+5 
		PageCreerProjet.datedebutprojet.click();
		OutilTechnique.formatdate();
		System.out.println(OutilTechnique.formatdate());
		
		PageCreerProjet.datedebutprojet.click();

		//- Date �ch�ance: S�lectionner dans le calendrier date J + 15 
		PageCreerProjet.bouton_dateecheanceprojet.click();

		//Le projet est cr�� : 
		//- dans le menu vertical � gauche de la page -> menu affich� = "D�tail du projet" 
		assertTrue(pageIndex.detailprojet.isDisplayed());

		//- dans le menu horizontal -> onglet affich� = "WBS (t�ches)" 
		assertTrue(pageIndex.ong_WBStaches.isDisplayed());


		//V�rifier les onglets - menu vertical : 
		//V�rifier le nom et la pr�sence des onglets pr�sent dans le menu vertical. 



		//Bouton d'enregistrement et d'annulation de l'�dition du projet </strong>: 

		//V�rifier la pr�sence des boutons d'enregistrement et d'annulation de l'�dition du projet. 
		//"Pr�sence au-dessus du menu vertical des boutons avec les caract�ristiques suivantes : 


		//assertTrue(PageDetailProjet.
		//PageCreerProjet.

		//PageDetailProjet.survol_element(b).click();
		//AssertThat(aaa).






		/*- Bouton d'enregistrement : 
		<ul> 
		 <li>ic�ne repr�sentant une disquette</li> 
		 <li>infobulle associ�e � l'ic�ne ""Enregistrer le projet""</li> 
		</ul> 
		Page

		- Bouton d'annulation de l'�dition : 
		<ul> 
		 <li>ic�ne repr�sentant une fl�che retour</li> 
		 <li>infobulle associ�e � l'ic�ne ""Annuler l'�dition""</li> 
		</ul>"
		 */

		/*
		 * Les onglets du menu vertical sont dans l'ordre suivant : <ul>
		 * <li>Planification de projet</li> <li>D�tail du projet</li> <li>Chargement des
		 * ressources</li> <li>Allocation avanc�e</li> <li>Tableau de bord</li> </ul>
		 */

	//	AssertThat(MenuHorizontal).








		//Capture d'écran - Ouverture de PageCreerCritere : vérifier que les boutons et champs sont présents dans la page
		//assertTrue("le bouton Enregistrer n'existe pas", PageCreerCritere.btn_enregistrer.isDisplayed());
		//assertTrue("le bouton Sauvegarder et continuer n'existe pas", PageCreerCritere.btn_sauvegarder_continuer.isDisplayed());
		//assertTrue("le bouton Annuler n'existe pas", PageCreerCritere.btn_annuler.isDisplayed());
		//assertEquals("Modifier", PageCreerCritere.creer_critere_modifier.getText());
		//Capture d'écran - Capture pour le testeur de l'état du tableau proposé. A ajouter, les checkboxes qui doivent être cochées par défaut

		//OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Critère - Test bouton [Annuler]");
		//OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Critère - Test bouton [Annuler]");
		//assertEquals("PARTICIPANT", PageCreerCritere.type_creer_critere.getText());		
	/*	PageCritere = PageCreerCritere.clicBtnAnnuler(driver);		
		assertFalse("Critère - Test bouton [Annuler]", false);
		//Capture d'écran - Test de la fonctionnalité annuler. Les modifications ne doivent pas être enregistrées dans la PageCritere

		PageCritere.clicBtnCreer(driver);
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Critère - Test bouton [Enregistrer]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Critère - Test bouton [Enregistrer]");
		PageCritere = PageCreerCritere.clicBtnEnregistrer(driver);
		assertTrue("Critère - Test bouton [Enregistrer]", true);
		Thread.sleep(2000);

		//Capture d'écran - Retour PageCritere : vérifier qu'aucune modification du tableau n'a été prise en compte
		PageCreerCritere = PageCritere.clicBtnCreer(driver);
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Test bouton [Sauver et continuer]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Test bouton [Sauver et continuer]");
		PageCreerCritere.clicBtnSauvegarderContinuer(driver);
		PageCritere = PageCreerCritere.clicBtnEnregistrer(driver);

	}
*/
}
}
