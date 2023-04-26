package models.dynamic;

import java.math.BigDecimal;
import java.util.EnumSet;

enum RentalSpaceType {RentalSpace, Retail, Office}

public class RentalSpace {
    // General rental space
    private BigDecimal rentalPrice;
    // Office
    private Integer workerCount;
    // Retail
    private String storeName;

    private RentalSpaceType type = RentalSpaceType.RentalSpace;

    public RentalSpace(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void makeOffice(int workerCount) throws Exception {
        if (this.type ==  RentalSpaceType.Office) {
            throw new Exception("Rental space is already an office space!");
        }
        this.storeName = null;
        this.workerCount = workerCount;
        type = RentalSpaceType.Office;
    }

    public void makeRetail(String storeName) throws Exception {
        if (this.type ==  RentalSpaceType.Retail) {
            throw new Exception("Rental space is already an office space!");
        }
        this.workerCount = null;
        this.storeName = storeName;
        type = RentalSpaceType.Retail;
    }

    public void makeUnrented() throws Exception {
        if (type == RentalSpaceType.RentalSpace) {
            throw new Exception("Rental space is already an unrented space!");
        }
        this.type = RentalSpaceType.RentalSpace;
        this.workerCount = null;
        this.storeName = null;
    }

    public int getWorkerCount() throws Exception {
        if (this.type ==  RentalSpaceType.Office) {
            return workerCount;
        } else {
            throw new Exception("The rental space is not an office space!");
        }
    }

    public String getStoreName() throws Exception {
        if (this.type ==  RentalSpaceType.Retail) {
            return storeName;
        } else {
            throw new Exception("The rental space is not a retail space!");
        }
    }

    @Override
    public String toString() {
        if (this.type ==  RentalSpaceType.Office) {
            return "Office space" +
                    ", rental price: " + rentalPrice +
                    ", worker count: " + workerCount;
        } else if (this.type ==  RentalSpaceType.Retail) {
            return "Retail space" +
                    ", rental price: " + rentalPrice +
                    ", store name: " + storeName;
        } else {
            return "Rental space" +
                    ", rental price: " + rentalPrice;
        }
    }
}
