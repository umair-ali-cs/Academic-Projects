# 2D-VisualMath

A **2D graph plotting calculator** built in Java Swing that allows users to visualize mathematical functions on a Cartesian plane. This project leverages the **exp4j** library for parsing and evaluating mathematical expressions, making it easy to plot complex equations interactively.

## Features

- Plot multiple equations simultaneously (up to 10 at a time)
- Show/Hide and Delete equations dynamically
- Supports standard mathematical notation, including trigonometric shortcuts (cotx, cscx, secx)
- Zoom in/out for detailed examination
- Color-coded graphs for clear differentiation
- Handles vertical asymptotes and discontinuities
- User-friendly interface with front and graphing screens
- Graceful handling of invalid inputs and exceptions

## Project Structure

```
2D-VisualMath/
│
├── lib/
│   └── exp4j-0.4.8.jar        # Library for expression evaluation
│
├── src/
│   ├── assets/
│   ├── Main.java
│   ├── Frame.java
│   ├── GraphPanel.java
│   │   Button.java
│   │   Input.java
│   │   Label.java
│   │   Box.java
│   └── Img.java
│
└── README.md
```

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/2D-VisualMath.git
   ```
2. Add the **exp4j** library to your project classpath. If using command line:
   ```bash
   javac -cp "lib/exp4j-0.4.8.jar" -d bin src/**/*.java
   ```
3. Run the application:
   ```bash
   java -cp "bin:lib/exp4j-0.4.8.jar" Main
   ```

> Note: On Windows, replace `:` with `;` in the classpath.

## Usage

1. Launch the application.
2. Front interface displays the project logo and a **Start** button.
3. Click **Start** to open the graphing interface.
4. Enter equations in the input pane.
5. Use **Show/Hide**, **Delete**, and **Zoom In/Out** buttons to interact with the graph.
6. Each equation is plotted in a unique color automatically.

## Methodology

- **Requirement Analysis:** Identify essential features such as adding/deleting/toggling equations, zooming, and grid display.
- **Design:** Modular approach with separate classes for UI components, graph panel, and equation management.
- **Implementation:** Integrated modules with action listeners, color themes, and exception handling.
- **Testing:** Verified usability, mathematical accuracy, and edge case handling.

## Contributors
- Umair Ali 
