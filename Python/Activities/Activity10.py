# Given tuple
num_tuple = (40, 50, 66, 42, 35)
print("Given list is ", num_tuple)

# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in num_tuple:
    if num % 5 == 0:
        print(num)