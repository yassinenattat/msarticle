package tn.yassine.msarticle.entities;

import lombok.*;

import tn.yassine.commons.entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article extends BaseEntity {

    private String nom;
    private int qte;
    private long stockId;



}
