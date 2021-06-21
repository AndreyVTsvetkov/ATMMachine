package ru.sber.atm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_cards")
@NoArgsConstructor
@Getter
@Setter
public class CardEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PINCODE")
    private  int pinCode;
    @Column(name = "CARDNUM")
    private String cardNum;
    @Column(name = "DATEEND")
    private Date dateEnd;
    @Column(name = "CVCCVV2CODE")
    private int cvcCvv2Code;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private CardEntity account_id;
}
