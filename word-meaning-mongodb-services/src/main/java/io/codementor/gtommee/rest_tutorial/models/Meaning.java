package io.codementor.gtommee.rest_tutorial.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Meaning {

		private int id;
		private String meaning;
		
		

		public Meaning() {
			super();
		}

		public Meaning(int id, String meaning) {
			super();
			this.id = id;
			this.meaning = meaning;
		}

		public int getId() {
			return id;
		}

		public String getMeaning() {
			return meaning;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Meaning [id=");
			builder.append(id);
			builder.append(", meaning=");
			builder.append(meaning);
			builder.append("]");
			return builder.toString();
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setMeaning(String meaning) {
			this.meaning = meaning;
		}

	}