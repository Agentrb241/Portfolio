#include "DoubleFactory.h"

DoubleFactory::DoubleFactory() {}

Op* DoubleFactory::createOp(double value) {
        Op* opr = new Op(value);
        return opr;
}

Rand* DoubleFactory::createRand() {
        Rand* rand = new Rand();
        return rand;
}
