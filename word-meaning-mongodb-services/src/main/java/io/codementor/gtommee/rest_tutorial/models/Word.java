package io.codementor.gtommee.rest_tutorial.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wordscollectionnew")
public class Word {	

	// public enum Type {
	// adjective, verb, noun, adverb;
	// }

	@Id
	private String _id;
	private String word;
	private String type;
	private Date createdDate;
	private Date lastModified;
	private Date lastRead;
	
	private List<String> tags;
	private List<Date> readHistory;
	
	

	private List<Meaning> meanings = new ArrayList<Meaning>();

	private List<Example> examples = new ArrayList<Example>();
	
	public List<Date> getReadHistory() {
		return readHistory;
	}

	public void setReadHistory(List<Date> readHistory) {
		this.readHistory = readHistory;
	}

	public Word(){}

	public Word(String _id, String word, String type) {
		super();
		this._id = _id;
		this.word = word;
		this.type = type;
	}

	public void addMeaning(String meaning) {
		if (meaning == null || meaning.trim().equals("")) {
			return;
		}
		meanings.add(new Meaning(meanings.size() + 1, meaning));
	}

	public void addExample(String example) {
		if (example == null || example.trim().equals("")) {
			return;
		}
		examples.add(new Example(examples.size() + 1, example));
	}
	
	public void addReadHistory(Date date) {
		if (date == null) {
			return;
		}
		readHistory.add(date);
	}
	
	public void addTag(String tag) {
		
		if (tag == null || tag.trim().equals("")) {
			return;
		}
		tags.add(tag);
	}

	

//	public ObjectId getId() {
//		return _id;
//	}

	public String getWord() {
		return word;
	}

	public String getType() {
		return type;
	}

	public List<Meaning> getMeanings() {
		return Collections.unmodifiableList(meanings);
	}

	public List<Example> getExamples() {

		return Collections.unmodifiableList(examples);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Word [_id=");
		builder.append(_id);
		builder.append(", word=");
		builder.append(word);
		builder.append(", type=");
		builder.append(type);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", lastModified=");
		builder.append(lastModified);
		builder.append(", lastRead=");
		builder.append(lastRead);
		builder.append(", tags=");
		builder.append(tags);
		builder.append(", readHistory=");
		builder.append(readHistory);
		builder.append(", meanings=");
		builder.append(meanings);
		builder.append(", examples=");
		builder.append(examples);
		builder.append("]");
		return builder.toString();
	}

//	public void setId(ObjectId objectId) {
//		this._id = objectId;
//	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setMeanings(List<Meaning> meanings) {
		this.meanings = meanings;
	}

	public void setExamples(List<Example> examples) {
		this.examples = examples;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getLastRead() {
		return lastRead;
	}

	public void setLastRead(Date lastRead) {
		this.lastRead = lastRead;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
