from datetime import date
import os
import random


# Creating empty lists to store data from the text files
menu_items = []
reservations = []

# Storing today's date
today = date.today()


# Reading the menu items in the file and adding them to the list
def read_menu_items():
    try:
        with open("menuItems_23032998.txt", "r") as file:
            for line in file:
                menu_items.append(line.strip())
    except FileNotFoundError:
        print("Menu items file not found.")
        return False
    return True


# Reading the reservations in the file and adding them to the list
def read_reservations():
    try:
        with open("reservation_23032998.txt", "r") as file:
            for line in file:
                reservation_data = line.strip().split("|")
                reservations.append(reservation_data)
    except FileNotFoundError:
        print("Reservations file not found.")
        return False
    return True


# To check if the date of reservation is at least five days in advance
def date_is_advance(date):
    date_difference = date - today
    MIN_DIFFERENCE = 5
    if date_difference.days >= MIN_DIFFERENCE:
        return True
    return False


# Check if session is not full on a certain date
def session_is_available(slot, date):
    MAX_SLOT = 8
    total_slot = 0

    for reservation in reservations:
        if reservation[0] == date and reservation[1] == slot:
            total_slot += 1
    if total_slot < MAX_SLOT:
        return True
    return False


# Add reservations
def add_reservation():
    while True:
        os.system("cls") # Clear console
        print("===Add Reservation(s)===")
        print("Enter your reservation details: ")
        name = input("Enter your name for the reservation: ").strip().upper()

        while True:
            os.system("cls")
            try:
                year = int(input("Enter year of reservation: "))
                month = int(input("Enter month of reservation: "))
                day = int(input("Enter day of reservation: "))

            except ValueError:
                print("Make sure you enter the date correctly.")
                continue

            # change the date from specific int to a whole date object
            try:
                reserved_date = date(year, month, day)
            except ValueError:
                print("Invalid Date.")
                continue

            # Check if the reservations date is 5 days in advance
            if not date_is_advance(reserved_date):
                print("Reservation has to be made at least 5 days in advance")
                continue
            break
        reserved_date = reserved_date.isoformat()
        print(
            "1: 12:00 pm – 02:00 pm\n2: 02:00 pm – 04:00 pm\n3: 06:00 pm – 08:00 pm\n4: 08:00 pm – 10:00 pm"
        )
        # Check if the slot is valid
        while True:
            try:
                session = int(input("Enter your desired slot number (1/2/3/4): "))
            except ValueError:
                print("Enter numbers only")
            else:
                if session < 1 or session > 4:
                    print("Invalid Session. Only 1/2/3/4.")
                    continue

                session = f"Slot {session}"
                if not session_is_available(session, reserved_date):
                    print(f"{session} session is full on {reserved_date}")
                    continue

                break

        # Check if the email format is entered correctly
        while True:
            email = input("Enter your email for the reservation: ")

            if (
                "@" not in email or "." not in email.split("@")[1]
            ):  # if @ and . is missing, it means the email is in wrong format.
                print("Wrong email format. Please enter again")

            else:
                print("Email saved!")
                break

        while True:
            phone_num = input("Enter your phone number for the reservation: ")

            if (
                not phone_num.isdigit()
            ):  # Check if the phone number contains only digits (no decimals or alphabets)
                print("Invalid Phone Number. Please enter numbers only.")

            elif len(phone_num) != 10:
                print("Invalid Phone Number. Phone Number should be 10 digits long.")

            else:
                print("Phone number saved!")
                break

        # Check if pax exceeds the limit
        while True:
            try:
                pax_size = int(input("Enter the number of pax (Max 4): "))
            except ValueError:
                print("Enter numbers only")
            else:
                if pax_size < 1 or pax_size > 4:
                    print("The number of pax can only be from 1 to 4.")
                else:
                    break

        # If everything clear then reservation can be added to the list
        reservation = [
            reserved_date,
            session,
            name,
            email,
            str(phone_num),
            str(pax_size),
        ]
        reservations.append(reservation)

        print("Reservation has been added")
        more_reservations = ""
        # Only stop asking for input when user correctly typed Y/N
        while more_reservations != "Y" and more_reservations != "N":
            more_reservations = input(
                "Would you like to add more reservations? Y/N: "
            ).upper()

        # If user don't want to add more_reservations, exit the function
        if more_reservations == "N":
            os.system("cls")
            break

    print("Thank you for adding reservations. Your reservations has been saved.")


