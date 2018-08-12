package io.codementor.gtommee.rest_tutorial.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bson.types.ObjectId;
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

	private List<Meaning> meanings = new ArrayList<Meaning>();

	private List<Example> examples = new ArrayList<Example>();
	
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
		builder.append("Word [id=");
		builder.append(_id);
		builder.append(", word=");
		builder.append(word);
		builder.append(", type=");
		builder.append(type);
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

}
