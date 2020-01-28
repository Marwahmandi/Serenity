@CRA 
Feature: En tant que collaborateur, 
	je souhaite accéder à mon cra
Pour retrouver mes projets dans mon cra


Background: 
	Given je me connecte en tant que "ACEGCC Acegcc" 
	
@NotSkip 
Scenario:
Affichage de la rubrique Mission et Client dans le cra d'un Collaborateur (le collaborateur est affectée à une mission "Nom_mission" avec le client "Nom_client") 
	Given je suis dans l'espace de "ACEGCC Acegcc" 
	When j accede à mon CRA du mois courant 
	And  jhzdgfjz
	Then  le nom de la mission "Nom_mission" avec le client "Nom_client" sont affichés