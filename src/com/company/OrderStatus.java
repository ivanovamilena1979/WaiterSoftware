package com.company;

public enum OrderStatus {
    COOKING {
        @Override
        public String toString() {
            return "Cooking";
        }
    },
    PREPARED {
        @Override
        public String toString() {
            return "Prepared";
        }

    },

    PAID {
        @Override
        public String toString() {
            return "Paid";
        }
    },
    SERVED {
        @Override
        public String toString() {
            return "Served";
        }
    },
    ORDERED {
        @Override
        public String toString() {
            return "Ordered";
        }
    },


}
