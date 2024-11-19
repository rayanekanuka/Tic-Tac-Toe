# Tic-Tac-Toe en Java

Bienvenue dans ce jeu de **Tic-Tac-Toe** en Java ! Un jeu classique où deux joueurs s'affrontent pour aligner trois symboles sur un plateau de 3x3. Ce projet a été conçu en utilisant les concepts de base de la programmation orientée objet, comme les classes, les objets et les méthodes.

## 🎮 Description

Ce jeu propose une interface console simple où deux joueurs peuvent jouer l'un contre l'autre en entrant leurs coups (lignes et colonnes). La partie se termine lorsqu'un joueur aligne trois pions, ou lorsque le plateau est rempli sans gagnant, indiquant un match nul.

## 🛠️ Fonctionnalités

- Jouez à **Tic-Tac-Toe** sur un plateau de 3x3.
- Modes de jeu disponibles :
  - Humain vs Bot
  - Bot vs Bot
  - Humain vs Humain
- Vérification des conditions de victoire (lignes, colonnes, diagonales).
- Le jeu se termine si un joueur gagne ou si le plateau est plein.
- Messages d'invite clairs pour guider les joueurs dans leurs mouvements.
- Affichage des messages de fin de partie avec des émoticônes en ASCII.

## 🚀 Installation

1. Clonez ce dépôt sur votre machine locale :
    ```bash
    git clone https://github.com/ton-utilisateur/tic-tac-toe-java.git
    ```

2. Ouvrez le projet dans votre IDE préféré (par exemple, IntelliJ IDEA, Eclipse, ou VSCode avec l'extension Java).

3. Compilez et exécutez le fichier `Main.java`.

## 📋 Utilisation

1. Lancez le programme en exécutant la classe `Main`.
2. Suivez les instructions à l'écran pour choisir le mode de jeu :
   - 1 : Humain vs Bot
   - 2 : Bot vs Bot
   - 3 : Humain vs Humain
3. Entrez les coups en spécifiant les coordonnées (ligne et colonne) lorsque c'est votre tour.
4. Le jeu affichera le plateau après chaque coup et indiquera le gagnant ou si la partie est nulle.

## 📂 Structure du projet

- `model/` : Contient les classes représentant la logique du jeu (TicTacToe, Player, HumanPlayer, ArtificialPlayer, Cell).
- `view/` : Contient les classes responsables de l'affichage du jeu (GameView, Menu).
- `Main.java` : Point d'entrée du programme.

## ❤️ Remerciements

Merci d'avoir joué à ce jeu de Tic-Tac-Toe en Java ! Amusez-vous bien ! 😊