package com.company;

public enum OrderStatus {
    COOKING {
        @Override
        public String toString() {
            return "Готви се";
        }
    },
    PREPARED {
        @Override
        public String toString() {
            return "Приготвена";
        }
    },

    PAID {
        @Override
        public String toString() {
            return "Платена";
        }
    },
    SERVED {
        @Override
        public String toString() {
            return "Сервирана";
        }
    },
    ORDERED {
        @Override
        public String toString() {
            return "Поръчана";
        }
    },


}
