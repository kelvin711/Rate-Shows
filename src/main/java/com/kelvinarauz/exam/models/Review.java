package com.kelvinarauz.exam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reviews")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Min(value=1, message="Invalid Rating")
	@Max(value=5, message="Invalid Rating")
	private Integer rating;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
	}
	
// relationship ------------------------------------------------------------
	
	// Many Reviews to One User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User critic;
	
	// Many Reviews to One Show
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="show_id")
	private Show show;
	
// relationship ------------------------------------------------------------
	
	public Review() {}

	public Review(@Min(value = 1, message = "Invalid Rating") @Max(value = 5, message = "Invalid Rating") Integer rating,
			User critic, Show show) {
		super();
		this.rating = rating;
		this.critic = critic;
		this.show = show;
	}

	public Long getId() {
		return id;
	}

	public Integer getRating() {
		return rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public User getCritic() {
		return critic;
	}

	public Show getShow() {
		return show;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCritic(User critic) {
		this.critic = critic;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	
	
}
