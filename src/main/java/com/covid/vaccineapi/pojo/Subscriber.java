package com.covid.vaccineapi.pojo;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NonNull
    @Column(name = "mobno")
    private String mobNo;
    @NonNull
    @Column(name = "pincode")
    private String pinCode;
}
