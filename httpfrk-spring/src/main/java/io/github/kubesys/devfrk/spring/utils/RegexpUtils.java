/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.kubesys.devfrk.spring.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author  wuheng@iscas.ac.cn
 * @version 2.3.0
 * @since   2023/06/30
 */
public class RegexpUtils {

	private RegexpUtils() {
		super();
	}

	/**
	 * @param regexp
	 * @param input
	 * @return
	 */
	public static boolean startWith(String regexp, String input) {
		Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
	}
}
