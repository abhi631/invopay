package org.zai.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private long client_id;
    private String client_name;
    private long client_type;
    private String client_fname;
    private String client_lname;
    private String client_email;
    private String client_company_name;
    private String client_mobile;
    private String client_website;
    private long ref_currency_id;
    private long ref_language_id;
    private String client_fax;
    private String client_tax;
    private String client_note;
    private String client_custom_fields;
    private String client_address_line1;
    private String client_address_line2;
    private String client_address_line3;
    private String client_city;
    private String client_state;
    private long ref_country_id;
    private String client_pincode;
    private long ref_supplier_id;
    private int delete_status;
    private long ref_user_id;
    private long transaction_id;
    private LocalDate added_date;
}
