class Solution(object):
    def threeConsecutiveOdds(self, arr):
        """
        :type arr: List[int]
        :rtype: bool
        """
        count=0
        for i in arr:
            if(i%2==1):
                count+=1
                if(count>=3):
                    return True
                continue
            if(count>0):
                count=0
        return False