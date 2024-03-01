def is_palindrome(sentence : str):
    alphabetical = filter(is_alphabetical, sentence)
    lowercase = ''.join(alphabetical).lower()
    for idx in range(len(lowercase)):
        if lowercase[idx] != lowercase[len(lowercase)-idx-1]:
            return False
        return True

def is_alphabetical(character : str):
    return character in [' ', ',', '-','\''] ### should be not int

if __name__=='__main__':
    print('Entrez un mot ou une phrase :')
    sentence = input()
    print(is_palindrome(sentence))