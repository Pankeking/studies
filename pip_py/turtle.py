from turtle import *

# Set up the turtle screen
window = turtle.Screen()
window.bgcolor("black")

# Create a turtle object
my_turtle = turtle.Turtle()
my_turtle.shape("turtle")
my_turtle.color("blue")

# Function to draw a colorful spiral
def colorful_spiral():
    colors = ["red", "orange", "yellow", "green", "blue", "purple"]
    for _ in range(36):
        my_turtle.color(colors[_ % 6])
        my_turtle.forward(100)
        my_turtle.right(170)
    my_turtle.hideturtle()

# Call the function to draw the spiral
colorful_spiral()

# Close the turtle graphics window when clicked
window.exitonclick()
