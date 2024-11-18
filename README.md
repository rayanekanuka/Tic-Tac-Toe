# Tic-Tac-Toe en Java

Bienvenue dans ce jeu de **Tic-Tac-Toe** en Java ! Un jeu classique où deux joueurs s'affrontent pour aligner trois symboles sur un plateau de 3x3. Ce projet a été conçu en utilisant les concepts de base de la programmation orientée objet, comme les classes, les objets et les méthodes.

## 🎮 Description

Ce jeu propose une interface console simple où deux joueurs peuvent jouer l'un contre l'autre en entrant leurs coups (lignes et colonnes). La partie se termine lorsqu'un joueur aligne trois pions, ou lorsque le plateau est rempli sans gagnant, indiquant un match nul.

## 🛠️ Fonctionnalités

- Jouez à **Tic-Tac-Toe** sur un plateau de 3x3.
- Vérification des conditions de victoire (lignes, colonnes, diagonales).
- Le jeu se termine si un joueur gagne ou si le plateau est plein.
- Messages d'invite clairs pour guider les joueurs dans leurs mouvements.

## 🚀 Installation

1. Clonez ce dépôt sur votre machine locale :
    ```bash
    git clone https://github.com/ton-utilisateur/tic-tac-toe-java.git
    ```

2. Ouvrez le projet dans votre IDE préféré (par exemple, IntelliJ IDEA, Eclipse, ou VSCode avec l'extension Java).

3. Compilez et exécutez le fichier `TicTacToe.java`.

## 🖥️ Utilisation

1. Lancez le programme en exécutant la classe `TicTacToe`.
   
2. Suivez les instructions dans la console pour jouer. Les joueurs entreront leurs coups sous la forme de deux entiers (ligne et colonne), séparés par un espace.

3. Le jeu continue jusqu'à ce qu'un joueur gagne ou que le plateau soit plein.

## 📜 Règles du jeu

- Deux joueurs s'affrontent : **Joueur X** et **Joueur O**.
- Les joueurs choisissent à tour de rôle une case vide sur le plateau pour y placer leur symbole.
- Le premier à aligner trois de ses symboles horizontalement, verticalement ou en diagonale gagne la partie.
- Si toutes les cases sont remplies sans alignement, la partie se termine par un match nul.

## 📁 Structure du projet

TicTacToe │ 
├── TicTacToe.java # Contient la logique du jeu et les règles 
├── Player.java # Classe pour gérer les joueurs 
├── Cell.java # Représente chaque cellule du plateau 
└── README.md # Documentation du projet

## 👾 Auteurs

- [Rayane Kanuka](https://github.com/rayanekanuka) - Créateur du projet
- [Collaborateurs éventuels] - Contributions

## 💬 Contribuer

Si vous souhaitez améliorer ce projet, n'hésitez pas à ouvrir une **pull request**. Toute contribution est la bienvenue !

1. Forkez ce projet.
2. Créez votre branche (`git checkout -b feature-nouvelle-fonctionnalite`).
3. Committez vos modifications (`git commit -am 'Ajout d'une nouvelle fonctionnalité'`).
4. Pushez vers la branche (`git push origin feature-nouvelle-fonctionnalite`).
5. Ouvrez une pull request.