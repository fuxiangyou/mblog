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
package me.qyh.blog.web.controller.front;

import java.io.Serializable;

import me.qyh.blog.core.entity.Space;
import me.qyh.blog.web.template.Template;

/**
 * 用来预览的模板bean
 * 
 * @author mhlx
 *
 */
public final class PreviewTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Space space;
	private final Template template;

	PreviewTemplate(Space space, Template template) {
		super();
		this.space = space;
		this.template = template;
	}

	public Space getSpace() {
		return space;
	}

	public Template getTemplate() {
		return template;
	}

}
