package br.com.projuris;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyFindChar implements FindCharachter{

	@Override
	public char findChar(String word) {
		Map<Character, Integer> charAndRepetition = iterateWordCountingRepetitions(word);
		return findNoRepetitionCharacter(charAndRepetition);
	}

	private Map<Character, Integer> iterateWordCountingRepetitions(String word) {
		Map<Character, Integer> charAndRepetition = new LinkedHashMap<>();
		for(int wordIndex = 0; wordIndex < word.length(); wordIndex++) {
			Integer numberOfRepetitions = charAndRepetition.get(word.charAt(wordIndex));
			if(numberOfRepetitions == null) {
				numberOfRepetitions = 0;
			}else {
				numberOfRepetitions++;
			}
			charAndRepetition.put(word.charAt(wordIndex), numberOfRepetitions);
		}
		return charAndRepetition;
	}
	
	private char findNoRepetitionCharacter(Map<Character, Integer> charAndRepetition) {
		char noRepeatitionChar = ' ';
		for(Character a : charAndRepetition.keySet()) {
			final int countingForChar = charAndRepetition.get(a);
			if(countingForChar == 0) {
				noRepeatitionChar = a;
				break;
			}
		}
		return noRepeatitionChar;
	}
}
