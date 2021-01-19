package com.kelvinarauz.exam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="shows")
public class Show {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1, message="Please provide a title")
	private String title;
	
	@Size(min=1, message="Please provide the network")
	private String network;
	
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
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User showCreator;
	
	// CascadeType.REMOVE will delete all reviews associated with a TV Show when that show is deleted
	@OneToMany(mappedBy="show", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
	private List<Review> reviews;
        
// relationship ------------------------------------------------------------
    
    public Show() {}

	

	public Show(@Size(min = 1, message = "Please provide a title") String title,
		@Size(min = 1, message = "Please provide the network") String network, User showCreator, List<Review> reviews) {
		super();
		this.title = title;
		this.network = network;
		this.showCreator = showCreator;
		this.reviews = reviews;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getNetwork() {
		return network;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public User getShowCreator() {
		return showCreator;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setShowCreator(User showCreator) {
		this.showCreator = showCreator;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	

}
