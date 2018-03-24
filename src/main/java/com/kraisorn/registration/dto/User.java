/**
 * 
 */
package com.kraisorn.registration.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author kraisorn
 *
 */
@Entity
@Table(name = "user")
public class User {
	
	@JsonProperty("id")
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int id;
	
	@JsonProperty("username")
	@Column(name = "username")
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	private String username;
	
	@JsonIgnore
    public String getPassword() { 
         return this.password;
    }
	//@JsonProperty("password")
	@JsonSetter("password")
	@Column(name = "password")
    public void setPassword(String password) { 
         this.password = password;
    }
    String password;

    @JsonProperty("address")
    @Column(name = "address")
    public String getAddress() { 
         return this.address ;
    }
    public void setAddress(String address) { 
         this.address = address ;
    }
    String address;

    @JsonProperty("phone")
    @Column(name = "phone")
    public String getPhone() { 
         return phone;
    }
    public void setPhone(String phone) { 
         this.phone = phone;
    }
    private String phone;

    @JsonProperty("reference_code")
    @Column(name = "reference_code")
    public String getReference_code() { 
         return this.reference_code ;
    }
    public void setReference_code(String reference_code) { 
         this.reference_code = reference_code ;
    }
    String reference_code;

    @JsonProperty("salary")
    public int getSalary() { 
         return this.salary ;
    }
    public void setSalary(int salary) { 
         this.salary = salary ;
    }
    int salary;
    
    @JsonProperty("member_type_id")
    @Column(name = "member_type_id")
    public int getMember_type_id() { 
         return this.member_type_id ;
    }
    public void setMember_type_id(int member_type_id) { 
         this.member_type_id = member_type_id ;
    }
    int member_type_id;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id)
			   .append(", username=").append(username)
			   .append(", address=").append(address)
			   .append(", phone=").append(phone)
			   .append(", referenceCode=").append(reference_code)
			   .append(", memberTypeId=").append(member_type_id)
			   .append("]");
		return builder.toString();
	}
}