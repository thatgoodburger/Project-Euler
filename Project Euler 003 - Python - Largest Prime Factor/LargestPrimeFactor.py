from math import floor
from math import sqrt
from random import randint

FLT_LOAD = 15


def main():
    args = get_input()

    for i in range(0, len(args)):
        print(process_input(args[i]))


# Ask for a list of numbers from the user and return as an array
def get_input():
    num_args = int(input("Enter the number of test items:\n"))
    args = []

    for i in range(0, num_args):
        args.append(int(input("Enter the number to test:\n")))

    return args


# Return the largest prime factor of an input number
def process_input(input_num):
    greatest_prime = 1

    if fermat_test(input_num):
        greatest_prime = input_num

    for i in range(2, floor(sqrt(input_num))):
        # if i is a factor, then test if the numbers are prime
        if input_num % i == 0:
            prime_factor = test_factor_pair(i, input_num / i)
            if prime_factor > greatest_prime:
                greatest_prime = prime_factor

    return greatest_prime


# Return the larger of x or y if either is prime, otherwise return 0.
def test_factor_pair(x, y):
    if fermat_test(y):
        return y
    elif fermat_test(x):
        return x
    else:
        return 0


# Return true if input_num is probably prime per fermat's little theorem.
# Does NOT factor in Carmichael Numbers.
def fermat_test(input_num):
    is_prime = True

    # select a such that 1 < a < input
    for i in range(0, FLT_LOAD):
        a = randint(1, input_num - 1)
        try:
            # big_num = a ** (input_num - 1) % input_num
            big_num = pow(a, input_num - 1, input_num)
        except:
            print(a, " ", i)
            continue

        prime_indicator = big_num == 1
        is_prime = is_prime and prime_indicator
        if not is_prime:
            break

    return is_prime


if __name__ == '__main__':
    main()
