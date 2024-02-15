// -------------------------------------------------------
// Assignment 4
// Written by: Marko Matijevic (40282591)
// For COMP 248 Section R – Fall 2023
// --------------------------------------------------------
public class PoS {
    // Attributes for the class PoS are Sales as an object and an array PrePaiCards
    private Sales sales;
    private PrePaiCard[] cards;


    // Default constructor
    public PoS() {

    }

    // Constructor with parameters
    public PoS(Sales sales1, PrePaiCard[] cards1) {
        this.sales = sales1;
        this.cards = cards1;
    }


    // equalValue returns true if SalesTotal() is equal between both objects and false otherwise
    public boolean equalValue(Sales sales1) {
        return this.sales.salesTotal() == sales1.salesTotal();
    }

    // equalsCategories returns true if the number of sales in each category is the same for each object
    public boolean equalCategories(Sales sales1) {
        return this.sales.equals(sales1);
    }

    // totalSales returns the total sales of a PoS in $ as an int
    public int totalSales() {
        return (int) sales.salesTotal();
    }

    // numCards returns the number of prepaid cards in a PoS as an int

    public int PrePaiCard_Count() {
        return (cards != null) ? cards.length : 0;
    }

    // addCard adds a new PrePaiCard to the PoS array. needs to account for the array being empty.
    public int addCard(PrePaiCard prePaiCard1) {
        if (this.cards == null) {
            this.cards = new PrePaiCard[0];
        }
        PrePaiCard[] newPrePaiCard = new PrePaiCard[this.cards.length + 1];
        for (int i = 0; i < this.cards.length; i++) {
            newPrePaiCard[i] = new PrePaiCard(this.cards[i]);
        }
        newPrePaiCard[this.cards.length] = new PrePaiCard(prePaiCard1);
        this.cards = new PrePaiCard[newPrePaiCard.length];
        for (int i = 0; i < newPrePaiCard.length; i++) {
            this.cards[i] = new PrePaiCard(prePaiCard1);
        }
        return cards.length;
    }

    // removeCard removes a PrePaiCard from the array taking into account if there are no cards
    public boolean removeCard(int index) {
        if (cards == null) {
            return false;
        }
        int nlength = cards.length - 1;
        if (cards.length == 1) {
            nlength = 0;
            cards = null;
            return true;
        }
        PrePaiCard[] temp = new PrePaiCard[nlength];
        for (int i = 0; i < nlength; i++) {
            if (i < index) {
                temp[i] = cards[i];
            } else {
                temp[i] = cards[i + 1];
            }
        }
        cards = new PrePaiCard[nlength];
        System.arraycopy(temp, 0, cards, 0, nlength);
        return true;
    }

    // updateDate will update the expiry day and month of a prepaid card.
    public void updateDate(int cardIndex, int newExpiryDay, int newExpiryMonth) {
        // checks if entered index exists within cards array
        if (cardIndex >= 0 && cardIndex <= cards.length) {
            // uses mutator methods to change the expiry day and month
            cards[cardIndex].setExpiryDay(newExpiryDay);
            cards[cardIndex].setExpiryMonth(newExpiryMonth);
            System.out.println("Expiry Date updated.");
        } else {
            System.out.println("Invalid card index");
        }
    }
// adds all the new meals together using sales.addSales (), with any extra meals that were added within the ().
    public int meal_add(int junior_sold, int teen_sold, int med_sold, int big_sold, int family_sold) {
        sales.addSales(junior_sold, teen_sold, med_sold, big_sold, family_sold);
// returns int
        return (int) sales.salesTotal();
    }
// Returns true if sales for two sale instances are equal.
    public boolean equals(PoS PoS1) {

        return (this.totalSales() == PoS1.totalSales()) && (this.PrePaiCard_Count() == PoS1.PrePaiCard_Count());

    }

// toString which will add "No PrePaiCards" if the condition of cards == null is met. Otherwise, it will run as normal

    @Override
    public String toString() {
        String s = sales.toString() + "\n";

        if (cards == null) {

            s += "No PrePaiCards\n";
            return s;
        }
        for (int i = 0; i < cards.length; i++) {
            s += cards[i].toString() + "\n";

        }
        return s;
    }

// method Breakdown_Sales is used to simply return the sales.toString() which does "returns string of new amount sold the character 'x' followed by the corresponding final price."
    public String Breakdown_Sales() {
        return sales.toString();
    }


}