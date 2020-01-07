package org.autom5;

import static org.assertj.core.api.Assertions.assertThat;  // main one
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
		//Accéder à l’application et se connecter en tant que admin/admin
		driver.get("http://localhost:8090/libreplan/");	
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

		//PageIndex pageIndex = PageFactory.initElements(driver, PageIndex.class);


		//********************* STEP 2 *********************
		//Acc�der au formulaire de cr�ation d'un projet
		//Cliquer sur l'ic�ne "Cr�er un nouveau projet" (1�re ic�ne "+" situ�e en dessous du logo "LibrePlan")
		driver.findElement(By.xpath("//span[@class='planner-icon z-button']//img")).click();
		PageCreerProjet pageCreerProjet = PageFactory.initElements(driver, PageCreerProjet.class);


		OutilTechnique.remplirChampTexte(pageCreerProjet.input_codeprojet, "PRJTEST001");
		pageCreerProjet.checkbox_codeprojet.click();
		assertTrue(pageCreerProjet.checkbox_codeprojet.equals(null));

		//v�rifier que le champ "nom" est pr�sent
		assertEquals("Nom", pageCreerProjet.label_nomprojet.getText());
		//log.info 	

		//v�rifier que le champ "nom" du projet est vide par d�faut
		assertThat(pageCreerProjet.input_nomprojet.getText().isEmpty());
		// log 			
		pageCreerProjet.input_nomprojet.sendKeys("PROJET_TEST1");

		//V�rifier que le champ "modele" est pr�sent
		assertEquals("Modele", pageCreerProjet.label_modeleprojet.getText());	
		// log 

		//v�rifier que le log le champ "modele" est vide par d�faut 
		assertThat(pageCreerProjet.input_modeleprojet.getText().isEmpty());

		// V�rifier que le champ "modele" est une liste deroulante
		assertThat(pageCreerProjet.input_modeleprojet.getAttribute("class").contains("bandbox"));
		//("le champ modele est une bandbox/liste d�roulante", PageCreerProjet.input_modeleprojet.getAttribute("class") );	

		//v�rifier que le label code est pr�sent
		assertEquals("Code", pageCreerProjet.label_codeprojet.getText());
		// log 
		// V�rifier que date de d�but est pr�sent
		assertEquals("Date de debut", pageCreerProjet.label_datedebut_projet.getText());
		// log 
		assertEquals(OutilTechnique.formatdate() , pageCreerProjet.datedebut_projet.getText());
		//la date du jour est �gale au champ datedebut => la valeur par d�faut est la date du jour
		// V�rifier que label �ch�ance est affich� (atttention= is displayed)
		assertEquals("Echeance", pageCreerProjet.label_dateecheance_projet.getText());
		// log 
		// Verifier que la date d'�echance du projet est vide par d�faut
		assertThat(pageCreerProjet.input_dateecheanceprojet).isNull();;
		// log
		assertEquals("Client", pageCreerProjet.label_clientprojet.getText());
		// log champ client existe
		assertThat(pageCreerProjet.input_clientprojet).isNull();
		// champ client vide par d�faut
		assertEquals("Calendrier", pageCreerProjet.label_calendrierprojet.getText());
		// log 	
		assertEquals("Default", pageCreerProjet.combobox_calendrierprojet.getText());
		// log 
		assertEquals("Accepter", pageCreerProjet.bouton_accepterprojet.getText());
		// log Bouton Accepter est pr�sent
		assertEquals("Annuler", pageCreerProjet.bouton_annulerprojet.getText());
		// log Bouton Annuler est pr�sent

		//********************* STEP 3 *********************
		//Creation du projet
		// Initialisation de la Page : verification des champs dans le tableau et clic sur le bouton "Continuer"

		OutilTechnique.remplirChampTexte(pageCreerProjet.input_nomprojet, "PROJET_TEST1");
		pageCreerProjet.checkbox_codeprojet.click();
		assertTrue(pageCreerProjet.checkbox_codeprojet.equals(null));
		OutilTechnique.remplirChampTexte(pageCreerProjet.input_codeprojet, "PRJTEST001");

		//- Date de d�but : S�lectionner dans le calendrier date J+5 
		pageCreerProjet.datedebutprojet.click();
		//OutilTechnique.formatdate();
		System.out.println(OutilTechnique.formatdate());
		CalendarCalcul.getTargetDateMonthAndYear_debutprojet(5);

		pageCreerProjet.datedebutprojet.click();

		//- Date �ch�ance: S�lectionner dans le calendrier date J + 15 
		pageCreerProjet.bouton_dateecheanceprojet.click();
		CalendarCalcul.getTargetDateMonthAndYear_echeanceprojet(15);

		//Cliquer sur le bouton accepter
		pageCreerProjet.bouton_accepterprojet.click();

		//Le projet est cr�� : 
		//- dans le menu vertical � gauche de la page -> menu affich� = "D�tail du projet" 
		assertTrue(pageIndex.detailprojet.isDisplayed());

		//- dans le menu horizontal -> onglet affich� = "WBS (t�ches)" 
		assertTrue(pageIndex.ong_WBStaches.isDisplayed());

		//********************* STEP 4 *********************
		//V�rifier les onglets - menu vertical : 
		//V�rifier le nom et la pr�sence des onglets pr�sent dans le menu vertical. 

		/*//Les onglets du menu vertical sont dans l'ordre suivant : 
		<ul> 
		 <li>Planification de projet</li> 
		 <li>D�tail du projet</li> 
		 <li>Chargement des ressources</li> 
		 <li>Allocation avanc�e</li> 
		 <li>Tableau de bord</li> 
		</ul>*/

		//creer une liste en trouvant le xpath sur le site
		//comparer cette liste a une liste faite manuellement



		//********************* STEP 5 *********************	
		//"V�rifier les onglets - menu horizontal : 

		//V�rifier le nom et la pr�sence des onglets pr�sent dans le menu horizontal. 
		//"Les onglets du menu horizontal sont dans l'ordre suivant : 
		//<ul> 
		//<li>WBS (t�ches)</li> 
		//<li>Donn�es g�n�rales</li> 
		//<li>Co�t</li> 
		//<li>Avancement</li> 
		//<li>Libell�s</li> 
		//<li>Exigence de crit�re</li> 
		//<li>Mat�riels</li> 
		//<li>Formulaire qualit� des t�ches</li> 
		//<li>Autorisation</li> 
		//</ul>"




		//********************* STEP 6 *********************
		//Bouton d'enregistrement et d'annulation de l'�dition du projet </strong>: 
		//V�rifier la pr�sence des boutons d'enregistrement et d'annulation de l'�dition du projet. 
		assertTrue("le bouton enregistrer n'est pas affich�",PageDetailProjet.icone_enregistrer.isDisplayed());
		assertTrue("le bouton annuler n'est pas affich�",PageDetailProjet.icone_annuler.isDisplayed());


		//"Pr�sence au-dessus du menu vertical des boutons avec les caract�ristiques suivantes : 
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



		//********************* STEP 7 *********************
		//"Utilisation du bouton d'annulation de l'�dition du projet (1/4) :  
		//Cliquer sur le bouton d'annulation de l'�dition du projet."
		PageDetailProjet.icone_annuler.click();

		//"Affichage d'une pop-up ""Confirmer la fen�tre de sortie"" contenant : 
		//- le message suivant : 
		//""Les modifications non enregistr�es seront perdues. 
		//Etes-vous s�r ?"" 
		assertTrue("la popup d'annulation n'est pas affich�e", PageDetailProjet.popupdiv_annulation.isDisplayed());
		assertEquals("Les modifications non enregistr�es seront perdues. �tes-vous s�r ?", PageDetailProjet.message_popupdiv_annulation);

		//- les boutons [OK] et [Annuler] 
		assertTrue("le bouton [OK] de la popup d'annulation n'est pas affich�", PageDetailProjet.popupdiv_boutonok.isDisplayed());
		assertTrue("le bouton [Annuler] de la popup d'annulation n'est pas affich�", PageDetailProjet.popupdiv_boutonannuler.isDisplayed());


		//********************* STEP 8 *********************
		//"Utilisation du bouton d'annulation de l'�dition du projet (2/4) : 

		//Dans la pop-up, cliquer sur le bouton [Annuler]. 
		PageDetailProjet.popupdiv_annulation.click();

		//"Fermeture de la pop-up ""Confirmer la fen�tre de sortie"" 
		assertFalse(PageDetailProjet.popupdiv_annulation.isDisplayed());

		//Dans le menu vertical � gauche de la page -> menu affich� = ""D�tail du projet""  

		//Dans le menu horizontal -> onglet affich� = ""WBS (t�ches)"" 



		//********************* STEP 9 *********************
		//"Utilisation du bouton d'annulation de l'�dition du projet (3/4) : 

		//Cliquer sur le bouton d'annulation de l'�dition du projet."



		//"Affichage d'une pop-up ""Confirmer la fen�tre de sortie"" contenant : 

		//- le message suivant : 
		//""Les modifications non enregistr�es seront perdues. 
		//Etes-vous s�r ?"" 

		//- les boutons [OK] et [Annuler] 


		//********************* STEP 10 *********************
		//"Utilisation du bouton d'annulation de l'�dition du projet (4/4) : 

		//Dans la pop-up, cliquer sur le bouton [OK]. 



		//"Fermeture de la pop-up ""Confirmer la fen�tre de sortie"" 

		//Dans le menu vertical � gauche de la page -> menu affich� = ""Planification des projets"" 

		//Dans le menu horizontal -> absence de menu horizontal 




		//********************* STEP 11 *********************
		//"V�rifier la cr�ation du projet : 

		//Passer la souris sur l'onglet ""Calendrier"" puis dans le sous-menu qui s'affiche, cliquer sur l'item ""Projets"". 



		//"La liste est affich�e � droite du menu vertical, le projet cr�� y est pr�sent. 

		//Dans le menu vertical � gauche de la page -> menu affich� = ""Liste des projets"". 



		//********************* STEP 12 *********************
		//"V�rifier les informations affich�es pour le projet : 

		//V�rifier la conformit� des informations affich�es pour le projet dans la liste affich�e. 


		//"Dans la liste des projets, pour le projet cr�� les informations affich�es dans les colonnes du tableau sont les suivantes : 

		//- Nom : PROJET_TEST1 
		//- Code : PRJTEST001 
		//- Date de d�but : date J+5 
		//- Ech�ance : date J+15 
		//- Client : champ non renseign� 
		//- Budget total : 0 � 
		//- Heures : 0 
		//- Etat : PRE-VENTES 
		//- Op�rations : 4 icones : modifier, supprimer, voir la pr�vision, cr�er un mod�le 

	}





}

