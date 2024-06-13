class Solution:
    def twoSum(self, nums, target):
        a=0
        for i in range(len(nums)):
            p = target-nums[i]
            if p in nums:
                a=nums.index(p)
                if a==i:
                    continue
                break
        return i,a