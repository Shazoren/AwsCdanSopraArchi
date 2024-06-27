# Documentation Technique du Projet

## 1. Introduction
- **Nom du Projet:** FakeBer (un service similaire à Uber)
- **Auteur:** MANCHON Yannick
- **Description:** Application de gestion de transport similaire à Uber, déployée sur un serveur AWS.

## 2. Technologies Utilisées
- **Langage de Programmation:** Java
- **Framework Backend:** Spring Boot
- **Version JDK:** 17
- **Système de Gestion de Base de Données:** MySQL
- **Outils de Développement:** Maven, Postman

## 3. Structure du Projet
- **src/main/java:** Contient les packages Java principaux
  - `com.example.awscdansopraarchi.controllers`: Contrôleurs API REST
  - `com.example.awscdansopraarchi.dtos`: DTOs (Data Transfer Objects)
  - `com.example.awscdansopraarchi.entities`: Entités JPA
  - `com.example.awscdansopraarchi.repositories`: Interfaces de Repository JPA
  - `com.example.awscdansopraarchi.services`: Services
- **src/main/resources:** Fichiers de configuration et ressources
  - `application.properties`: Configuration de l'application
  - `data.sql`: Script SQL pour initialiser la base de données

## 4. Architecture
Le projet utilise Spring Boot, un framework Java pour le développement rapide d'applications basées sur Java EE. Il suit une architecture MVC (Modèle-Vue-Contrôleur) avec une couche de services intermédiaire pour la logique métier.
- **Modèle:** Entités JPA représentant les données persistantes.
- **Vue:** Aucune vue dans le backend (API REST), mais les DTOs servent de contrat de données.
- **Contrôleur:** Gère les endpoints REST, appelle les services appropriés.
- **Service:** Contient la logique métier, traite les données et interagit avec les repositories.

## 5. Configuration
- **Base de Données:** MySQL avec Hibernate comme ORM. Les détails de connexion sont configurés dans `application.properties`.
- **Dépendances Maven:** Principales dépendances incluent Spring Boot Starter Web, Spring Boot Starter Data JPA, etc.

## 6. Principales Fonctionnalités
1. **Gestion des Clients**
   - CRUD (Create, Read, Update, Delete) pour les clients.
   - Calcul des statistiques de course par client.
   
2. **Gestion des Courses**
   - Ajout de nouvelles courses avec client associé.
   - Statistiques de courses par client (nombre de courses, distance totale).

## 7. Utilisation
- **Ajouter un Client**
  - Endpoint : `POST /Client/add`
  - Body de la requête : (insérer le format du corps de la requête)
  
- **Ajouter un Chauffeur**
  - Endpoint : `POST /Chauffeur/add`
  - Body de la requête : (insérer le format du corps de la requête)
  
- **Afficher par ID**
  - Endpoint : `GET /(Client/Chauffeur)/get/{id}`
  - Résultat pour l’id 1 de chauffeur : (insérer le résultat attendu)
  
- **Afficher tous les résultats**
  - Endpoint : `GET /(Client/Chauffeur)/getAll`
  - Résultat pour un getAll de client : (insérer le résultat attendu)
  
- **Supprimer un Chauffeur ou un Client**
  - Endpoint : `DELETE /(Chauffeur/Client)/delete/{id}`
  - Résultat pour : (insérer le résultat attendu)
  
- **Trier par type de chauffeur**
  - Endpoint : `GET /Chauffeur/countByType`
  - Résultat de la requête : (insérer le résultat attendu)
  
- **Ajouter une Course**
  - Endpoint : `POST /Course/add`
  - Body de la requête : (insérer le format du corps de la requête)
  
- **Obtenir les Statistiques de Course d'un Client**
  - Endpoint : `GET /courses/clientStats/{clientId}`
  - Réponse JSON : (insérer le format de la réponse JSON)

## 9. Déploiement
- **Environnement de Développement:** Utilisation d’un serveur AWS.

## 11. GitHub
- [Lien GitHub du Projet](https://github.com/Shazoren/AwsCdanSopraArchi)
