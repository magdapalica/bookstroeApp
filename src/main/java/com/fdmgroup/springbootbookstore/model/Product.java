package com.fdmgroup.springbootbookstore.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fdmgroup.springbootbookstore.model.User;

	@Entity
	public class Product {

		@Id
		@GeneratedValue
		@Column(name = "product_id")
		private Integer id;

		public Product() {
		};

		
		private String author;
		private String title;
		private String category;
		private double price;
		private String description;
		
		@OnDelete(action = OnDeleteAction.CASCADE)
		@ManyToOne(targetEntity = User.class)
		private User owner;

		@OneToMany(cascade = CascadeType.PERSIST)
		private List<Picture> pictures;

		public List<Picture> getPictures() {
			return pictures;
		}

		public void setPictures(List<Picture> pictures) {
			this.pictures = pictures;
		}

		public Integer getId() {
			return id;
		}
//
//		public void setId(Integer id) {
//			this.id = id;
//		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public Product( String author, String title, String category, double price) {
			super();
			this.author = author;
			this.title = title;
			this.category = category;
			this.price = price;
		}
		
		public User getOwner() {
			return owner;
		}

		public void setOwner(User owner) {
			this.owner = owner;
		}
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", author=" + author + ", title=" + title + ", category=" + category
					+ ", price=" + price + ", pictures=" + pictures + "]";
		}

			
}

		

