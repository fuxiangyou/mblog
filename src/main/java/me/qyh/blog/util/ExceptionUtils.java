/*
 * Copyright 2016 qyh.me
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.qyh.blog.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class ExceptionUtils {

	private ExceptionUtils() {

	}

	/**
	 * 获取异常集合
	 * 
	 * @param throwable
	 * @return
	 */
	public static List<Throwable> getThrowableList(Throwable throwable) {
		final List<Throwable> list = new ArrayList<Throwable>();
		while (throwable != null && list.contains(throwable) == false) {
			list.add(throwable);
			throwable = throwable.getCause();
		}
		return list;
	}

	/**
	 * 从集合中取出指定的异常
	 * 
	 * @param throwable
	 *            异常
	 * @param types
	 *            类型数组，
	 * @return
	 */
	public static Optional<Throwable> getFromChain(Throwable throwable, Class<?>... types) {
		if (throwable == null || types == null || types.length == 0) {
			return Optional.empty();
		}
		List<Throwable> throwables = getThrowableList(throwable);
		Collections.reverse(throwables);
		for (Throwable th : throwables) {
			if (matchType(th, types)) {
				return Optional.of(th);
			}
		}
		return Optional.empty();
	}

	private static boolean matchType(Throwable th, Class<?>... types) {
		return th != null && Arrays.stream(types).anyMatch(th.getClass()::equals);
	}
}
