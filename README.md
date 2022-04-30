# Maze Game

<!---Esses são exemplos. Veja https://shields.io para outras pessoas ou para personalizar este conjunto de escudos. Você pode querer incluir dependências, status do projeto e informações de licença aqui--->

![GitHub repo size](https://img.shields.io/github/repo-size/LucasCester/maze-game?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/LucasCester/maze-game?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/LucasCester/maze-game?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/LucasCester/maze-game?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/LucasCester/maze-game?style=for-the-badge)

<img src="https://st.depositphotos.com/2875617/3497/v/600/depositphotos_34971427-stock-illustration-simple-maze.jpg" alt="exemplo imagem">

> This is a school project, it's a simple maze game. You can select one of the six maps or create a new one to play, after 
> selecting the map the algorithm will go through the whole map until it finds the exit.

## ☕ Running the Maze Game

After cloning the project, to start the game you will run the **Index** file, type your name and select the map.

```
What would your name be, adventurer ?
> Lucas

Enter the name of the .txt file to load the map:
> mapa0.txt
```

## 📐 Creating a Map

To create a map follow the instructions bellow.

- Create a .txt file.
- The first line will be the number of rows.
- The second line will be the number of columns.



- "#" = wall.
- " " = path to walk.
- "E" = The begining of the maze.
- "S" = The exit of the maze.

Exemple:

```
5
9
#########
E       #
### #####
### #####
###S#####
```
