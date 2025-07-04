#HONG TING WAI
#TP068065
def check_digit(choice):
    #user should give this function a number in string
    for i in choice:  #then using for loop to loop thorugh every digit in that string
        if i not in ['0','1','2','3','4','5','6','7','8','9']: #if the element in that string does not in this list
            return False #it means that that is something other that digit in that string, so return False
    return True #else return True prove that that string only contain digit

def simplechoice(mylist):
    #give this function a list contain the element you only want user to input
    choice = "any wrong answer" #set the choice equal to any string other than element in your list
    while choice not in mylist: #if the choice not in your list, this while loop will keep asking you to reset the choice
        choice = input("Please select your next step: ") # then this choice will be reset by user's input
        if choice not in mylist:                  # that's mean if choice reset by user's input is not in your list
            print("Sorry, invalid input, please try again!")    #this loop will keep asking user to input the correct choice

    if check_digit(choice) == False:   #if user's input is not a digit, and in the upper case                               
        choice = choice.lower()        # here will transform them into lower case
    
    return choice

def choice_in_integer(mylist):
    #very similar to function simplechoice
    #except that this only accept the range (mylist) that contain digit
    choice = "any wrong answer"
    while choice not in mylist:
        choice = input("Please select your next step: ")
        if choice not in mylist:
            print("Sorry, invalid input, please try again! (Note: Only enter number")
    return int(choice) #here will transform the choice to integer first before return

def choice_trace(count,selection):
    #variable:
    #count = a number you wish that user only input in this range of number
    #        example, 10, that this means you wish user to input from 1 to 10 only
    #selection= a list that contain the element other than number that user can input,
    #           example a letter 'a'
    trace = 0 
    while trace < count:
        trace = trace + 1
        selection.append(str(trace))
    #this while loop is just used to append all the number in your range to the selection to
    #make the selection as a list that contain all the element the user can input
    #example,number 10, this while loop will append the number from 1 up to 10 to this selection one by one

    choice = "any wrong answer"
    while choice not in selection:
        choice = input("Please select your next step: ")
        if choice not in selection:
            print("Sorry,invalid input. Please try again")
        
    if check_digit(choice) == False:
        choice = choice.lower()
    #after that, here is just the same thing as function choice_in_integer
    
    return choice


def display_item_detail(item,storage):
    #variable
    #item =  a number input by user to indicate which item the user want
    #storage = a giant list that contain many sub lists, each sub list
    #           contains the detail of the grocery
    print("\n")
    print("Type: ",storage[item-1][0])
    print("Name: ",storage[item-1][1])
    print("Expire date: ",storage[item-1][2])
    print("Price: ",storage[item-1][3])
    print("Stock: ",storage[item-1][4])
    print("Specification: ",storage[item-1][5])

def rearrange(item):
    #this function is to rearrange the sub lists which contain the
    #detail of all the grocery in the giant list
    #this function will rearrange the gisnt list according to their 'type'
    beverages = []
    bread = []
    baking = []
    canned = []
    cereal = []
    cooking = []
    dairy = []
    frozen = []
    fruit = []
    health = []
    instant = []
    snack = []
    sauce = []
    vegetable = []
    others = []
    #set each type as an empty list
    all_item = []
    #set all item to an empty list
    for i in item:
        if i[0] == "Beverages":
            beverages.append(i)
        elif i[0] == "Bread/Bakery":
            bread.append(i)
        elif i[0] == "Baking Ingredient":
            baking.append(i)
        elif i[0] == "Canned Food":
            canned.append(i)
        elif i[0] == "Cereal":
            cereal.append(i)
        elif i[0] == "Cooking ingredient":
            cooking.append(i)
        elif i[0] == "Dairy":
            dairy.append(i)
        elif i[0] == "Frozen Food":
            frozen.append(i)
        elif i[0] == "Fruit":
            fruit.append(i)
        elif i[0] == "Health/Beauty":
            health.append(i)
        elif i[0] == "Instant Food":
            instant.append(i)
        elif i[0] == "Snack":
            snack.append(i)
        elif i[0] == "Sauce/Seasoning":
            sauce.append(i)
        elif i[0] == "Vegetable":
            vegetable.append(i)
        else:
            others.append(i)
    #in that giant list, loop through all the sub list
    #then, this for loop will append the sub list to the
    #viarible that hold the empty list according to their 'type'
    def append_mode(item,all_item):
        for i in item:
            all_item.append(i)
    #define another sub function in this function
    #this sub function is to loop thorugh the 'type' list
    #and append all the item in every 'type' list to all_item
    append_mode(beverages,all_item)
    append_mode(bread,all_item)
    append_mode(baking,all_item)
    append_mode(canned,all_item)
    append_mode(cereal,all_item)
    append_mode(cooking,all_item)
    append_mode(dairy,all_item)
    append_mode(frozen,all_item)
    append_mode(fruit,all_item)
    append_mode(health,all_item)
    append_mode(instant,all_item)
    append_mode(snack,all_item)
    append_mode(sauce,all_item)
    append_mode(vegetable,all_item)
    append_mode(others,all_item)
#finally return the all_item giant list which contain the detail of all the grocery
#the grocery in all_item should be arranged according to their type
    return all_item

