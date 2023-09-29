import pytest
from leetCode.quickSort import Solution

class TestQuickSort:
    @pytest.mark.parametrize(
        "nums, expected",
        [
            ([3, 7, 11, 2, 9, 4, 12], [2, 3, 4, 7, 9, 11, 12]),  # Happy path
            ([], []),  # Empty list
            ([1], [1]),  # List with a single element
            ([1, 1, 1, 1], [1, 1, 1, 1]),  # List with all elements equal
            ([9, 8, 7, 6, 5, 4, 3, 2, 1], [1, 2, 3, 4, 5, 6, 7, 8, 9]),  # Reverse sorted list
            ([1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 2, 3, 4, 5, 6, 7, 8, 9]),  # Already sorted list
            ([5, 4, 3, 2, 1, 6, 7, 8, 9], [1, 2, 3, 4, 5, 6, 7, 8, 9]),  # Random order list
        ],
        ids=[
            "Happy path",
            "Empty list",
            "List with a single element",
            "List with all elements equal",
            "Reverse sorted list",
            "Already sorted list",
            "Random order list",
        ],
    )
    def test_quickSort(self, nums, expected):
        # Arrange
        solution = Solution()

        # Act
        solution.quickSort(nums)

        # Assert
        assert nums == expected
