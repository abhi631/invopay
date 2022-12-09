package com.example.authserver.model;

//import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @NotNull private String user_name;
    @NotNull private String full_name;
    @NotNull private String nick_name;
    private String company_name;
    private String street;
    private String state;
    private String postcode;
    private String suburb;
    @NotNull private int ref_country_id;
    private String phone;
    @NotNull private String email;
    @NotNull private String password;
    @NotNull private String original_password;
    @NotNull private String imei_no;
    @NotNull private int ref_user_group_id;
     private int ref_client_id;
    @NotNull private int ref_supplier_id;
    @NotNull private int audit_record;
    @NotNull private int session_time_limit;
    @NotNull private int reminder_interval_time;
    @NotNull private String  user_image;
    @NotNull private String login_time;
    @NotNull private String last_login_time;
    @NotNull private int status;
    private String website;
    private String vat_number;
    @NotNull private int delete_status;
    @NotNull private int transaction_id;
    @NotNull private LocalDate added_date;




}
