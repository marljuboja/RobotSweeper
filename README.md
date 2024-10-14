
# Cleaning Robot Simulation

## Overview
This project simulates a robot that navigates a floor plan of a house, avoiding obstacles and checking its path before moving. The robot operates within a grid-based room map, where each cell can contain an obstacle. This project is implemented in Java and uses a modular approach with two main classes: `RoomMap` and `Robot`.

## Project Structure
The project includes the following primary files:

- **RoomMap.java**: This class is responsible for generating a random room layout with obstacles and providing methods to check for obstacles in the robot's path. It simulates a floor plan as a two-dimensional array, where certain cells are designated as obstacles.
- **Robot.java**: This class represents the robot's behavior. It interacts with the `RoomMap` to determine if the robot can move in a specified direction without hitting an obstacle. It includes logic to prevent movement into blocked paths.

## Features
### Random Room Map Generation
- The `RoomMap` class generates a grid where obstacles are randomly placed. Obstacles are represented by "1" in the grid, while open spaces are represented by "0".
- The percentage of obstacle-filled cells can be adjusted by modifying the code, allowing for flexibility in the room layout complexity.

### Obstacle Detection and Movement
- The `Robot` class includes a `checkAndMove` function that checks whether the intended path is clear before moving. If an obstacle is detected in the desired direction, the robot will remain in its current position and print a message.
- The robot starts in a random position on the grid that is free of obstacles. It can attempt to move up, down, left, or right.

## Usage
1. **Clone the Repository**
   ```bash
   git clone [repository link]
