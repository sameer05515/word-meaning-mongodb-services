package io.codementor.gtommee.rest_tutorial.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "typescollection")
public class Type {

	@Id
	private String _id;
	private String type;
	private String typeDescription;
	private Date createdDate;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeDescription() {
		return typeDescription;
	}
	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type [_id=");
		builder.append(_id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", typeDescription=");
		builder.append(typeDescription);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
