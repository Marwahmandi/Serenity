#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: En tant que collaborateur je veux retrouver une rubrique Informations professionnelles dans ma fiche RH contenant différents onglets
Background: je me connecte en tant que "ACEGCC Acegcc" 

 @NotSkip 
  Scenario: Navigation entre different onglet
   # Given je me conncete en tant que collaborateur
    When j'appuie sur le Menu ma fiche RH
    Then redirection vers la rubrique Informations professionnelles
    And je navigue entre les differents onglets
   # | Contrat | Période d'essai | Fonction | Rémunération | Frais | Matériel
 

 @Skip 
Scenario: Navigation entre different onglet
    Given je me conncete en tant que collaborateur
		When j'appuie sur le Menu ma fiche RH
		Then redirection vers la rubrique Informations personnelles	
		And je navigue entre les differents onglet
      #   | Identité  |Adresse | Téléphone&mail  | Cas d'urgences  | Coordonnées bancaires  |





    
