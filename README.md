# Cleaning Robot Simulation

## Overview
This project simulates a robot navigating a house floor plan, avoiding obstacles and checking its path before moving. The robot operates within a grid-based room map, where each cell can contain an obstacle. The project is implemented in Java and uses a modular approach with three main classes: `RoomMap`, `Robot`, and `Main`.

## Project Structure
The project includes the following primary files:

- **RoomMap.java**: Manages the grid layout of the room, including obstacle placement. It generates a random room map and includes methods for obstacle checking.
- **Robot.java**: Represents the robot and its behavior. The robot interacts with the `RoomMap` to check for obstacles in its path and attempts to move in specified directions while avoiding them.
- **Main.java**: The main entry point for the program. This class initializes the room map, places the robot, and runs sample movement commands to demonstrate the robot’s functionality.

## Features
### Random Room Map Generation
- The `RoomMap` class generates a grid with random obstacles. Obstacles are represented by "1" in the grid, while open spaces are represented by "0".
- By default, the grid has a 30% probability of obstacles, but this can be adjusted to change the complexity of the room layout.

### Obstacle Detection and Movement
- The `Robot` class includes a `checkAndMove` function that ensures the robot only moves if the intended path is clear. If an obstacle is detected in the chosen direction, the robot will stay in its current position and print a message indicating the blocked path.
- The robot starts in a random, obstacle-free position on the grid and can attempt to move up, down, left, or right.

### Main Functionality
- The **Main.java** file ties everything together by initializing the `RoomMap` and `Robot`, printing the room layout, and running a sequence of sample moves to demonstrate the robot’s obstacle detection and movement capabilities.
- The `Main` class provides a quick and easy way to visualize how the robot interacts with the room map and how it handles obstacles in its path.

## Usage
1. **Clone the Repository**
   ```bash
   git clone
