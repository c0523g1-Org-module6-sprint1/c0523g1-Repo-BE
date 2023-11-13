package com.dating.dto.search_advanced;

import com.dating.model.gender.Gender;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public interface SearchAvancedDto {
     int getId();
     String getName();
     String getAvatar();
     String  getLocation();
     String getJob();
}
