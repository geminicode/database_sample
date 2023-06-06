package com.sample.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;

@Data
@Entity
@Table(name = "PERSON")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	

	@Id
	@Column(name = "id", nullable = false)
	private UUID id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
    @CreatedDate
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    @Column(name = "created_on", nullable = false, columnDefinition = "timestamp with time zone")
    private OffsetDateTime createdOn;	
}