# Cancels the specific reservation made by the user
def cancel_reservation():
    run = True
    while run:
        os.system("cls") # Clear console
        while True:  # Loops the code if the user enters invalid date formats
            # user is prompted to enter the details of their reservation
            try:
                year = int(input("Enter the year of your reservation (e.g. 2004): "))
                month = int(input("Enter the month of your reservation (e.g. 6): "))
                day = int(input("Enter the day of your reservation (e.g. 2): "))

                reserved_date = date(year, month, day)
                # combines the year, the month and the day into a date format in the variable reserved_date

            # Displays error to user if user has entered a number bigger than 12 in the month and a number bigger than 31 in the day
            except ValueError:
                print("Invalid Date Format")

            else:
                break

        # user is prompted to enter the slot number of the reservation.
        while True:
            try:
                session = int(input("Enter your slot number (1/2/3/4): "))
            except ValueError:
                print("Error. Enter numbers only")
            else:
                if not (0 < session < 5):
                    print("Invalid Session. Only enter 1/2/3/4.")
                else:
                    break

        # User is prompted to enter the name of their reservation
        while True:
            name = input("Enter the name used for the reservation: ").upper()
            if name == "":
                print("You cannot leave the name blank")
            else:
                break

        # Check if the email format is entered correctly
        while True:
            email = input("Enter the email of your reservation: ")
            if (
                "@" not in email or "." not in email.split("@")[1]
            ):  # if @ and . is missing, it means the email is in wrong format.
                print("Wrong email format. Please enter again")
            else:
                break

        while True: # Check if the phone number contains only digits (no decimals or alphabets)
            phone_num = input("Enter the phone number of your reservation: ")
            if not phone_num.isdigit():
                print("Invalid Phone Number. Please enter numbers only.")

            elif len(phone_num) != 10:
                print("Invalid Phone Number. Phone Number should be 10 digits long.")
            else:
                break

        found_reservation = False

        # Check for all three details in all the reservations in the list to find a match
        for reservation in reservations:
            if (
                reservation[0] == str(reserved_date)
                and reservation[1] == f"Slot {session}"
                and reservation[2].upper() == name
                and reservation[3] == email
                and reservation[4] == phone_num
            ):
                # When a match has been found, the reservation is deleted
                found_reservation = True
                details = "|".join(reservation)
                print()
                print(f"Reservation found! {details} has been deleted")
                print()
                reservations.remove(reservation)
                break  # Break out of the loop once the reservation is deleted

        # If the reservation isn't found, it will inform the user with a message
        if not found_reservation:
            print()
            print("Reservation not found.")
            print()

        # Asks the user if they want to continue the operation
        more_update = ""

        # Only stop asking for input when user correctly typed Y/N
        while more_update != "N" and more_update != "Y":
            more_update = input(
                "Would you like to cancel anymore reservations? Type 'N' to quit or 'Y' to continue: "
            ).upper()

        # If user don't want to update, exit the function
        if more_update == "N":
            print()
            break

