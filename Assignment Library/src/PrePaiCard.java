// -------------------------------------------------------
// Assignment 4
// Written by: Marko Matijevic (40282591)
// For COMP 248 Section R – Fall 2023
// --------------------------------------------------------

// PrePaiCard class to store and update information for the pre-paid cards that may be added or present in a PoS

public class PrePaiCard {
    // PPC names and declaration of PPC information
    public static final String CARNIVORE = "Carnivore";
    public static final String HALAL = "Halal";
    public static final String KOSHER = "Kosher";
    public static final String PESCATARIAN = "Pescatarian";
    public static final String VEGETARIAN = "Vegetarian";
    public static final String VEGAN = "Vegan";
    private String cardType;
    private String cardHolderID;
    private int expiry_Day;
    private int expiry_Month;

    // Default constructor


    // Constructor with 4 parameters then validating them.
    // set expiry_Day to 0 if not equal to or between 1 and 31
    // set expiry_Month to 0 if not equal to or between 0 and 12
    public PrePaiCard(String cardType, String cardHolderID, int expiry_Day, int expiry_Month) {
        this.cardType = cardType;
        this.cardHolderID = String.valueOf(cardHolderID);
        if (expiry_Day >= 1 && expiry_Day <= 31) {
            this.expiry_Day = expiry_Day;
        } else {
            this.expiry_Day = 0;
        }
        if (expiry_Month >= 1 || expiry_Month <= 12) {
            this.expiry_Month = expiry_Month;
        } else {
            this.expiry_Month = 0;
        }
    }

    // Copy constructor
    public PrePaiCard(PrePaiCard otherCard) {
        this.cardType = otherCard.cardType;
        this.cardHolderID = otherCard.cardHolderID;
        this.expiry_Day = otherCard.expiry_Day;
        this.expiry_Month = otherCard.expiry_Month;
    }

    // Accessor methods for PrePaiCard information
    public String getCardType() {

        return cardType;
    }

    //simple get__ method
    public String getCardHolderID() {

        return cardHolderID;
    }
    //simple get__ method

    public int getExpiryDay() {

        return expiry_Day;
    }

    // Mutator method to alter expiry day.
    // Will check if the new day is within 1 and 31
    // If correct, replace old expiryDay with new one.
    // If not, set it to 0
    public void setExpiryDay(int day) {
        if (day >= 1 && day <= 31) {
            expiry_Day = day;
        } else {
            expiry_Day = 0;
        }
    }

    public int getExpiryMonth() {

        return expiry_Month;
    }
    // Mutator method to alter expiry month.
    // Will check if the new day is within 1 and 12
    // If correct, replace old expiryDay with new one.
    // If not, set it to 0
    public void setExpiryMonth(int month) {
        // Validate and set expiry month
        if (month >= 1 && month <= 12) {
            expiry_Month = month;
        } else {
            expiry_Month = 0;
        }
    }

    // toString method which will format the plugged-in day and month to have a 0 before the entered value, if it is less than 10.
    // returns all PrePaiCard info in given format
    @Override
    public String toString() {
        String spec_day = (expiry_Day < 10) ? "0" + expiry_Day : String.valueOf(expiry_Day);
        String spec_month = (expiry_Month < 10) ? "0" + expiry_Month : String.valueOf(expiry_Month);

        return (cardType + " - " + cardHolderID + " - " + spec_day + "/" + spec_month + ".");

    }

    // equals method to compare two PrePaiCard objects
    @Override
    public boolean equals(Object obj) {
        // If this equals obj, it means they are  equal and will return true
        if (this == obj) {
            return true;
        }
        // If obj == null it cannot be equal or getClass != obj.getclass(), returns false
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Makes a new Card_Contrast object of the class PrePaiCard with content of obj.
        // return true if all the values are equal, and false if any of them aren't equal.
        PrePaiCard Card_Contrast = (PrePaiCard) obj;
        return this.cardType.equals(Card_Contrast.cardType) && this.cardHolderID.equals(Card_Contrast.cardHolderID) && this.expiry_Day == Card_Contrast.expiry_Day && this.expiry_Month == Card_Contrast.expiry_Month;
    }
}