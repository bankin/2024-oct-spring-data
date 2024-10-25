package bg.softuni.entities.gringotts;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column(columnDefinition = "TEXT(1000)")
    private String notes;

    @Basic(optional = false)
    private int age;

    @Column(name = "magic_wand_creator", length = 100)
    private String magicWandCreator;

    @Column(name = "magic_wand_size")
    private short magicWandSize;

    @Column(name = "deposit_group", length = 20)
    private String depositGroup;

    @Column(name = "deposit_start_date")
    private Instant depositStartDate;

    @Column(name = "deposit_amount")
    private Double depositAmount;

    @Column(name = "deposit_interest")
    private Double depositInterest;

    @Column(name = "deposit_charge")
    private Double depositCharge;

    @Column(name = "deposit_expiration_date")
    private Instant depositExpirationDate;

    @Column(name = "is_deposit_expired")
    private boolean isDepositExpired;

    public WizardDeposit() {}

    public WizardDeposit(int age, String lastName, short magicWandSize, String depositGroup, Instant depositStartDate) {
        this.age = age;
        this.lastName = lastName;
        this.magicWandSize = magicWandSize;
        this.depositGroup = depositGroup;
        this.depositStartDate = depositStartDate;
    }

    @Override
    public String toString() {
        return "WizardDeposit{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", notes='" + notes + '\'' +
                ", age=" + age +
                ", magicWandCreator='" + magicWandCreator + '\'' +
                ", magicWandSize=" + magicWandSize +
                ", depositGroup='" + depositGroup + '\'' +
                ", depositStartDate=" + depositStartDate +
                ", depositAmount=" + depositAmount +
                ", depositInterest=" + depositInterest +
                ", depositCharge=" + depositCharge +
                ", depositExpirationDate=" + depositExpirationDate +
                ", isDepositExpired=" + isDepositExpired +
                '}';
    }
}
