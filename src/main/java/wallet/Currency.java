package wallet;

public enum Currency {
        RUPEE{
                @Override
                public double getTotalAmount(double amount) {
                        return amount;
                }
                @Override
                public double convertToRupees(double amount) {
                        return amount;
                }
        },
        DOLLAR{
                @Override
                public double getTotalAmount(double amount) {
                        return amount/74.85;
                }

                @Override
                public double convertToRupees(double amount) {
                        return amount*74.85;
                }
        };



        public abstract double getTotalAmount(double amount);

        public abstract double convertToRupees(double amount);
}

