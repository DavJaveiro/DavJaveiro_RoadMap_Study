
x = ["fist", "second", "third"]
print(len(x))

l = input("Fale: ")
print(f"Você digitou {l}")

y = [-1, 9] + x

print(y)

y[0:3] = []
print(y) 



y.reverse()
print(y)

# Convert list to tuple
tuple(x)
print(x)