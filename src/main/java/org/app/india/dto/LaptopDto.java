package org.app.india.dto;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "techie_Store")
public class LaptopDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "lap_auto",strategy = "increment")
	@GeneratedValue(generator = "lap_auto")
	@Column(name = "id")
	private Long id;
	@Column(name = "laptop_name")
	private String laptopName;
	@Column(name = "brand_name")
	private String brandName;
	@Column(name = "release_year")
	private Integer releaseYear;
	@Column(name = "specification")
	private String specification;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	@Override
	public String toString() {
		return "LaptopDto [id=" + id + ", laptopName=" + laptopName + ", brandName=" + brandName + ", releaseYear="
				+ releaseYear + ", specification=" + specification + "]";
	}
}