# Update function
def update_reservation():
    while True:
        os.system("cls") # Clear console
        print("Enter the information of the previous reservation")
        while True:
            # Check if the user inputted integers only
            while True:
                try:
                    year = int(input("Enter year of reservation: "))
                except ValueError:
                    print("Enter numbers only")
                else:
                    break

            while True:
                try:
                    month = int(input("Enter month of reservation: "))
                except ValueError:
                    print("Enter numbers only")
                else:
                    break

            while True:
                try:
                    day = int(input("Enter day of reservation: "))
                except ValueError:
                    print("Enter numbers only")
                else:
                    break

            # Check if date exists
            try:
                reserved_date = date(year, month, day)
            except ValueError:
                print("Invalid date")
            else:
                break

        print(
            "1: 12:00 pm – 02:00 pm\n2: 02:00 pm – 04:00 pm\n3: 06:00 pm – 08:00 pm\n4: 08:00 pm – 10:00 pm"
        )
        while True:
            # Check if user inputted integers only
            try:
                session = int(input("Enter the slot number of the session (1/2/3/4): "))
            except ValueError:
                print("Enter numbers only")
            else:
                # Check if session exists
                if session >= 1 and session <= 4:
                    break
                print("Invalid Session")

        session = f"Slot {session}"
        reserved_date = date.isoformat(reserved_date)

        # Name inputed will be convert to uppercase and remove space around
        name = input("Enter name used for reservation: ").strip().upper()

        # Used to determine whether reservation is found in reservations list
        found_reservation = False

        # Access each reservation stored in the reservations list
        for reservation in reservations:
            # Check for all three details in the reservation
            if (
                reservation[0] == reserved_date
                and reservation[1] == session
                and reservation[2] == name
            ):
                # Clear console
                os.system("cls")
                # Update the variable to show reservation is found
                found_reservation = True
                print("Reservation found! Enter the new information for reservation")
                while True:
                    while True:
                        # Check if user inputted integers only
                        try:
                            new_year = int(input("Enter new year of reservation: "))
                        except ValueError:
                            print("Enter numbers only")
                        else:
                            break

                    while True:
                        try:
                            new_month = int(input("Enter new month of reservation: "))
                        except ValueError:
                            print("Enter numbers only")
                        else:
                            break

                    while True:
                        try:
                            new_day = int(input("Enter new day of reservation: "))
                        except ValueError:
                            print("Enter numbers only")
                        else:
                            break

                    # Check if date exists
                    try:
                        new_reserved_date = date(new_year, new_month, new_day)
                    except ValueError:
                        print("Invalid date")
                    else:
                        # Will only allow update if new date is 5 days in advance
                        if date_is_advance(new_reserved_date):
                            break
                        print("Reservation has to be made at least 5 days in advance")

                # Convert date object to string
                new_reserved_date = date.isoformat(new_reserved_date)

                print(
                    "1: 12:00 pm – 02:00 pm\n2: 02:00 pm – 04:00 pm\n3: 06:00 pm – 08:00 pm\n4: 08:00 pm – 10:00 pm"
                )
                while True:
                    try:
                        new_session = int(
                            input(
                                "Enter the slot number of the new_session (1/2/3/4): "
                            )
                        )
                    except ValueError:
                        print("Enter numbers only")
                    else:
                        # Check if session exists
                        if new_session >= 1 and new_session <= 4:
                            new_session = f"Slot {new_session}"
                            # Check if session is not full then only allow update
                            if not session_is_available(new_session, new_reserved_date):
                                print(
                                    f"{new_session} session is full on {new_reserved_date}"
                                )
                                continue
                            break
                        print("Invalid Session")

                # Check if the email format is entered correctly
                while True:
                    new_email = input("Enter your new email for the reservation: ")

                    if (
                        "@" not in new_email or "." not in new_email.split("@")[1]
                    ):  # if @ and . is missing, it means the new email is in wrong format.
                        print("Wrong email format. Please enter again")
                    else:
                        print("Email saved!")
                        break

                while True:
                    new_phone_num = input(
                        "Enter your phone number for the reservation (without '-'): "
                    )

                    if (
                        not new_phone_num.isdigit()
                    ):  # Check if the phone number contains only digits (no decimals or alphabets)
                        print("Invalid Phone Number. Please enter numbers only.")

                    elif len(new_phone_num) != 10:
                        print(
                            "Invalid Phone Number. Phone Number should be 10 digits long."
                        )

                    else:
                        print("Phone number saved!")
                        break

                # Check if pax exceeds the limit
                while True:
                    try:
                        new_pax_size = int(input("Enter the number of pax (Max 4): "))
                    except ValueError:
                        print("Enter numbers only")
                    else:
                        if new_pax_size < 1 or new_pax_size > 4:
                            print("The number of pax can only be from 1 to 4.")
                        else:
                            break

                while True:
                    # Name inputed will be convert to uppercase and remove space around
                    new_name = input("Enter new name for reservation: ").strip().upper()
                    if len(new_name) != 0:
                        break
                    print("Do not leave your name blank")

                # Replace old details with new ones
                reservation[0] = new_reserved_date
                reservation[1] = new_session
                reservation[2] = new_name
                reservation[3] = new_email
                reservation[4] = new_phone_num
                reservation[5] = str(new_pax_size)
                print("Reservation updated")
                break

        if found_reservation == False:
            print("Reservation can't be found")
          
        more_update = ""
        # Only stop asking for input when user correctly typed Y/N
        while more_update != "Y" and more_update != "N":
            more_update = input(
                "Would you like to update more reservations? Y/N: "
            ).upper()

        # If user don't want to update, exit the function
        if more_update == "N":
            os.system("cls")
            return


