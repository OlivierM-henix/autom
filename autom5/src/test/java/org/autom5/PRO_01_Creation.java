package org.autom5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.autom5.PagesMenuCalendrier.PageCreerProjet;
import org.autom5.PagesMenuCalendrier.PageDetailProjet;
import org.junit.After;
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
	
	@After
	public void fermerNavigateur () {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {


		//********************* STEP 1 *********************
		//AccÃ©der Ã  lâ€™application et se connecter en tant que admin/admin
		driver.get("http://localhost:8090/libreplan/");	
		PageCnx pageCnx = PageFactory.initElements(driver, PageCnx.class);
		PageIndex pageIndex = pageCnx.sidentifier("admin", "admin", driver);
		Thread.sleep(5000);

		//VÃ©rifier la bonne connexion
		assertTrue(pageIndex.btn_deconnexion.isEnabled());
		assertEquals(pageIndex.txt_utilisateurConnecte.getText(),"utilisateur: admin");

		// Se rendre sur la page Ã  tester l'aide de la mÃ©thode selectionnerMenu de la PageAbstract: exemple avec Ressources / Formulaires QualitÃ©
		// Adapter les noms Ã  votre page !!!
		//PAS NECESSAIRE DANS LE TEST CALENDRIER CAR ONGLET PAR DEFAUT
		//pageIndex.selectionnerMenu(driver, "Ressources", "CritÃ¨re");
		//PageFormulaireQualite pageFormulaireQualite = PageFactory.initElements(driver, PageFormulaireQualite.class);

		//PageIndex pageIndex = PageFactory.initElements(driver, PageIndex.class);


		//********************* STEP 2 *********************
		//Accï¿½der au formulaire de crï¿½ation d'un projet
		//Cliquer sur l'icï¿½ne "Crï¿½er un nouveau projet" (1ï¿½re icï¿½ne "+" situï¿½e en dessous du logo "LibrePlan")
		driver.findElement(By.xpath("//span[@class='planner-icon z-button']//img")).click();
		System.out.println("popup affichée");
		PageCreerProjet pageCreerProjet = PageFactory.initElements(driver, PageCreerProjet.class);
<<<<<<< HEAD
		pageCreerProjet.input_nomprojet.sendKeys("PRJTEST001");
		
		
		//OutilTechnique.remplirChampTexte(pageCreerProjet.input_nomprojet, "PRJTEST001");
		
=======


		OutilTechnique.remplirChampTexte(pageCreerProjet.input_codeprojet, "PRJTEST001");
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672
		pageCreerProjet.checkbox_codeprojet.click();
		assertTrue(pageCreerProjet.checkbox_codeprojet.equals(null));

		//vï¿½rifier que le champ "nom" est prï¿½sent
		assertEquals("Nom", pageCreerProjet.label_nomprojet.getText());
		//log.info 	

<<<<<<< HEAD
		//vérifier que le champ "nom" du projet est vide par défaut
		assertTrue(pageCreerProjet.input_nomprojet.getText().isEmpty());
=======
		//vï¿½rifier que le champ "nom" du projet est vide par dï¿½faut
		assertThat(pageCreerProjet.input_nomprojet.getText().isEmpty());
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672
		// log 			
		pageCreerProjet.input_nomprojet.sendKeys("PROJET_TEST1");

		//Vï¿½rifier que le champ "modele" est prï¿½sent
		assertEquals("Modele", pageCreerProjet.label_modeleprojet.getText());	
		// log 

<<<<<<< HEAD
		//vérifier que le log le champ "modele" est vide par défaut 
		assertTrue(pageCreerProjet.input_modeleprojet.getText().isEmpty());

		// Vérifier que le champ "modele" est une liste deroulante
		assertTrue(pageCreerProjet.input_modeleprojet.getAttribute("class").contains("bandbox"));
		//("le champ modele est une bandbox/liste déroulante", PageCreerProjet.input_modeleprojet.getAttribute("class") );	
=======
		//vï¿½rifier que le log le champ "modele" est vide par dï¿½faut 
		assertThat(pageCreerProjet.input_modeleprojet.getText().isEmpty());

		// Vï¿½rifier que le champ "modele" est une liste deroulante
		assertThat(pageCreerProjet.input_modeleprojet.getAttribute("class").contains("bandbox"));
		//("le champ modele est une bandbox/liste dï¿½roulante", PageCreerProjet.input_modeleprojet.getAttribute("class") );	
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672

		//vï¿½rifier que le label code est prï¿½sent
		assertEquals("Code", pageCreerProjet.label_codeprojet.getText());
		// log 
		// Vï¿½rifier que date de dï¿½but est prï¿½sent
		assertEquals("Date de debut", pageCreerProjet.label_datedebut_projet.getText());
		// log 
		assertEquals(OutilTechnique.formatdate() , pageCreerProjet.datedebut_projet.getText());
		//la date du jour est ï¿½gale au champ datedebut => la valeur par dï¿½faut est la date du jour
		// Vï¿½rifier que label ï¿½chï¿½ance est affichï¿½ (atttention= is displayed)
		assertEquals("Echeance", pageCreerProjet.label_dateecheance_projet.getText());
		// log 
<<<<<<< HEAD
		// Verifier que la date d'éechance du projet est vide par défaut
		assertTrue(pageCreerProjet.input_dateecheanceprojet.getText().isEmpty());;
		// log
		assertEquals("Client", pageCreerProjet.label_clientprojet.getText());
		// log champ client existe
		assertTrue(pageCreerProjet.input_clientprojet.getText().isEmpty());
		// champ client vide par défaut
=======
		// Verifier que la date d'ï¿½echance du projet est vide par dï¿½faut
		assertThat(pageCreerProjet.input_dateecheanceprojet).isNull();;
		// log
		assertEquals("Client", pageCreerProjet.label_clientprojet.getText());
		// log champ client existe
		assertThat(pageCreerProjet.input_clientprojet).isNull();
		// champ client vide par dï¿½faut
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672
		assertEquals("Calendrier", pageCreerProjet.label_calendrierprojet.getText());
		// log 	
		assertEquals("Default", pageCreerProjet.combobox_calendrierprojet.getText());
		// log 
		assertEquals("Accepter", pageCreerProjet.bouton_accepterprojet.getText());
		// log Bouton Accepter est prï¿½sent
		assertEquals("Annuler", pageCreerProjet.bouton_annulerprojet.getText());
		// log Bouton Annuler est prï¿½sent

		//********************* STEP 3 *********************
		//Creation du projet
		// Initialisation de la Page : verification des champs dans le tableau et clic sur le bouton "Continuer"

		OutilTechnique.remplirChampTexte(pageCreerProjet.input_nomprojet, "PROJET_TEST1");
		pageCreerProjet.checkbox_codeprojet.click();
		assertTrue(pageCreerProjet.checkbox_codeprojet.equals(null));
		OutilTechnique.remplirChampTexte(pageCreerProjet.input_codeprojet, "PRJTEST001");

<<<<<<< HEAD
		//- Date de début : Sélectionner dans le calendrier date J+5 
		pageCreerProjet.bouton_datedebutprojet.click();
=======
		//- Date de dï¿½but : Sï¿½lectionner dans le calendrier date J+5 
		pageCreerProjet.datedebutprojet.click();
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672
		//OutilTechnique.formatdate();
		System.out.println(OutilTechnique.formatdate());
		CalendarCalcul.getTargetDateMonthAndYear_debutprojet(5);

		pageCreerProjet.bouton_datedebutprojet.click();

		//- Date ï¿½chï¿½ance: Sï¿½lectionner dans le calendrier date J + 15 
		pageCreerProjet.bouton_dateecheanceprojet.click();
		CalendarCalcul.getTargetDateMonthAndYear_echeanceprojet(15);

		//Cliquer sur le bouton accepter
		pageCreerProjet.bouton_accepterprojet.click();

		//Le projet est crï¿½ï¿½ : 
		//- dans le menu vertical ï¿½ gauche de la page -> menu affichï¿½ = "Dï¿½tail du projet" 
		assertTrue(pageIndex.detailprojet.isDisplayed());

		//- dans le menu horizontal -> onglet affichï¿½ = "WBS (tï¿½ches)" 
		assertTrue(pageIndex.ong_WBStaches.isDisplayed());

		//********************* STEP 4 *********************
		//Vï¿½rifier les onglets - menu vertical : 
		//Vï¿½rifier le nom et la prï¿½sence des onglets prï¿½sent dans le menu vertical. 

		/*//Les onglets du menu vertical sont dans l'ordre suivant : 
		<ul> 
		 <li>Planification de projet</li> 
		 <li>Dï¿½tail du projet</li> 
		 <li>Chargement des ressources</li> 
		 <li>Allocation avancï¿½e</li> 
		 <li>Tableau de bord</li> 
		</ul>*/

		//creer une liste en trouvant le xpath sur le site
		//comparer cette liste a une liste faite manuellement



		//********************* STEP 5 *********************	
		//"Vï¿½rifier les onglets - menu horizontal : 

		//Vï¿½rifier le nom et la prï¿½sence des onglets prï¿½sent dans le menu horizontal. 
		//"Les onglets du menu horizontal sont dans l'ordre suivant : 
		//<ul> 
		//<li>WBS (tï¿½ches)</li> 
		//<li>Donnï¿½es gï¿½nï¿½rales</li> 
		//<li>Coï¿½t</li> 
		//<li>Avancement</li> 
		//<li>Libellï¿½s</li> 
		//<li>Exigence de critï¿½re</li> 
		//<li>Matï¿½riels</li> 
		//<li>Formulaire qualitï¿½ des tï¿½ches</li> 
		//<li>Autorisation</li> 
		//</ul>"




		//********************* STEP 6 *********************
		//Bouton d'enregistrement et d'annulation de l'ï¿½dition du projet </strong>: 
		//Vï¿½rifier la prï¿½sence des boutons d'enregistrement et d'annulation de l'ï¿½dition du projet. 
		assertTrue("le bouton enregistrer n'est pas affichï¿½",PageDetailProjet.icone_enregistrer.isDisplayed());
		assertTrue("le bouton annuler n'est pas affichï¿½",PageDetailProjet.icone_annuler.isDisplayed());


		//"Prï¿½sence au-dessus du menu vertical des boutons avec les caractï¿½ristiques suivantes : 
		/*- Bouton d'enregistrement : 
		<ul> 
		 <li>icï¿½ne reprï¿½sentant une disquette</li> 
		 <li>infobulle associï¿½e ï¿½ l'icï¿½ne ""Enregistrer le projet""</li> 
		</ul> 
		Page

		- Bouton d'annulation de l'ï¿½dition : 
		<ul> 
		 <li>icï¿½ne reprï¿½sentant une flï¿½che retour</li> 
		 <li>infobulle associï¿½e ï¿½ l'icï¿½ne ""Annuler l'ï¿½dition""</li> 
		</ul>"
		 */

		/*
		 * Les onglets du menu vertical sont dans l'ordre suivant : <ul>
		 * <li>Planification de projet</li> <li>Dï¿½tail du projet</li> <li>Chargement des
		 * ressources</li> <li>Allocation avancï¿½e</li> <li>Tableau de bord</li> </ul>
		 */



		//********************* STEP 7 *********************
		//"Utilisation du bouton d'annulation de l'ï¿½dition du projet (1/4) :  
		//Cliquer sur le bouton d'annulation de l'ï¿½dition du projet."
		PageDetailProjet.icone_annuler.click();

		//"Affichage d'une pop-up ""Confirmer la fenï¿½tre de sortie"" contenant : 
		//- le message suivant : 
		//""Les modifications non enregistrï¿½es seront perdues. 
		//Etes-vous sï¿½r ?"" 
		assertTrue("la popup d'annulation n'est pas affichï¿½e", PageDetailProjet.popupdiv_annulation.isDisplayed());
		assertEquals("Les modifications non enregistrï¿½es seront perdues. ï¿½tes-vous sï¿½r ?", PageDetailProjet.message_popupdiv_annulation);

		//- les boutons [OK] et [Annuler] 
		assertTrue("le bouton [OK] de la popup d'annulation n'est pas affichï¿½", PageDetailProjet.popupdiv_boutonok.isDisplayed());
		assertTrue("le bouton [Annuler] de la popup d'annulation n'est pas affichï¿½", PageDetailProjet.popupdiv_boutonannuler.isDisplayed());


		//********************* STEP 8 *********************
		//"Utilisation du bouton d'annulation de l'ï¿½dition du projet (2/4) : 

		//Dans la pop-up, cliquer sur le bouton [Annuler]. 
		PageDetailProjet.popupdiv_annulation.click();

		//"Fermeture de la pop-up ""Confirmer la fenï¿½tre de sortie"" 
		assertFalse(PageDetailProjet.popupdiv_annulation.isDisplayed());

		//Dans le menu vertical ï¿½ gauche de la page -> menu affichï¿½ = ""Dï¿½tail du projet""  

		//Dans le menu horizontal -> onglet affichï¿½ = ""WBS (tï¿½ches)"" 



		//********************* STEP 9 *********************
		//"Utilisation du bouton d'annulation de l'ï¿½dition du projet (3/4) : 

		//Cliquer sur le bouton d'annulation de l'ï¿½dition du projet."



		//"Affichage d'une pop-up ""Confirmer la fenï¿½tre de sortie"" contenant : 

		//- le message suivant : 
		//""Les modifications non enregistrï¿½es seront perdues. 
		//Etes-vous sï¿½r ?"" 

		//- les boutons [OK] et [Annuler] 


		//********************* STEP 10 *********************
		//"Utilisation du bouton d'annulation de l'ï¿½dition du projet (4/4) : 

		//Dans la pop-up, cliquer sur le bouton [OK]. 



		//"Fermeture de la pop-up ""Confirmer la fenï¿½tre de sortie"" 

		//Dans le menu vertical ï¿½ gauche de la page -> menu affichï¿½ = ""Planification des projets"" 

		//Dans le menu horizontal -> absence de menu horizontal 




		//********************* STEP 11 *********************
		//"Vï¿½rifier la crï¿½ation du projet : 

		//Passer la souris sur l'onglet ""Calendrier"" puis dans le sous-menu qui s'affiche, cliquer sur l'item ""Projets"". 



		//"La liste est affichï¿½e ï¿½ droite du menu vertical, le projet crï¿½ï¿½ y est prï¿½sent. 

		//Dans le menu vertical ï¿½ gauche de la page -> menu affichï¿½ = ""Liste des projets"". 



		//********************* STEP 12 *********************
		//"Vï¿½rifier les informations affichï¿½es pour le projet : 

		//Vï¿½rifier la conformitï¿½ des informations affichï¿½es pour le projet dans la liste affichï¿½e. 


		//"Dans la liste des projets, pour le projet crï¿½ï¿½ les informations affichï¿½es dans les colonnes du tableau sont les suivantes : 

		//- Nom : PROJET_TEST1 
		//- Code : PRJTEST001 
		//- Date de dï¿½but : date J+5 
		//- Echï¿½ance : date J+15 
		//- Client : champ non renseignï¿½ 
		//- Budget total : 0 ï¿½ 
		//- Heures : 0 
		//- Etat : PRE-VENTES 
		//- Opï¿½rations : 4 icones : modifier, supprimer, voir la prï¿½vision, crï¿½er un modï¿½le 

	}





}

