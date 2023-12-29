import colorama
class Point:
    def __init__(self, x, y) -> None:
        self.x = x
        self.y = y


directions = [
  [0,-1],
  [1, 0],
  [0, 1],
  [-1,0]
]

def walk(maze: list[list[str]], wall: str, current: Point, end: Point, seen: list[list[bool]], path: list[Point]) -> bool:
    
    if current.x < 0:
        return False

    if current.x >= len(maze[0]):
        return False
      
    if current.y < 0 or current.y >= len(maze):
        return False
    
    if maze[current.y][current.x] == wall:
        return False
    
    if current.x == end.x and current.y == end.y:
        path.append(current)
        return True
    
    if seen[current.x][current.y]:
        return False
      
    seen[current.x][current.y] = True
    
    path.append(current)
    for x, y in directions:
        point = Point(current.x + x, current.y + y)
        if walk(maze, wall, 
             point, 
             end, seen, path):
          return True
    
    path.pop()
    return False
      



def solve(maze: list[str], wall: str, start: Point, end: Point) -> list[Point]:
    path = [start]
    seen = [[False] * len(maze) for _ in range(len(maze[0]))]
    walk(maze, wall, start, end, seen, path)
    return path
  
maze = [
        "oooooooooo o",
        "o        o o",
        "o        o o",
        "o oooooooo o",
        "o          o",
        "o oooooooooo",
    ];

maze_2 = [
    "ooooooooooooooo",
    "o             o",
    "o ooo oooo oooo",
    "o   o     o   ",
    "o ooo oooo o   ",
    "o   o     o   ",
    "o ooo oooo oooo",
    "o             o",
    "ooooooooooooo o",
    "              o",
    "ooooooooooooo o",
    "ooooooooooooo o",
    "              o",
    "ooooooooooooo o",
    "              o",
    "ooooooooooooo o",
    "ooooooooooooo o",
    "              o",
    "o ooooooooooooo",
    "o              ",
    "oooooooooooooo ",
    "oooooooooooooo ",
    "oooooooooooooo ",
]
    
mazeResult = [
        Point(10, 0),
        Point(10, 1),
        Point(10, 2),
        Point(10, 3),
        Point(10, 4),
        Point(9, 4),
        Point(8, 4),
        Point(7, 4),
        Point(6, 4),
        Point(5, 4),
        Point(4, 4),
        Point(3, 4),
        Point(2, 4),
        Point(1, 4),
        Point(1, 5),
    ];

def draw_path(maze, path):
    modified_maze = [[" "] * len(maze[0]) for _ in range(len(maze))]  # Create a copy of the maze
    
    for rows in range(len(maze)):
        for cols in range(len(maze[rows])):
            modified_maze[rows][cols] = maze[rows][cols]
            
    for p in path:
        if modified_maze[p.y][p.x] != 'o':
            modified_maze[p.y][p.x] = '*'

    return modified_maze
  
result = solve(maze, "o", Point(10,0), Point(1, 5))
drawn_result = draw_path(maze, result)
drawn_check = draw_path(maze, mazeResult)

for row in drawn_result:
    print(row)
print("\n")    
for row in drawn_check:
    print(row)
    
print("\n")    
result_2 = solve(maze_2, "o", Point(2,1), Point(14,22))
drawn_2 = draw_path(maze_2, result_2)

print("\n")
colorama.init()
messages = []
for row in drawn_2:
    message = []
    for col in row:
        if col == '*':
            message.append(colorama.Back.RED + col + colorama.Back.RESET)
        elif col == 'o':
            message.append(colorama.Fore.CYAN + col + colorama.Fore.RESET)
        else:
            message.append(col)
    messages.append(message)
    


for i in range(len(messages)):
    for j in range(len(message)):
        if j == len(message) - 1:
            print(messages[i][j], end="\n")
        else:  
            print(messages[i][j], end="")
        






    