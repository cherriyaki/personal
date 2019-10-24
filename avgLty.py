# authors: David Yin, Cherry Lim (Derry Yim)

# please replace the txt file with your own
f= open("damndog.txt","r")

contents = f.read()

string = ''
total = 0
ctr = 0
lineCtr = 1

for char in contents :
    # when space is reached
    if char == ' ' :
        try :
            # only keep the string if it has '.' 
            if '.' not in string :
                string = ''
                continue
            # if string is float, add to sum and take average
            else :
                total += float(string)
                ctr += 1
                if ctr == 6:
                    print(str(lineCtr) + ' ' + str(total/6))
                    total = 0
                    ctr = 0
                    lineCtr += 1
                string = ''
        except :
            string = ''
    # appends character to string
    else :
        string = string + char