# Display reservations in the system
def display_reservations():  # reservations is a list of lists
    print(
        "Date".ljust(11),
        "Time".ljust(11),
        "Name".ljust(18),
        "Email".ljust(25),
        "Phone".ljust(11),
        "Number of People".ljust(2),
    )

    for x in reservations:
        slot = x[1]
        match slot:
            case "Slot 1":
                slot = "12pm - 2pm"
            case "Slot 2":
                slot = "2pm - 4pm"
            case "Slot 3":
                slot = "6pm - 8pm"
            case "Slot 4":
                slot = "8pm - 10pm"
        print(
            x[0].ljust(11),
            slot.ljust(11),
            x[2].ljust(18),
            x[3].ljust(25),
            x[4].ljust(11),
            x[5].ljust(2),
        )

    more_update = ""
    # Only stop asking for input when user correctly typed Y/N
    while more_update != "Y":
        more_update = input(
            "\nType 'Y' if you wish to return to main menu: "
        ).upper()
    # If user ready to return to main menu, clear console and return to menu
    os.system("cls")
    return

      
# Generate meal recommendations based on the menu
def meal_recommendation():
    random_index = random.randint(0, len(menu_items) - 1)
    meal_selector = menu_items[random_index]

    print()
    print("Here is a recommendation for you.")
    print()
    print("*****", meal_selector, "*****")

    more_update = ""
    # Only stop asking for input when user correctly typed Y/N
    while more_update != "Y":
        more_update = input(
            "\nType 'Y' if you wish to return to main menu: "
        ).upper()

    # If user ready to return to main menu, clear console and return to menu
    os.system("cls")
    return


# Exit function
def exit():
    try:
        # Update all the changes to the text files
        with open("reservation_23032998.txt", "w") as file:
            for reservation in reservations:
                line = "|".join(reservation)
                file.write(line)
                file.write("\n")
    except FileNotFoundError:
        print("Unable to overwrite file(s) with updated reservation(s)")


# Main menu
def main():
    if not read_menu_items() or not read_reservations():
        print("Exiting program...")
        return

    while True:
        # Displaying functions to choose from to users
        print("=== Charming Thyme Trattoria's restaurant management system ===")
        print("a. Add Reservation(s)")
        print("b. Cancel Reservation(s)")
        print("c. Update/Edit Reservation(s)")
        print("d. Display")
        print("e. Generate Meal Recommendation)")
        print("f. Exit")

        choice = input("Enter the allocated alphabet to proceed: ").lower()
        # This line below clear the console
        os.system("cls")
        # Call functions according to the choice the user made
        match choice:
            case "a":
                add_reservation()
            case "b":
                cancel_reservation()
            case "c":
                update_reservation()
            case "d":
                display_reservations()
            case "e":
                meal_recommendation()
            case "f":
                exit()
                print("Thank you for using the program")
                break  # break is used to end the program
            case _:
                print("Invalid choice. Please try again.\n")

main()

