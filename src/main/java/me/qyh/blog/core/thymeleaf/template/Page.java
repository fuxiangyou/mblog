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
package me.qyh.blog.core.thymeleaf.template;

import java.sql.Timestamp;
import java.util.Objects;

import me.qyh.blog.core.entity.BaseEntity;
import me.qyh.blog.core.entity.Space;
import me.qyh.blog.core.thymeleaf.TemplateUtils;
import me.qyh.blog.util.Validators;

public class Page extends BaseEntity implements Template {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Space space;// 所属空间
	private String tpl;// 组织片段，用来将片段组织在一起
	private String name;
	private String description;
	private Timestamp createDate;
	private String alias;
	private Boolean allowComment;// 是否允许评论

	public Page() {
		super();
	}

	public Page(Integer id) {
		super(id);
	}

	public Page(String alias) {
		this.alias = alias;
	}

	public Page(Space space, String alias) {
		this.space = space;
		this.alias = alias;
	}

	public Page(Page page) {
		this.id = page.id;
		this.space = page.space;
		this.tpl = page.tpl;
		this.name = page.name;
		this.description = page.description;
		this.createDate = page.createDate;
		this.alias = page.alias;
		this.allowComment = page.allowComment;
	}

	@Override
	public final boolean isCallable() {
		return false;
	}

	@Override
	public Template cloneTemplate() {
		return new Page(this);
	}

	@Override
	public final boolean isRoot() {
		return true;
	}

	@Override
	public final String getTemplate() {
		return tpl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Boolean getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(Boolean allowComment) {
		this.allowComment = allowComment;
	}

	public Page toExportPage() {
		Page page = new Page();
		page.setTpl(getTpl());
		page.setAlias(alias);
		page.setName(name);
		page.setDescription(description);
		return page;
	}

	public String getTemplateName() {
		return TemplateUtils.getPageTemplateName(this);
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	public String getTpl() {
		return tpl;
	}

	public void setTpl(String tpl) {
		this.tpl = tpl;
	}

	@Override
	public boolean equalsTo(Template other) {
		if (Validators.baseEquals(this, other)) {
			Page rhs = (Page) other;
			return Objects.equals(name, rhs.name) && Objects.equals(description, rhs.description)
					&& Objects.equals(createDate, rhs.createDate) && Objects.equals(alias, rhs.alias)
					&& Objects.equals(allowComment, rhs.allowComment) && Objects.equals(space, rhs.space)
					&& Objects.equals(tpl, rhs.tpl);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Page [space=" + space + ", alias=" + alias + "]";
	}

}