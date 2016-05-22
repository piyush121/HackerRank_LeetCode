import re

def compare(x, y):
    return cmp(len(x), len(y))

def filterWords(passage):
    allowedCharacters = set(['r', 's', 't', 'l', 'n', 'a', 'e', 'i', 'o', 'u'])
    words = re.split("' |, |,|\\. |\\.|\\s", passage)
    result = []
    for word in words:
        word = word.lower()
        temp = set()
        for i in xrange(0, len(word)):
            if word[i] not in allowedCharacters:
                temp.add(word[i])
            if len(temp) > 1:
                break
            if i == len(word) - 1:
                result.append(word)

    result = sorted(result, cmp=compare)
    return result

def mostCommonWord(words):
    wordCount = {}
    for word in words:
        if wordCount.__contains__(word):
            wordCount[word] += 1
        else:
            wordCount[word] = 1
    count = 0
    mostFrequentWord = ""
    for word in wordCount:
        if(wordCount[word] > count):
            count = wordCount[word]
            mostFrequentWord = word
    return mostFrequentWord

passage =  "Two households, both alike in dignity,In fair Verona, where we lay our scene,From ancient grudge break to new mutiny,Where civil blood makes civil hands unclean.From forth the fatal loins of these two foes A pair of star-cross'd lovers take their life Whose misadventured piteous overthrows Do with their death bury their parents' strife. The fearful passage of their death-mark'd love,And the continuance of their parents' rage,Which, but their children's end, nought could remove,Is now the two hours' traffic of our stage;The which if you with patient ears attend,What here shall miss, our toil shall strive to mend."

result = filterWords(passage)
print result
print "Most Common word: " + mostCommonWord(result)
