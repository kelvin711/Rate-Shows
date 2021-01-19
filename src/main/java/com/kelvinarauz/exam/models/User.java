package com.kelvinarauz.exam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String firstName;
    
    @Email(message="Email must be valid")
    private String email;
   
    @Size(min=8, message="Password must be greater than 8 characters")
    private String password;
    
    @Transient
    private String passwordConfirmation;
    
    @Transient
    private String duplicate;
    
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
	
	// One User to Many Shows
	@OneToMany(mappedBy="showCreator", fetch=FetchType.LAZY)
	private List<Show> shows;
	
	// One User to Many Reviews
	@OneToMany(mappedBy="critic", fetch=FetchType.LAZY)
	private List<Review> reviews;
	

// relationship ------------------------------------------------------------
	public User() {}

	public User(@NotEmpty String firstName, @Email(message = "Email must be valid") String email,
			@Size(min = 8, message = "Password must be greater than 8 characters") String password, List<Show> shows,
			List<Review> reviews) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.shows = shows;
		this.reviews = reviews;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public String getDuplicate() {
		return duplicate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Show> getShows() {
		return shows;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public void setDuplicate(String duplicate) {
		this.duplicate = duplicate;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	

		
}