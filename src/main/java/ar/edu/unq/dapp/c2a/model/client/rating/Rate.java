package ar.edu.unq.dapp.c2a.model.client.rating;

public enum Rate {
    ATROCIOUS{
        @Override
        public Integer toInteger() {
            return 1;
        }
    },
    UGLY{
        @Override
        public Integer toInteger() {
            return 2;
        }
    },
    BAD{
        @Override
        public Integer toInteger() {
            return 3;
        }
    },
    GOOD{
        @Override
        public Integer toInteger() {
            return 4;
        }
    },
    SUPERB{
        @Override
        public Integer toInteger() {
            return 5;
        }
    },
    ;

    public abstract Integer toInteger();
}
