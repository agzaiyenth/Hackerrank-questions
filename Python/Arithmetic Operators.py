"""
Task
The provided code stub reads two integers from STDIN, a and b.
Add code to print three lines where:

    The first line contains the sum of the two numbers.
    The second line contains the difference of the two numbers (first - second).
    The third line contains the product of the two numbers.
 """

if __name__ == '__main__':
    a = int(input())
    b = int(input())
    if((a>=1 and a<=(10**10)) and ((b>=1 and b<=(10**10)))): 
        print(a+b)
        print(a-b)
        print(a*b)
