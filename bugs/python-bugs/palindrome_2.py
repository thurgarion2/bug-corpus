def is_palindrome(sentence : str, f):
    alphabetical = filter(f, sentence)
    lowercase = str(alphabetical).lower() ## you should join instead
    for idx in range(len(lowercase)):
        if lowercase[idx] != lowercase[len(lowercase)-idx-1]:
            return False
        return True

def is_alphabetical(character : str):
    return character not in [' ', ',', '-','\'']

if __name__=='__main__':
    print('Entrez un mot ou une phrase :')
    sentence = input()
    print(is_palindrome(sentence, is_alphabetical))