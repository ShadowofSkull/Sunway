# Ques 1:

# totalCookies = int(input("Enter total number of cookies: "))
# CookiesInBox = int(input("Enter total number of cookies in a box: "))
# BoxInContainers = int(input("Enter total number of boxes in a container: "))

# boxesToShip = totalCookies // CookiesInBox
# containersToShip = boxesToShip // BoxInContainers
# leftOverCookies = totalCookies % CookiesInBox
# leftOverBoxes = boxesToShip % BoxInContainers

# if leftOverBoxes != 0:
#     leftOverCookies += leftOverBoxes * CookiesInBox

# print(f"Number of boxes to ship the cookies: {boxesToShip}\nNumber of containers to ship the boxes: {containersToShip}")
# print(f"Left over cookies: {leftOverCookies}\nLeft over boxes: {leftOverBoxes}")


# Ques 2

# def add(num1, num2) -> int:
#     return num1 + num2
# def substract(num1, num2):
#     return num1 - num2
# def multiply(num1, num2):
#     return num1 * num2
# def divide(num1, num2):
#     if (num2 == 0):
#         print("Denominator can't be zero")
#         return
#     return num1 // num2

# def ifCalc(num1, num2, operator):
#     if      (operator == '+'):
#         result = add(num1, num2)
#     elif    (operator == '-'):
#         result = substract(num1, num2)
#     elif    (operator == '*'):
#         result = multiply(num1, num2)
#     elif    (operator == '/'):
#         result = divide(num1, num2)
#     else:
#         print("Invalid Operator")
#         return
#     if result != None:
#         print(f"{num1} {operator} {num2} = {result}")

# def matchCalc(num1, num2, operator):
#     match operator:
#         case "+":
#             result = add(num1, num2)
#         case "-":
#             result = substract(num1, num2)
#         case "*":
#             result = multiply(num1, num2)
#         case "/":
#             result = divide(num1, num2)
#         case _:
#             print("Invalid Operator")
#             return
# #At the divide function, when the denominator is zero it will exit the function by returning None so as long result is not None we will print the result
#     if result != None:
#         print(f"{num1} {operator} {num2} = {result}")

# while True:
#     num1 = int(input("Enter num1: "))
#     num2 = int(input("Enter num2: "))
#     operator = (input("Enter operator: "))
#     # ifCalc(num1, num2, operator)
#     matchCalc(num1, num2, operator)
#     repeatCalc = input("Would you like to continue using the calculator? Enter Y/N\n")
#     if (repeatCalc != 'N' and repeatCalc != 'Y'):
#         print("Invalid request")
#         break
#     if (repeatCalc == 'N'):
#         break


# Ques 3

# netPrice = int(input("Enter net price of each copy: "))
# copiesSold = int(input("Enter the estimated number of copies that will be sold: "))

# optionOne = 25000
# optionTwo = int(netPrice * 0.125 * copiesSold)

# if copiesSold >= 4000:
#     copiesOver4k = copiesSold % 4000
#     optionThree = int(netPrice * 0.1 * 4000 + netPrice * 0.14 * copiesOver4k)
# else:
#     optionThree = int(netPrice * 0.1 * copiesSold)

# maxRoyalty = max(optionOne, optionTwo, optionThree)
# if optionOne == maxRoyalty:
#     bestOption = "Option 1"
# elif optionTwo == maxRoyalty:
#     bestOption = "Option 2"
# else:
#     bestOption = "Option 3"

# print(f"Option 1: $25000\nOption 2: ${optionTwo}\nOption 3: ${optionThree}")
# print(f"Best option is {bestOption}")


# Ques 4

# roomCost = float(input("Enter cost of renting one room ($): "))
# roomsBooked = int(input("Enter amount of rooms booked: "))
# daysBooked = int(input("Enter the days of booking: "))
# salesTaxPercent = float(input("Enter the sales tax (%): "))

# roomDiscount = 0
# if daysBooked >= 3:
#     roomDiscount += 5

# if roomsBooked >= 30:
#     roomDiscount += 30
# elif roomsBooked >= 20:
#     roomDiscount += 20
# elif roomsBooked >= 10:
#     roomDiscount += 10

# if roomDiscount == 0:
#     roomDiscount = 1

# OGTotalCost = roomCost * roomsBooked
# totalCost = (OGTotalCost * (roomDiscount / 100))
# roomDiscount = ((((OGTotalCost - totalCost) / roomsBooked) / roomCost) * 100)
# totalBilling = totalCost + (totalCost * (salesTaxPercent / 100))

# print(f"\nRent of a room: ${roomCost}\nDiscount on each room: {roomDiscount}%\
#       \nRooms booked: {roomsBooked}\nDays the rooms are booked: {daysBooked}\n\
# Total cost of the rooms: ${totalCost}\nSales tax: {salesTaxPercent}%\n\
# Total billing amount: ${totalBilling}")