shop = True # set the shop = True, then using while loop to 'open' the shop
while shop == True: #if the shop is reset equal to false in the program, the shop will 'close'
    #grocey file
    try:
        grocery = open("grocery.txt",mode='r') #open the text file and the mode is 'read'
        grocery_item_view = [] #set a variable to hold an empty string, this string will hold all the data in the text file later.

        for line in grocery: # to each every line in the text file, i use "~" as a seperator
            item = line.split('~') #thus split the line using "~", this make the data in the text file as a number of lists
            grocery_item_view.append(item) #finally, append all the lists which contain the detail in the text file to the empty string we have set just now
        #finally remember to close the file
        grocery.close()
    except:
        print("Sorry, the grocery file is not found!") #if the file can't open, then will print this line

    #customer file
    try:
        customer = open("customer.txt",mode = "r")
        view_customer = []
        for item in customer:
            item_no_space = item.rstrip()
            x = item_no_space.split('~')
            view_customer.append(x)
        customer.close()
    except:
        print("Sorry, the customer file is not found!")

    #admin file
    try:
        admin_file = open("admin.txt",mode='r')
        admin_info = []
        for r in admin_file:
            line = r.rstrip().split("~")
            admin_info.append(line)
        admin_file.close()
    except:
        print("Sorry, the admin file is not found!")

    #order file
    try:
        order_file = open("order.txt",mode='r')
        order_info = []
        for r in order_file:
            line = r.rstrip().split("~")
            order_info.append(line)
        order_file.close()
    except:
        print("Sorry, the order file is not found!")

    print("\nWelcome to FRESHCO Sdn Bhd")
    print("1 ---> Login\n2 ---> Register\n3 ---> Admin\n4 ---> View groceries\n5 ---> Quit")
    #5 options in the main page. Login, Register, Admin, View groceris and Quit
    print("\nPlease enter a number.\nFor example enter '1' for Login")
    print("(Note: Only enter number, for example enter 1 for Login)")
    first = choice_in_integer(['1','2','3','4','5'])
    #Call the function to let user input his/her next step
    if first == 1: #if user choose 1, then the program will enter login interface
        customer_detail = ['',''] #store the user_id and password the user input
        customer_information = [] #store the detail of the customer if he/she successfully log in
        customer = True #while customer equal to True, the customer's interface 'open, else it 'close'
        customer_login = True #this use in while loop for user to input his/her user id and password in logn's interface
                              # if he/she successfully log in (enter correct user id and password), customer_login will be reset to false
        customer_interface = False # customer_interface will be reset as True
        while customer == True:
            while customer_login == True:
                print("Please input your User ID and Password")
                print("\n(For testing,if lecturer not wish to register first, lecturer can input like this: \nUser ID: Tag1998\nPassword:abcd123456)")

                print("\n1 ---> User ID\t:",customer_detail[0])  #first since the customre_detail is just empty, so it will print nothing after the string
                print("2 ---> Password\t:",customer_detail[1])  #after user enter user_id and password, the program below will append those inputs into the list
                print("3 ---> Login")       #at that time, here will print the user's input to let them check if he/she have mistaken input wrong id or password
                print("\na ---> Go back to previous section\nb ---> Exit") #if correct, they can input'3' to login, else continue modifying
                print("\nPlease select 1 or 2 to input your User ID and Password: ")
                step = simplechoice(['1','2','3','a','A','b','B']) #call function to let the user choose his/her next step
    #step : 1 (modify user id); 2 (modify password); 3 (after check no wrong input, input this to login); a (exit this login interface); b (exit the shop)
                if step == '1':
                    user = input("User ID: ")
                    customer_detail[0] = user #prompt the user to input user id, reset the first element of customer_detail to the user id his/her input
                elif step == '2':
                    password = input("Password: ")
                    customer_detail[1] = password #prompt the user to input password, reset the second element of customer_detail to the user id his/her input
                elif step == '3':
                    for item in view_customer: #using for loop to loop through the customer's detail in the text file
                        
                        if customer_detail[0] == item[6] and customer_detail[1] == item[7]: #if the input is same as recorded in text file
                            print("\nSuccessful log in")
                            customer_information.append(item)
                            customer_login = False
                            customer_interface = True #customer_login reset to false; customer_interface reset as True
                            break #break the loop, next loop --> customer = True, customer_login = False, customer_interface = True
                    
                    if customer_interface == False: #if not same, the while loop will ask the user input again
                        print("Sorry, your admin User ID or password is wrong. Please try again!")
                    
                         
                elif step == 'a':
                    customer = False #if user choose 'a', all the variable related to customer will be reset as false, it will quit to the main interface.
                    customer_login = False
                    break
                else:
                    customer = False #if user choose 'b', beside the variable related to customer, the shop will be reset to false too
                    customer_login = False # this will end the whole program including the main interface
                    shop = False
                    break

            while customer_interface == True: 
                print("\nCustomer interface:")
                print("1 ---> View groceries/Buy groceries\n2 ---> View own order\n3 ---> View own personal information")
                print("\na ---> Sign out")
            #step: 1 (View/buy the grocery); 2 (View customer own order); 3 (view customer own information); a (sign out)
                next_step = simplechoice(['1','2','3','a','A']) #(prompt the user for his/her next step
                
                if next_step == '1':
                    view_grocery = True #if user choose 1, set view_grocery = True to 'open' the interface,
                                        #else if it is false, the interface will 'close'
                    cart = [] #set cart to empty list, it is used to store the item user wish to
                              #buy in this format ['item','price','quantity']
                    total = 0 #set total=0, this is to calculate the total price the user has bought
                    while view_grocery == True:
                        print("\n")
                        print("View groceries/Buy groceries: ")
                        print("1 ---> view/buy all groceries\n2 ---> Search specific grocery\n3 --> Cart\n\na ---> Go Back to previous section\nb ---> Sign out\n")
            #step: 1 (view/buy); 2 (search); 3 (put item in cart); 4 (sign out)
                        view_choice = simplechoice(['1','2','3','a','A','b','B']) #ask user choose his/her next step
                        if view_choice == '1':
                            all = True #set all= True to 'open' view groceries
                            while all == True: #else, reset the all to false to quit this section
                                count = 0 #set count=0, this is to calculate how many items that are in the text file
                                print("\n")
                                print("All: ")
                                print("{0:<20} | {1:<50} | {2:<8}".format("Type","Name","Price"))
                                for item in grocery_item_view: #use for loop to loop through all the items in the text file
                                    count = count + 1 #each loop, the count will add one, so it will trace the number of the item
                                    if item[4] == '0':  #if the 'stock' detail in text file equal to 0, then print out of stock
                                        mystring = str(count) + " ---> " + item[1] + " (Out of stock)"
                                        print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                                    else:
                                        mystring = str(count) + " ---> " + item[1]
                                        print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                                print("\n")
                                print("a ---> Go back to previous section")
                                print("b ---> Add to cart\n")
                                print("If you wish to pay for the item, you may exit this 'View groceries' by input 'a', and enter the 'Cart' section by input '3' afterwards.")
                                print("Or you wish to delete the item in your card you have added, you may exit this 'View groceries' by input 'a', and enter the 'Cart' section by input '3' afterwards.")
                                print("\nYou can choose the specific number on the left side of the item's name to view the item's detail")
                                itemchoice = choice_trace(count,['a','b','A','B'])
                        #step: every number in the range of count (view the item's detail); a (quit this view section) b (Add item to the cart)
                                if check_digit(itemchoice) == True: #check if user input number or the letter ('a' or 'b')
                                    item_detail = True #if user's input is number, that means user wish to view the item's detail
                                    while item_detail == True: #set item_detail to true, if this reset to false, the viewing detail section will end
                                        itemchoice = int(itemchoice)
                                        print("\n")
                                        print("Type: ",grocery_item_view[itemchoice-1][0]) #the itemchoice-1 is beacuse the index position in list start from 0
                                        print("Name: ",grocery_item_view[itemchoice-1][1])
                                        print("Expire date: ",grocery_item_view[itemchoice-1][2])
                                        print("Price: ",grocery_item_view[itemchoice-1][3])
                                        print("Stock: ",grocery_item_view[itemchoice-1][4])
                                        print("Specification: ",grocery_item_view[itemchoice-1][5])
                                        print("a ---> Go back to previous section\nb ---> Add to cart")
                        #step: a (quilt this viewing detail section); b (all the item to the cart)
                                        user_choice = simplechoice(['a','b','A','B']) #prompt the user next step
                                        if user_choice == 'a':
                                            item_detail = False #if 'a', reset the item_detail to false, in next loop, the viewing detail section is close
                                            break
                                        else:
                                            amount = True #if user wish to add the item to the cart, the program will ask the user to input the quantity
                                            while amount == True: #set the amount = True, if user has finish input the quantity, amount will reset to false
                                                print("How many do you want?")
                                                print("0 ---> Cancel adding to cart")
                                                choice = "any wrong answer"
                                                while check_digit(choice) == False:
                                                    choice = input("(If you wish to cancel adding the item to your cart,just input a numeric zero,'0' here, else input the quantity of items you want)\nQuantity: ")
                                                    if check_digit(choice) == False:
                                                        print("Please input the amount of the item you wish to buy probably. Input a numeric zero,'0' if you wish to cancel adding the items to your cart.")
                                                        
                                                if choice == '0': #if user give up to add this item to cart, they can input 0
                                                    amount = False #reset amount to false to finish this section
                                                    break
                                                else: #this is to check the user's quantity exceed the stock recorded in text file or not
                                                    if int(choice) <= int(grocery_item_view[itemchoice-1][4]): #if not exceeded, append the 'item','price','amount' into cart list
                                                        cart.append([grocery_item_view[itemchoice-1][1],grocery_item_view[itemchoice-1][3],choice]) 
                                                        print("You have successfully added",choice,grocery_item_view[itemchoice-1][1],"to your cart")
                                                        amount = False                              #if not exceeded, the user can add the item in that quantity to his/her cart
                                                        item_detail = False # reset these two variables to false, and the program will quit the viewing detail section
                                                        break
                                                    else:
                                                        print("Sorry, your quantity exceed the stock we have")
                                                        print("We apologize to you first if this cause you any inconvenience")
                                                        print("Please try again") #if exceeded, the amount is still qual to true, the program will ask the user for quantity again
                                else:
                                    if itemchoice == 'a':
                                        all = False #if user choose 'a', reset all equal to false, the program will quit view/buy section
                                        break
                                    else:
                                        shopping = True #if user choose 'b', it means he/she wish to do shopping and add item to the cart
                                        while shopping == True: #if customer done shopping, program will reset this to false
                                            #--------------------------------------------------------------------------------------------------
                                            count = 0    # this part is same as above to print the all the item in text file
                                            print("\n")
                                            print("All: ")
                                            print("{0:<20} | {1:<50} | {2:<8}".format("Type","Name","Price"))
                                            for item in grocery_item_view:
                                                count = count + 1
                                                if item[4] == '0':
                                                    mystring = str(count) + " ---> " + item[1] + " (Out of stock)"
                                                    print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                                                else:
                                                    mystring = str(count) + " ---> " + item[1]
                                                    print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                                            #---------------------------------------------------------------------------------------------------
                                            print("Please select the item you wish to add to your cart")
                                            print("Or you don't wish to add anything to your cart for now, you can input following instructions")
                                            print("\na ---> Go back to previous section (View Grocery)")
                                            print("If you wish to pay for the item, you may exit this 'View groceries' by input 'a', and enter the 'Cart' section by input '3' afterwards.")
                                            print("Or you wish to delete the item in your card you have added, you may exit this 'View groceries' by input 'a', and enter the 'Cart' section by input '3' afterwards.")
                                            print("\nYou can choose the specific number on the left side of the item's name to add the item to your cart")
                                            customer_cart = choice_trace(count,['a','A'])
                                            #step: every number in the range of count (put item into cart); a (quit this shopping section)
                                            if check_digit(customer_cart) == True: #check if user input a number or a letter 'a'
                                                customer_cart = int(customer_cart)
                                            #==========================================================================================================
                                                amount = True   #this part is same as above to ask the user the quantity of the item he/she wish to buy
                                                while amount == True:
                                                    print("How many do you want?")
                                                    print("0 ---> Cancel adding to cart")
                                                    choice = "any wrong answer"
                                                    while check_digit(choice) == False:
                                                        choice = input("(If you wish to cancel adding the item to your cart,just input a numeric zero,'0' here, else input the quantity of items you want)\nQuantity: ")
                                                        if check_digit(choice) == False:
                                                            print("Please input the amount of the item you wish to buy probably. Input a numeric zero,'0' if you wish to cancel adding the items to your cart.")
                                                            
                                                    if choice == '0':
                                                        amount = False
                                                        break
                                                    else:
                                                        if int(choice) <= int(grocery_item_view[customer_cart-1][4]):
                                                            cart.append([grocery_item_view[customer_cart-1][1],grocery_item_view[customer_cart-1][3],choice])
                                                            print("You have successfully added",choice,grocery_item_view[customer_cart-1][1],"to your cart")
                                                            amount = False
                                                            print("Continue adding other items to your cart?")
                                                            print("1 ---> Yes\n2 ---> No") #only difference is here
                                                            print("\nInput '1' to continue adding item to your cart, else input 2 to stop adding item to your cart")
                                                            choice = simplechoice(['1','2'])  # ask user whether he/she wish to continue adding item to the cart or not 
                                                            if choice == '1': #if yes, then shopping is still true, the user can add another item during next loop
                                                                shopping = True
                                                            else:
                                                                shopping = False #if no, the shopping is reset to false, in the next loop, the user will quit this shopping section
                                                                break
                                                
                                                        else:
                                                            print("Sorry, your quantity exceed the stock we have")
                                                            print("We apologize to you first if this cause you any inconvenience")
                                                            print("Please try again")
                                            #=============================================================================================================
                                                
                                            else:
                                                shopping = False #if user input letter 'a', but not a number
                                                break #the shopping is reset to false, in the next loop, the user will quit this shopping section
                                        
                        elif view_choice == '2': #user choose 2 if he/she wish to search specific grocery
                            search = True #set search equal to true, if this reset to false, the search will 'close'
                            while search == True:
                                searched_item = [] #set search_item to an empty list, this is to store the item which match the user's search
                                print("\n")
                                print("Please type the item's name you wish to search")
                                print("Note: you can type with upper case or lower case, but make sure the spelling is correct!")
                                search = input("Search: ") #get user's search
                                search = search.lower() #set the user's input to lower case
                                for item in grocery_item_view: #using for loop to loop through all the item in the text file
                                    x = item[1].lower() #set the name of the item to lower case (so as avoid seaching fail due to this upper
                                    if search in x:       #or lower case issue
                                        searched_item.append(item) #if the name of item match the user input, append them to searched_item
                                show_item = True #after search, set show_item to true to show the item the user has searched
                                while show_item == True:
                                    count = 0 #set count=0, this is to trace the number of searched item
                                    print("\n")
                                    print("You have searched",len(searched_item),"results :")
                                    print("{0:<20} | {1:<50} | {2:<8}".format("Type","Name","Price"))
                                    for item in searched_item: #using for loop to loop through every item in search
                                        count = count + 1
                                        if item[4] == '0':
                                            mystring = str(count) + " ---> " + item[1] + " (Out of stock)"
                                            print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                                        else:
                                            mystring = str(count) + " ---> " + item[1]
                                            print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                                    print("\n")
                                    print("a ---> Go back to previous section")
                                    print("b ---> Add to cart\n")
                                    print("\nYou can choose the specific number on the left side of the item's name to view the item's detail")
                            #step: every number in range count (view the searched item detail); a (quit this search section); b (all the item user has searched to the cart)
                                    itemchoice = choice_trace(count,['a','b','A','B']) #prompt the user to get next step
                                    if check_digit(itemchoice) == True:
                                        item_detail = True
                                        while item_detail == True:
                                            itemchoice = int(itemchoice)
                                            display_item_detail(itemchoice,searched_item)
                                            print("a ---> Go back to previous section\nb ---> Add to cart")
                                            user_choice = simplechoice(['a','b','A','B'])
                                            if user_choice == 'a':
                                                item_detail = False
                                                break
                                            else:
                                                amount = True
                                                while amount == True:
                                                    print("How many do you want?")
                                                    print("0 ---> Cancel adding to cart")
                                                    choice = "any wrong answer"
                                                    while check_digit(choice) == False:
                                                        choice = input("(If you wish to cancel adding the item to your cart,just input a numeric zero,'0' here, else input the quantity of items you want)\nQuantity: ")
                                                        if check_digit(choice) == False:
                                                            print("Please input the amount of the item you wish to buy probably. Input a numeric zero,'0' if you wish to cancel adding the items to your cart.")
                                                            
                                                    if choice == '0':
                                                        amount = False
                                                        break
                                                    else:
                                                        if int(choice) <= int(grocery_item_view[itemchoice-1][4]):
                                                            cart.append([grocery_item_view[itemchoice-1][1],grocery_item_view[itemchoice-1][3],choice])
                                                            print("You have successfully added",choice,grocery_item_view[itemchoice-1][1],"to your cart")
                                                            amount = False
                                                            item_detail = False
                                                            break
                                                        else:
                                                            print("Sorry, your quantity exceed the stock we have")
                                                            print("We apologize to you first if this cause you any inconvenience")
                                                            print("Please try again")
                                    else:
                                        if itemchoice == 'a':
                                            show_item = False
                                            search = False
                                            break
                                        else:
                                            shopping = True
                                            while shopping == True:
                                                count = 0
                                                print("\n")
                                                print("{0:<20} | {1:<50} | {2:<8}".format("Type","Name","Price"))
                                                for item in searched_item:
                                                    count = count + 1
                                                    if item[4] == '0':
                                                        mystring = str(count) + " ---> " + item[1] + " (Out of stock)"
                                                        print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                                                    else:
                                                        mystring = str(count) + " ---> " + item[1]
                                                        print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                                                print("Please select the item you wish to add to your cart")
                                                print("Or you don't wish to add anything to your cart for now, you can input following instructions")
                                                print("\na ---> Go back to previous section (View Grocery)")
                                                print("If you wish to pay for the item, you may exit this 'View groceries' by input 'a', and enter the 'Cart' section by input '3' afterwards.")
                                                print("Or you wish to delete the item in your card you have added, you may exit this 'View groceries' by input 'a', and enter the 'Cart' section by input '3' afterwards.")
                                                print("\nYou can choose the specific number on the left side of the item's name to add the item to your cart")
                                                customer_cart = choice_trace(count,['a','A'])
                                                if check_digit(customer_cart) == True:
                                                    customer_cart = int(customer_cart)
                                                    amount = True
                                                    while amount == True:
                                                        print("How many do you want?")
                                                        print("0 ---> Cancel adding to cart")
                                                        choice = "any wrong answer"
                                                        while check_digit(choice) == False:
                                                            choice = input("(If you wish to cancel adding the item to your cart,just input a numeric zero,'0' here, else input the quantity of items you want)\nQuantity: ")
                                                            if check_digit(choice) == False:
                                                                print("Please input the amount of the item you wish to buy probably. Input a numeric zero,'0' if you wish to cancel adding the items to your cart.")
                                                                
                                                        if choice == '0':
                                                            amount = False
                                                            break
                                                        else:
                                                            if int(choice) <= int(grocery_item_view[customer_cart-1][4]):
                                                                cart.append([grocery_item_view[customer_cart-1][1],grocery_item_view[customer_cart-1][3],choice])
                                                                print("You have successfully added",choice,grocery_item_view[customer_cart-1][1],"to your cart")
                                                                amount = False
                                                                print("Continue adding other items to your cart?")
                                                                print("1 ---> Yes\n2 ---> No")
                                                                print("\nInput '1' to continue adding item to your cart, else input 2 to stop adding item to your cart")                                                              
                                                                choice = simplechoice(['1','2'])
                                                                if choice == '1':
                                                                    shopping = True
                                                                else:
                                                                    shopping = False
                                                                    break
                                                            else:
                                                                print("Sorry, your quantity exceed the stock we have")
                                                                print("We apologize to you first if this cause you any inconvenience")
                                                                print("Please try again")
                                                    
                                                else:
                                                    shopping = False
                                                    break
                        elif view_choice == '3':
                            trolley = True #set trolley = True to 'open' this section
                            while trolley == True: #else, if reset trolley to false, the program will quit this section
                                total = 0 #set total = 0, this is to count the total price the user has bought
                                count = 0 #set count = 0, this is to trace the number of the item user's cart have
                                print("{0:^50} | {1:^6} | {2:<8} | {3:^6}".format("Item","Price","Quanity","Total"))
                                for item in cart: #use for loop to loop through the item in cart
                                    price = '' #set price to empty string, this is to store the price of the item without "RM"
                                                #(originally the price of each item in text file is recorded like this "RM 4.50"
                                    total_each_item = 0 #set total_each_item = 0, this is to count the total price of each item
                                    count = count+1 #for each loop, count = count + 1
                                    #-----------------------------------------------------------------
                                        #this for loop is to remove the "RM" in the price part.
                                    for i in item[1]: #loop through each character in price (price in text file is recorded like this "RM 4.50"
                                        if i =="R" or i=="M": #if the for loop meet "R" or "M", just skip the process and go to next loop
                                            pass
                                        else:
                                            price = price+i #else, if the item is not "R" or "M", concatenate the price into a new string
                                    #----------------------------------------------------------------------
                                    total_each_item = float(price)*int(item[2]) #calculate the total price of each item (item's price * item's quantity)
                                    my_item_string = str(count) + " ---> " + item[0]
                                    my_price_string = "RM {total_item:4.2f}".format(total_item = total_each_item)
                                    print("{0:<50} | {1:^6} | {2:<8} | {3:^6}".format(my_item_string,item[1],item[2],my_price_string))
                                    total = total + total_each_item #calculate the total price of every items (total + total of each item)
                                print("{0:>70} | {0:^6}".format(""))
                                total_string = "RM {total_item:4.2f}".format(total_item = total)
                                print("{0:>70} | {1:^6}".format("Total",total_string))
                                        #print the cart interface in this format -->     Item     |  Price  |  Quantity  |  Total
                                                                   #For example  --> 1 ---> xxxx  |  RM x.xx|    10      |  RM xx.xx
                                    #at last line print the total of every item  -->                           Total     |  RM xx.xx
                                print("a ---> Go back to previous section\nb ---> Pay for the items\nc ---> Modify quantity/Delete")
                        #step: a (quit viewing cart section); b (pay for all the item); c (modify the cart
                                choice = simplechoice(['a','b','c','A','B','C']) #prompt the user to get next step
                                if choice == 'a': #if user choose 'a', then reset trolley to false
                                    trolley = False #this will quit this viewing cart section
                                    break
                                elif choice == 'b':
                                    pay = True #if user choose 'b', which is to pay, set pay to true to enter pay interface
                                    while pay == True: #else if reset pay to false, the program will quit this pay section

                                        if cart == []: #check the user's cart is empty or not
                                            print("Sorry, you don't havr any item in your cart. Go ahead to add something to your cart!")
                                            pay = False # if is empty, set the trolley to false and quith this pay section
                                            break
                                        #if the cart is not empty, then continue the loop
                                        print("The total is RM {total_item:4.2f}".format(total_item = total))
                                        print("Before your payment, please make sure the address in your personal information is correct, we will deliver the item to you via that address. You can check or modify it in 'View own personal information' section")
                                        print("Choose a way you wish to pay: \n1 ---> Cash delivery\n2 ---> E-wallet\n3 ---> Debit/Credit card\n\na ---> Go back to the previous section")
                         #step: 1 (cash); 2 (E-wallet); 3(Card); a (quit this pay section
                         # in this program, we assume that all the payment is successful
                                        choice = simplechoice(['1','2','3','a','A']) #prompt the user to input next step
                                        if check_digit(choice) == True: #check the user's input is a digit or not
                                            print("You have successfully paid for the item!")# if yes, means user have successfully pay for the item
                                            print("Remember to notify us when you received the item in your 'View own order' section")
                                    
                                #the part below is to update the order text file according to the user's order
                                            item_string = '' #set the item string to empty string, this is to store 'item' and 'quantitiy' in a specific order
                                            for item in cart: #loop through the item in the cart
                                                item_string = item_string + item[0] +'=' +item[2]+"," #make the string like this "item=quantity,item2=quantity2,"
                                            item_string = item_string[0:-1] #this is to remove the last "," in item_string
                                            order_string = customer_information[0][0]+"~"+item_string+"~"+customer_information[0][1]+"~"+customer_information[0][2]+"~"+customer_information[0][3]+"~paid~not delivered~not received~\n"
                            #the code above is to concatenate all the require information in the text file in a specific order
                                            myfile = open("order.txt",mode='a')#open the order text file in append mode
                                            myfile.write(order_string) # append the order string which has been modified in a specif order to the text file
                                            myfile.close() #close the text file
                                #end for order text file

                                            
                                #below is to update the 'stock' detail in grocery file
                                            for item in grocery_item_view: #loop through all the grocery in the text file
                                                for i in cart: #loop thorugh all the item in the cart
                                                    if i[0] == item[1]: #if the item's name in cart is same as in the text file
                                                        item[4] = str(int(item[4])- int(i[2])) #calculate the stock left after the user has successfully bought the item
                                            string_ready_to_grocery_textfile = [] #set an empty string to store the string in a specific order to rewrite into the text file
                                            for item in grocery_item_view: #loop thrpugh the item in this giant string (have introduce this variable in open grocery text file section above)
            #because the in the text file, the last character is a seperator, which is "~", so the .split("~") function will cause all the sub lists have one more empty string item at
            #last index position, thus,the program will remove that last empty string item in each sub lists.
                                                item.pop(-1) 
                                                mystring = ""  #set mystring to empty string (hold each line of the text file later)
                                                for x in item: #loop through all the element in sub list
                                                    mystring = mystring + x + "~" #concatenate the string in a specific order
                                                final = mystring + "\n" #each string should add this "\n" to add a new line (for tidy purpose in the text file)
                                                string_ready_to_grocery_textfile.append(final) #append each line to the giant list variable
            #Because i only open the text file at the beginning and store all the data in the text file in a giant list, thus if not append this empty string to the last item in each
            #sub list, the program will remove the last item in my sub lists in the next loop if the user wish to pay for the item again. Thus, i append back the empty string i have
            #removed just now so as the program will only always remove the empty string only to avoid any data lost in next loop
                                                item.append("")
                                            my_grocery_file = open("grocery.txt",mode="w") #oppend the file in write mode
                                            for line in string_ready_to_grocery_textfile: #loop through that giant list that contains every line of the text file
                                                 my_grocery_file.write(line) # write the data into the text file
                                            my_grocery_file.close() #close the text file
                                            
                                            #order file
                                            #since the order file is updated based on the cart variable, the order_info this giant list has not been updated
                                            #thus, the program will open the order text file in read mode again to update that giant list.
                                            try: 
                                                order_file = open("order.txt",mode='r')
                                                order_info = []
                                                for r in order_file:
                                                    line = r.rstrip().split("~")
                                                    order_info.append(line)
                                                order_file.close()
                                            except:
                                                print("Sorry, the order file is not found!")

                                            cart = [] #after paying all the item, set the cart to empty
                                            pay = False #set pay to false, quit this pay interface
                                            break
                                        else:
                                            pay = False #if user choose 'a', set pay to false, quit the pay section
                                            break
                                else:
                                    change_quantity = True #if user choose 'c', it means user wish to modigy his/her cart
                                    while change_quantity == True: #set change_quantity to true to 'open' this section
                                        print("a ---> Go back to previous section")
                                        print("Select the number stated at the left side of the item's name to change the quantity")
                                        user_choice = choice_trace(count,['a','A'])
                                #step: every number in count (choose the spefic item in cart to mofigy); a (quit this modify section)

                                        #if user input an integer, the user can modify the quantity of the item in the cart
                                        # the code below is just same as the amount section we have talked above
                                        
                                        if check_digit(user_choice) == True: 
                                            amount = True          
                                            user_choice = int(user_choice)
                                            while amount == True:
                                                print("How many do you want?")
                                                print("0 ---> Delete the item")
                                                choice = "any wrong answer"
                                                while check_digit(choice) == False:
                                                    choice = input("(If you wish to delete the item to your cart,just input a numeric zero,'0' here, else input the quantity of items you want)\nQuantity: ")
                                                    if check_digit(choice) == False:
                                                        print("Please input the amount of the item you wish to buy probably. Input a numeric zero,'0' if you wish to delete the items.")
                                                                    
                                                if choice == '0':
                                                    cart.pop(user_choice-1)
                                                    amount = False
                                                    break
                                                else:
                                                    trace = 0
                                                    for item in grocery_item_view:   
                                                        if cart[user_choice-1][0] == item[1]:
                                                            break
                                                        else:
                                                            trace = trace+1
                                                    if int(choice) <= int(grocery_item_view[trace][4]):
                                                        cart.pop(user_choice-1)
                                                        cart.append([grocery_item_view[trace][1],grocery_item_view[trace][3],choice])
                                                        print("You have successfully modify",choice,grocery_item_view[trace][1],"to your cart")
                                                        amount = False
                                                        break
                                                    else:
                                                        print("Sorry, your quantity exceed the stock we have")
                                                        print("We apologize to you first if this cause you any inconvenience")
                                                        print("Please try again")
                                        else:
                                            if user_choice == 'a': #if user choose 'a', then the change_quantity will be reset in to false
                                                change_quantity = False #this will quite the modifying section `
                                                break
                                            
                            
                                
                                
                            
                        elif view_choice == 'a':
                            view_grocery = False #reset view_grocery = false and quit this section
                            break          #but it still remain in customer's interface
                        else:
                            view_grocery = False
                            customer_interface = False #reset these three variables to false
                            customer = False #this will sign out the user's account, go to main interface
                            
                            print("Thank!\nHope to see you again!")
                            break
                elif next_step == '2': #if user choose 2, the program will enter view order interface

                    viewing_order = True # set viewing_order = true to 'open' this section
                    while viewing_order == True: #else if reset to false, will 'close this section'
                        print("{0:^50} | {1:^8} | {2:^35}".format("Item","Quantity","Status"))
                        customer_item = [] #set customer_item to empty list
                        for item in order_info: #loop through the giant list which contain the data from the text file
                            if item[0] == customer_information[0][0]: #if the order belong to the customer
                                customer_item.append(item) #append the order to the customer_item list
                        
                        #below is the same thing as above we have talked in other sections
                        #the part is mainly to print out the user's order detail
                        count = 0
                        
                        order_item = []
                        for i in customer_item:
                            count = count + 1
                            stick = i[1].split(",")
                            order_item = []
                            for r in stick:
                                item_stock = r.split("=")
                                order_item.append(item_stock)

                            for r in order_item:
                                mystring = str(count) + " ---> " + r[0]
                                status_string = customer_item[count-1][5] + ", " + customer_item[count-1][6] + ", " + customer_item[count-1][7]
                                print("{0:<50} | {1:^8} | {2:^35}".format(mystring,r[1],status_string))
                            print("{0:-<50} | {0:-<8} | {0:-^40}".format(""))
                            
                        print("\na ---> Go back to previous section\nb ---> Confirm received")
                        print("Please input 'a' to quit this section or 'b' to confirm you have received the item.")
                        #step: a (quit this view order section); b (confirm the item has been received)
                        choice = simplechoice(['a','A','b','B']) #prompt the user to input next step
                        if choice == 'a': #if user choose 'a', then reset the viewing_order to false
                            viewing_order = False #then the program will quit this viewing order section
                            break
                        else:
                            receive = True #else if user need to respond to the company they have receive the item can choose 'b'
                            while receive == True: #set receive = True to 'open' this section                   
                                print("a ---> Go back to previous section")
                                print("Choose the number at left side of the item's name if you have received the item, else input 'a' to leave this section")
                        #the user just have to choose the number of the order that they have receive, else choose a to quit this section
                        #step: every number in count (to confirm which order the user has received); a (quit this receive section)
                                received_item = choice_trace(count,['a','A']) #prompt user to input next step

                                for item in customer_item[int(received_item)-1]: #loop through the item in customer_item
                                    if item == "not delivered": #if the item has not been delivered by the company
                                        print("Sorry, your items have not been delivered yet by our company.")
                                        print("we apolgize to you first if this cause you any inconvenience!")
                                        receive = False # set reveive to false and quit this section
                                        break

                                if receive == False:
                                    break

                                if check_digit(received_item) == True: 
                                    received_item = int(received_item)
                                    print("Are you sure you have received the item?")
                                    print("1 ---> Yes ; 2 ---> No")
                                    choice = simplechoice(['1','2']) #prompt the user to input if he/she confirm the order has been received
                                    if choice == '1': #if user say yes
                                        customer_item[received_item-1][7] = "received" #then set the 'not received' status in the list to 'received
                                        for r in order_info: #set status of the item of the user in giant list to 'received'
                                            if r[0] == customer_item[received_item-1][0] and r[1] == customer_item[received_item-1][1]:
                                                r[7] = "received"
                                    #below is the same thing as we have talked above
                                    #it's just prepare the string and write the updated date to the text file
                                        string_ready_to_order_textfile = []
                                        for item in order_info:
                                            item.pop(-1)
                                            mystring = ""
                                            for x in item:
                                                mystring = mystring + x + "~"
                                            final = mystring + "\n"
                                            string_ready_to_order_textfile.append(final)
                                            item.append("")
                                        my_order_file = open("order.txt",mode="w")
                                        for line in string_ready_to_order_textfile:
                                            my_order_file.write(line)
                                        my_order_file.close()
                                        receive = False #after done,set receive to false ans quit this section
                                        break
                                else:
                                    receive = False #the user can also input 'a' to quit this section
                                    break
                                        
                                    
                elif next_step == '3':

                    info_viewing = True #the user can choose '3' to view his/her own personal information
                    while info_viewing == True: #set info_viewing to True to 'open' this section
                        print("Name: ",customer_information[0][0])
                        print("Address: ",customer_information[0][1])
                        print("Email: ",customer_information[0][2])
                        print("Contact: ",customer_information[0][3])
                        print("Gender: ",customer_information[0][4])
                        print("Date of birth: ",customer_information[0][5])
                        print("User ID: ",customer_information[0][6])
                        print("Password: ",customer_information[0][7])
                        #print all the detail based on customer_information (the variable set above at the login part)
                        print("\na ---> Go back to previous section\nb ---> Change account detail")
                        #step: a (quit this viewing section); b (modify account detail)
                        choice = simplechoice(['a','b','A','B']) #prompt user to input next step
                        if choice == 'a': #if user choose 'a', set info_viewing to false and quit this section
                            info_viewing = False
                            break
                        else:
                            modifying = True #else, set modifying to true to 'open' modifying section
                            while modifying == True:
                                print("\n1 ---> Name: ",customer_information[0][0])
                                print("2 ---> Address: ",customer_information[0][1])
                                print("3 ---> Email: ",customer_information[0][2])
                                print("4 ---> Contact: ",customer_information[0][3])
                                print("5 ---> Gender: ",customer_information[0][4])
                                print("6 ---> Date of birth: ",customer_information[0][5])
                                print("7 ---> User ID: ",customer_information[0][6])
                                print("8 ---> Password: ",customer_information[0][7])
                                print("Note: You can't change your Name, User ID and Date of birth")
                                print("\na ---> Go back to previous section\nb ---> I have done modification")
                                print("Please select the item you wish to change ")
                                #print all the details
                                #step: the number from 1 to 8 (to modify each detail); a (quit this modifying section); b (done modifying)
                                choice = simplechoice(['1','2','3','4','5','6','7','8','a','A','b','B']) #ask user for the next step
                                if check_digit(choice) == True: #check the user's input is an integer or not, if yes start modifying details
                                    if choice == '1': #the user can't change the name
                                        print("Sorry, you can't change your name")
                                    elif choice == '2':
                                        print("Please make sure your address is correct as it's very important for us to deliver the item to you")
                                        print("Example: No99,Jalan Good,Taman Best,56000,Cheras,Kuala Lumpur,Malaysia")
                                        address = input("Address: ") # ask user to input new address
                                        customer_information[0][1] = address #update the list in customer_information
                                    elif choice == '3':
                                        email = "any wrong answer"
                                        while "@" not in email or '.com' not in email: #if user input not contain '@' and '.com'
                                            email = input("Email: ") #this while loop will keep asking he user to input a proper email
                                            if "@" not in email or '.com' not in email:
                                                print("Please write a valid email")
                                                print("Example: abcd@gamil.com")
                                        customer_information[0][2] = email #update the list in customer_information
                                    elif choice == '4':
                                        contact = "any wrong answer"
                                        check = check_digit(contact)
                                        while check == False: #if the user's input contain any charater which is not an interger
                                            print("Make sure your number is correct\nExample: 60123456789")
                                            contact = input("Contact: ") # the while loop will keep asking user to input a proper contact
                                            check = check_digit(contact) #check whether the input contain any non-integer charavter
                                            if check == False:
                                                print("Sorry, invalid input. Please try again!")
                                        customer_information[0][3] = contact #update the list in customer_information
                                    elif choice == '5':
                                        print("1 ---> Male\n2 ---> Female")
                                        gender = 'any wrong answer'
                                        while gender not in ['1','2']: #if user input is not 1 or 2, 
                                            gender = input("Gender: ") #this while loop will keep asking user to input the gender
                                            if gender not in ['1','2']:
                                                print("Sorry, invalid input. Type 1 if you are male or 2 if you are female")
                                        if gender == '1':
                                            customer_information[0][4] = "Male" #update the list in customer_information
                                        else:
                                            customer_information[0][4] = "Female" #update the list in customer_information
                                    elif choice == '6':
                                        print("Sorry, you can't change your birthday date") #user can't modify his/her birthday date
                                    elif choice =='7':
                                        print("Sorry, you can't change your User ID") #user can't modify his/her user id
                                    else:
                                        original = input("Please input your original password: ") #ask user to input the old password
                                        if original == customer_information[0][7]: #if old password is same as recoreded in the text file
                                            new = input("Please input your new password")
                                            customer_information[0][7] = new #update the list in customer_information
                                        else: #if the old password is wrong, the user will not able to input his new password, he can try again in next loop
                                            print("Sorry, your original password is wrong. Please try again")          
                                else:
                                    if choice == 'a': #if user choose 'a', the program will quit this modifying section
                                        modifying = False
                                        break
                                    else: #if done modifying, user can choose 'b'
                                        print("Are you sure all the detail are correct")
                                        print("1 ---> Yes, update my detail\n2 ---> No, I wish to continue modifying my detail")
                                        customer_choose = input("Please select your next step: ") #ask user if he/she confirm finish modifying their details
                                        while customer_choose not in ['1','2']: #if the choice not in 1 or 2, this while loop will keep asking the user to
                                            print("Sorry, invalid input. Please try again")#input a correct choice
                                            customer_choose = input("Please select your next step: ")
                                        if customer_choose == '1': #if user confirm to update his/her details, choose 1
                                            trace = 0 #set trace = 0, this is to trace the index position of the user's detail in the giant list
                                            for item in view_customer: #loop through the giant list
                                                if item[6] == customer_information[0][6]: #this line use the user id to find out the index position of the user's detail in the giant list
                                                    view_customer.pop(trace) #remove that old details in the giant list
                                                else:
                                                    trace = trace + 1 #if can't find the index position of the user's details, add 1 to trace and continue to next loop
                                            view_customer.append(customer_information[0]) #append the new user's detail to the giant list
                                        #below is same thing as we have talked above
                                        #it's to use the data in the giant list and rewrite the customer text file in order to update the user's detail.
                                            string_ready_to_customer_textfile = []
                                            for item in view_customer:
                                                item.pop(-1)
                                                mystring = ""
                                                for x in item:
                                                    mystring = mystring + x + "~"
                                                final = mystring + "\n"
                                                string_ready_to_customer_textfile.append(final)
                                                item.append("")
                                            my_customer_file = open("customer.txt",mode="w")
                                            for line in string_ready_to_customer_textfile:
                                                my_customer_file.write(line)
                                            my_customer_file.close()
                                            
                                            
                                            print("You have successfully update your details!")
                                            modifying = False #after finish updating, set modifying to false and quit this modifying section
                                            break
                                            
                                        else: #if user choose 2, that is continue modifying, the continue statement will bring the user to next loop
                                            continue #so the user can continue modify his/her detail
                                            
                                    
                                
                    
                else: #else, if customer wish to sign out, can choose 'a'
                    customer_interface = False #set these two variables to false,
                    customer = False #the program will quit he customer's interface
                    break #and bring the user to the main interface
    elif first == 2: #if new customer wish to register, can choose 2
        register = True # set register True, while this equal to true, the register section 'open'
        detail = ["","","","","","","",""] #set detail to list that contain 8 empty string, those empty string will hold each details need from user later
        while register == True:
            print("\nPlease provide us your following details: ")
            print("1 ---> Name\t:",detail[0]) #since the detail ij still contain empty string
            print("2 ---> Address\t:",detail[1]) #so it will be empty beside the printed string,
            print("3 ---> Email\t:",detail[2]) #after user input details, the program will update those details in the detail's list
            print("4 ---> Contact\t:",detail[3]) #so, the details will be printed here to let the user check if he/she got input wrong or not
            print("5 ---> Gender\t:",detail[4])
            print("6 ---> Date of birth\t:",detail[5])
            print("7 ---> User ID\t:",detail[6])
            print("8 ---> Password\t:",detail[7])
            print("\n(After done modifying your detail, please choose this selection)\n9 ---> I have done modifying my detail")
            print("\na ---> Go back to previous section\nb ---> Exit")
            print("\nPlease select a number to modify your details")
            #step: number from 1 to 8 (input details); 9 (finish input the details); a (quit this register section); b (quit this program)
            choice = simplechoice(['1','2','3','4','5','6','7','8','9','a','b','A','B']) #ask the user for next step
            if choice == '1':
                name = input("Name: ")
                for i in view_customer: #loop through the giant list
                    while i[0] == name: #check if the user name input by user has been used or not, if has, this while loop keep
                        print("Sorr, your Name has been registered by others.") #asking uer to input an user name which has not been used before
                        print("Please try again!")
                        id = input("Name: ")
                detail[0] = name #update the list in detail
            elif choice == '2':
                print("Please make sure your address is correct as it's very important for us to deliver the item to you")
                print("Example: No99,Jalan Good,Taman Best,56000,Cheras,Kuala Lumpur,Malaysia")
                address = input("Address: ")
                detail[1] = address
            elif choice == '3':
                email = "any wrong answer"
                while "@" not in email or '.com' not in email: #if user's input b not contain "@" or ".com"
                    email = input("Email: ") #this while loop keep asking user to input a proper email
                    if "@" not in email or '.com' not in email:
                        print("Please write a valid email")
                        print("Example: abcd@gamil.com")
                detail[2] = email #update the list in detail
            elif choice == '4':
                contact = "any wrong answer"
                check = check_digit(contact) #check if any character in user's input is a non-integer
                while check == False:# if has, this while loop keep asking user to input a proper contact
                    print("Make sure your number is correct\nExample: 60123456789")
                    contact = input("Contact: ")
                    check = check_digit(contact)
                    if check == False:
                        print("Sorry, invalid input. Please try again!")
                detail[3] = contact #update the list in detail
            elif choice == '5':
                print("1 ---> Male\n2 ---> Female")
                gender = 'any wrong answer'
                while gender not in ['1','2']: #if user's input is not 1 or 2
                    gender = input("Gender: ") # this while loop keep asking user to input a proper choice
                    if gender not in ['1','2']:
                        print("Sorry, invalid input. Type 1 if you are male or 2 if you are female")
                if gender == '1':
                    detail[4] = "Male" #update the list in detail
                else:
                    detail[4] = "Female" #update the list in detail
            elif choice == '6':
                datedetail = ["","",""] #set datedetail to a list contain three empty string (to store day,month,year later)
                date = True #set date to true to 'open' this date section
                while date == True:
                    print("1 ---> Day\t:",datedetail[0])
                    print("2 ---> Month\t:",datedetail[1])
                    print("3 ---> Year\t:",datedetail[2])
                    print("4 ---> Save")
                    print("\nPlease select a number to modify your date of birth")
                    #step: 1 (modify day); 2 (modify month); 3 (modify year); 4 (save)
                    number = choice_in_integer(['1','2','3','4']) #ask user for next step
                    if number == 1:
                        day = 'any wrong answer'
                        check = check_digit(day) # check the day input if contain any non-integer or not
                        while (check == False) or (int(day)<1) or (int(day)>31): #if the day exceed 31 or below 1
                            day = input("Day: ") #this while loop keep asking user to input a proper day
                            check = check_digit(day)
                            if (check == False) or (int(day)<1) or (int(day)>31):
                                print("Sorry, invalid input. Please try again")
                        datedetail[0] = day #update the list in datedetail
                       
                    elif number == 2:
                        month_list = ["Jan","Feb","Mar","Apr","May","June","July","Aug","Sept","Oct","Nov","Dec"]
                        print("1 ---> Jan\n2 ---> Feb\n3 ---> Mar\n4 ---> Apr\n5 ---> May\n6 ---> Jun\n7 ---> Jul\n8 ---> Aug\n9 ---> Sep\n10 ---> Oct\n11 ---> Nov\n12 ---> Dec")
                        month = 'any wrong answer'
                        #set month_list to a list that contain twelve month's string
                        #if user's input not in the range of 1 to 12
                        #the while loop will keep asking the user to input again
                        while month not in ['1','2','3','4','5','6','7','8','9','10','11','12']:
                            month = input("Month: ")
                            if month not in ['1','2','3','4','5','6','7','8','9','10','11','12']:
                                print("Sorry, invalid input. Please select the number probably")
                                
                        if month =='1':
                            datedetail[1] = month_list[0]#update the list in datedetail
                        elif month == '2':
                            datedetail[1] = month_list[1]#update the list in datedetail
                        elif month == '3':
                            datedetail[1] = month_list[2]#update the list in datedetail
                        elif month =='4':
                            datedetail[1] = month_list[3]#update the list in datedetail
                        elif month =='5':
                            datedetail[1] = month_list[4]#update the list in datedetail
                        elif month =='6':
                            datedetail[1] = month_list[5]#update the list in datedetail
                        elif month =='7':
                            datedetail[1] = month_list[6]#update the list in datedetail
                        elif month =='8':
                            datedetail[1] = month_list[7]#update the list in datedetail
                        elif month =='9':
                            datedetail[1] = month_list[8]#update the list in datedetail
                        elif month =='10':
                            datedetail[1] = month_list[9]#update the list in datedetail
                        elif month =='11':
                            datedetail[1] = month_list[10]#update the list in datedetail
                        else:
                            datedetail[1] = month_list[11]#update the list in datedetail
                    elif number == 3:
                        year = 'any wrong answer'
                        check = check_digit(year)
                        while check == False or len(year) != 4: #if year contain any non-integer or its length exceed 4
                            year = input("Year: ") #this while loop keep asking user to input a proper year
                            year = year.replace(' ','') #this is to replace any space in user's input in case the user
                            check = check_digit(year)   #have type the space accidentally
                            if check == False or len(year) != 4:
                                print("Sorry, invalid input. Please insert your year probable. Example: 1996")
                        datedetail[2] = year #update the list in datedetail
                    else: #if user has complete modifying the birthday date, can choose 4
                        thrity_month = ["Apr","June","Sept","Nov"] #set thirty_month to a list that contains 4 month which has only 30 days
                        if datedetail[0] == "" or datedetail[1] =="" or datedetail[2] =="":
                            print("Please make sure all the three sections are filled up probable before you save")
                        # if the datedetails contain any empty string, the date while loop will not break and will continue running asking the user
                        #to complete the birthday date
                        elif datedetail[1] == "Feb" and int(datedetail[0]) >29: #if the month is Feb and the day exceed 29, this while loop will not break also
                            print("Sorry, your day exceed the maximum days of the month, you can't save")
                            print("Please make the corrections")
                            datedetail[0] = ""
                            datedetail[1] = ""
                            
                        elif datedetail[1] in thrity_month and int(datedetail[0]) >30: #if the month is in thrity_month and the day exceed 30, this while loop will not break also
                            print("Sorry, your day exceed the maximum days of the month, you can't save")
                            print("Please makes the corrections")
                            datedetail[0] = ""
                            datedetail[1] = ""
                            
                        else: #else if eveything ok, the date will reset to false and will quit this date section
                            date_string = datedetail[0] + " " + datedetail[1] + " " + datedetail[2] #set date_string to the string we want using data in date detail
                            detail[5] = date_string #update the list in detail
                            date = False
                            break
                                
            elif choice == '7':
                id = input("User ID: ")
                for i in view_customer: #loop through the giant list
                    while i[6] == id: #check if the user id has been used before or not, if yes then continue looping
                        print("Sorr, your User ID has been used by others.")
                        print("Please try again!")
                        id = input("User ID: ") 
                detail[6] = id #update the list in detail

            elif choice == '8':
                print("Your password should have at least 8 characters.")
                password = input("Password: ")
                for i in view_customer: #loop through the giant list
                    while i[7] == password or len(password)<=8:#check if the password has been used before or not and check if the length of the password have exceed 8 or not
                        print("Sorr, your Password has been used by others or your Password is too short.")

                        print("Your password should exceed 8 characters.\nPlease try again!")
                        password = input("Password: ")
                rewrite = input("Please rewrite your password: ") #ask the user to rewrite the password
                if rewrite == password: #if rewrtie password is same as the password before
                    detail[7] = password #update the list in detail
                else:#if not, continue looping, and ask the user to try again.
                    print("Password input failed. Your rewite password is not same as password you input at the first time. Please try again!")
                
            elif choice == '9': #if user has finished filling the details, then can choose 9
                if '' not in detail: #check if any empty in detail (check the user has miss up filling details or not)
                    print("\n")
                    print("Please check your detail is correct (if has any error, input 'a' to continue modifying your details, else input 'b' to complete registeration): ")
                    print("Name\t:",detail[0])
                    print("Address\t:",detail[1])
                    print("Email\t:",detail[2])
                    print("Contact\t:",detail[3])
                    print("Gender\t:",detail[4])
                    print("Date of birth\t:",detail[5])
                    print("User ID\t:",detail[6])
                    print("Password\t:",detail[7])
                    print("\na ---> Go back to previous section\nb ---> All is done, finish registeration")
                    print("\nCheck your details carefully. If has any error, input 'a' to continue modifying your details, else input 'b' to complete registeration")
                    #step: a (continue modifying); b (finish registeration)
                    user_input = simplechoice(['a','A','B','b']) #ask user for the next step
                    if user_input == 'a': #if user wish to modify again,then the program will bring the user to next loop
                        pass
                    else: #else, update the user's detail to the text file
                        #below is same as above we have talked
                        #it's just to ready a string in a proper order and rewrite the text file with the updated details
                        string_ready_for_textfile = ''
                        for item in detail:
                            string_ready_for_textfile = string_ready_for_textfile + item + "~"
                        add_new_line = string_ready_for_textfile + "\n"
                        customer_file = open("customer.txt",mode = "a")
                        customer_file.write(add_new_line)
                        customer_file.close()
                        print("\nYou have successfully register your account!")
                        register = False #after successfully register, set register to false
                        break #quit this register section
                else: #if user has something not filled up yet
                    short_storage = ["Name","Address","Email","Contact","Gender","Date of birth","User ID","Password"] #set short_storage to a list that contain 8 string
                    count = 0 #set count = 0, this is to trace the index position of the string in short_storage
                    not_completed_detail = [] #set not_completed_detail to an empty list (store string that user has not filled up yet later)
                    for i in detail: #loop through the detail list
                        if i == '': #if element equal to an empty string
                            not_completed_detail.append(short_storage[count]) #append the specific string to not_completed_detail by using short_storage and count
                        count = count + 1 #add 1 to count every loop
                    detail_holder = "" #set detail_holder to an empty string (store string that has not been filled up yet)
                    for item in not_completed_detail: #loop through the not_completed_detail
                        detail_holder = detail_holder + " " + item #concatenate the string

                    print("\nSorry, you can't proceed with this step")
                    print("This is because your" + detail_holder + "has not been filled up yet!") #so we can stated exactly what item has not been filled up yet by user
                    print("Please complete your detail before proceed with this step.")
                                 
            elif choice == 'a': #if user not wish to register can choose a
                register = False #reset register to false and quit this register section
                break
            else:
                print("Thanks!\nHope to see you again!")
                register = False #if user wish to end the program, can choose 'b'
                shop = False #reset register to false and shop to false
                break #the program will totally end

    elif first == 3: # for admin, they can choose 3 in the main interface
        admin_detail = ['',''] #set admin_detail to a list that contain two empty string,this is to store admin's user id and password

        admin = True #set admin = True
        admin_login = True  #this use in while loop for admin to input his/her user id and password in logn's interface
        admin_interface = False # if he/she successfully log in (enter correct user id and password),  admin_login will be reset to false
                                # and admin_interface will reset to True
        while admin == True:
            while admin_login == True: 
                print("Please input your admin User ID and Password")
                print("For testing, lecturer can input like this: \nUser ID: Admin00001\nPassword:123456789")

                print("\n1 ---> User ID\t:",admin_detail[0])
                print("2 ---> Password\t:",admin_detail[1]) #it will print the element in the admin_detail
                print("3 ---> Login")
                print("\na ---> Go back to previous section\nb ---> Exit")
                print("\nPlease select 1 or 2 to input your User ID and Password: ")
            #step: 1 (modify user id); 2 (modify password); 3 (login); a ( quit this admin section and go back to main interface
                step = simplechoice(['1','2','3','a','A','b','B']) # ask admin for next step

                if step == '1':
                    user = input("User ID: ") #ask admin to input user id
                    admin_detail[0] = user #update the list in admin_datail
                elif step == '2':
                    password = input("Password: ")#ask admin to input password
                    admin_detail[1] = password #update the list in admin_datail
                elif step == '3': #after finish, admin can choose 3 to login
                    for item in admin_info: # loop throudh the admin_info giant list (set when open admin text file)
                        
                        if admin_detail[0] == item[0] and admin_detail[1] == item[1]:
                            print("\nSuccessful log in") #if admin's input is same as recorded, it means admin can successfully log in
                            admin_login = False #reset admin_login to false and admin_interface to True
                            admin_interface = True #in next loop, the program will not enter this login interface again but admin interface
                            break 
                    if admin_interface == False: #if not, the variable will be still the same and the while loop will keep asking admin to input correct id and password
                        print("Sorry, your admin User ID or password is wrong. Please try again!\n")
                            
                         
                elif step == 'a':
                    admin = False #if admin choose 'a', the variable related to admin will reset to false
                    admin_login = False #the program will quit the admin interface and bring admin to main interface
                    break
                else:
                    admin = False #if admin choose 'b', all the variable will reset to false
                    admin_login = False # the program will totally ended
                    shop = False
                    print("Thanks! Hope to see you again!")
                    break

            while admin_interface == True:
                print("\nAdmin interface:")
                print("1 ---> Grocery viewing/modification\n2 ---> Customer Order")
                print("\na ---> Sign out")
                #step: 1 (view/modify grocery); 2 (view customer order); a (sign out)
                next_step = simplechoice(['1','2','a','A']) #ask admin for next step
                if next_step == '1': #if admin wish to view/modify grocery
                    view_grocery = True #set view_grocery to true to 'open' this grocery interface
                    while view_grocery == True:
                        print("\n")
                        print("Grocery viewing/modification:")
                        print("1 ---> Grocery\n2 ---> Search specific pruducts\n\na ---> Go Back to previous section\nb ---> Sign out")
                        print("Please enter a number or an alphabet stated above.\nFor example enter '1' for viewing/modifying grocery or 'a' to go back to previous section")
                        print("Note: Only enter number or alphabet 'a' and 'b', for example enter 1 for viewing/modifying grocery or 'a' to go back to previous section")
                        #step: 1 (view/modify grocery); 2 (search specific grocery); a (quit this grocery interface); b (sign out)
                        view_choice = simplechoice(['1','2','a','b','A','B']) #ask admin for next step
                        if view_choice == '1': #if admin choose 1
                            all = True #set all to true to 'open'this interface
                            while all == True:
                                #the way showing all the groceries is just same as above, only difference is the additional option
                                #so here will explain the additional option
                                count = 0
                                print("\n")
                                print("All: ")
                                print("{0:^20} | {1:^50} | {2:<10}".format("Type","Item","Stock"))
                                for item in grocery_item_view:
                                    count = count + 1
                                    item_string = "{0} {1} {2}".format(count,"--->",item[1])
                                    print("{0:<20} | {1:-<50} | {2:<10}".format(item[0],item_string,item[4]))
                                print("\n")
                                print("a ---> Go back to previous section\nb ---> Sign out\nc ---> Upload new grocery\nd ---> Update/modify geocery information\ne ---> Delete geocery")
                                print("\nYou can choose the specific number on the left side of the item's name to view the item's detail or choose an alphabet to proceed your next step")
                                itemchoice = choice_trace(count,['a','b','A','B','c','C','d','D','e','E'])
                        #step: every number in the range of count (view the grocery detail); a (quit this view/modify grocery interface);
                        #b (sign out); c (upload new grocery); d (update/modify grocery detail); e (delete grocery)
                                if check_digit(itemchoice) == True: #check the admin's input is an integer or not
                                    item_detail = True # if yes, set item_detail to True
                                    while item_detail == True:
                                    #here is same as above we have talked
                                    #it's just print the item' detaul that admin has chosen
                                        itemchoice = int(itemchoice)
                                        print("\n")
                                        print("Type: ",grocery_item_view[itemchoice-1][0])
                                        print("Name: ",grocery_item_view[itemchoice-1][1])
                                        print("Expire date: ",grocery_item_view[itemchoice-1][2])
                                        print("Price: ",grocery_item_view[itemchoice-1][3])
                                        print("Stock: ",grocery_item_view[itemchoice-1][4])
                                        print("Specification: ",grocery_item_view[itemchoice-1][5])
                                        print("a ---> Go back to previous section\nb ---> Sign out")
                                        user_choice = input("Plase select your next step: ")
                                        #step: a (quit this viewing item detail interface); b (sig out)
                                        while user_choice not in ['a','b','A','B']:
                                            print("Sorry, invalid input. Please select an alphabet for your next step.")
                                            user_choice = input("Plase select your next step: ")
                                            user_choice = user_choice.lower()
                                        if user_choice == 'a':
                                            item_detail = False #set item_detail to false to quit this view item detail interface
                                            break
                                        else:
                                            item_detail = False
                                            all = False          #set these variables to false to quit admin interface
                                            view_grocery = False #after this, the program will bring the admin to main interface
                                            admin_interface = False
                                            admin = False
                                            break
                                else: #else if admin choose 'a', the program will set all to false
                                    if itemchoice == 'a':
                                        all = False #the program will quit this grocery interface and bring admin back
                                        break       #admin interface
                                    elif itemchoice == 'b': #else admin can choose to sign out by choosing 'b'
                                        all = False
                                        view_grocery = False
                                        admin_interface = False #these variables will reset to false and admin will sign out and return back to main interface
                                        admin = False
                                        break
                                    elif itemchoice == 'c': #if admin wish to upload grocery, can choose this
                                        upload = True #set upload to true to 'open' upload interface
                                        up_detail = ['','','','','',''] #set up_detail to a list which contains 6 empty string (hold the detail of the item)
                                        while upload == True: 
                                            print("Please fill in the following details (After complete this form, type 'b' to upload the grocery): ")
                                            print("1 ---> Type\t:",up_detail[0])
                                            print("2 ---> Name\t:",up_detail[1])
                                            print("3 ---> Expire date\t:",up_detail[2])
                                            print("4 ---> Price\t:",up_detail[3])
                                            print("5 ---> Stock\t:",up_detail[4])
                                            print("6 ---> Specification\t:",up_detail[5])
                                            print("\na ---> Go back to previous section\nb ---> upload")
                                        #step: 1 (choose type of the item); 2 (input its name); 3 (input its expire date);
                                        #4 (input its price); 5 (input its stock);6 (input its spec); a (exit this upload interface);b (confirm upload)
                                            next_step = simplechoice(['1','2','3','4','5','6','a','A','b','B']) #ask user for next step
                                            if next_step == '1':
                                                print("\n1 ---> Beverages\n2 ---> Bread/Bakery\n3 ---> Baking Ingredient\n4 ---> Canned Food\n5 ---> Cereal\n6 ---> Cooking ingredient\n7 ---> Dairy\n8 ---> Frozen Food\n9 ---> Fruit\n10 ---> Health/Beauty\n11 ---> Instant Food\n12 ---> Snack\n13 ---> Sauce/Seasoning\n14 ---> Vegetable\n15 ---> Others")
                                                print("PLease select the type of the grocery")
                                                #choose a number from 1 to 15. each number represent one type of the item
                                                admin_choice = simplechoice(['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15'])
                                                if admin_choice == '1':
                                                    up_detail[0] = "Beverages" #update the list in up_detail
                                                elif admin_choice == '2':
                                                    up_detail[0] = "Bread/Bakery" #update the list in up_detail
                                                elif admin_choice == '3':
                                                    up_detail[0] = "Baking Ingredient" #update the list in up_detail
                                                elif admin_choice == '4':
                                                    up_detail[0] = "Canned Food" #update the list in up_detail
                                                elif admin_choice == '5':
                                                    up_detail[0] = "Cereal" #update the list in up_detail
                                                elif admin_choice == '6':
                                                    up_detail[0] = "Cooking ingredient" #update the list in up_detail
                                                elif admin_choice == '7':
                                                    up_detail[0] = "Dairy" #update the list in up_detail
                                                elif admin_choice == '8':
                                                    up_detail[0] = "Frozen Food" #update the list in up_detail
                                                elif admin_choice == '9':
                                                    up_detail[0] = "Fruit" #update the list in up_detail
                                                elif admin_choice == '10':
                                                    up_detail[0] = "Health/Beauty" #update the list in up_detail
                                                elif admin_choice == '11':
                                                    up_detail[0] = "Instant Food" #update the list in up_detail
                                                elif admin_choice == '12':
                                                    up_detail[0] = "Snack" #update the list in up_detail
                                                elif admin_choice == '13':
                                                    up_detail[0] = "Sauce/Seasoning" #update the list in up_detail
                                                elif admin_choice == '14':
                                                    up_detail[0] = "Vegetable" #update the list in up_detail
                                                else: #if the item's type is not shown here, then choose this 'other' option
                                                    up_detail[0] = "Others" #update the list in up_detail
                                            elif next_step == '2':
                                                name = input("Grocery's name: ") #ask admin to input item's name
                                                up_detail[1] = name  #update the list in up_detail
                                            elif next_step == '3':
                                                #date modification is just same as above we have talked
                                                datedetail = ["","",""] 
                                                date = True
                                                while date == True:
                                                    print("1 ---> Day\t:",datedetail[0])
                                                    print("2 ---> Month\t:",datedetail[1])
                                                    print("3 ---> Year\t:",datedetail[2])
                                                    print("4 ---> Save")
                                                    print("\nPlease select a number to modify your date of birth: ")
                                                    number = choice_in_integer(['1','2','3','4'])
                                                    if number == 1:
                                                        day = 'any wrong answer'
                                                        check = check_digit(day)
                                                        while (check == False) or (int(day)<1) or (int(day)>31):
                                                            day = input("Day: ")
                                                            check = check_digit(day)
                                                            if (check == False) or (int(day)<1) or (int(day)>31):
                                                                print("Sorry, invalid input. Please try again")
                                                        datedetail[0] = day
                                                       
                                                    elif number == 2:
                                                        month_list = ["Jan","Feb","Mar","Apr","May","June","July","Aug","Sept","Oct","Nov","Dec"]
                                                        print("1 ---> Jan\n2 ---> Feb\n3 ---> Mar\n4 ---> Apr\n5 ---> May\n6 ---> Jun\n7 ---> Jul\n8 ---> Aug\n9 ---> Sep\n10 ---> Oct\n11 ---> Nov\n12 ---> Dec")
                                                        month = 'any wrong answer'
                                                        while month not in ['1','2','3','4','5','6','7','8','9','10','11','12']:
                                                            month = input("Month: ")
                                                            if month not in ['1','2','3','4','5','6','7','8','9','10','11','12']:
                                                                print("Sorry, invalid input. Please select the number probably")
                                                                
                                                        if month =='1':
                                                            datedetail[1] = month_list[0]
                                                        elif month == '2':
                                                            datedetail[1] = month_list[1]
                                                        elif month == '3':
                                                            datedetail[1] = month_list[2]
                                                        elif month =='4':
                                                            datedetail[1] = month_list[3]
                                                        elif month =='5':
                                                            datedetail[1] = month_list[4]
                                                        elif month =='6':
                                                            datedetail[1] = month_list[5]
                                                        elif month =='7':
                                                            datedetail[1] = month_list[6]
                                                        elif month =='8':
                                                            datedetail[1] = month_list[7]
                                                        elif month =='9':
                                                            datedetail[1] = month_list[8]
                                                        elif month =='10':
                                                            datedetail[1] = month_list[9]
                                                        elif month =='11':
                                                            datedetail[1] = month_list[10]
                                                        else:
                                                            datedetail[1] = month_list[11]
                                                    elif number == 3:
                                                        year = 'any wrong answer'
                                                        check = check_digit(year)
                                                        while check == False or len(year) != 4:
                                                            year = input("Year: ")
                                                            year = year.replace(' ','')
                                                            check = check_digit(year)
                                                            if check == False or len(year) != 4:
                                                                print("Sorry, invalid input. Please insert your year probable. Example: 1996")
                                                        datedetail[2] = year
                                                    else:
                                                        thrity_month = ["Apr","June","Sept","Nov"]
                                                        if datedetail[0] == "" or datedetail[1] =="" or datedetail[2] =="":
                                                            print("Please make sure all the three sections are filled up probable before you save")
                                                            

                                                        elif datedetail[1] == "Feb" and int(datedetail[0]) >29:
                                                            print("Sorry, your day exceed the maximum days of the month, you can't save")
                                                            print("Please make the corrections")
                                                            datedetail[0] = ""
                                                            datedetail[1] = ""
                                                            
                                                        elif datedetail[1] in thrity_month and int(datedetail[0]) >30:
                                                            print("Sorry, your day exceed the maximum days of the month, you can't save")
                                                            print("Please makes the corrections")
                                                            datedetail[0] = ""
                                                            datedetail[1] = ""
                                                            
                                                        else:
                                                            date_string = datedetail[0] + " " + datedetail[1] + " " + datedetail[2]
                                                            up_detail[2] = date_string
                                                            date = False
                                                            break
                                                                
                                            elif next_step == '4': 
                                                price = 'any wrong answer'
                                                price_1 = price.replace('.','') #this way to set is just to aim to remove the'.' in the price's string to access the check_digit function
                                                                                #but we want to remain the '.' in original price string,so here set a new variable to the price without '.'
                                                while check_digit(price_1) == False: #check the admin's input is an integer or not
                                                    price = input("Grocey's price :RM") #ask admin to input the price
                                                    price_1 = price.replace('.','') #remove the '.'
                                                    if check_digit(price_1)==False:
                                                        print("Please input the grocery's price probable")
                                                price = "RM" + price #add "RM" to the price string
                                                up_detail[3] = price  #update the list in up_detail
                                            elif next_step == '5':
                                                stock = 'any wrong answer'
                                                while check_digit(stock) == False: #check if the admin's input is integer or not
                                                    stock = input("Grocery's stock: ")#ask admin to input stock
                                                    if check_digit(stock)== False:
                                                        print("Sorry, invalid input. Please input the grocery's stock probable")
                                                up_detail[4] = stock  #update the list in up_detail
                                            elif next_step == '6':
                                                spec = input("Grocery's specification: ") #ask admin to input specification
                                                up_detail[5] = spec  #update the list in up_detail
                                            elif next_step == 'a':#if admin not wish to upload, then can choose 'a'
                                                upload = False # set upload to false, the program will end the upload interface
                                                break
                                            else: #if admin has completed the form, then can input 'b' to upload
                                                if '' not in up_detail: # check if admin has miss up something haven't filled up yet, if not
                                                    print("\n")
                                                    print("Please check grocery's detail is correct (if has any error, input 'a' to continue modifying the details, else input 'b' to complete uploading): ")
                                                    print("Type\t:",up_detail[0])
                                                    print("Name\t:",up_detail[1])
                                                    print("Exire date\t:",up_detail[2])
                                                    print("Price\t:",up_detail[3])
                                                    print("Stock\t:",up_detail[4])
                                                    print("Specification\t:",up_detail[5])
                                                    print("\na ---> Go back to previous section\nb ---> All is done, finish uploading")
                                                    #step: a (go back and continue modifying); b (finish uploading)
                                                    print("\nCheck the details carefully. If has any error, input 'a' to continue modifying your details, else input 'b' to complete uploading")
                                                    user_input = simplechoice(['a','b']) #ask admin for next step

                                                    if user_input == 'a':
                                                        pass #if a, then the while loop will continue to next loop, admin can continue modifying the detail
                                                    else:
                                                        #below is just same as above we have talked
                                                        #it just update the grocery text file by using the updating details in the giant string
                                                        string_ready_for_textfile = ''
                                                        up_detail.append("")
                                                        grocery_item_view.append(up_detail)
                                                        grocery_item_view = rearrange(grocery_item_view)
                                                        for item in up_detail:
                                                            if item != "":
                                                                string_ready_for_textfile = string_ready_for_textfile + item + "~"
                                                        add_new_line = string_ready_for_textfile + "\n"
                                                        grocery_file = open("grocery.txt",mode = "a")
                                                        grocery_file.write(add_new_line)
                                                        grocery_file.close()
                                                        print("\nYou have successfully uploaded a grocery!")
                                                        upload = False
                                                        break
                                                else: #if admin has miss up something and have not been filled up yet
                                                    #below is just same as above we have talke
                                                    #it just print the item that admin has not been filled up yet
                                                    #and ask the admin fill up the empty part before uploading
                                                    short_storage = ["Type","Name","Exire date","Price","Stock","Specification"]
                                                    count = 0
                                                    not_completed_detail = []
                                                    for i in up_detail:
                                                        if i == '':
                                                            not_completed_detail.append(short_storage[count])
                                                        count = count + 1
                                                    detail_holder = ""
                                                    for item in not_completed_detail:
                                                        detail_holder = detail_holder + " " + item

                                                    print("\nSorry, you can't proceed with this step")
                                                    print("This is because your" + detail_holder + "has not been filled up yet!")
                                                    print("Please complete your detail before proceed with this step.")
                                                    print("Note: If the grocary has not any specification, you can put a '-' for it")
                                                                    
                                    elif itemchoice == 'd': #if admin wish to update or modify the item detail, admin can choose 'd'
                                        update_modify = True #set update_modify to True

                                        #admin update/modify the item detail is the same thing as admin uploading the item
                                        #so here, we only explain about the difference
                                        while update_modify == True:
                                            count = 0
                                            print("\nUpdate/modify:")
                                            print("{0:^50} | {1:<10}".format("item","stock"))
                                            for item in grocery_item_view:
                                                count = count + 1
                                                item_string = "{0} {1} {2}".format(count,"--->",item[1])
                                                print("{0:-<50} | {1:<10}".format(item_string,item[4]))
                                            print("\na ---> Go back to the previous section")
                                            print("Please select the grocery you wish to update/modify (select the number at the left side of the grocery's name)\nIf you not wish to update/modify or update/modify another item again, type 'a' to quit update/modify mode")
                                            admin_choice = choice_trace(count,['a','A'])
                                      #step: every number in the range of count (choose the specific item to modify its detail); a (quit this updating section); b (finish modifying)
                                            if check_digit(admin_choice) == True: # if admin choose a number to modify the detail of a specific item
                                                updating = True #set updating to true
                                                admin_modifying = int(admin_choice) #set the admin's choice from string to integer
                                                modifying_item = grocery_item_view[admin_modifying-1] #set modifying item to the list of the specific item (the list from the giant string)
                                                grocery_item_view.pop(admin_modifying-1) #remove the list of specific item that the admin choose to modify in the giant list
                                                
                                                while updating == True:
                                                    print("1 ---> Type\t:",modifying_item[0])
                                                    print("2 ---> Name\t:",modifying_item[1])
                                                    print("3 ---> Exire date\t:",modifying_item[2])
                                                    print("4 ---> Price\t:",modifying_item[3])
                                                    print("5 ---> Stock\t:",modifying_item[4])
                                                    print("6 ---> Specification\t:",modifying_item[5])
                                                    print("\na ---> Cancel update/modify, Go back to previous section\nb ---> Done updating/modifying")
                                                    updating_detail = simplechoice(['1','2','3','4','5','6','a','A','b','B'])
                                                    if updating_detail == '1':
                                                        print("\n1 ---> Beverages\n2 ---> Bread/Bakery\n3 ---> Baking Ingredient\n4 ---> Canned Food\n5 ---> Cereal\n6 ---> Cooking ingredient\n7 ---> Dairy\n8 ---> Frozen Food\n9 ---> Fruit\n10 ---> Health/Beauty\n11 ---> Instant Food\n12 ---> Snack\n13 ---> Sauce/Seasoning\n14 ---> Vegetable\n15 ---> Others")
                                                        print("\nOriginal Type: ",modifying_item[0])
                                                        print("PLease select the type of the grocery ")
                                                        admin_choice = simplechoice(['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15'])
                                                        if admin_choice == '1':
                                                            modifying_item[0] = "Beverages"
                                                        elif admin_choice == '2':
                                                            modifying_item[0] = "Bread/Bakery"
                                                        elif admin_choice == '3':
                                                            modifying_item[0] = "Baking Ingredient"
                                                        elif admin_choice == '4':
                                                            modifying_item[0] = "Canned Food"
                                                        elif admin_choice == '5':
                                                            modifying_item[0] = "Cereal"
                                                        elif admin_choice == '6':
                                                            modifying_item[0] = "Cooking ingredient"
                                                        elif admin_choice == '7':
                                                            modifying_item[0] = "Dairy"
                                                        elif admin_choice == '8':
                                                            modifying_item[0] = "Frozen Food"
                                                        elif admin_choice == '9':
                                                            modifying_item[0] = "Fruit"
                                                        elif admin_choice == '10':
                                                            modifying_item[0] = "Health/Beauty"
                                                        elif admin_choice == '11':
                                                            modifying_item[0] = "Instant Food"
                                                        elif admin_choice == '12':
                                                            modifying_item[0] = "Snack"
                                                        elif admin_choice == '13':
                                                            modifying_item[0] = "Sauce/Seasoning"
                                                        elif admin_choice == '14':
                                                            modifying_item[0] = "Vegetable"
                                                        else:
                                                            modifying_item[0] = "Others"
                                                    elif updating_detail == '2':
                                                        print("\nOriginal name: ",modifying_item[1])
                                                        name = input("Grocery's name: ")
                                                        modifying_item[1] = name
                                                    elif updating_detail == '3':
                                                        print("\nOriginal Expire Date: ",modifying_item[2])
                                                        datedetail = ["","",""]
                                                        date = True
                                                        while date == True:
                                                            print("\n1 ---> Day\t:",datedetail[0])
                                                            print("2 ---> Month\t:",datedetail[1])
                                                            print("3 ---> Year\t:",datedetail[2])
                                                            print("4 ---> Save")
                                                            print("\nPlease select a number to modify your date of birth: ")
                                                            number = choice_in_integer(['1','2','3','4'])
                                                            if number == 1:
                                                                day = 'any wrong answer'
                                                                check = check_digit(day)
                                                                while (check == False) or (int(day)<1) or (int(day)>31):
                                                                    day = input("Day: ")
                                                                    check = check_digit(day)
                                                                    if (check == False) or (int(day)<1) or (int(day)>31):
                                                                        print("Sorry, invalid input. Please try again")
                                                                datedetail[0] = day
                                                               
                                                            elif number == 2:
                                                                month_list = ["Jan","Feb","Mar","Apr","May","June","July","Aug","Sept","Oct","Nov","Dec"]
                                                                print("1 ---> Jan\n2 ---> Feb\n3 ---> Mar\n4 ---> Apr\n5 ---> May\n6 ---> Jun\n7 ---> Jul\n8 ---> Aug\n9 ---> Sep\n10 ---> Oct\n11 ---> Nov\n12 ---> Dec")
                                                                month = 'any wrong answer'
                                                                while month not in ['1','2','3','4','5','6','7','8','9','10','11','12']:
                                                                    month = input("Month: ")
                                                                    if month not in ['1','2','3','4','5','6','7','8','9','10','11','12']:
                                                                        print("Sorry, invalid input. Please select the number probably")
                                                                        
                                                                if month =='1':
                                                                    datedetail[1] = month_list[0]
                                                                elif month == '2':
                                                                    datedetail[1] = month_list[1]
                                                                elif month == '3':
                                                                    datedetail[1] = month_list[2]
                                                                elif month =='4':
                                                                    datedetail[1] = month_list[3]
                                                                elif month =='5':
                                                                    datedetail[1] = month_list[4]
                                                                elif month =='6':
                                                                    datedetail[1] = month_list[5]
                                                                elif month =='7':
                                                                    datedetail[1] = month_list[6]
                                                                elif month =='8':
                                                                    datedetail[1] = month_list[7]
                                                                elif month =='9':
                                                                    datedetail[1] = month_list[8]
                                                                elif month =='10':
                                                                    datedetail[1] = month_list[9]
                                                                elif month =='11':
                                                                    datedetail[1] = month_list[10]
                                                                else:
                                                                    datedetail[1] = month_list[11]
                                                            elif number == 3:
                                                                year = 'any wrong answer'
                                                                check = check_digit(year)
                                                                while check == False or len(year) != 4:
                                                                    year = input("Year: ")
                                                                    year = year.replace(' ','')
                                                                    check = check_digit(year)
                                                                    if check == False or len(year) != 4:
                                                                        print("Sorry, invalid input. Please insert your year probable. Example: 1996")
                                                                datedetail[2] = year
                                                            else:
                                                                thrity_month = ["Apr","June","Sept","Nov"]
                                                                if datedetail[0] == "" or datedetail[1] =="" or datedetail[2] =="":
                                                                    print("Please make sure all the three sections are filled up probable before you save")
                                                                    

                                                                elif datedetail[1] == "Feb" and int(datedetail[0]) >29:
                                                                    print("Sorry, your day exceed the maximum days of the month, you can't save")
                                                                    print("Please make the corrections")
                                                                    datedetail[0] = ""
                                                                    datedetail[1] = ""
                                                                    
                                                                elif datedetail[1] in thrity_month and int(datedetail[0]) >30:
                                                                    print("Sorry, your day exceed the maximum days of the month, you can't save")
                                                                    print("Please makes the corrections")
                                                                    datedetail[0] = ""
                                                                    datedetail[1] = ""
                                                                    
                                                                else:
                                                                    date_string = datedetail[0] + " " + datedetail[1] + " " + datedetail[2]
                                                                    modifying_item[2] = date_string
                                                                    date = False
                                                                    break
                                                                    #"2250"  integer
                                                    elif updating_detail == '4':
                                                        print("\nOriginal Price: ",modifying_item[3])
                                                        price = 'any wrong answer'
                                                        price_1 = price.replace('.','')
                                                        while check_digit(price_1) == False:
                                                            price = input("Grocey's price :RM")
                                                            price_1 = price.replace('.','')
                                                            if check_digit(price_1)==False:
                                                                print("Please input the grocery's price probable")
                                                        price = "RM" + price
                                                        modifying_item[3] = price
                                                    elif updating_detail == '5':
                                                        print("\nOriginal Stock: ",modifying_item[4])
                                                        stock = 'any wrong answer'
                                                        while check_digit(stock) == False:
                                                            stock = input("Grocery's stock: ")
                                                            if check_digit(stock)== False:
                                                                print("Sorry, invalid input. Please input the grocery's stock probable")
                                                        modifying_item[4] = stock
                                                    elif updating_detail == '6':
                                                        print("\nOriginal Specification: ",modifying_item[5])
                                                        spec = input("Grocery's specification: ")
                                                        modifying_item[5] = spec
                                                    elif updating_detail == 'a':
                                                        updating = False
                                                        break
                                                    else:
                                                        grocery_item_view.append(modifying_item)
                                                        grocery_item_view = rearrange(grocery_item_view)
                                                        string_ready_to_grocery_textfile = []
                                                        for item in grocery_item_view:
                                                            item.pop(-1)
                                                            mystring = ""
                                                            for x in item:
                                                                mystring = mystring + x + "~"
                                                            final = mystring + "\n"
                                                            string_ready_to_grocery_textfile.append(final)
                                                            item.append("")
                                                        my_grocery_file = open("grocery.txt",mode="w")
                                                        for line in string_ready_to_grocery_textfile:
                                                            my_grocery_file.write(line)
                                                        my_grocery_file.close()
                                                        print("\nYou have successfully update the detail of the grocery!")
                                                        print("You can continue modifying or quit this modifying mode by typing 'a'")
                                                        updating = False
                                                        break
                                          
                                            else: # if admin not wish to update/modify, then choose 'a' to close this update section
                                                update_modify = False #set update_modify to false
                                                break
                                        
                                    else: #if admin wish to delete the grocery the can choose 'e'
                                        #delete grocery
                                        deleting = True #set deleting to true to 'open' delete interface
                                        while deleting == True:
                                            #--------------------------------------------------------------------------
                                            count = 0 #this section is to print all the item, we have explained above
                                            print("\nDelete:")
                                            print("{0:^50} | {1:<10}".format("item","stock"))
                                            for item in grocery_item_view:
                                                count = count + 1
                                                item_string = "{0} {1} {2}".format(count,"--->",item[1])
                                                print("{0:-<50} | {1:<10}".format(item_string,item[4]))
                                            print("\na ---> Go back to the previous section")
                                            print("Please select the grocery you wish to delete (select the number at the left side of the grocery's name)\nIf you not wish to delete or delete another item again, type 'a' to quit deleting mode")
                                           #----------------------------------------------------------------------------------
                                            #step: every number in the range of count (choose the specific item to delete); a (go back and exit this delete interface)
                                            delete_choice = choice_trace(count,['a','A']) #ask admin for next step
                                            if check_digit(delete_choice) == True: #if admin's input is an integer, its mean admin has chosen a specific grocery to delete
                                                delete_choice = int(delete_choice) #set admin's choice to integer
                                                print("Are you sure want to delete",grocery_item_view[delete_choice - 1][1],"?")
                                                print("1 ---> Yes\n2 ---> No") #ask admin if he/she sure to delete the item
                                                sure_or_not = simplechoice(['1','2']) #ask admin for next step
                                                if sure_or_not == '1': #if admin sure to delete the grocery
                                                    grocery_item_view.pop(delete_choice - 1) #remove the list of the chosen item in the giant string
                                                    #below is the same as we have explained above
                                                    #it's to rewrtie the grocey text file with updating detail in the giant string
                                                    string_ready_to_grocery_textfile = []
                                                    for item in grocery_item_view:
                                                        item.pop(-1)
                                                        mystring = ""
                                                        for x in item:
                                                            mystring = mystring + x + "~"
                                                        final = mystring + "\n"
                                                        string_ready_to_grocery_textfile.append(final)
                                                        item.append("")
                                                    my_grocery_file = open("grocery.txt",mode="w")
                                                    for line in string_ready_to_grocery_textfile:
                                                        my_grocery_file.write(line)
                                                    my_grocery_file.close()
                                                    print("You have successfully deleted the item!")
                                                else: #if admin not sure to delete the grocery, then the loop will bring the admin back to delete interface to choose any item to delete
                                                    pass #or go back to view grocery interface by typing 'a'
   
                                            else: #if admin not wish to delete grocery, then input 'a' to close the delete interface
                                                deleting = False # and back to view grocery interface
                                                break
                                            
                                                
                        elif view_choice == '2': #if admin wish to search specific grocery, they can choose 2
                            search = True #set search to true to 'open' the search omterface
                            while search == True:
                                searched_item = [] #set searched_item to empty list
                                print("\n")
                                print("Please type the item's name you wish to search")
                                print("Note: you can type with upper case or lower case, but make sure the spelling is correct!")
                                search = input("Search: ") #get the search from the admin (grocery's name)
                                search = search.lower() #set the search to lower case
                                for item in grocery_item_view: #using for loop to loop through all the item in the giant string
                                    x = item[1].lower() #set the item's name to a variable which has already made it to lower case
                                    if search in x: #if the item's name is same as search
                                        searched_item.append(item) #append the item to the searched_item
                                show_item = True #set show_item to true to 'oepn' the searched result interface
                                while show_item == True:
                                    count = 0 #set count to 0 (this count is to trace the number of the searched item
                                    print("\n")
                                    print("You have searched",len(searched_item),"results :")
                                    print("{0:<20} | {1:<50} | {2:<8}".format("Type","Name","Price"))
                                    for item in searched_item: #loop through all the result in searched item
                                        count = count + 1 #for each loop, add 1 to the count
                                        if item[4] == '0': # if the stock is 0, then print out of stock
                                            mystring = str(count) + " ---> " + item[1] + " (Out of stock)"
                                            print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                                        else:
                                            mystring = str(count) + " ---> " + item[1]
                                            print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                                    print("\n")
                                    print("a ---> Go back to previous section")
                                    print("\nYou can choose the specific number on the left side of the item's name to view the item's detail")
                                    #step: every number in the range of count (view the detail of the specific grocery); a (exit this search interface)
                                    itemchoice = choice_trace(count,['a','A']) #ask admin for next step
                                    if check_digit(itemchoice) == True: #if admin's choice is an integer, means he/she wish to view the detail of the specific grocery
                                        item_detail = True #set item detail to true to 'open' view detail interface
                                        while item_detail == True:
                                            itemchoice = int(itemchoice) #set the choice froma string to an integer
                                            display_item_detail(itemchoice,searched_item) #call the function to print the detail of the chosen grocery
                                            print("a ---> Go back to previous section")
                                            user_choice = input("Plase select your next step: ") # ask user for next step
                                            #step: a (exit the view detail interface)
                                            while user_choice not in ['a','A']: #if admin's input not 'a'
                                                    print("Sorry, invalid input. Please select an alphabet for your next step.")
                                                    user_choice = input("Plase select your next step: ")#the while loop will keep asking admin to input again
                                                    user_choice = user_choice.lower() #set the admin input to lower case
                                            if user_choice == 'a':
                                                item_detail = False #then, if admin's input is 'a', st item_detail to false and exit the view detail interface
                                                break
                                    else:
                                        if itemchoice == 'a': #if admin not wish to search the item's detail, can input 'a'
                                            search = False #set these two variables to false and exit the search interface
                                            show_item = False
                                            break
                        elif view_choice == 'a':
                            view_grocery = False
                            break
                        else:
                            view_grocery = False
                            admin_interface = False
                            admin = False
                            break
                        
                elif next_step == '2':
                    order = True #set order to true to 'open' the order interface
                    while order == True:
                        print("\nOrder:")
                        print("1 ---> Pending to deliver\n2 ---> View customer's order\n3 ---> Search customer order\n")
                        print("a ---> Go Back to previous section\nb ---> Sign out")
                        print("\nPlease enter a number or an alphabet stated above.\nFor example enter '1' for viewing the item pending to deliver or 'a' to go back to prtvious section")
                        #step: 1 (set itema s delivered); 2 (view customer's order); 3 (search specific customer order)
                        choice = simplechoice(['1','2','3','a','A','b','B']) #ask admin for next step
                        if choice == '1': #if admin has deliverd the item to customer, he/she can input 1
                            pending = True #set pending to true to 'oepn' pending interface
                            while pending == True:
                                not_delivered = [] #Set not_delivered to an empty list (later will store the item that have not been delivered)
                                for item in order_info: #loop through all the item in the order_info giant string
                                    if item[5] == "paid" and item[6] == "not delivered" and item[7] == "not received":
                                        not_delivered.append(item) #if the item's status is paid,not delivered and not received, append the item to not_delivered list
                                print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format("customer","Item","Quantity","Address"))
                                count = 0 #set count to 0, this is to trace the number of the not delivered item
                                for i in not_delivered: #loop through all the item in the not_delivered list
                                    not_delivered_item = [] #set not_delivered_item to an empty list, later is to store the not delivered item after the item and its quantity is separated
                                   
                                    stick = i[1].split(",") #the item part in text file is recorded like this, "pepsi=2,soya=5", thus split the item using the seperator ","
                                    for r in stick: #loop through the item in stick (in the stick --> ["pepsi=2","soya=5"]
                                        item_stock = r.split("=")#we need to seperate the item and its quantity, so split again using seperator "="
                                        not_delivered_item.append(item_stock) #append the final item to not_delivered_item (in not_delivered_item --> ["pepsi","2","soya","5"]
                                    count = count + 1 #for each loop, add one to the count

                                    # the part below we have explaned it above in the customer's view order section
                                    if len(not_delivered_item) == 1:
                                        mystring = str(count) + " ---> " + i[0]
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(mystring,not_delivered_item[0][0],not_delivered_item[0][1],i[2]))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(i[3],'','',''))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(i[4],'','',''))
                                        print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^60}".format(''))
                                    elif len(not_delivered_item) == 2:
                                        mystring = str(count) + " ---> " + i[0]
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(mystring,not_delivered_item[0][0],not_delivered_item[0][1],i[2]))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(i[3],not_delivered_item[1][0],not_delivered_item[1][1],''))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(i[4],'','',''))
                                        print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^60}".format(''))
                                    elif len(not_delivered_item) == 3:
                                        mystring = str(count) + " ---> " + i[0]
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(mystring,not_delivered_item[0][0],not_delivered_item[0][1],i[2]))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(i[3],not_delivered_item[1][0],not_delivered_item[1][1],''))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(i[4],not_delivered_item[2][0],not_delivered_item[2][1],''))
                                        print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^60}".format(''))
                                    else:
                                        mystring = str(count) + " ---> " + i[0]
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(mystring,not_delivered_item[0][0],not_delivered_item[0][1],i[2]))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(i[3],not_delivered_item[1][0],not_delivered_item[1][1],''))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format(i[4],not_delivered_item[2][0],not_delivered_item[2][1],''))
                                        n = 0
                                        while n<=2:
                                            not_delivered_item.pop(0)
                                            n=n+1
                                        counting = 0
                                        for i in not_delivered_item:
                                            print("{0:<20} | {1:^40} | {2:^8} | {3:^60}".format('',i[counting],i[counting+1],''))
                                            counting = counting+2
                                        print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^60}".format(''))

                                print("a ---> Go back to the previous section")
                                print("If the company has sent the item, select the number at the left side of the customer's name, else you can type 'a' to leave this section:")
                                #step: every number in the range of count (to choose spefic item that has been delivered);  a (exit this pending interface)
                                delivered_or_not = choice_trace(count,['a','A']) #ask admin for next step
                                if check_digit(delivered_or_not) == True: #if admin's input is an interger, it means he/she wish to set a specific item as delivered
                                    for r in order_info: #loop through the item in order_info giant list
                                        if not_delivered[int(delivered_or_not)-1] == r: #check if the list of the chosen item is the same as the item in  of the giant list in looping
                                            position = order_info.index(r) #if found the item, get the index position of the list
                                            order_info[position][6] = "delivered" #set the status in the giant list as "delivered
                                    #below part we have explained above
                                    # it's to rewrite the order text file using the updated detail in the giant list
                                    string_ready_to_order_textfile = []
                                    for item in order_info:
                                        item.pop(-1)
                                        mystring = ""
                                        for x in item:
                                            mystring = mystring + x + "~"
                                        final = mystring + "\n"
                                        string_ready_to_order_textfile.append(final)
                                        item.append("")
                                    my_order_file = open("order.txt",mode="w")
                                    for line in string_ready_to_order_textfile:
                                        my_order_file.write(line)
                                    my_order_file.close()
                                    print("You have successfully marked the item as delivered!")
                                else:        #if admin not wish to set the item as delivered, he/she can quitthie pending interface by input 'a'      
                                    pending = False #set pending to false,the program will bring the admin out to order interface
                                    break
                                        
                        elif choice == '2':
                            viewing = True #set viewing to true to 'open' view order interface
                            while viewing == True:
                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format("customer","Item","Quantity","Status","Address"))
                                count = 0 #set count to 0 to trace the number of order
                                for i in order_info: #loop through all the item in the order_info giant string
                                    order_item = [] #set order_item to an empty list (store the item in order_jnfo)
                                    stick = i[1].split(",")#the item part in text file is recorded like this, "pepsi=2,soya=5", thus split the item using the seperator ","
                                    for r in stick: #loop through the item in stick (in the stick --> ["pepsi=2","soya=5"]
                                        item_stock = r.split("=") #we need to seperate the item and its quantity, so split again using seperator "="
                                        order_item.append(item_stock) #append the final item to order_item (in order_item --> ["pepsi","2","soya","5"]
                                    count = count + 1 #for each loop, add 1 to the count
                                    # the part below we have explaned it above in the customer's view order section
                                    if len(order_item) == 1:
                                        mystring = str(count) + " ---> " + i[0]
                                        #5,6,7
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(mystring,order_item[0][0],order_item[0][1],i[5],i[2]))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(i[3],'','',i[6],''))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(i[4],'','',i[7],''))
                                        print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^15} | {0:-^60}".format(''))
                                    elif len(order_item) == 2:
                                        mystring = str(count) + " ---> " + i[0]
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(mystring,order_item[0][0],order_item[0][1],i[5],i[2]))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(i[3],order_item[1][0],order_item[1][1],i[6],''))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(i[4],'','',i[7],''))
                                        print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^15} | {0:-^60}".format(''))
                                    elif len(order_item) == 3:
                                        mystring = str(count) + " ---> " + i[0]
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(mystring,order_item[0][0],order_item[0][1],i[5],i[2]))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(i[3],order_item[1][0],order_item[1][1],i[6],''))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(i[4],order_item[2][0],order_item[2][1],i[7],''))
                                        print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^15} | {0:-^60}".format(''))
                                    else:
                                        mystring = str(count) + " ---> " + i[0]
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(mystring,order_item[0][0],order_item[0][1],i[5],i[2]))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(i[3],order_item[1][0],order_item[1][1],i[6],''))
                                        print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(i[4],order_item[2][0],order_item[2][1],i[7],''))
                                        n = 0
                                        while n<=2:
                                            order_item.pop(0)
                                            n=n+1
                                        counting = 0
                                        for r in order_item:
                                            print("{0:<20} | {1:^40} | {2:^8} | {0:^15} | {0:^60}".format('',r[counting],r[counting+1]))
                                            counting = counting+2
                                        print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^15} | {0:-^60}".format(''))
                                print("\na ---> Go back to previous section")
                                print("\nPlease input 'a' to quit this section if you have done viewing all the order of the customer.")
                                #step: a (quit the view order interface)
                                choice = simplechoice(['a','A']) #ask admin for next step
                                if choice == 'a': #if admin's input is 'a'
                                    viewing = False #reset viewing to false, quit the view order interface
                                    break  #the program will bring the admin back to order interface
                                   
                        elif choice == '3': #if admin wish to search a specific customer's order, the choose 3
                            search = True  #set search to true
                            while search == True:
                                searched_item = [] #set searched_item to an empty list
                                print("\n")
                                print("Please type the customer's name you wish to search")
                                print("Note: you can type with upper case or lower case, but make sure the spelling is correct!")
                                search = input("Search: ") #ask admin to input customer's name
                                search = search.lower() #set the input to lower case
                                for item in order_info: #loop through all the item in order_info giant list
                                    x = item[0].lower() #set the customer's name in giant string to a new variable after make them into lower case
                                    if search in x: #check if the search input is same with x or not
                                        searched_item.append(item) # if same, append the list to searched_item from order_info giant list
                                show_customer = True # set show customer to true to 'open' view customer order interface
                                while show_customer == True:
                                    count_1 = 0 #set count_1 to 0, this is to trace the number of the item in searched_item
                                    print("\n")
                                    print("You have searched",len(searched_item),"results :")
                                    for i in searched_item:
                                        count_1 = count_1 + 1
                                        print(count_1,"--->",i[0])
                                    print("\n")
                                    print("a ---> Go back to previous section")
                                    print("You can select the number beside the customer's name to view his/her order")
                                    #step: every number in the range of count (view the order of the specific customer); a (exit the view customer order interface)
                                    search_choice = choice_trace(count_1,['a','A']) #ask admin for next step
                                    if check_digit(search_choice) == True: #check whether the admin's input is an integer or not
                                        show_order = True #if yes, then set show_order to true to 'open' show order interface

                                        #below is the part we have explained above at the customer view own order section
                                        while show_order == True:
                                            search_choice = int(search_choice)
                                            order_item = []
                                            stick = searched_item[search_choice-1][1].split(",")
                                            for r in stick:
                                                item_stock = r.split("=")
                                                order_item.append(item_stock)
                                            print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format("customer","Item","Quantity","Status","Address"))
                                            if len(order_item) == 1:
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][0],order_item[0][0],order_item[0][1],searched_item[search_choice-1][5],searched_item[search_choice-1][2]))
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][3],'','',searched_item[search_choice-1][6],''))
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][4],'','',searched_item[search_choice-1][7],''))
                                                print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^15} | {0:-^60}".format(''))
                                            elif len(order_item) == 2:
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][0],order_item[0][0],order_item[0][1], searched_item[search_choice-1][5], searched_item[search_choice-1][2]))
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][3],order_item[1][0],order_item[1][1], searched_item[search_choice-1][6],''))
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][4],'','', searched_item[search_choice-1][7],''))
                                                print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^15} | {0:-^60}".format(''))
                                            elif len(order_item) == 3:
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][0],order_item[0][0],order_item[0][1], searched_item[search_choice-1][5], searched_item[search_choice-1][2]))
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][3],order_item[1][0],order_item[1][1],searched_item[search_choice-1][6],''))
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][4],order_item[2][0],order_item[2][1],searched_item[search_choice-1][7],''))
                                                print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^15} | {0:-^60}".format(''))
                                            else:
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][0],order_item[0][0],order_item[0][1],searched_item[search_choice-1][5],searched_item[search_choice-1][2]))
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][3],order_item[1][0],order_item[1][1],searched_item[search_choice-1][6],''))
                                                print("{0:<20} | {1:^40} | {2:^8} | {3:^15} | {4:^60}".format(searched_item[search_choice-1][4],order_item[2][0],order_item[2][1],searched_item[search_choice-1][7],''))
                                                n = 0
                                                while n<=2:
                                                    order_item.pop(0)
                                                    n=n+1
                                                counting = 0
                                                for i in order_item:
                                                    print("{0:<20} | {1:^40} | {2:^8} | {0:^15} | {0:^60}".format('',i[counting],i[counting+1]))
                                                    counting = counting+2
                                                print("{0:-<20} | {0:-^40} | {0:-^8} | {0:-^15} | {0:-^60}".format(''))
                                            print("\na ---> Go back to previous section")
                                            print("\nPlease input 'a' to quit this section if you have done viewing all the order of the customer.")
                                            #step: a (quit the view customer order interface)
                                            choice = simplechoice(['a','A']) #ask the admin for next step
                                            if choice == 'a': #if admin's input is 'a'
                                                show_order = False #set show_order to false
                                                break #the program will bring admin back to order interface
                                    else: #if admin not wish to view customer's order, can input 'a' to quit the view customer order section
                                        show_customer = False #set show_order to false
                                        break #the program will bring admin back to order interface
                                                                                     
                        elif choice == 'a':
                            order = False
                            break
                        else:
                            order = False
                            admin_interface = False
                            admin = False
                            break
                else: #if admin wish to log out, can choose 'a' in admin interface
                    admin_interface = False #reset admin_interface and admin to false
                    admin = False  #the program will bring the admin back to the main interface
                    break

    elif first == 4: #if not registered customer wish to view groceries, can choose 4
        view_grocery = True #set  view_grocery to true to 'open' view grocery interface
        while view_grocery == True:
            print("\n")
            print("View groceries: ")
            print("1 ---> view all groceries\n2 ---> Search specific grocery\n\na ---> Go Back to previous section\nb ---> exit\n")
            #step: 1 (view all groceries); 2 (search specific grocery); a (go back to mai interface); b (exit the program)
            view_choice = simplechoice(['1','2','a','b','A','B']) #ask user for next step
            print("Please enter a number or an alphabet stated above.\nFor example enter '1' for searching specific items or 'a' to go back to prtvious section")
            print("Note: Only enter number or alphabet 'a' and 'b', for example enter 1 for searching specific items or 'a' to go back to prtvious section")
            if view_choice == '1':
                all = True #if user wish to view all groceries, then choose 1
                while all == True:
                    count = 0 #set count to 0, this is to trace the number of the grocery
                    print("\n")
                    print("All: ")
                    print("{0:<20} | {1:<50} | {2:<8}".format("Type","Name","Price"))
                    for item in grocery_item_view: #loop through all the groceries in the giant string
                        count = count + 1 #for each loop, add 1 to the count
                        if item[4] == '0': #if stock in the giant string (from the text file) is 0, then print out of stock
                            mystring = str(count) + " ---> " + item[1] + " (Out of stock)"
                            print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                        else:
                            mystring = str(count) + " ---> " + item[1]
                            print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                    print("\n")
                    print("a ---> Go back to previous section")
                    print("b ---> Exit\n")
                    print("\nYou can choose the specific number on the left side of the item's name to view the item's detail")
                    #step: every number in the range of count (view the detail of the specific grocery); a (go back to view grocery interface); b (exit the program)
                    itemchoice = choice_trace(count,['a','b','A','B'])#ask user for next step
                    if check_digit(itemchoice) == True: #check if the user's input is an integer
                        item_detail = True #if yes, set item detail to true to 'open' view item detail interface
                        #below part we have explained above
                        while item_detail == True:
                            itemchoice = int(itemchoice) #set the user choice from string to an integer
                            print("\n")
                            print("Type: ",grocery_item_view[itemchoice-1][0])
                            print("Name: ",grocery_item_view[itemchoice-1][1])
                            print("Expire date: ",grocery_item_view[itemchoice-1][2])
                            print("Price: ",grocery_item_view[itemchoice-1][3])
                            print("Stock: ",grocery_item_view[itemchoice-1][4])
                            print("Specification: ",grocery_item_view[itemchoice-1][5])
                            print("a ---> Go back to previous section\nb ---> Exit")
                            #step: a (go back to view grocery interface); b (exit the program)
                            user_choice = simplechoice(['a','b','A','B']) #ask user for the next step
                            if user_choice == 'a': #if user choose 'a', then reset item detail to false
                                item_detail = False #the program will bring the user back to view order interface
                                break
                            else: #if user choose 'c', then reset these variables to false, this will close the entire progra,
                                item_detail = False
                                all = False
                                view_grocery = False
                                shop = False
                                print("Thanks!\nHope to see you again!")
                                break
                    else: #if user not wish to view grocery, user can input 'a' to exit the view grocery interface
                        if itemchoice == 'a':
                            all = False #reset all to false, the program will bring the user to the main interface
                            break
                        else: #if user wish to exit the entire program, can choose 'b'
                            all = False #then these variables will be reset to false
                            view_grocery = False
                            shop = False
                            print("Thanks!\nHope to see you again!")
                            break
            elif view_choice == '2': #if user wish to search a spefcific grocery, then choose 2
                search = True #set search to True to 'open' the search interface
                while search == True:
                    searched_item = [] #set searched_item to an empty list
                    print("\n")
                    print("Please type the item's name you wish to search")
                    print("Note: you can type with upper case or lower case, but make sure the spelling is correct!")
                    search = input("Search: ") #ask user to input grocery's name
                    search = search.lower() #set the input to lower case
                    for item in grocery_item_view: #loop through all the item in grocery_item_view giant list
                        x = item[1].lower() #set the grocery's name in giant string to a new variable after make them into lower case
                        if search in x: #check if the search input is same with x or not
                            searched_item.append(item) # if same, append the list to searched_item from grocery_item_view giant list
                    show_item = True # set show customer to true to 'open' view searched grocery interface
                    while show_item == True:
                        count = 0 #set count to 0, this is to trace the number of the item in searched_item
                        print("\n")
                        print("You have searched",len(searched_item),"results :")
                        print("{0:<20} | {1:<50} | {2:<8}".format("Type","Name","Price"))
                        for item in searched_item:
                            count = count + 1
                            if item[4] == '0':
                                mystring = str(count) + " ---> " + item[1] + " (Out of stock)"
                                print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                            else:
                                mystring = str(count) + " ---> " + item[1]
                                print("{0:<20} | {1:<50} | {2:<8}".format(item[0],mystring,item[3]))
                        print("\n")
                        print("a ---> Go back to previous section")
                        print("b ---> Exit\n")
                        print("\nYou can choose the specific number on the left side of the item's name to view the item's detail")
                        #step: every number in the range of count (view the detail of the specific grocery); a (exit the search interface); b (exit the entire program)
                        itemchoice = choice_trace(count,['a','b','A','B']) #ask the user for next step
                        if check_digit(itemchoice) == True: #check if the user's input is an integer or not
                            item_detail = True #if yes, set item detail to true to 'open' view grocery detail interface
                            while item_detail == True:
                                itemchoice = int(itemchoice) #set the user;s choice to an integer
                                display_item_detail(itemchoice,searched_item) #call the function to print the grocery detail
                                print("a ---> Go back to previous section\nb ---> Exit")
                                #steo: a (go back to view grocery interface); b (exit the entire program)
                                user_choice = simplechoice(['a','b','A','B']) #ask user for the next step
                                if user_choice == 'a': #if user choose 'a', then reset item detail to false
                                    item_detail = False #the program will bring the user exit the view grocery detail interface and back to view grocery interface
                                    break
                                else: #if user choose 'b', then these variables will reset to false
                                    item_detail = False #this will close the entire program
                                    show_item = False
                                    search = False
                                    view_grocery = False
                                    shop = False
                                    print("Thanks!\nHope to see you again!")
                                    break
                        else: #if user not wish to search grocery, then choose 'a' to go back to the view grocery interface
                            if itemchoice == 'a':
                                show_item = False #these two variable wll be reset to false
                                search = False
                                break
                            else: # if user wish to cloase the entire program, then choose ;b;
                                show_item = False #these variables will be reset to false
                                searchss = False
                                view_grocery = False
                                shop = False
                                print("Thanks!\nHope to see you again!")
                                break
            elif view_choice == 'a': #if the user not wish to view grocery, can choose 'a' go back to main interface
                view_grocery = False #view_grocery will be reset to falose
                break
            else: # if user wish to exit the entire program, can choose 'b'
                view_grocery = False #these two variables will be reset to false
                shop = False
                print("Thank!\nHope to see you again!")
                break
    else: #at main interface, user can choose 5 to exit the entire program
        shop = False
        print("Thanks!\nHope to see you again!")
        break
    

