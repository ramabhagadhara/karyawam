package com.karyawan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false,name = "nip",unique = true)
    private String nip;

    @NotEmpty(message = "First name is required")
    @Column(nullable = false,name = "firstName")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Column(nullable = false,name = "lastName")
    private String lastName;

    @NotEmpty(message = "Jabatan is required")
    @Column(nullable = false,name = "jabatan")
    private String jabatan;

    @NotEmpty(message = "Email is required")
    @Column(nullable = false,name = "email",unique = true)
    private String email;

    @NotEmpty(message = " Phone Number is required")
    @Column(nullable = false,name = "phone",unique = true)
    private String phone;

    @NotEmpty(message = " Alamat is required")
    @Column(nullable = false,name = "alamat")
    private String alamat;

}
