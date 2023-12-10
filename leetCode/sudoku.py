import collections

def valid(table: list[list[str]]) -> bool:
    rows = collections.defaultdict(set)
    columns = collections.defaultdict(set)
    squares = collections.defaultdict(set)
    
    for row in range(9):
      for col in range(9):
        if table[row][col] == '.':
          continue
        if table[row][col] in rows[row] or table[row][col] in columns[col] or table[row][col] in squares[row//3, col//3]:
          return False
        rows[row].add(table[row][col])
        columns[col].add(table[row][col])
        squares[row//3, col//3].add(table[row][col])
  
              
    
    
    return True
  
  

  
board1 = [
["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
# True

board2 = [
["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
# False

tries = []
tries.append(board1)
tries.append(board2)

for tri in tries:
  print(valid(tri))