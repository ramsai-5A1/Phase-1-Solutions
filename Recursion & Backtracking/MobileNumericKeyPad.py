#User function Template for python3
class Solution:
    def getCount(self, n):
        matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9], [-1, 0, -1]]
        directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
       # cache = []
       # for i in range(n):
       #     curr = []
       #     for row in range(len(matrix)):
       #         t = []
       #         for col in range(len(matrix[0])):
       #             t.append(-1)
       #         curr.append(t)
       #     cache.append(curr)
       #cache = [[[[-1] for col in range(len(matrix[0]))] for row in range(len(matrix))] for i in range(n)]
        rows, cols = len(matrix), len(matrix[0])
        cache = [[[-1] * cols for j in range(rows)] for i in range(n + 1)]
        #print(cache)
        
        def helper(n, row, col):
            if n == 0:
                return 1
            elif cache[n][row][col] != -1:
                return cache[n][row][col]
                
            result = helper(n - 1, row, col)
            for direction in directions:
                newRow = direction[0] + row 
                newCol = direction[1] + col 
                if newRow >= 0 and newCol >= 0 and newRow < len(matrix) and newCol < 3 and matrix[newRow][newCol] != -1:
                    result += helper(n - 1, newRow, newCol)
            cache[n][row][col] = result
            return result 
                
           
        currResult = 0 
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] != -1:
                    currResult += helper(n - 1, row, col)
        
        return currResult
        
        
        
        
