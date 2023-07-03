fruit_shop = {
    "apple": 10,
    "banana": 25,
    "orange": 8,
    "peaches": 35
}

key_to_check = input("What are you looking for? ").lower()

if key_to_check in fruit_shop:
    print("Yes, this is available")
else:
    print("No, this is not available")