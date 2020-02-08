package io.codementor.gtommee.rest_tutorial.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Example {

		private int id;
		private String example;

		
		
		public Example() {
			super();
		}

		public Example(int id, String example) {
			super();
			this.id = id;
			this.example = example;
		}

		public int getId() {
			return id;
		}

		public String getExample() {
			return example;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Example [id=");
			builder.append(id);
			builder.append(", example=");
			builder.append(example);
			builder.append("]");
			return builder.toString();
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setExample(String example) {
			this.example = example;
		}

	}