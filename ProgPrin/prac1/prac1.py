# Question 1

userInput1 = float(input("Enter score 1: "))
userInput2 = float(input("Enter score 2: "))
userInput3 = float(input("Enter score 3: "))
userInput4 = float(input("Enter score 4: "))
userInput5 = float(input("Enter score 5: "))

score_total = userInput1 + userInput2 + userInput3 + userInput4 + userInput5
average_score = score_total/5

print(f"Average score: {average_score}")

# Question 2

myr_amount = float(input("Enter MYR value: MYR "))
sgd_amount = myr_amount / 3.04
sgd_rounded = round(sgd_amount, 2)

print(f"The amount in SGD is : SGD {sgd_rounded}")

# Question 3

rate = 3 * 10 ** 8
seconds = 365 * 24 * 60 ** 2
distance = rate * seconds

print(f"Light travels {distance} meters in a year.")

# Question 4

length = float(input("Enter the length of the rectangle: "))
height = float(input("Enter the height of the rectangle: "))
area = length * height
perimeter = (2 * length) + (2 * height)

print(f"The area of the rectangle is: {area}")
print(f"The perimeter of the rectangle is: {perimeter}")

# Question 5

mass = float(input("Enter the object's mass (kg): ")) 
velocity = float(input("Enter the object's velocity (m/s): ")) 

momentum = mass * velocity
kineticEnergy = (mass * velocity ** 2) / 2

print(f"The object's momentum is {momentum}")
print(f"The object's kinetic energy is {kineticEnergy}")

# Question 6

pi_value = 3.142

radius = float(input("Enter the sphere's radius: "))  

diameter = 2 * radius
circumference = diameter * pi_value
surfaceArea = 4 * pi_value * radius * radius
volume = 4/3.0 * pi_value * radius * radius * radius

print(f"Diameter     : {diameter}")
print(f"Circumference: {circumference}")
print(f"Surface area : {surfaceArea}")
print(f"Volume       : {volume}")

# Question 7

bill = float(input('Enter total of the bill in RM: '))
friends = int(input('Enter number of friends: '))

service_charge = bill * 1.10
total = service_charge * 1.06

payment = total / friends
print(f"Amount needed to be paid per person is RM {round (payment, 2)}")

# Question 8

wage = float(input("Enter the employee's hourly wage: RM"))  
totalregularHours = float(input("Enter the total regular hours: "))  
overtimeHours = float(input("Enter the overtime hours: "))  

weeklyPay = wage * totalregularHours
overtimePay = overtimeHours * wage * 1.5
totalPay = weeklyPay + overtimePay

print(f"The total weekly pay is RM {round(totalPay, 2)}")
