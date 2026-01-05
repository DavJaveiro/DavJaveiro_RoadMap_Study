f = open("myfile", "w")
f.write("First line with necessary newline character\n")


f.write("Second line with necessary newline character\n")
f.close()

f = open("myfile", "r")
line1 = f.readline()
line2 = f.readline()
f.close()
print(line1, line2)

import os
directory = os.getcwd() # get current working directory
print(directory)

filename = os.path.join(directory, "myfile")
print(filename)


f = open(filename, "r") # open file for reading mode
print(f.readline())
f.close()