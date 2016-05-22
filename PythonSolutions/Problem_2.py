import random

set_1 = set()
set_2 = set()
set_3 = set()

for i in xrange(0, 3):
    set_1.add(random.randrange(1, 1000))
    set_2.add(random.randrange(1, 1000))
    set_3.add(random.randrange(1, 1000))

print str(set_1) + "\n" + str(set_2) + "\n" + str(set_3)

merged = []
merged = set_1.union(set_2).union(set_3)    # remove duplicate values.
merged = sorted(merged, reverse=True)   # Sorting in desc order.

print merged

new_merged = ["grapefruit" if not x % 2 and not x % 5
              else "five" if not x % 5 else "two" if not x % 2
              else x for x in merged]

print new_merged

output = [2 if x == "grapefruit" else "grapefruit" if x == "two" else x for x in new_merged]

print output
