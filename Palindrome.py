class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        x=str(x)
        a=x[::-1]
        if(x==a):
            return True
        else:
            return False