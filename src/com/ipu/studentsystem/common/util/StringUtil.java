
package com.ipu.studentsystem.common.util;

import com.ipu.studentsystem.common.constant.UtilityConstant;

/**
 * StringUtil is used to perform some general String operations used throughout
 * the project development
 * 
 * @author raghav
 * 
 */
public class StringUtil {

	/**
	 * Takes Strings variable arguments and return the final concatenated String
	 * 
	 * @param argumentList
	 *            : Strings to concatenate
	 * @return : concatenated String of varArgs
	 */
	public static String concatenate(String... argumentList) {
		StringBuffer concatenatedBuffer = new StringBuffer();
		for (String args : argumentList) {
			if (args == null) {
				concatenatedBuffer.append(UtilityConstant.BLANK_STRING);
			} else {
				concatenatedBuffer.append(args);
			}
		}
		return concatenatedBuffer.toString().trim();
	}
}