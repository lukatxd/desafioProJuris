package br.com.projuris;

public class MyFindArray implements FindArray {

	@Override
	public int findArray(int[] array, int[] subArray) {
		int matchingIndex = -1;

		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
			for(int subArrayIndex =0 ;
					subArrayIndex < subArray.length 
					&& arrayIndex+subArrayIndex < array.length
					&& array[arrayIndex+subArrayIndex] == subArray[subArrayIndex] ;
					subArrayIndex ++) {
				if(subArrayIndex+1 == subArray.length) {
					matchingIndex = arrayIndex;
				}
			}
		}

		return matchingIndex;
	}
}
