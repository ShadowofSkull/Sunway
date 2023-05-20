# Ques 1

# newVid = int(input("Enter total amount of new videos: "))
# oldVid = int(input("Enter total amount of old videos: "))
# nights = int(input("Enter total amount of nights: "))

# newVidCharges = newVid * 3
# oldVidCharges = oldVid * 2

# print(f"Total cost: {(newVidCharges + oldVidCharges) * nights}")

# Ques 2

# elapseTime = int(input("Enter elapse time for event(s): "))
# hours = str(elapseTime // 60**2)
# mins = str((elapseTime % 60**2) // 60)
# seconds = str((elapseTime % 60**2) % 60)

# print(hours + " : " + mins + " : " + seconds)


#Ques 3

# yearlyIncome = float(input("Enter yearly income: "))
# if yearlyIncome > 50001:
#     taxRate = 0.25
# elif yearlyIncome >= 10001:
#     taxRate = 0.15
# elif yearlyIncome >= 2501:
#     taxRate = 0.05
# else:
#     taxRate = 0

# taxPay = str(yearlyIncome * taxRate)
# print("Tax to pay = RM " + taxPay)

#Question 4
# monthlyDataUsage = int(input("enter monthly data usage: "))
# if monthlyDataUsage > 10:
#     charges = ((monthlyDataUsage - 10) * 30) + 10 * 15
# else:
#     charges = monthlyDataUsage * 15

# print(charges)

#5

# choice = input("Enter R/r for rectangle or C/c for circle: ")
# area = 0
# pi = 3.14159
# if choice is "R" or choice is "r":
#     length = int(input("Enter length of rectangle: "))
#     width = int(input("Enter width of rectangle: "))
#     area = length * width
# elif (choice is "C" or choice is "c"):
#     radius = int(input("Enter radius of circle: "))
#     area = pi * radius**2
# print(area)


#6
# dayNum = input("Enter num of day: ")
# day = ""
# match dayNum:
#     case "1":
#         day = "Monday"
#     case "2":
#         day = "Tuesday"
#     case "3":
#         day = "Wednesday"
#     case "4":
#         day = "Thursday"
#     case "5":
#         day = "Friday"
#     case "6":
#         day = "Saturday"
#     case "7":
#         day = "Sunday"
# drinkOfDay = [["Monday", "Peppermint Mocha"], ["Tuesday", "Candy Bar Latte"], 
#               ["Wednesday", "Caramel Coffee"], ["Thursday", "Choc almond cafe"], 
#               ["Friday", "Pumpkin"], ["Saturday", "vanilla"],
#                 ["Sunday", "ginger"]]

# for days in drinkOfDay:
#     if drinkOfDay[days][0] == day:
#         drink = drinkOfDay[days][1]
#         break
# print(drink)


