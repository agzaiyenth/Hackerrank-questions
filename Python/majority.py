class MissingElementException(Exception):
    def __init__(self, a, b):
        self.a = a
        self.b = b
        
        
def areEqual(query, a ,b):
    if not a in query or not b in query[a]:
        raise MissingElementException(a, b)
    return query[a][b]

def algo(n, query):

    relevant_groups = []
    for i in xrange(0, n, 2):
        group = [i, i+1]
        relevant_groups.append(group)

    while relevant_groups:
        group_a = relevant_groups.pop(0)
        group_len = len(group_a)
        if areEqual(query, group_a[0], group_a[group_len//2]):
            while relevant_groups:
                group_b = relevant_groups.pop(0)
                group_len_b = len(group_b)
                if areEqual(query, group_b[0], group_b[group_len_b//2]):
                    if areEqual(query, group_a[0], group_b[0]):
                        group = group_a
                        group.extend(group_b)
                        relevant_groups.append(group)
                        break
                    else:
                        if group_len > group_len_b:
                            relevant_groups.append(group_a)
                            break
                        elif group_len < group_len_b:
                            relevant_groups.append(group_b)
                            break
                        else:
                            break
            if not relevant_groups:
                # this should be the answer
                return group_a[0]
    return query


def nextQuestion(n, plurality, lies, color, exact_lies, query):
    try:
        print (algo(n, query))
    except MissingElementException as e:
        print ("%ld % ld" % (e.a, e.b))
        
if __name__ == '__main__':
    vals = [int(i) for i in raw_input().strip().split()]
    query_size = input()
    query = {}
    for i in range(vals[0]):
        query[i] = {}

    for i in range(query_size):
        temp = [j for j in raw_input().strip().split()]
        if temp[2] == "YES":
            query[int(temp[0])][int(temp[1])] = 1
            query[int(temp[1])][int(temp[0])] = 1
        else:
            query[int(temp[0])][int(temp[1])] = 0
            query[int(temp[1])][int(temp[0])] = 0

    nextQuestion(vals[0], vals[1], vals[2], vals[3], vals[4], query)