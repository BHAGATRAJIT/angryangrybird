# Angry Birds Game - Java LibGDX Implementation

This project is a simplified version of the classic Angry Birds game, developed in Java using the libGDX framework. It features various bird types, blocks, and pigs, each with unique characteristics, to provide engaging and strategic gameplay.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Gameplay Instructions](#gameplay-instructions)
- [Code Structure](#code-structure)
  - [Bird Classes](#bird-classes)
  - [Block Classes](#block-classes)
  - [Pig Classes](#pig-classes)
  - [Slingshot Mechanism](#slingshot-mechanism)
  - [Level Classes](#level-classes)
  - [Game Screens](#game-screens)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction

Welcome to the Angry Birds Game built with Java and libGDX! This project aims to recreate the fun and challenge of the original game by allowing players to launch various birds at pigs strategically placed within structures made of different materials. The physics-based gameplay ensures a realistic and enjoyable experience.

## Features

### Multiple Bird Types:
- **Red Bird**: A balanced bird with no special abilities.
- **Yellow Bird**: Can accelerate mid-flight for increased speed and impact.
- **Blue Bird**: Can split into three smaller birds mid-flight, increasing the chances of hitting multiple targets.

### Variety of Blocks:
- **Glass Blocks**: Fragile and easily destroyed.
- **Wood Blocks**: Moderate durability, requiring more force to break.
- **Stone Blocks**: Highly durable, requiring precise hits.

### Pigs:
- Different sizes and health levels.
- Strategically positioned to increase difficulty.

### Levels:
- Multiple levels with increasing difficulty.
- Each level offers unique configurations of birds, pigs, and blocks.
- Ability to save and load levels.

### Game Screens:
- **Home Screen**: Start a new game, load a game, or exit.
- **Level Selection Screen**: Choose from unlocked levels.
- **Win/Lose Screens**: Display results after level completion or failure.
- **Pause Screen**: Pause the game with options to resume, restart, or exit.

### Physics-Based Gameplay:
- Realistic launching, movement, and collision using libGDX's physics engine.

### User Interface:
- Interactive slingshot mechanism.
- On-screen buttons and dialogs for navigation and game control.

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- libGDX Framework
- Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse

### Setup Instructions

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/your-repo/angry-birds.git
    ```

2. **Import the Project**:
  - Open your IDE.
  - Import the project as a Gradle or Maven project.

3. **Install Dependencies**:
  - Ensure all libGDX libraries are correctly configured in your project.
  - Install any additional dependencies specified in `build.gradle` or `pom.xml`.

4. **Build the Project**:
  - **For Gradle**: Run the build command.
  - **For Maven**: Run the Maven build command.

## Usage

### Running the Game
- **From the IDE**: Run the `Core` class's `main` method.
- **From the Command Line**: Use the appropriate command for your build system (Gradle/Maven).

## Gameplay Instructions

## Selecting and Launching Birds

### Select a Bird:
- Click on the desired bird from the available pool to select it for launch.

### Adjust Launch Parameters:
- **Angle Slider**: Use the angle slider to set the desired launch angle.
- **Power Slider**: Use the power slider to adjust the launch strength.

### Launch the Bird:
- Press the **Launch** button to fire the selected bird with the specified angle and power.


### Special Abilities:
- **Yellow Bird**: Press the Space key during flight to activate the speed boost.
- **Blue Bird**: Press the Space key during flight to split into three birds.
- **Red Bird**: Press the Space key during flight to temporarily increase its size, making it more impactful upon collision.


### Objective:
- Destroy all pigs in the level using the available birds.

### Pause Game:
- Press the "Pause" button or the P key to pause the game.

## Code Structure

## Bird Classes
All bird types extend the base `Bird` class, which handles common properties like position, texture, and physics body.

- **Bird.java**: Base class for all birds. Manages physics body, state, and movement.
- **RedBird.java**:  Overrides the `activateAbility()` method is triggered, it temporarily increases the bird's size, enhancing its impact during collisions.
- **YellowBird.java**: Overrides the `activateAbility()` method to implement speed boost.
- **BlueBird.java**: Overrides the `activateAbility()` method to implement splitting into multiple birds.

### Block Classes
Blocks inherit from the base `Block` class, defining the structure's appearance and physical properties.

- **Block.java**: Base class for blocks. Manages texture, position, and physics body.
- **GlassBlock.java**, **WoodBlock.java**, **StoneBlock.java**: Represent blocks of different materials with varying durability.

### Pig Classes
Pigs are represented by the `Pig` class, implementing the necessary properties and methods for gameplay.

- **Pig.java**: Handles health, position, and reactions to collisions.

### Slingshot Mechanism
The `Slingshot` class manages the launching of birds.

- **Slingshot.java**: Draws the slingshot on the screen. Handles input for adjusting angle and power. Launches birds with calculated force.

### Level Classes
Levels are implemented as separate classes, inheriting from the `Level` base class.

- **Level.java**: Abstract base class containing common level functionality.
- **Level1.java**, **Level2.java**, **Level3.java**: Define specific configurations of birds, pigs, and blocks. Implement unique challenges for the player.

### Game Screens
Different screens manage various game states and navigation.

- **HomeScreen.java**: The starting screen of the game. Options to start a new game, load a game, or exit.
- **LevelSelectionScreen.java**: Allows players to select from available levels. Unlocked levels are accessible based on progression.
- **WinScreen.java**: Displayed upon successful completion of a level. Provides options to proceed to the next level, retry, or return to level selection.
- **LoseScreen.java**: Displayed when the player fails a level. Provides options to retry or return to level selection.
- **PauseScreen.java**: Activated during gameplay to pause the game. Options to resume, restart the level, or exit to the main menu.

## Testing

The project includes unit tests to ensure code reliability and functionality.

### JUnit Tests:
- Located in the `test` directory.
- Test classes for `Level`, `Bird`, `Block`, and other components.

### Running Tests

- **From the Command Line**: Run the tests with your build system (Gradle/Maven).
- **From IDE**: Right-click the test directory and select "Run All Tests".


