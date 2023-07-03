str1 = "Hello Sana"
print(str1)

str1 = 19
print(str1)

str1 = True
print(str1)
# Lists and its examples
example_list = ["apple", "banana", "cherry"]
print(example_list)

example_list.append("watermelon")
print(example_list)

example_list.insert(2, "mango")
print(example_list)

example_list.remove('cherry')
print(example_list)

example_list[1] = 'black current'
print(example_list)

ex_list = example_list + ['Papaya', 'Orange', 'Fig', 'Grapes']
print(ex_list)

ex_list.pop(2)
print(example_list)

input_string = input('Enter elements of a list separated by space ')
print("\n")
user_list = input_string.split()
# print list
print('list: ', user_list)

# convert each item to int type
for i in range(len(user_list)):
    # convert each item to int type
    user_list[i] = int(user_list[i])

# Calculating the sum of list elements
print("Sum = ", sum(user_list))

