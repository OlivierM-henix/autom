package org.autom5;

import static org.assertj.core.api.Assertions.assertThat;  // main one
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.autom5.PagesMenuCalendrier.PageCreerProjet;
import org.autom5.PagesMenuCalendrier.PageDetailProjet;
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


		//********************* STEP 1 *********************
		//AccÃ©der Ã  lâ€™application et se connecter en tant que admin/admin
		driver.get("http://localhost:8081/libreplan/");	
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
		//Accéder au formulaire de création d'un projet
		//Cliquer sur l'icône "Créer un nouveau projet" (1ère icône "+" située en dessous du logo "LibrePlan")
		driver.findElement(By.xpath("//span[@class='planner-icon z-button']//img")).click();
		PageCreerProjet pageCreerProjet = PageFactory.initElements(driver, PageCreerProjet.class);

		OutilTechnique.remplirChampTexte(pageCreerProjet.input_codeprojet, "PRJTEST001");
		pageCreerProjet.checkbox_codeprojet.click();
		assertTrue(pageCreerProjet.checkbox.equals(null));

		//vérifier que le champ "nom" est présent
		assertEquals("Nom", pageCreerProjet.label_nomprojet.getText());
		//log.info 	

		//vérifier que le champ "nom" du projet est vide par défaut
		assertThat(pageCreerProjet.input_nomprojet.getText().isEmpty());
		// log 			
		pageCreerProjet.input_nomprojet.sendKeys("PROJET_TEST1");

		//Vérifier que le champ "modele" est présent
		assertEquals("Modele", pageCreerProjet.label_modeleprojet.getText());	
		// log 

		//vérifier que le log le champ "modele" est vide par défaut 
		assertThat(pageCreerProjet.input_modeleprojet.getText().isEmpty());

		// Vérifier que le champ "modele" est une liste deroulante
		assertThat(pageCreerProjet.input_modeleprojet.getAttribute("class").contains("bandbox"));
		//("le champ modele est une bandbox/liste déroulante", PageCreerProjet.input_modeleprojet.getAttribute("class") );	

		//vérifier que le label code est présent
		assertEquals("Code", pageCreerProjet.label_codeprojet.getText());
		// log 
		// Vérifier que date de début est présent
		assertEquals("Date de debut", pageCreerProjet.label_datedebut_projet.getText());
		// log 
		assertEquals(OutilTechnique.formatdate() , pageCreerProjet.datedebut_projet.getText());
		//la date du jour est égale au champ datedebut => la valeur par défaut est la date du jour
		// Vérifier que label échéance est affiché (atttention= is displayed)
		assertEquals("Echeance", pageCreerProjet.label_dateecheance_projet.getText());
		// log 
		// Verifier que la date d'éechance du projet est vide par défaut
		assertThat(pageCreerProjet.input_dateecheanceprojet).isNull();;
		// log
		assertEquals("Client", pageCreerProjet.label_clientprojet.getText());
		// log champ client existe
		assertThat(pageCreerProjet.input_clientprojet).isNull();
		// champ client vide par défaut
		assertEquals("Calendrier", pageCreerProjet.label_calendrierprojet.getText());
		// log 	
		assertEquals("Default", pageCreerProjet.combobox_calendrierprojet.getText());
		// log 
		assertEquals("Accepter", pageCreerProjet.bouton_accepterprojet.getText());
		// log Bouton Accepter est présent
		assertEquals("Annuler", pageCreerProjet.bouton_annulerprojet.getText());
		// log Bouton Annuler est présent

		//********************* STEP 3 *********************
		//Creation du projet
		// Initialisation de la Page : verification des champs dans le tableau et clic sur le bouton "Continuer"

		OutilTechnique.remplirChampTexte(pageCreerProjet.input_nomprojet, "PROJET_TEST1");
		pageCreerProjet.checkbox_codeprojet.click();
		assertTrue(pageCreerProjet.checkbox.equals(null));
		OutilTechnique.remplirChampTexte(pageCreerProjet.input_codeprojet, "PRJTEST001");

		//- Date de début : Sélectionner dans le calendrier date J+5 
		pageCreerProjet.datedebutprojet.click();
		//OutilTechnique.formatdate();
		System.out.println(OutilTechnique.formatdate());
		CalendarCalcul.getTargetDateMonthAndYear_debutprojet(5);

		pageCreerProjet.datedebutprojet.click();

		//- Date échéance: Sélectionner dans le calendrier date J + 15 
		pageCreerProjet.bouton_dateecheanceprojet.click();
		CalendarCalcul.getTargetDateMonthAndYear_echeanceprojet(15);

		//Cliquer sur le bouton accepter
		pageCreerProjet.bouton_accepterprojet.click();

		//Le projet est créé : 
		//- dans le menu vertical à gauche de la page -> menu affiché = "Détail du projet" 
		assertTrue(pageIndex.detailprojet.isDisplayed());

		//- dans le menu horizontal -> onglet affiché = "WBS (tâches)" 
		assertTrue(pageIndex.ong_WBStaches.isDisplayed());

		//********************* STEP 4 *********************
		//Vérifier les onglets - menu vertical : 
		//Vérifier le nom et la présence des onglets présent dans le menu vertical. 

		/*//Les onglets du menu vertical sont dans l'ordre suivant : 
		<ul> 
		 <li>Planification de projet</li> 
		 <li>Détail du projet</li> 
		 <li>Chargement des ressources</li> 
		 <li>Allocation avancée</li> 
		 <li>Tableau de bord</li> 
		</ul>*/

		//creer une liste en trouvant le xpath sur le site
		//comparer cette liste a une liste faite manuellement



		//********************* STEP 5 *********************	
		//"Vérifier les onglets - menu horizontal : 

		//Vérifier le nom et la présence des onglets présent dans le menu horizontal. 
		//"Les onglets du menu horizontal sont dans l'ordre suivant : 
		//<ul> 
		//<li>WBS (tâches)</li> 
		//<li>Données générales</li> 
		//<li>Coût</li> 
		//<li>Avancement</li> 
		//<li>Libellés</li> 
		//<li>Exigence de critère</li> 
		//<li>Matériels</li> 
		//<li>Formulaire qualité des tâches</li> 
		//<li>Autorisation</li> 
		//</ul>"




		//********************* STEP 6 *********************
		//Bouton d'enregistrement et d'annulation de l'édition du projet </strong>: 
		//Vérifier la présence des boutons d'enregistrement et d'annulation de l'édition du projet. 
		assertTrue("le bouton enregistrer n'est pas affiché",PageDetailProjet.icone_enregistrer.isDisplayed());
		assertTrue("le bouton annuler n'est pas affiché",PageDetailProjet.icone_annuler.isDisplayed());


		//"Présence au-dessus du menu vertical des boutons avec les caractéristiques suivantes : 
		/*- Bouton d'enregistrement : 
		<ul> 
		 <li>icône représentant une disquette</li> 
		 <li>infobulle associée à l'icône ""Enregistrer le projet""</li> 
		</ul> 
		Page

		- Bouton d'annulation de l'édition : 
		<ul> 
		 <li>icône représentant une flèche retour</li> 
		 <li>infobulle associée à l'icône ""Annuler l'édition""</li> 
		</ul>"
		 */

		/*
		 * Les onglets du menu vertical sont dans l'ordre suivant : <ul>
		 * <li>Planification de projet</li> <li>Détail du projet</li> <li>Chargement des
		 * ressources</li> <li>Allocation avancée</li> <li>Tableau de bord</li> </ul>
		 */



		//********************* STEP 7 *********************
		//"Utilisation du bouton d'annulation de l'édition du projet (1/4) :  
		//Cliquer sur le bouton d'annulation de l'édition du projet."
		PageDetailProjet.icone_annuler.click();

		//"Affichage d'une pop-up ""Confirmer la fenêtre de sortie"" contenant : 
		//- le message suivant : 
		//""Les modifications non enregistrées seront perdues. 
		//Etes-vous sûr ?"" 
		assertTrue("la popup d'annulation n'est pas affichée", PageDetailProjet.popupdiv_annulation.isDisplayed());
		assertEquals("Les modifications non enregistrées seront perdues. Êtes-vous sûr ?", PageDetailProjet.message_popupdiv_annulation);

		//- les boutons [OK] et [Annuler] 
		assertTrue("le bouton [OK] de la popup d'annulation n'est pas affiché", PageDetailProjet.popupdiv_boutonok.isDisplayed());
		assertTrue("le bouton [Annuler] de la popup d'annulation n'est pas affiché", PageDetailProjet.popupdiv_boutonannuler.isDisplayed());


		//********************* STEP 8 *********************
		//"Utilisation du bouton d'annulation de l'édition du projet (2/4) : 

		//Dans la pop-up, cliquer sur le bouton [Annuler]. 
		PageDetailProjet.popupdiv_annulation.click();

		//"Fermeture de la pop-up ""Confirmer la fenêtre de sortie"" 
		assertFalse(PageDetailProjet.popupdiv_annulation.isDisplayed());

		//Dans le menu vertical à gauche de la page -> menu affiché = ""Détail du projet""  

		//Dans le menu horizontal -> onglet affiché = ""WBS (tâches)"" 



		//********************* STEP 9 *********************
		//"Utilisation du bouton d'annulation de l'édition du projet (3/4) : 

		//Cliquer sur le bouton d'annulation de l'édition du projet."



		//"Affichage d'une pop-up ""Confirmer la fenêtre de sortie"" contenant : 

		//- le message suivant : 
		//""Les modifications non enregistrées seront perdues. 
		//Etes-vous sûr ?"" 

		//- les boutons [OK] et [Annuler] 


		//********************* STEP 10 *********************
		//"Utilisation du bouton d'annulation de l'édition du projet (4/4) : 

		//Dans la pop-up, cliquer sur le bouton [OK]. 



		//"Fermeture de la pop-up ""Confirmer la fenêtre de sortie"" 

		//Dans le menu vertical à gauche de la page -> menu affiché = ""Planification des projets"" 

		//Dans le menu horizontal -> absence de menu horizontal 




		//********************* STEP 11 *********************
		//"Vérifier la création du projet : 

		//Passer la souris sur l'onglet ""Calendrier"" puis dans le sous-menu qui s'affiche, cliquer sur l'item ""Projets"". 



		//"La liste est affichée à droite du menu vertical, le projet créé y est présent. 

		//Dans le menu vertical à gauche de la page -> menu affiché = ""Liste des projets"". 



		//********************* STEP 12 *********************
		//"Vérifier les informations affichées pour le projet : 

		//Vérifier la conformité des informations affichées pour le projet dans la liste affichée. 


		//"Dans la liste des projets, pour le projet créé les informations affichées dans les colonnes du tableau sont les suivantes : 

		//- Nom : PROJET_TEST1 
		//- Code : PRJTEST001 
		//- Date de début : date J+5 
		//- Echéance : date J+15 
		//- Client : champ non renseigné 
		//- Budget total : 0 € 
		//- Heures : 0 
		//- Etat : PRE-VENTES 
		//- Opérations : 4 icones : modifier, supprimer, voir la prévision, créer un modèle 

	}





}

