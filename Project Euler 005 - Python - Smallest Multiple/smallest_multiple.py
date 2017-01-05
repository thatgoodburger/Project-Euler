def main():
    args = get_input()

    for i in args:
        print(smallest_multiple(i))


# Ask for a list of numbers from the user and return as an array
def get_input():
    num_args = int(input("Enter the number of test items:\n"))
    args = []

    for i in range(0, num_args):
        args.append(int(input("Enter the number to test:\n")))
    return args


def smallest_multiple(a):
    product = 1
    for i in range(1, a+1):
        greatest_factor = gcd(product, i) if product > i else gcd(i, product)
        product *= (i / greatest_factor)
    return product


def gcd(x, y):
    while y > 0:
        x, y = gcd_step(x, y)
    return x


def gcd_step(x, y):
    temp = y
    y = x % y
    x = temp
    return x, y


if __name__ == '__main__':
    main()
